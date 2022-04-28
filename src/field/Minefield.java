package field;

public class Minefield {

	private int rows;
	private int columns;
	private Slot[][] slot;

	public Minefield() {

	}

	public Minefield(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		slot = new Slot[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Slot[][] getSlot() {
		return slot;
	}

	public void setSlot(Slot[][] slot) {
		this.slot = slot;
	}

	public Slot slot(int row, int column) {
		return slot[row][column];
	}
	
	public Slot[][] generateMinefieldMatrix() {
		Slot[][] minefieldMatrix = new Slot[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				minefieldMatrix[i][j] = (Slot) slot(i, j);
			}
		}
		return minefieldMatrix;
	}
}