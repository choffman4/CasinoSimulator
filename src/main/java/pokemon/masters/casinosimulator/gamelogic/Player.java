package pokemon.masters.casinosimulator.gamelogic;

public class Player {
    private static String name;
    private static int chipMoney;
    private static int bankMoney;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static int getChipMoney() {
        return chipMoney;
    }

    public static void setChipMoney(int chipMoney) {
        Player.chipMoney = chipMoney;
    }

    public static int getBankMoney() {
        return bankMoney;
    }

    public static void setBankMoney(int bankMoney) {
        Player.bankMoney = bankMoney;
    }
}
