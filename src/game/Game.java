package game;

import Input.Config;
import Input.Input;
import Input.InputHandler;
import UI.ExposedMatrix;
import UI.UIHandler;
import field.Minefield;

public class Game {
    private final InputHandler inputHandler;
    private final UIHandler uiHandler;
    private boolean isAlive;

    private Minefield minefield;

    public Game(InputHandler inputHandler, UIHandler uiHandler) {
        this.isAlive = true;
        this.uiHandler = uiHandler;
        this.inputHandler = inputHandler;
    }

    public boolean isPlayerAlive() {
        return this.isAlive;
    }

    public Config getGameConfig() {
        return this.inputHandler.getGameConfig();
    }

    public void startGame(Minefield minefield) {
        this.minefield = minefield;
        this.minefield.generateMinefieldMatrix();
        this.renderCurrentGameState();
    }

    public void actOnPlayerInput() {
        Input input = this.inputHandler.getPlayerInput();
        this.minefield.activateSlot(input.selectedRow, input.selectedColumn);
        this.isAlive = !this.hasPlayerSteppedOnMine(input);
        this.renderCurrentGameState();
    }

    private boolean hasPlayerSteppedOnMine(Input input) {
        return this.minefield.hasMineOnPosition(input.selectedRow, input.selectedColumn);
    }

    private void renderCurrentGameState() {
        ExposedMatrix exposedMatrix = this.minefield.getMinefieldState();
        this.uiHandler.renderGame(exposedMatrix);
    }

    public boolean hasPlayerWon() {
        return this.minefield.isMinefieldClear();
    }

    public void endGame() {
        if (!this.isPlayerAlive()) {
            this.uiHandler.renderGameOver();
        }
        if (this.hasPlayerWon()) {
            this.uiHandler.renderWin();
        }
    }
}