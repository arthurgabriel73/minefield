package application;

import game.Game;

public class Program {

	public static void main(String[] args) {

		Game game = new Game();

		System.out.println("Good Luck!");

		UI.clearScreen();
		UI.printGame(game);
	}
}
