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
			System.out.println(temp.getParent().getX() + " , " + temp.getParent().getY());
			temp = temp.getParent();
		}

		System.out.println("That took " + (System.currentTimeMillis() - time) + "ms");
	}

	private void findAdjacent(Node currentNode) {

		openSet.remove(currentNode);
		closedSet.add(currentNode);

		if (currentNode.equals(endNode)) {
			atEnd = true;
			endNode.setParent(currentNode);
			return;
		} else {
			search(currentNode, 0, 1); // north
			search(currentNode, 1, 0); // east
			search(currentNode, 0, -1); // south
			search(currentNode, -1, 0); // west
			search(currentNode, 1, 1); // north east
			search(currentNode, -1, 1); // north west
			search(currentNode, 1, -1); // south east
			search(currentNode, -1, -1); // south west
		}

	}

	private void search(Node currentNode, int nextX, int nextY) {
		try {
			Node nextNode = new Node(currentNode.getX() + nextX, currentNode.getY() + nextY, currentNode);
			if (Grid.getCellValue(currentNode.getX() + nextX, currentNode.getY() + nextY) == Cell.Free
					&& !wasVisited(nextNode) && !openSet.contains(nextNode)) {
				openSet.add(nextNode);

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
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
