package application;

import game.Game;

public class Program {

	public static void main(String[] args) {

		Game game = new Game();
		
		UI.clearScreen();
		System.out.println("\nGood Luck!\n");

		
		UI.printGame(game);
	}
}