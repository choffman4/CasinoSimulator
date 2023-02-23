package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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

    @FXML
    private StackPane btnRoll, btnRules, stack11, stack12, stack2, stack3, stack7, stackAnyCraps, stackBet10, stackBet4,
            stackBet5, stackBet6, stackBet8, stackBet9, stackDontPass, stackField, stackHardway2, stackHardway3,
            stackHardway4, stackHardway5, stackHorns, stackPass, btnBack;

    @FXML
    private ImageView imgArrowMarker1, imgArrowMarker10, imgArrowMarker100, imgArrowMarker1k, imgArrowMarker20,
            imgArrowMarker5, imgArrowMarker50, imgArrowMarker500, imgArrowMarker5k, imgBack, imgBet10, imgBet11,
            imgBet12, imgBet21, imgBet3, imgBet4, imgBet5, imgBet6, imgBet7, imgBet8, imgBet9, imgBetAnyCraps,
            imgBetDontPass1, imgBetField, imgBetHardway2, imgBetHardway3, imgBetHardway4, imgBetHardway5, imgBetHorns1,
            imgBetPass, imgDice1, imgDice2, imgPoint, imgPoint10, imgPoint4, imgPoint5, imgPoint6, imgPoint8, imgPoint9,
            imgRoll, imgRules, btnChip1, btnChip10, btnChip100, btnChip1K, btnChip20, btnChip5, btnChip50, btnChip500,
            btnChip5K, img8ExtraBet2, img8ExtraBet1, img6ExtraBet1, img6ExtraBet2;

    @FXML
    private Text txtBack, txtChipsAmount, txtRoll, txtRules;

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
    void onBet10(MouseEvent event) {

    }

    @FXML
    void onBet11(MouseEvent event) {

    }

    @FXML
    void onBet12(MouseEvent event) {

    }

    @FXML
    void onBet2(MouseEvent event) {

    }

    @FXML
    void onBet3(MouseEvent event) {

    }

    @FXML
    void onBet4(MouseEvent event) {

    }

    @FXML
    void onBet5(MouseEvent event) {

    }

    @FXML
    void onBet6(MouseEvent event) {

    }

    @FXML
    void onBet7(MouseEvent event) {

    }

    @FXML
    void onBet8(MouseEvent event) {

    }

    @FXML
    void onBet9(MouseEvent event) {

    }

    @FXML
    void onBetAny(MouseEvent event) {

    }

    @FXML
    void onBetDontPass(MouseEvent event) {

    }

    @FXML
    void onBetField(MouseEvent event) {

    }

    @FXML
    void onBetHardway2(MouseEvent event) {

    }

    @FXML
    void onBetHardway3(MouseEvent event) {

    }

    @FXML
    void onBetHardway4(MouseEvent event) {

    }

    @FXML
    void onBetHardway5(MouseEvent event) {

    }

    @FXML
    void onBetHorns(MouseEvent event) {

    }

    @FXML
    void onBetPassLine(MouseEvent event) {

    }

    @FXML
    void onRoll(MouseEvent event) {

    }

    @FXML
    void onRules(MouseEvent event) {

    }
}
