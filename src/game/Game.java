package game;

import java.util.Random;

import field.Minefield;
import field.Slot;

public class Game {

	private boolean isAlive;
	private boolean winner;

	Random rand = new Random();
	Slot slot = new Slot();
	Minefield minefield = new Minefield();

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

	public Minefield getMinefield() {
		return minefield;
	}

	public void setMinefield(Minefield minefield) {
		this.minefield = minefield;
	}

	public void isThereABomb(Slot slot) {
		
		for (int bombCount = 0; bombCount < 16;) {
			for (int i = 0; i < minefield.getRows(); i++) {
				for (int j = 0; j < minefield.getColumns(); j++) {
					
					int r = rand.nextInt(6);
					if (r == 0) {
						bombCount++;

						slot.setContent(true);
					} else {
						slot.setContent(false);
					}
				}
			}
		}

	}

}