package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.IOException;

public class BlackJackController {
    //This function initialize runs whenever the scene loads
    @FXML
    protected void initialize() {
        System.out.println("Hello World");
    }

    //This button goes back a page to game selection
    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }

    @FXML
    void onStand(MouseEvent event) {

    }


    @FXML
    void onDeal(MouseEvent event) {

    }

    @FXML
    void betFifty(MouseEvent event) {

    }

    @FXML
    void betFive(MouseEvent event) {

    }

    @FXML
    void betFiveHundred(MouseEvent event) {

    }

    @FXML
    void betFiveThousand(MouseEvent event) {

    }

    @FXML
    void betOne(MouseEvent event) {

    }

    @FXML
    void betOneHundred(MouseEvent event) {

    }

    @FXML
    void betOneThousand(MouseEvent event) {

    }

    @FXML
    void betTen(MouseEvent event) {

    }

    @FXML
    void betTwenty(MouseEvent event) {

    }

    @FXML
    void onRules(MouseEvent event) {

    }
}
