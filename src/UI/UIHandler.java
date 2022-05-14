package UI;

public interface UIHandler {

    void renderGame(ExposedMatrix exposedMatrix);

    void verifiesIfThePlayerHaveWon(boolean isWinner);

    void verifiesIfThePlayerHaveDied(boolean isAlive);
}
