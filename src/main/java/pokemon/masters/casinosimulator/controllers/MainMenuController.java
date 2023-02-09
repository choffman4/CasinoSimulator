package pokemon.masters.casinosimulator.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.IOException;

public class MainMenuController {
    @FXML
    private ImageView btnExit, btnMore, btnPlay;

    @FXML
    protected void initialize() {
        System.out.println("Welcome to Casino Simulator");
        //Player player = new Player("Player", 4000);
    }

    //This button exits the game
    @FXML
    void onExitGame(MouseEvent event) {
        Platform.exit();
    }
    //This button gives more options
    @FXML
    void onMoreOptions(MouseEvent event) {
        System.out.println("More Options Button has been clicked");
    }

    @FXML
    void onPlayGame(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }
}
