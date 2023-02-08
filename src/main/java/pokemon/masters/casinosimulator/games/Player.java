package pokemon.masters.casinosimulator.games;

public class Player {
    private String name;
    private int bankMoney;
    private int gamblingMoney;

    public Player(String name, int bankMoney, int gamblingMoney) {
        this.name = name;
        this.bankMoney = bankMoney;
        this.gamblingMoney = gamblingMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBankMoney() {
        return bankMoney;
    }

    public void setBankMoney(int bankMoney) {
        this.bankMoney = bankMoney;
    }

    public int getGamblingMoney() {
        return gamblingMoney;
    }

    public void setGamblingMoney(int gamblingMoney) {
        this.gamblingMoney = gamblingMoney;
    }
}
