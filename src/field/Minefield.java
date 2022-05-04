package field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Minefield {

	private int rows;
	private int columns;
	private int numberOfMines;
	private Slot[][] minefieldMatrix;

	public Minefield() {

	}

	Random randomNumber = new Random();
	Slot slot = new Slot();

	public Minefield(int rows, int columns, int numberOfMines) {
		this.rows = rows;
		this.columns = columns;
		this.numberOfMines = numberOfMines;
		this.generateMinefieldMatrix();

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

	private Slot[][] generateMinefieldMatrix() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				this.minefieldMatrix[i][j] = new Slot(false);
			}
		}
		this.setMinesOnMinefield();
		return minefieldMatrix;
	}

	//____________


	public void mineList() {
		List<ArrayList<Integer>> minePlaces = new ArrayList<>();
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				minePlaces.add(new ArrayList<>(Arrays.asList(i, j)));
			}
		}

		int quantityOfSlots = this.rows*this.columns;
		int numberOfPlacedMines = 0;
		while (numberOfPlacedMines < this.numberOfMines) {
			 ArrayList<Integer> randomMinePlace = minePlaces.get(randomNumber.nextInt(quantityOfSlots));

			Slot randomSlot = getSlot(minefieldMatrix);
			setMinesOnMinefield(randomSlot);
			minePlaces.remove(randomMinePlace);
			numberOfPlacedMines += 1;
		}
	}

	public Slot getSlot(Slot[][] minefieldMatrix){
		int i = randomNumber.nextInt(this.rows);
		int j = randomNumber.nextInt(this.columns);
		return minefieldMatrix[i][j];
	}

	public void setMinesOnMinefield(Slot randomSlot){
		slot.setMine(true);
	}
}