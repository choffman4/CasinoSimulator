package pokemon.masters.casinosimulator.controllers;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pokemon.masters.casinosimulator.gamelogic.slotmachine.SlotMachine;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SlotMachineController {

    SlotMachine slots = new SlotMachine();

    protected ArrayList<Image> slotImages = new ArrayList<>();

    @FXML
    protected void initialize() {

        try {
            // show how much money the player has
            slots.showPlayerMoney(txtChipsAmount);

            // adds all the images to slot images array on start, this is to be able to display and grab easily
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
        //the animation
        AnimationTimer tm = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (slots.getStartTime() == 0) {
                    slots.setStartTime(now);
                    this.start();
                    btnSpin.setDisable(true);
                }

                long elapsedTime = slots.getAnimationStart() - slots.getStartTime();

                System.out.println(elapsedTime);
                //lasts for 5 seconds
                if (elapsedTime >= 5_000_000_000L) {
                    this.stop();
                    btnSpin.setDisable(false);
                } else {
                    slots.setAnimationStart(now);
                    //set random images
                    slots.setImages(imgSlot1, imgSlot2, imgSlot3, slotImages);
                }
            }

        };
        //these need to be reset to spin again
        slots.setStartTime(0);
        slots.setAnimationStart(0);
        tm.handle(0);
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
}
