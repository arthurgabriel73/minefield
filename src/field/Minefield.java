package field;

import UI.ExposedMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        getSlot(row, column).setStatus(true);
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

    public void setNumberOfMinesAroundSlot(int row, int column) {
        int minesAround = 0;
        int[][] positions = {
                {row - 1, column - 1},
                {row - 1, column},
                {row - 1, column + 1},
                {row, column - 1},
                {row, column + 1},
                {row + 1, column - 1},
                {row + 1, column},
                {row + 1, column + 1}
        };

        Slot slot = this.getSlot(row, column);

        for (int[] position : positions) {
//            Slot selectedSlot = this.getSlot(position[0], position[1]);
            if (positionExists(position[0], position[1])
                    && this.getSlot(position[0], position[1]).isThereAMine()) {
                minesAround += 1;
            }
        }
        slot.setHowManyMinesAroundMe(minesAround);
    }

    public boolean hasMineOnPosition(int row, int column) {
        Slot slot = this.getSlot(row, column);
        return slot.isThereAMine();
    }

    private boolean positionExists(int row, int column) {
        return row >=0 && row < rows && column >=0 && column < columns;
    }

//    public int[][] getPositionsAroundSlot(int row, int column) {
//
//        int[][] positions = {
//                {row - 1, column - 1},
//                {row - 1, column},
//                {row - 1, column + 1},
//                {row, column - 1},
//                {row, column + 1},
//                {row + 1, column - 1},
//                {row + 1, column},
//                {row + 1, column + 1}
//        };
//        positions = (int[][]) Arrays.stream(positions)
//                .filter(x -> x[0] >= 0 && x[0] < rows && x[1] >=0 && x[1] < columns)
//                .toArray();
//
//        return positions;
//    }
}