package pokemon.masters.casinosimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pokemon.masters.casinosimulator.gamelogic.Player;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            //First window to open when program is launched is "mainMenuView.fxml"
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class
                    .getResource("mainMenuView.fxml"));
            //Default Window size for application (1050 W, 650 H)
            Scene scene = new Scene(fxmlLoader.load(), 1050, 650);
            stage.setTitle("Casino Simulator Menu");
            stage.setScene(scene);
            stage.show();
            //initializing player data
            Player.setName("Player");
            Player.setChipMoney( 10000);
            Player.setBankMoney(15000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}