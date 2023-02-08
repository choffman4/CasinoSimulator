package pokemon.masters.casinosimulator.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //First window to open when program is launched is "chooseGameView.fxml"
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chooseGameView.fxml"));
        //Default Window size for application (1050 W, 650 H)
        Scene scene = new Scene(fxmlLoader.load(), 1050, 650);
        stage.setTitle("Casino Simulator Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}