package Input;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler{

    Scanner sc = new Scanner(System.in);

    @Override
    public Config getGameConfig() {

        System.out.println("Select the field length: ");
        String length = sc.nextLine();
        int rows = printMessageUntilIntegerIsPassed(length);
        System.out.println("Select the number of mines to be set up on the field: ");
        String numberOfMinesStr = sc.nextLine();
        int numberOfMines = printMessageUntilIntegerIsPassed(numberOfMinesStr);

        return new Config(rows, rows, numberOfMines);
    }

    @Override
    public Input getPlayerInput() {

        System.out.println("Select a row: ");
        int row = this.sc.nextInt();
        System.out.println("Select a column: ");
        int column = this.sc.nextInt();

        return new Input(row, column);
    }

    private Integer printMessageUntilIntegerIsPassed(String message) {
        int valueInt;
        while (true) {
            try {
                System.out.println(message);
                String valueStr = this.sc.nextLine();
                valueInt = Integer.parseInt(valueStr);
                break;
            }
            catch (NumberFormatException ignored) {}
        }
        return valueInt;
    }
}
