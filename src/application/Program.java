package application;

import UI.ConsoleUIHandler;
import Input.ConsoleInputHandler;
import Input.InputHandler;
import UI.UIHandler;
import game.Game;


public class Program {

    public static void main(String[] args) {

        UIHandler uiHandler = new ConsoleUIHandler();
        InputHandler inputHandler = new ConsoleInputHandler();
        Game game = new Game(inputHandler, uiHandler);
            while (game.isPlayerAlive()) {
                game.actOnPlayerInput();
            }

        System.out.println("BOOOOOOM!!!!");
    }
}