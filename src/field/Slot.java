package field;



public class Slot {

    private boolean hasMine;
    private boolean status = false;
    private Integer numberOfMinesAround;

    public Slot(boolean content) {
        this.hasMine = content;
    }

    public Integer getNumberOfMinesAround() {
        return this.numberOfMinesAround;
    }

    public void setHowManyMinesAroundMe(Integer howManyMinesAroundMe) {
        this.numberOfMinesAround = howManyMinesAroundMe;
    }

    public boolean isThereAMine() {
        return hasMine;
    }

    public void setMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isOpen() {
        return this.status;
    }

    public Slot setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public boolean activate() {
        this.status = true;
        return this.hasMine;
    }
}