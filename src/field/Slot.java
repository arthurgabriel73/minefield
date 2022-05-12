package field;



public class Slot {

    private boolean hasMine;
    private boolean status = false;
    private Integer howManyMinesAroundMe;

    public Slot(boolean content) {
        this.hasMine = content;
        this.howManyMinesAroundMe = howManyMinesAroundMe;
    }

    public void setMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isOpen() {
        return this.status;
    }

    public boolean activate() {
        this.status = true;
        return this.hasMine;
    }
}



//    public Integer getHowManyMinesAroundMe() {
//        int minesAround = 0;
//
//        for (int i = 0; i < slotMatrix.length; i++) {
//            for (int j = 0; j < slotMatrix.length; j++) {
//
//                if (positionExists(i - 1, j - 1)) {
//                    if (slotMatrix[i - 1][j - 1].getContent()) {
//                        minesAround += 1;
//                    }
//                }
//                if (positionExists(i - 1, j)) {
//                    if (slotMatrix[i - 1][j].getContent()) {
//                        minesAround += 1;
//                    }
//                }
//                if (positionExists(i - 1, j + 1)) {
//                    if (slotMatrix[i - 1][j + 1].getContent()) {
//                        minesAround += 1;
//                    }
//                }
//                if (positionExists(i, j - 1)) {
//                    if (slotMatrix[i][j - 1].getContent()) {
//                        minesAround += 1;
//                    }
//                }
//                if (positionExists(i, j + 1)) {
//                    if (slotMatrix[i][j + 1].getContent()) {
//                        minesAround += 1;
//                    }
//                }
//                if (positionExists(i + 1, j - 1)) {
//                    if (slotMatrix[i + 1][j - 1].getContent()) {
//                        minesAround += 1;
//                    }
//                }
//                if (positionExists(i + 1, j)) {
//                    if (slotMatrix[i + 1][j].getContent()) {
//                        minesAround += 1;
//                    }
//                }
//                if (positionExists(i + 1, j + 1)) {
//                    if (slotMatrix[i + 1][j + 1].getContent()) {
//                        minesAround += 1;
//                    }
//                }
//            }
//        }
//        return this.howManyMinesAroundMe = minesAround;
//    }
//
//    private boolean positionExists(int row, int column) {
//        return row >= 0 && row < slotMatrix.length && column >= 0 && column < slotMatrix.length;
//    }