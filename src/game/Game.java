package game;

import field.Minefield;
//import field.Slot;

public class Game {

	private boolean isAlive;
	private boolean winner;

	private Minefield field;

	public Game() {
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
}