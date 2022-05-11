package Input;

public class Config {

    private final int gameRows;
    private final int gameColumns;
    private final int numberOfBombs;

    public Config(int gameRows, int gameColumns, int numberOfBombs) {
        this.gameRows = gameRows;
        this.gameColumns = gameColumns;
        this.numberOfBombs = numberOfBombs;
    }

    public int getGameRows() {
        return gameRows;
    }
    public int getGameColumns() {
        return gameColumns;
    }
    public int getNumberOfBombs() {
        return numberOfBombs;
    }
}
