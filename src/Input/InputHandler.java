package Input;

public interface InputHandler {

     Input getPlayerInput();
     Config getGameConfig();

}


//InputHandler será uma interface que possui apenas um método chamado getPlayerInput(), ele nao recebe nada apenas
// implementa algo que pedirá um input do player, e retorna este input num formato ADEQUADO para o MineField lidar
