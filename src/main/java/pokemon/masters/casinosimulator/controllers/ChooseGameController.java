package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.IOException;

public class ChooseGameController {

    //This function initialize runs whenever the scene loads
    @FXML
    protected void initialize() {
        txtChipCount.setText("$4,000");
        //stage.setUserData(object);
    }

    @FXML
    private ImageView btnBack, btnBank, btnBlackJack, btnCraps, btnPoker, btnRoulette, btnSlots;
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
//        ChangeScene.changeScene(event, "pokerView.fxml");
    }

    @FXML
    void onRoulette(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "rouletteView.fxml");
    }

}
