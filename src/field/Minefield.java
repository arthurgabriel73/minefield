package field;

import UI.ExposedMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

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
    }

    private void calculateNumberOfMinesAroundEachSlot() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.setNumberOfMinesAroundSlot(row, column);
            }
        }
    }

    public void activateSlot(int row, int column) {
       Slot slot = getSlot(row, column).setStatus(true);
       if (slot.getNumberOfMinesAround() == 0) {
           this.revealPositionsAroundSlot(row, column);
       }
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
        this.calculateNumberOfMinesAroundEachSlot();
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

    private void setNumberOfMinesAroundSlot(int row, int column) {
        int minesAround = 0;

        int[][] positions = getPositionsAroundSlot(row, column);
        Slot slot = this.getSlot(row, column);

        for (int[] position : positions) {
            Slot selectedSlot = this.getSlot(position[0], position[1]);

            if (selectedSlot.isThereAMine()) {
                minesAround += 1;
            }
        }
        slot.setHowManyMinesAroundMe(minesAround);
    }

    public boolean hasMineOnPosition(int row, int column) {
        Slot slot = this.getSlot(row, column);
        return slot.isThereAMine();
    }

    private int[][] getPositionsAroundSlot(int row, int column) {

        int[][] defaultPositions = {
                {(row - 1),( column - 1)},
                {(row - 1), (column)},
                {(row - 1), (column + 1)},
                {(row), (column - 1)},
                {(row), (column + 1)},
                {(row + 1), (column - 1)},
                {(row + 1), (column)},
                {(row + 1), (column + 1)}
        };

       return Stream.of(defaultPositions)
                .filter(i -> i[0] >= 0 && i[0] < rows && i[1]>=0 && i[1] < columns)
                .toArray(int[][]::new);
    }

    private void revealPositionsAroundSlot(int row, int column) {
        int[][] positionsAroundThisSlot = this.getPositionsAroundSlot(row, column) ;
        for (int[] position : positionsAroundThisSlot) {
            Slot selectedSlot = this.getSlot(position[0], position[1]);
            if (selectedSlot.isThereAMine() || selectedSlot.isOpen()) {
                continue;
            }
            selectedSlot.activate();
            if (selectedSlot.getNumberOfMinesAround() == 0) {
                this.revealPositionsAroundSlot(position[0], position[1]);
            }
        }
    }
}