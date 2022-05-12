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
    }
}

//punlci Game(uiHandler, ) {
//    this.inputHandler = inputHandler;
//    this.startGame()
//}
//
//private startGame() {
//    Config config = this.inputHandler.getConfig();
//    this.minefield = Minefield(config)
//}
//
//
//MINEFIELD;
//public Minefield(Config config) {
//    this.config = config;
//    this.generateMinefieldMatrix(config.rowSize, config.columnSize, config.numberOfBombs)
//}

    // UIHandler será uma interface que apenas possui um método chamado renderGame(), esse método recebe apenas
    // um parametro que é uma matrix contendo numeros de 0 a 8 ou as letras A, F e B, vou chamar isso de
    // ESTADO DE EXIBIÇÃO. Esse método renderiza o jogo.

    //InputHandler será uma interface que possui apenas um método chamado getPlayerInput(), ele nao recebe nada apenas
    // implementa algo que pedirá um input do player, e retorna este input num formato ADEQUADO para o MineField lidar.


    // O Game deve possuir o método actOnPlayerInput() resposável por acionar o InputHandler, passar o input ao
    // MineField para que o jogo seja processador, o MineField deverá retornar o ESTADO DE EXIBIÇÃO após interpretar o
    // input do player. Por fim o actOnPlayerInput passa o ESTADO DE EXIBIÇÃO para o uiHandler renderizar o jogo.

//    GAME
//actOnPlayerInput() {
//    Input input = this.inputHandler.getInput();
//    this.minefield.activateSlot(input.selectedRow, input.selectedColumn);
//    ExposedMatrix exposedMatrix = this.minefield.getMinefieldState;
//    this.uiHandler.renderGame(exposedMatrix);
//}
//
//
//
//
//MINEFIELD
//void activateSlot(Input input) {
//    Content content = this.openSlot(input.selectedRow, input.selectedColum);
//    if content = bomba {
//        return BOMB
//
//}
//ExposedMatrix getMinefieldState() {
//    return new ExposedMatrix(this.minefield)
//}
//
//
//onpeSlot(int row, int column) {
//    Slot slot = this.minefieldMatrix[row][columm];
//    Content content = slot.open();
//}
//
//
//    public ExposedMatrix(Minefield minefield){
//
//        this.matrix = ...
//    }