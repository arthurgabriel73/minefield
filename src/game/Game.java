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
    private boolean weveGotAWinner;

    private Minefield minefield;

    public Game(InputHandler inputHandler, UIHandler uiHandler) {
        this.isAlive = true;
        this.uiHandler = uiHandler;
        this.inputHandler = inputHandler;
        this.startGame();
    }

    public boolean isPlayerAlive() {
        return this.isAlive;
    }

    public boolean findIfWeveGotAWinner() {
        return this.weveGotAWinner;
    }

    public void startGame() {
        Config config = this.inputHandler.getGameConfig();
        this.minefield = new Minefield(config.gameRows(), config.gameColumns(), config.numberOfMines());
        this.renderCurrentGameState();
    }

    public void actOnPlayerInput() {
        Input input = this.inputHandler.getPlayerInput();
        this.minefield.activateSlot(input.selectedRow, input.selectedColumn);
        this.isAlive = !this.hasPlayerSteppedOnBomb(input);
        this.renderCurrentGameState();
        this.verifiesIfTheGameHasEnd();
    }

    private void verifiesIfTheGameHasEnd() {
        if(!this.minefield.haveSomeoneEscaped()) {
            this.uiHandler.verifiesIfThePlayerHaveDied(this.isAlive);
        }

        this.uiHandler.verifiesIfThePlayerHaveWon(this.minefield.haveSomeoneEscaped());
        this.weveGotAWinner = this.minefield.haveSomeoneEscaped();
    }

    private boolean hasPlayerSteppedOnBomb(Input input) {
        return this.minefield.hasMineOnPosition(input.selectedRow, input.selectedColumn);
    }

    private void renderCurrentGameState() {
        ExposedMatrix exposedMatrix = this.minefield.getMinefieldState();
        this.uiHandler.renderGame(exposedMatrix);
    }
}