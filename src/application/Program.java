package application;

import UI.UIHandler;
import game.Game;
import Input.InputHandler;
import  UI.ConsoleUIHandler;
import Input.ConsoleInputHandler;

public class Program {

    public static void main(String[] args) {

        UIHandler consoleUserInterface = new ConsoleUIHandler();
        InputHandler consoleInput = (InputHandler) new ConsoleInputHandler();
        Game game = new Game(consoleInputHandler, consoleUIHandler);
            while (game.playerIsAlive()) {
                game.actOnPlayerInput();
            }

    }
}

    // UIHandler será uma interface que apenas possui um método chamado renderGame(), esse método recebe apenas
    // um parametro que é uma matrix contendo numeros de 0 a 8 ou as letras A, F e B, vou chamar isso de
    // ESTADO DE EXIBIÇÃO. Esse método renderiza o jogo.

    //InputHandler será uma interface que possui apenas um método chamado getPlayerInput(), ele nao recebe nada apenas
    // implementa algo que pedirá um input do player, e retorna este input num formato ADEQUADO para o MineField lidar.


    // O Game deve possuir o método actOnPlayerInput() resposável por acionar o InputHandler, passar o input ao
    // MineField para que o jogo seja processador, o MineField deverá retornar o ESTADO DE EXIBIÇÃO após interpretar o
    // input do player. Por fim o actOnPlayerInput passa o ESTADO DE EXIBIÇÃO para o uiHandler renderizar o jogo.
    //    actOnPlayerInput() {
    //        Input input = this.inputHandler.getInput();
    //        mineFieldState = this.mineField.actOnInput(input);
    //        this.uiHandler.renderGame(mineFieldState);
    //    }