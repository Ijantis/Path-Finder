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
	private static Grid myMap;

	public FindPath(int startX, int startY, int goalX, int goalY, Grid myMap) {

		openSet = new ArrayList<Node>();
		closedSet = new ArrayList<Node>();

		// endNode = new Node(goalX, goalY, null);
		// startNode = new Node(startX, startY, null);

		endNode = new Node(52, 20, null);
		startNode = new Node(5, 5, null);

		FindPath.myMap = myMap;

		openSet.add(startNode);

		while (!openSet.isEmpty() && !atEnd) {

			findAdjacent(openSet.get(0));

		}

		System.out.println("Found the end");
		Node temp = endNode;
		while (temp.getParent() != null) {
			System.out.println(temp.getParent().getX() + " , "
					+ temp.getParent().getY());
			temp = temp.getParent();
		}
	}

	private void findAdjacent(Node tempNode) {

		openSet.remove(tempNode);
		closedSet.add(tempNode);

		if (tempNode.equals(endNode)) {
			atEnd = true;
			endNode.setParent(tempNode);
		} else {
			System.out.println("Checking around coords x: " + tempNode.getX()
					+ " y: " + tempNode.getY());

			// NORTH
			try {
				Node temp = new Node(tempNode.getX(), tempNode.getY() + 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX(), tempNode.getY() + 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);
					System.out.println("-- Added " + tempNode.getX() + " "
							+ (tempNode.getY() + 1));

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// EAST
			try {
				Node temp = new Node(tempNode.getX() + 1, tempNode.getY(),
						tempNode);
				if (Grid.getCellValue(tempNode.getX() + 1, tempNode.getY()) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);
					System.out.println("-- Added " + (tempNode.getX() + 1)
							+ " " + tempNode.getY());

				}

			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// SOUTH
			try {
				Node temp = new Node(tempNode.getX(), tempNode.getY() - 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX(), tempNode.getY() - 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);
					System.out.println("-- Added " + tempNode.getX() + " "
							+ (tempNode.getY() - 1));

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// WEST
			try {
				Node temp = new Node(tempNode.getX() - 1, tempNode.getY(),
						tempNode);
				if (Grid.getCellValue(tempNode.getX() - 1, tempNode.getY()) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);
					System.out.println("-- Added " + (tempNode.getX() - 1)
							+ " " + tempNode.getY());

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// NORTH EAST
			try {
				Node temp = new Node(tempNode.getX() + 1, tempNode.getY() + 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX() + 1, tempNode.getY() + 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);
					System.out.println("-- Added " + (tempNode.getX() - 1)
							+ " " + tempNode.getY());

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// NORTH WEST
			try {
				Node temp = new Node(tempNode.getX() - 1, tempNode.getY() + 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX() - 1, tempNode.getY() + 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);
					System.out.println("-- Added " + (tempNode.getX() - 1)
							+ " " + tempNode.getY());

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// SOUTH EAST
			try {
				Node temp = new Node(tempNode.getX() + 1, tempNode.getY() - 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX() + 1, tempNode.getY() - 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);
					System.out.println("-- Added " + (tempNode.getX() - 1)
							+ " " + tempNode.getY());

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

			// SOUTH WEST
			try {
				Node temp = new Node(tempNode.getX() - 1, tempNode.getY() - 1,
						tempNode);
				if (Grid.getCellValue(tempNode.getX() - 1, tempNode.getY() - 1) == Cell.Free
						&& !wasVisited(temp) && !openSet.contains(temp)) {

					openSet.add(temp);
					System.out.println("-- Added " + (tempNode.getX() - 1)
							+ " " + tempNode.getY());

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}

		}

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
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
