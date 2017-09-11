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
	private static int count = 0;

	public FindPath(int startX, int startY, int goalX, int goalY, Grid myMap) {

		long time = System.currentTimeMillis();
		count = 0;

		openSet = new ArrayList<Node>();
		closedSet = new ArrayList<Node>();

		endNode = new Node(goalX, goalY);
		startNode = new Node(startX, startY);

		openSet.add(startNode);

		while (!openSet.isEmpty() && !atEnd) {

			findAdjacent(openSet.get(0));

		}

		System.out.println("Found the end");
		Node temp = endNode;
		while (temp.hasParent()) {
			System.out.println("here");
			Grid.setCellValue(temp.getX(), temp.getY(), Cell.Path);
			for (Node node : closedSet) {
				if(node.getX() == temp.getParentX() && node.getY() == temp.getParentY()) {
					temp = node;
					break;
				}
			}
		}
		
		Grid.setCellValue(temp.getX(), temp.getY(), Cell.Path);
		
		System.out.println("That took " + (System.currentTimeMillis() - time) + "ms");
		System.out.println(count);
	}

	private void findAdjacent(Node currentNode) {

		openSet.remove(currentNode);
		closedSet.add(currentNode);
		System.out.println("Current node is " + currentNode.toString());
		if (currentNode.equals(endNode)) {
			atEnd = true;
			endNode.setParent(currentNode.getParentX(), currentNode.getParentY());
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
		count++;
		try {
			Node nextNode = new Node(currentNode.getX() + nextX, currentNode.getY() + nextY);

			if (!wasVisited(nextNode) && !openSet.contains(nextNode)
					&& Grid.getCellValue(currentNode.getX() + nextX, currentNode.getY() + nextY) == Cell.Free) {
				openSet.add(nextNode);
				nextNode.setParent(currentNode.getX(), currentNode.getY());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
	}

	private boolean wasVisited(Node temp) {
		return this.closedSet.contains(temp);
	}

}
