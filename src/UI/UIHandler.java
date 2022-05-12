package UI;

import java.lang.reflect.Array;

public interface UIHandler {

    void renderGame(ExposedMatrix exposedMatrix);


    // UIHandler será uma interface que apenas possui um método chamado renderGame(), esse método recebe apenas
    // um parametro que é uma matrix contendo numeros de 0 a 8 ou as letras A, F e B, vou chamar isso de
    // ESTADO DE EXIBIÇÃO. Esse método renderiza o jogo.
}
