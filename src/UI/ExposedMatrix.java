package UI;
import field.Minefield;
import field.Slot;

public class ExposedMatrix {

    public String[][] matrix;

    public ExposedMatrix(Slot[][] minefield) {
        this.generateExposedMatrix(minefield);
    }

    private void generateExposedMatrix(Slot[][] minefield) {
//        this.matrix = new String[minefield.getMinefieldMatrix().length()][minefield.getMinefieldMatrix().length()];
//
//        for (int i = 0; i < exposedMatrix.length; i++) {
//            for (int j = 0; j < exposedMatrix.length; j ++) {
//                if (!minefieldMatrix[i][j].isOpen()) {
//                    this.exposedMatrix[i][j] = "C";
//                }
//                else this.exposedMatrix[i][j] = minefieldMatrix[i][j].getHowManyMinesAroundMe().toString();
//            }
//        }
    }
}
