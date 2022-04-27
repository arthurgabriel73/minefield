package game;

import field.Field;
import field.Slot;

public class Game {

	private boolean isAlive;
	private boolean winner;
	
	private Field field;
	
	public Game() {
		field = new Field(8, 8 );
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

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	public Slot[][] getSlot(){
		Slot[][] mat = new Slot[field.getRows()][field.getColumns()];
		for (int i = 0; i < field.getRows(); i++) {
			for (int j = 0; j < field.getColumns(); j++) {
				mat[i][j] = (Slot) field.slot(i, j);
			}
		}
		return mat;		
	}
}
