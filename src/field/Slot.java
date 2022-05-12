package field;



public class Slot {

    private boolean hasMine;
    private boolean status = false;
    private Integer howManyMinesAroundMe;

    public Slot(boolean content) {
        this.hasMine = content;
    }

    public Integer getHowManyMinesAroundMe() {
        return howManyMinesAroundMe;
    }

    public void setHowManyMinesAroundMe(Integer howManyMinesAroundMe) {
        this.howManyMinesAroundMe = howManyMinesAroundMe;
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean activate() {
        this.status = true;
        return this.hasMine;
    }
}