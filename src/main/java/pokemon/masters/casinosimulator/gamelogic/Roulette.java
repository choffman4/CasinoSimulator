package pokemon.masters.casinosimulator.gamelogic;

import java.util.Random;

public class Roulette {
    Random random = new Random();

    //selected chip indicated by the arrow
    private int currentChipInHand;

    //Win Conditions
    //////////////////////////////////
    private boolean red;
    private boolean green;
    private boolean black;
    private boolean even;
    private boolean odd;

    private boolean first12;
    private boolean second12;
    private boolean third12;

    private boolean firstHalf;

    private boolean top12;
    private boolean middle12;
    private boolean bottom12;

    public int getCurrentChipInHand() {
        return currentChipInHand;
    }

    public void setCurrentChipInHand(int currentChipInHand) {
        this.currentChipInHand = currentChipInHand;
    }

    private int roleNumber;

    public boolean isOdd() {
        return odd;
    }

    public void setOdd(boolean odd) {
        this.odd = odd;
    }

    public boolean isFirst12() {
        return first12;
    }

    public void setFirst12(boolean first12) {
        this.first12 = first12;
    }

    public boolean isSecond12() {
        return second12;
    }

    public void setSecond12(boolean second12) {
        this.second12 = second12;
    }

    public boolean isThird12() {
        return third12;
    }

    public void setThird12(boolean third12) {
        this.third12 = third12;
    }

    public boolean isFirstHalf() {
        return firstHalf;
    }

    public void setFirstHalf(boolean firstHalf) {
        this.firstHalf = firstHalf;
    }

    public boolean isTop12() {
        return top12;
    }

    public void setTop12(boolean top12) {
        this.top12 = top12;
    }

    public boolean isMiddle12() {
        return middle12;
    }

    public void setMiddle12(boolean middle12) {
        this.middle12 = middle12;
    }

    public boolean isBottom12() {
        return bottom12;
    }

    public void setBottom12(boolean bottom12) {
        this.bottom12 = bottom12;
    }

    public boolean isEven() {
        return even;
    }

    public void setEven(boolean even) {
        this.even = even;
    }

    public boolean isGreen() {
        return green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public int getRoleNumber() {
        return roleNumber;
    }

    //logic behind spin the wheel win conditions
    public void setRoleNumber() {
        int rand = random.nextInt(37);
        if (rand == 0) {
            setEven(false);
            setOdd(false);
            setRed(false);
            setBlack(false);
            setGreen(true);
            //    if odd
        } else if (rand == 1 || rand == 3 || rand == 5 || rand == 7 || rand == 9 || rand == 11 || rand == 13
                || rand == 15 || rand == 17 || rand == 19 || rand == 21 || rand == 23 || rand == 25 || rand == 27
                || rand == 29 || rand == 31 || rand == 33 || rand == 35) {
            setEven(false);
            setEven(true);
            setRed(true);
            setBlack(false);
            setGreen(false);
            //    if even
        } else if (rand == 2 || rand == 4 || rand == 6 || rand == 8 || rand == 10 || rand == 12 || rand == 14
                || rand == 16 || rand == 18 || rand == 20 || rand == 22 || rand == 24 || rand == 26 || rand == 28
                || rand == 30 || rand == 32 || rand == 34 || rand == 36) {
            setEven(true);
            setOdd(false);
            setRed(false);
            setBlack(true);
            setGreen(false);
        }

        if (rand == 1 || rand == 4 || rand == 7 || rand == 10 || rand == 13 || rand == 16 || rand == 19 || rand == 22
                || rand == 25 || rand == 28 || rand == 31 || rand == 34) {
            setBottom12(true);
            setMiddle12(false);
            setTop12(false);
        } else if (rand == 2 || rand == 5 || rand == 8 || rand == 11 || rand == 14 || rand == 17 || rand == 20
                || rand == 23 || rand == 26 || rand == 29 || rand == 32 || rand == 35) {
            setBottom12(false);
            setMiddle12(true);
            setTop12(false);
        } else if (rand == 3 || rand == 6 || rand == 9 || rand == 12 || rand == 15 || rand == 18 || rand == 21
                || rand == 24 || rand == 27 || rand == 30 || rand == 33 || rand == 36) {
            setBottom12(false);
            setMiddle12(false);
            setTop12(true);
        }

        if (rand == 1 || rand == 2 || rand == 3 || rand == 4 || rand == 5 || rand == 6 || rand == 7
                || rand == 8 || rand == 9 || rand == 10 || rand == 11 || rand == 12) {
            setFirst12(true);
            setSecond12(false);
            setThird12(false);
        } else if (rand == 13 || rand == 14 || rand == 15 || rand == 16 || rand == 17 || rand == 18 || rand == 19
                || rand == 20 || rand == 21 || rand == 22 || rand == 23 || rand == 24) {
            setFirst12(false);
            setSecond12(true);
            setThird12(false);
        } else if (rand == 25 || rand == 26 || rand == 27 || rand == 28 || rand == 29 || rand == 30 || rand == 31
                || rand == 32 || rand == 33 || rand == 34 || rand == 35 || rand == 36) {
            setFirst12(false);
            setSecond12(false);
            setThird12(true);
        }

        if(rand == 1 || rand == 2 || rand == 3 || rand == 4 || rand == 5 || rand == 6 || rand == 7
                || rand == 8 || rand == 9 || rand == 10 || rand == 11 || rand == 12 || rand == 13 || rand == 14
                || rand == 15 || rand == 16 || rand == 17 || rand == 18) {
            setFirstHalf(true);
        } else if (rand == 19 || rand == 20 || rand == 21 || rand == 22 || rand == 23 || rand == 24 || rand == 25
                || rand == 26 || rand == 27 || rand == 28 || rand == 29 || rand == 30 || rand == 31 || rand == 32
                || rand == 33 || rand == 34 || rand == 35 || rand == 36){
            setFirstHalf(false);
        }

        this.roleNumber = rand;
    }

}
