package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.services.ChangeScene;
import pokemon.masters.casinosimulator.services.FormatMoney;

import java.io.IOException;

public class ChooseGameController {
    Player player;
    StackPane btnBack;

    //This function initialize runs whenever the scene loads
    @FXML
    protected void initialize() {
        txtChipCount.setText(FormatMoney.Format(Player.getChipMoney()));
    }

    @FXML
    private ImageView imgBack, imgBank, btnBlackJack, btnCraps, btnPoker, btnRoulette, btnSlots;
    @FXML
    private Text txtChipCount;

    //This button goes back a page to game selection
    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "mainMenuView.fxml");
    }
    @FXML
    protected void onSlotMachine(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "slotMachineView.fxml");
    }

    @FXML
    void onBlackJack(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "blackJackView.fxml");
    }

    @FXML
    void onCraps(MouseEvent event) throws IOException {
//        ChangeScene.changeScene(event, "crapsView.fxml");
    }

    @FXML
    void onPoker(MouseEvent event) throws IOException {
       ChangeScene.changeScene(event, "pokerView.fxml");
    }

    @FXML
    void onRoulette(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "rouletteView.fxml");
    }

    @FXML
    void onBank(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "bankView.fxml");
    }

}
