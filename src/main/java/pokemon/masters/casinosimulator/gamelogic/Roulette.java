package pokemon.masters.casinosimulator.gamelogic;

import java.util.Random;

public class Roulette {
    private int roleColor;
    Random random = new Random();

    public int getRoleNumber() {
        int roleNumber = random.nextInt(37);
        return roleNumber;
    }

    public int getRoleColor() {
        return roleColor;
    }

    public void setRoleColor(int roleColor) {
        this.roleColor = roleColor;
    }
}
