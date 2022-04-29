package application;

import field.Minefield;
import field.Slot;
import game.Game;

public class UI {

	Game game = new Game();
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void printGame(Game game) {
		Minefield minefield = new Minefield(8, 8, 16);
		/*printField(minefield.generateMinefieldMatrix());
		System.out.println("");*/
	}

	public static void printField(Slot[][] minefield) {
		for (int i = 0; i < minefield.length; i++) {
			System.out.print(ANSI_BLUE);
			System.out.print((i+1) + " ");
			for (int j = 0; j < minefield.length; j++) {
				printSlot(minefield[i][j]);

			}
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}

	private static void printSlot(Slot slot) {
		Minefield minefield = new Minefield();
		String boolString;
		boolean bool = slot.getContent();
		if (bool == false) {
			boolString = "O";
		}
		else boolString = "X";

		System.out.print(boolString + " ");
	}
}
