package field;

import UI.ExposedMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Minefield {

    Random randomNumber = new Random();
    private int rows;
    private int columns;
    private int numberOfMines;
    private Slot[][] minefieldMatrix;

    public Minefield(int rows, int columns, int numberOfMines) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfMines = numberOfMines;
        this.generateMinefieldMatrix();
    }

    public void activateSlot(int row, int column) {

    }

    public ExposedMatrix getMinefieldState() {
        return new ExposedMatrix(this.minefieldMatrix);
    }

    private void generateMinefieldMatrix() {
        this.minefieldMatrix = new Slot[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.minefieldMatrix[i][j] = new Slot(false, false, 0);
            }
        }
        this.placeMinesOnMinefield();
    }

    private void placeMinesOnMinefield() {
        List<ArrayList<Integer>> minePlaces = new ArrayList<>();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                minePlaces.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }

        int quantityOfSlots = this.rows * this.columns;
        int numberOfPlacedMines = 0;
        while (numberOfPlacedMines < this.numberOfMines) {

            ArrayList<Integer> randomMinePlace = minePlaces.get(randomNumber.nextInt(quantityOfSlots));

            Slot randomSlot = this.getSlot(randomMinePlace.get(0), randomMinePlace.get(1));
            randomSlot.setMine(true);
            minePlaces.remove(randomMinePlace);
            numberOfPlacedMines += 1;
            quantityOfSlots -= 1;
        }
    }

    private Slot getSlot(int row, int column) {
        return this.minefieldMatrix[row][column];
    }
}