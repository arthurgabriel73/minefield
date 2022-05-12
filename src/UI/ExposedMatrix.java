package UI;

import field.Slot;

public class ExposedMatrix {

    public String[][] matrix;

    public ExposedMatrix(Slot[][] minefield) {

        this.matrix = new String[minefield.length][minefield[0].length];

        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[0].length; j ++) {
                if (!minefield[i][j].isOpen()) {
                    this.matrix[i][j] = "C";
                }
                else this.matrix[i][j] = String.format("%d", minefield[i][j].getHowManyMinesAroundMe());
            }
        }
    }
}
