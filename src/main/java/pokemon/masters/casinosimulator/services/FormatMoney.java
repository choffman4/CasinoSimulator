package pokemon.masters.casinosimulator.services;

import java.text.DecimalFormat;

public class FormatMoney {
    //this function formats money, example: $1,100,000
    public static String Format(int money) {
        DecimalFormat formatter = new DecimalFormat("$#,###");
        String formattedMoney = formatter.format(money);

        return formattedMoney;
    }
}
