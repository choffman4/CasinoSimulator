package pokemon.masters.casinosimulator.services;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pokemon.masters.casinosimulator.gamelogic.Player;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChangeScene {

    private static Stage stage;
    private static Scene scene;

    //This function allows the user to change between scenes on buttons like backPage or ChooseGame functions
    public static void changeScene(Event event, String strFXMLFileName) throws IOException {

        URL url = new File("src/main/resources/pokemon/masters/casinosimulator/" + strFXMLFileName).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
