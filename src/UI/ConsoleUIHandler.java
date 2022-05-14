package UI;

public class ConsoleUIHandler implements UIHandler{

    @Override
    public void renderGame(ExposedMatrix exposedMatrix) {
        for (int i = 0; i < exposedMatrix.matrix.length; i++) {
            System.out.print((i) + " ");
            for (int j = 0; j < exposedMatrix.matrix[0].length; j++) {
                System.out.print(exposedMatrix.matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("  ");
        for(int i = 0; i < exposedMatrix.matrix.length; i++) {

            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public void renderWin() {
        System.out.println("THE MINEFIELD IS CLEAR!");
    }

    @Override
    public void renderGameOver() {
            System.out.println("YOU DIED!");
    }
}