package pokemon.masters.casinosimulator.controllers;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.IOException;

public class SlotMachineController {

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
}
