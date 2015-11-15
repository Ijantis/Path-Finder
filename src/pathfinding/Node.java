package pathfinding;

public class Node {

	private int x;
	private int y;
	private int parentX, parentY;
	private boolean hasParent = false;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getParentX() {
		return this.parentX;
	}

	public int getParentY() {
		return this.parentY;
	}

	public void setParent(Node parent) {
		this.hasParent = true;
		this.parentX = parent.getX();
		this.parentY = parent.getY();
	}

	public boolean hasParent() {
		return this.hasParent;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Node) {
			Node temp = (Node) obj;
			return temp.getX() == this.x && temp.getY() == this.y;
		}
		return false;
	}

}
