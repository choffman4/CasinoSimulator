package pokemon.masters.casinosimulator.gamelogic.Roulette;

public class Cell {

    private String name;
    private String color;
    private final int cellId;
    private int topCellNumber;
    private int bottomCellNumber;
    private int leftCellNumber;
    private int rightCellNumber;
    private int cellColumn;
    private int cellRow;
    private int payOut;
    private boolean isEven;

    private boolean hasChip;
    private int chipValue;

    public Cell(String color, int cellId, int payOut) {
        this.color = color;
        this.cellId = cellId;
        this.payOut = payOut;
    }

    public Cell(int cellId, int payOut, String name) {
        this.cellId = cellId;
        this.payOut = payOut;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Cell{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", cellId=" + cellId +
                ", topCellNumber=" + topCellNumber +
                ", bottomCellNumber=" + bottomCellNumber +
                ", leftCellNumber=" + leftCellNumber +
                ", rightCellNumber=" + rightCellNumber +
                ", cellColumn=" + cellColumn +
                ", cellRow=" + cellRow +
                ", payOut=" + payOut +
                ", isEven=" + isEven +
                ", hasChip=" + hasChip +
                ", chipValue=" + chipValue +
                '}';
    }

    public int getPayOut() {
        return payOut;
    }

    public void setPayOut(int payOut) {
        this.payOut = payOut;
    }

    public String getColor() {
        return color;
    }

    public int getCellId() {
        return cellId;
    }

    public int getTopCellNumber() {
        return topCellNumber;
    }

    public void setTopCellNumber(int topCellNumber) {
        this.topCellNumber = topCellNumber;
    }

    public int getBottomCellNumber() {
        return bottomCellNumber;
    }

    public void setBottomCellNumber(int bottomCellNumber) {
        this.bottomCellNumber = bottomCellNumber;
    }

    public int getLeftCellNumber() {
        return leftCellNumber;
    }

    public void setLeftCellNumber(int leftCellNumber) {
        this.leftCellNumber = leftCellNumber;
    }

    public int getRightCellNumber() {
        return rightCellNumber;
    }

    public void setRightCellNumber(int rightCellNumber) {
        this.rightCellNumber = rightCellNumber;
    }

    public int getCellColumn() {
        return cellColumn;
    }

    public void setCellColumn(int cellColumn) {
        this.cellColumn = cellColumn;
    }

    public int getCellRow() {
        return cellRow;
    }

    public void setCellRow(int cellRow) {
        this.cellRow = cellRow;
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }

    public boolean isHasChip() {
        return hasChip;
    }

    public void setHasChip(boolean hasChip) {
        this.hasChip = hasChip;
    }

    public int getChipValue() {
        return chipValue;
    }

    public void setChipValue(int chipValue) {
        this.chipValue = chipValue;
    }
}
