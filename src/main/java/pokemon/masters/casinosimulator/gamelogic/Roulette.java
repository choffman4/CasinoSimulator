package pokemon.masters.casinosimulator.gamelogic;

import java.util.Random;

public class Roulette {
    private int roleColor;
    Random random = new Random();
    private int currentBetPos;
    private int currentChipBets;

    public int getCurrentBetPos() {
        return currentBetPos;
    }

    public void setCurrentBetPos(int currentBetPos) {
        this.currentBetPos = currentBetPos;
    }

    public int getCurrentChipBets() {
        return currentChipBets;
    }

    public void setCurrentChipBets(int currentChipBets) {
        this.currentChipBets = currentChipBets;
    }

    public int getRoleNumber() {
        return random.nextInt(37);
    }

    public int getRoleColor() {
        return roleColor;
    }

    public void setRoleColor(int roleColor) {
        this.roleColor = roleColor;
    }
}
