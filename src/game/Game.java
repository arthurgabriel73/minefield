package game;

import field.Minefield;
import field.Slot;

public class Game {

	private boolean isAlive;
	private boolean winner;

	private Minefield field;

	public Game() {
		field = new Minefield(8, 8);
		isAlive = true;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public Minefield getField() {
		return field;
	}

	public void setField(Minefield field) {
		this.field = field;
	}

	public Slot[][] getMinefieldMatrix() {
		Slot[][] minefield = new Slot[field.getRows()][field.getColumns()];
		for (int i = 0; i < field.getRows(); i++) {
			for (int j = 0; j < field.getColumns(); j++) {
				minefield[i][j] = (Slot) field.slot(i, j);
			}
		}
		return minefield;
	}
}