package pokemon.masters.casinosimulator.controllers;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SlotMachineController {

    protected ArrayList<Image> slotImages = new ArrayList<>();

    @FXML
    protected void initialize() {
//        slotImages.clear();

        try {
            InputStream banana = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelBanana.png");
            Image imgBanana = new Image(banana);
            slotImages.add(imgBanana);

            InputStream bars = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelBars.png");
            Image imgBars = new Image(bars);
            slotImages.add(imgBars);

            InputStream bell = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelBell.png");
            Image imgBell = new Image(bell);
            slotImages.add(imgBell);

            InputStream cherry = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelCherry.png");
            Image imgCherry = new Image(cherry);
            slotImages.add(imgCherry);

            InputStream lemon = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelLemon.png");
            Image imgLemon = new Image(lemon);
            slotImages.add(imgLemon);

            InputStream melon = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelMelon.png");
            Image imgMelon = new Image(melon);
            slotImages.add(imgMelon);

            InputStream orange = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelOrange.png");
            Image imgOrange = new Image(orange);
            slotImages.add(imgOrange);

            InputStream plum = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelPlum.png");
            Image imgPlum = new Image(plum);
            slotImages.add(imgPlum);

            InputStream seven = new FileInputStream("src\\main\\resources\\pokemon\\masters\\casinosimulator\\casinoassets\\Slots\\WheelSeven.png");
            Image imgSeven = new Image(seven);
            slotImages.add(imgSeven);

            System.out.println(slotImages);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private StackPane btnBack, btnSpin, btnRules;

    @FXML
    private ImageView btnChip1, btnChip10, btnChip100, btnChip1K, btnChip20, btnChip5, btnChip50, btnChip500, btnChip5K,
            imgArrowMarker1, imgArrowMarker10, imgArrowMarker100, imgArrowMarker1k, imgArrowMarker20, imgArrowMarker5,
            imgArrowMarker50, imgArrowMarker500, imgArrowMarker5k, imgBack, imgBetContainer, imgRules, imgSlot1,
            imgSlot2, imgSlot3, imgSpin;

    @FXML
    private Text txtBack, txtBet, txtChipsAmount, txtRules, txtSpin;

    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }
    @FXML
    void onRules(MouseEvent event) {

    }

    @FXML
    void onSpin(MouseEvent event) {

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

    public int randNum() {

        return ThreadLocalRandom.current().nextInt(0, 4);
    }

    public boolean randTF() {

        return ThreadLocalRandom.current().nextBoolean();
    }

}
