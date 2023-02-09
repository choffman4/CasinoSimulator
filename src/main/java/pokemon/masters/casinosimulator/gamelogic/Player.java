package pokemon.masters.casinosimulator.gamelogic;

public class Player {
    private String name;
    private int gamblingMoney;

    public Player(String name, int bankMoney) {
        this.name = name;
        this.gamblingMoney = gamblingMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamblingMoney() {
        return gamblingMoney;
    }

    public void setGamblingMoney(int gamblingMoney) {
        this.gamblingMoney = gamblingMoney;
    }
}
