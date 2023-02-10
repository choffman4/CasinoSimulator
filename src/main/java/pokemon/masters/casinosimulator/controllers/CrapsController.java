package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.IOException;

public class CrapsController {
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

    public void onRoll(MouseEvent mouseEvent) {
    }

    public void betOne(MouseEvent mouseEvent) {
    }

    public void betFive(MouseEvent mouseEvent) {
    }

    public void betTen(MouseEvent mouseEvent) {
    }

    public void betTwenty(MouseEvent mouseEvent) {
    }

    public void betFifty(MouseEvent mouseEvent) {
    }

    public void betOneHundred(MouseEvent mouseEvent) {
    }

    public void betFiveHundred(MouseEvent mouseEvent) {
    }

    public void betOneThousand(MouseEvent mouseEvent) {
    }

    public void betFiveThousand(MouseEvent mouseEvent) {
    }
}
