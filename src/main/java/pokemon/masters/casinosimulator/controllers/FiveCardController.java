package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.IOException;

public class FiveCardController {
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
    private StackPane btnBack;

    @FXML
    private ImageView btnChip1;

    @FXML
    private ImageView btnChip10;

    @FXML
    private ImageView btnChip100;

    @FXML
    private ImageView btnChip1K;

    @FXML
    private ImageView btnChip20;

    @FXML
    private ImageView btnChip5;

    @FXML
    private ImageView btnChip50;

    @FXML
    private ImageView btnChip500;

    @FXML
    private ImageView btnChip5K;

    @FXML
    private StackPane btnDraw;

    @FXML
    private StackPane btnRules;

    @FXML
    private ImageView imgArrowMarker1;

    @FXML
    private ImageView imgArrowMarker10;

    @FXML
    private ImageView imgArrowMarker100;

    @FXML
    private ImageView imgArrowMarker1k;

    @FXML
    private ImageView imgArrowMarker20;

    @FXML
    private ImageView imgArrowMarker5;

    @FXML
    private ImageView imgArrowMarker50;

    @FXML
    private ImageView imgArrowMarker500;

    @FXML
    private ImageView imgArrowMarker5k;

    @FXML
    private ImageView imgBack;

    @FXML
    private ImageView imgCard1;

    @FXML
    private ImageView imgCard2;

    @FXML
    private ImageView imgCard3;

    @FXML
    private ImageView imgCard4;

    @FXML
    private ImageView imgCard5;

    @FXML
    private ImageView imgCard6;

    @FXML
    private ImageView imgRules;

    @FXML
    private ImageView imgSpin;

    @FXML
    private Text txtBack;

    @FXML
    private Text txtChips;

    @FXML
    private Text txtRules;

    @FXML
    private Text txtSpin;

    @FXML
    void bet1(MouseEvent event) {

    }

    @FXML
    void bet10(MouseEvent event) {

    }

    @FXML
    void bet100(MouseEvent event) {

    }

    @FXML
    void bet1k(MouseEvent event) {

    }

    @FXML
    void bet20(MouseEvent event) {

    }

    @FXML
    void bet5(MouseEvent event) {

    }

    @FXML
    void bet50(MouseEvent event) {

    }

    @FXML
    void bet500(MouseEvent event) {

    }

    @FXML
    void bet5k(MouseEvent event) {

    }

    @FXML
    void onDraw(MouseEvent event) {

    }

    @FXML
    void onRules(MouseEvent event) {

    }
}
