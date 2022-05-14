package application;

import Input.Config;
import UI.ConsoleUIHandler;
import Input.ConsoleInputHandler;
import Input.InputHandler;
import UI.UIHandler;
import field.Minefield;
import game.Game;


public class Program {

    public static void main(String[] args) {

        UIHandler uiHandler = new ConsoleUIHandler();
        InputHandler inputHandler = new ConsoleInputHandler();

        Game game = new Game(inputHandler, uiHandler);

        Config config = game.getGameConfig();

        Minefield minefield = new Minefield(config.gameRows(), config.gameColumns(), config.numberOfMines());

        game.startGame(minefield);


        while (game.isPlayerAlive() && !game.hasPlayerWon()) {
            game.actOnPlayerInput();
        }
        game.endGame();
    }
}