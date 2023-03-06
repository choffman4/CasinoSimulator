package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.services.ChangeScene;
import pokemon.masters.casinosimulator.services.FormatMoney;

import java.io.IOException;

public class BankController {

    @FXML
    private ImageView imgBack, imgDeposit, imgWithdraw;

    @FXML
    private Text txtBank, txtChips;

    @FXML
    private TextField txtDeposit, txtWithdraw;

    public void initialize() {
        refreshText();
    }
    public void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }

    //Withdraws money from bankMoney into players chipMoney
    public void onWithdraw(MouseEvent mouseEvent) {
        int withDrawAmount = Math.abs(Integer.parseInt(txtWithdraw.getText()));
        int bankMoney = Player.getBankMoney();
        int chipMoney = Player.getChipMoney();

        if (withDrawAmount <= bankMoney) {
            bankMoney -= withDrawAmount;
            chipMoney += withDrawAmount;

            setPlayerMoney(bankMoney, chipMoney);
            refreshText();
        }

    }

    //Deposits money from chipMoney into players bankMoney
    public void onDeposit(MouseEvent mouseEvent) {

        int depositAmount = Math.abs(Integer.parseInt(txtDeposit.getText()));
        int bankMoney = Player.getBankMoney();
        int chipMoney = Player.getChipMoney();

        if(depositAmount > Player.getChipMoney()) {
            depositAmount = Player.getChipMoney();
        }

        bankMoney += depositAmount;
        chipMoney -= depositAmount;

        setPlayerMoney(bankMoney, chipMoney);
        refreshText();
    }

    public void refreshText() {
        txtBank.setText(FormatMoney.Format(Player.getBankMoney()));
        txtChips.setText(FormatMoney.Format(Player.getChipMoney()));
        txtDeposit.setText("");
        txtWithdraw.setText("");
    }

    public void setPlayerMoney(int bankMoney, int chipMoney) {
        Player.setBankMoney(bankMoney);
        Player.setChipMoney(chipMoney);
    }

}
