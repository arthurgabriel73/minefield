package application;

import field.Minefield;
import field.Slot;
import game.Game;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        Minefield minefield = new Minefield();


        UI.clearScreen();
        System.out.println("\nGood Luck!\n");


        UI.printGame(game);
    }
}