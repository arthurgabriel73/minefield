package Input;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler{

    Scanner sc = new Scanner(System.in);

    @Override
    public Config getGameConfig() {
        int rows = printMessageUntilIntegerIsPassed("Select the number of rows: ");
        int columns = printMessageUntilIntegerIsPassed("Select the number of columns: ");
        System.out.print("Select the number of mines to be set up on the field: ");
        String numberOfMinesStr = sc.nextLine();
        int numberOfMines = printMessageUntilIntegerIsPassed(numberOfMinesStr);

        return new Config(rows, columns, numberOfMines);
    }

    @Override
    public Input getPlayerInput() {

        System.out.print("Select a row: ");
        int row = this.sc.nextInt();
        System.out.print("Select a column: ");
        int column = this.sc.nextInt();

        return new Input(row, column);
    }

    private Integer printMessageUntilIntegerIsPassed(String message) {
        int valueInt;
        System.out.print(message);
        while (true) {
            try {
                String valueStr = this.sc.next();
                valueInt = Integer.parseInt(valueStr);
                break;
            }
            catch (NumberFormatException e) {
                System.out.print("Please insert a valid value: ");
            }
        } return valueInt;
    }
}
