package field;

import UI.ExposedMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Minefield {

    private final int rows;
    private final int columns;
    private final int numberOfMines;
    private Slot[][] minefieldMatrix;

    Random randomNumber = new Random();

    public Minefield(int rows, int columns, int numberOfMines) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfMines = numberOfMines;
        this.generateMinefieldMatrix();

        for (Slot[] matrix : this.minefieldMatrix) {
            for (int j = 0; j < this.minefieldMatrix.length; j++) {
                this.howManyMinesAroundSlot(matrix[j]);
            }
        }
    }

    public void activateSlot(int row, int column) {

        getSlot(row-1, column-1).setStatus(true);

    }

    public boolean stillAlive(int row, int column){
        return !minefieldMatrix[row-1][column-1].isThereAMine();
    }

    public ExposedMatrix getMinefieldState() {
        return new ExposedMatrix(this.minefieldMatrix);
    }

    private void generateMinefieldMatrix() {
        this.minefieldMatrix = new Slot[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.minefieldMatrix[i][j] = new Slot(false);
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

    //------------------------------------------
    public void howManyMinesAroundSlot(Slot slot) {
        int minesAround = 0;

        for (int i = 0; i < this.minefieldMatrix.length; i++) {
            for (int j = 0; j < this.minefieldMatrix.length; j++) {

                if (positionExists(i - 1, j - 1)) {
                    if (this.minefieldMatrix[i - 1][j - 1].isThereAMine()) {
                        minesAround += 1;
                    }
                }
                if (positionExists(i - 1, j)) {
                    if (this.minefieldMatrix[i - 1][j].isThereAMine()) {
                        minesAround += 1;
                    }
                }
                if (positionExists(i - 1, j + 1)) {
                    if (this.minefieldMatrix[i - 1][j + 1].isThereAMine()) {
                        minesAround += 1;
                    }
                }
                if (positionExists(i, j - 1)) {
                    if (this.minefieldMatrix[i][j - 1].isThereAMine()) {
                        minesAround += 1;
                    }
                }
                if (positionExists(i, j + 1)) {
                    if (this.minefieldMatrix[i][j + 1].isThereAMine()) {
                        minesAround += 1;
                    }
                }
                if (positionExists(i + 1, j - 1)) {
                    if (this.minefieldMatrix[i + 1][j - 1].isThereAMine()) {
                        minesAround += 1;
                    }
                }
                if (positionExists(i + 1, j)) {
                    if (this.minefieldMatrix[i + 1][j].isThereAMine()) {
                        minesAround += 1;
                    }
                }
                if (positionExists(i + 1, j + 1)) {
                    if (this.minefieldMatrix[i + 1][j + 1].isThereAMine()) {
                        minesAround += 1;
                    }
                }
            }
        }

        slot.setHowManyMinesAroundMe(minesAround);
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < minefieldMatrix.length && column >= 0 && column < minefieldMatrix.length;
    }
}