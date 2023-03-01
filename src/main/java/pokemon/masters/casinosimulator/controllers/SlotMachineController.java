package pokemon.masters.casinosimulator.controllers;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.gamelogic.slotmachine.SlotMachine;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SlotMachineController {

    private boolean displayRules = false;

    public boolean isDisplayRules() {
        return displayRules;
    }
    public void setDisplayRules(boolean displayRules) {
        this.displayRules = displayRules;
    }

    TextArea rulesTextArea;

    SlotMachine slots = new SlotMachine();

    protected ArrayList<Image> slotImages = new ArrayList<>();

    protected ArrayList<ImageView> yellowMarkers = new ArrayList<>();

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

            yellowMarkers.add(imgArrowMarker1);
            yellowMarkers.add(imgArrowMarker5);
            yellowMarkers.add(imgArrowMarker10);
            yellowMarkers.add(imgArrowMarker20);
            yellowMarkers.add(imgArrowMarker50);
            yellowMarkers.add(imgArrowMarker100);
            yellowMarkers.add(imgArrowMarker500);
            yellowMarkers.add(imgArrowMarker1k);
            yellowMarkers.add(imgArrowMarker5k);

            slots.setMarkersInvisible(yellowMarkers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Pane rulesPane;

    @FXML
    private StackPane btnBack, btnSpin, btnRules;

    @FXML
    private ImageView btnChip1, btnChip10, btnChip100, btnChip1K, btnChip20, btnChip5, btnChip50, btnChip500, btnChip5K,
            imgArrowMarker1, imgArrowMarker10, imgArrowMarker100, imgArrowMarker1k, imgArrowMarker20, imgArrowMarker5,
            imgArrowMarker50, imgArrowMarker500, imgArrowMarker5k, imgBack, imgRules, imgSlot1,
            imgSlot2, imgSlot3, imgSpin;

    @FXML
    private Text txtBack, txtBet, txtChipsAmount, txtRules, txtSpin, txtChipsBet;

    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }
    @FXML
    void onRules(MouseEvent event) {
        if (!displayRules) {
            // Create the TextArea and set rulesVisible to true
            rulesTextArea = new TextArea("Spin to win!\n" +
                    "Payouts based on Bet/Result are listed under the rules button.");
            rulesTextArea.setPrefSize(400, 400);
            rulesTextArea.setEditable(false);
            rulesTextArea.setLayoutX((rulesPane.getWidth() - rulesTextArea.getPrefWidth()) / 2);
            rulesTextArea.setLayoutY((rulesPane.getHeight() - rulesTextArea.getPrefHeight()) / 2);
            rulesPane.getChildren().add(rulesTextArea);
            displayRules = true;
        } else {
            // Delete the TextArea and set rulesVisible to false
            rulesPane.getChildren().remove(rulesTextArea);
            displayRules = false;
        }
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
                //lasts for 3 seconds
                if (elapsedTime >= 3_000_000_000L) {
                    this.stop();
                    btnSpin.setDisable(false);
                    slots.playerWon(imgSlot1, imgSlot2, imgSlot3);
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
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker50, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 50) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 50);
            slots.addMinusPlayerMoney(-50);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }

    @FXML
    void betFive(MouseEvent event) {
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker5, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 5) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 5);
            slots.addMinusPlayerMoney(-5);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }

    @FXML
    void betFiveHundred(MouseEvent event) {
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker500, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 500) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 500);
            slots.addMinusPlayerMoney(-500);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }

    @FXML
    void betFiveThousand(MouseEvent event) {
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker5k, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 5000) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 5000);
            slots.addMinusPlayerMoney(-5000);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }

    @FXML
    void betOne(MouseEvent event) {
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker1, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 1) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 1);
            slots.addMinusPlayerMoney(-1);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }

    @FXML
    void betOneHundred(MouseEvent event) {
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker100, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 100) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 100);
            slots.addMinusPlayerMoney(-100);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }

    @FXML
    void betOneThousand(MouseEvent event) {
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker1k, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 1000) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 1000);
            slots.addMinusPlayerMoney(-1000);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }

    @FXML
    void betTen(MouseEvent event) {
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker10, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 10) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 10);
            slots.addMinusPlayerMoney(-10);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }

    @FXML
    void betTwenty(MouseEvent event) {
        // show what got selected
        slots.changeMarkerPosition(imgArrowMarker20, yellowMarkers);
        // add the money to the bet if the user has enough
        if ((Player.getChipMoney() - 20) >= 0) {
            slots.addMoneyToBet(txtChipsBet, 20);
            slots.addMinusPlayerMoney(-20);
            slots.showPlayerMoney(txtChipsAmount);
        }
    }
}
