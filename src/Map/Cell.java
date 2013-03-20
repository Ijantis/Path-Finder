package Map;

public class Cell {

	public static final int Free = 0;
	public static final int Obstacle = 1;
	private int value;

	protected Cell(int state) {
		this.value = state;
	}

	protected void setValue(int value) {
		this.value = value;
	}

	protected int getCellValue() {
		return this.value;
	}

}
