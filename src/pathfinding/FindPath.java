package pathfinding;

import java.util.ArrayList;

import map.Cell;
import map.Grid;

public class FindPath {

	private ArrayList<Node> openSet;
	private ArrayList<Node> closedSet;
	private boolean atEnd = false;
	private static Node endNode;
	private static Node startNode;

	public FindPath(int startX, int startY, int goalX, int goalY, Grid myMap) {

		long time = System.currentTimeMillis();

		openSet = new ArrayList<Node>();
		closedSet = new ArrayList<Node>();

		endNode = new Node(goalX, goalY, null);
		startNode = new Node(startX, startY, null);

		openSet.add(startNode);

		while (!openSet.isEmpty() && !atEnd) {

			findAdjacent(openSet.get(0));

		}

		System.out.println("Found the end");
		Node temp = endNode;
		while (temp.getParent() != null) {
			Grid.setCellValue(temp.getX(), temp.getY(), Cell.Path);
			System.out.println(temp.getParent().getX() + " , "
					+ temp.getParent().getY());
			temp = temp.getParent();
		}

		System.out.println("That took " + (System.currentTimeMillis() - time)
				+ "ms");
	}

	private void findAdjacent(Node tempNode) {

		openSet.remove(tempNode);
		closedSet.add(tempNode);

		if (tempNode.equals(endNode)) {
			atEnd = true;
			endNode.setParent(tempNode);
		} else {
			Node temp;
			// NORTH
			try {
				temp = new Node(tempNode.getX(), tempNode.getY() + 1, tempNode);
				if (Grid.getCellValue(tempNode.getX(), tempNode.getY() + 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// EAST
			try {
				temp = new Node(tempNode.getX() + 1, tempNode.getY(), tempNode);
				if (Grid.getCellValue(tempNode.getX() + 1, tempNode.getY()) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);

				}

			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// SOUTH
			try {
				temp = new Node(tempNode.getX(), tempNode.getY() - 1, tempNode);
				if (Grid.getCellValue(tempNode.getX(), tempNode.getY() - 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// WEST
			try {
				temp = new Node(tempNode.getX() - 1, tempNode.getY(), tempNode);
				if (Grid.getCellValue(tempNode.getX() - 1, tempNode.getY()) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// NORTH EAST
			try {
				temp = new Node(tempNode.getX() + 1, tempNode.getY() + 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX() + 1, tempNode.getY() + 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// NORTH WEST
			try {
				temp = new Node(tempNode.getX() - 1, tempNode.getY() + 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX() - 1, tempNode.getY() + 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// SOUTH EAST
			try {
				temp = new Node(tempNode.getX() + 1, tempNode.getY() - 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX() + 1, tempNode.getY() - 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// SOUTH WEST
			try {
				temp = new Node(tempNode.getX() - 1, tempNode.getY() - 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX() - 1, tempNode.getY() - 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

		}

	}

	private boolean wasVisited(Node temp) {

		if (this.closedSet.contains(temp)) {
			return true;
		} else {

			return false;
		}
	}

}
