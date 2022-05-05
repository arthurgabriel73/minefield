package game;

import field.Slot;

public class Game {

    private boolean isAlive = true;
    private Slot chosenSlot;

    public Game() {

    }

    public Game(boolean isAlive, Slot chosenSlot) {
        this.isAlive = isAlive;
        this.chosenSlot = chosenSlot;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Slot getChosenSlot() {
        return chosenSlot;
    }

    public void setChosenSlot(Slot chosenSlot) {
        this.chosenSlot = chosenSlot;
    }


}