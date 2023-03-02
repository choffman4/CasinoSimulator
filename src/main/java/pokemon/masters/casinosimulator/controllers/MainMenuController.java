package pokemon.masters.casinosimulator.controllers;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainMenuController {

    @FXML
    private ImageView btnExit, btnMore, btnPlay;

    Image imageBtnDown, imageBtnUp;

    @FXML
    protected void initialize() throws FileNotFoundException {
        InputStream btnDown = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/ButtonDown.png");
        imageBtnDown = new Image(btnDown);
        InputStream btnUp = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/ButtonUp.png");
        imageBtnUp = new Image(btnUp);
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
    void onPlayGame(MouseEvent mouseEvent) throws IOException {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> btnPlay.setImage(imageBtnDown)),
                new KeyFrame(Duration.seconds(.1), event -> btnPlay.setImage(imageBtnUp)),
                new KeyFrame(Duration.seconds(.15), event -> btnPlay.setImage(imageBtnUp))
        );
        timeline.play();
        timeline.setOnFinished(e -> {
            try {
                ChangeScene.changeScene(mouseEvent, "chooseGameView.fxml");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

}
