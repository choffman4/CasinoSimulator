package pokemon.masters.casinosimulator.gamelogic.Roulette;

public class SpinResult {
    private String color;
    private int number;
    private int column;
    private int row;
    private boolean isEven;
    private boolean isFirstHalf;

    public SpinResult(String color, int number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return "SpinResult{" +
                "color='" + color + '\'' +
                ", number=" + number +
                ", column=" + column +
                ", row=" + row +
                ", isEven=" + isEven +
                ", isFirstHalf=" + isFirstHalf +
                '}';
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }

    public boolean isFirstHalf() {
        return isFirstHalf;
    }

    public void setFirstHalf(boolean firstHalf) {
        isFirstHalf = firstHalf;
    }
}
