package field;

import java.util.ArrayList;
import java.util.Random;

public class Minefield {

	private int rows;
	private int columns;
	private int numberOfMines;
	private Slot[][] minefieldMatrix;

	public Minefield() {

	}

	Random rand = new Random();
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
		ArrayList<Coords> minePlaces = new ArrayList<Coords>();
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				minePlaces.add(new Coords(i, j));

			}
		}


		Random randomNumber = new Random();

		int numberOfPlacedMines = 0;
		while (numberOfPlacedMines < this.numberOfMines) {
			int quantityOfSlots = this.rows*this.columns;
			Coords randomMinePlace = minePlaces.get(rand.nextInt(quantityOfSlots));

		/*	Slot randomSlot = this.minefieldMatrix
			randomSlot.setMine()
			minePLaces.remove(??? randomMinePlace)
			numberOfPlacedMines += 1*/
		}

	}


	private void getSlot(int rows, int columns) {


	}


	//____________

	private void setMinesOnMinefield() {
		int placedMinesCount = 0;
		while(placedMinesCount < this.numberOfMines) {
		}
	}
}