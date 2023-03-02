package pokemon.masters.casinosimulator.gamelogic.slotmachine;

import javafx.animation.AnimationTimer;
import javafx.event.EventTarget;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.services.FormatMoney;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SlotMachine {

    FormatMoney formatMoney = new FormatMoney();

    private long animationStart;

    private long startTime = 0;

    private int moneyBet = 0;

    public long getAnimationStart() {
        return animationStart;
    }

    public void setAnimationStart(long animationStart) {
        this.animationStart = animationStart;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getMoneyBet() {
        return moneyBet;
    }

    public void setMoneyBet(int moneyBet) {
        this.moneyBet = moneyBet;
    }

    public int randNum() {

        return ThreadLocalRandom.current().nextInt(0, 9);
    }

    public void setImages(ImageView slot1, ImageView slot2, ImageView slot3, ArrayList<Image> slotImages) {
        slot1.setImage(slotImages.get(randNum()));
        slot2.setImage(slotImages.get(randNum()));
        slot3.setImage(slotImages.get(randNum()));
    }

    public void showPlayerMoney(Text chipsDisplay) {
        String formattedMoney = formatMoney.Format(Player.getChipMoney());
        chipsDisplay.setText(formattedMoney);
    }

    public void addMinusPlayerMoney(int moneyChange) {
        Player.setChipMoney(Player.getChipMoney() + moneyChange);
    }

    public void setMarkersInvisible(ArrayList<ImageView> markers) {
        // make markers invisible
        // disable and transparent to mouse is there for precaution
        for (ImageView marker: markers
        ) {
            marker.setVisible(false);
            marker.setDisable(true);
            marker.setMouseTransparent(true);
        }
    }

    public void changeMarkerPosition(ImageView marker, ArrayList<ImageView> otherMarkers) {
        setMarkersInvisible(otherMarkers);
        // enable the one above the chip
        marker.setVisible(true);
    }

    public void addMoneyToBet(Text betDisplay, int moneyToAdd) {
        // set the temporary variable for our money bet
        setMoneyBet(getMoneyBet() + moneyToAdd);
        // formats money
        String formattedMoney = formatMoney.Format(getMoneyBet());
        betDisplay.setText(formattedMoney);
    }

    public Boolean winCheck(ImageView slot1, ImageView slot2, ImageView slot3) {
        Boolean win = false;
        // get url of the images
        Image slot1Image = slot1.getImage();
        Image slot2Image = slot2.getImage();
        Image slot3Image = slot3.getImage();
        // check if the name of the files is all the same
        if (slot1Image == slot2Image) {
            if (slot1Image == slot3Image) {
                win = true;
            }
        }
        // return true or false
        return win;
    }

    public void payoutCalculator(ImageView itemWon, int betAmount, ArrayList<Image> slotImages) {
        // get what the item matched was
        Image item = itemWon.getImage();

        for (Image slotImage: slotImages) {
            if ( item == slotImage) {
                int betEarnings;
                int totalEarnings;
                // calculate bet amount by what the payout for that item is
                switch (slotImages.indexOf(slotImage)) {
                    case 0:
                        betEarnings = getMoneyBet() * 3;
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                    case 1:
                        betEarnings = getMoneyBet() * 100;
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                    case 2:
                        betEarnings = getMoneyBet() * 50;
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                    case 3:
                        betEarnings = getMoneyBet() * 20;
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                    case 4:
                        betEarnings = getMoneyBet();
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                    case 5:
                        betEarnings = getMoneyBet() * 5;
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                    case 6:
                        betEarnings = getMoneyBet() * 2;
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                    case 7:
                        betEarnings = getMoneyBet() * 10;
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                    case 8:
                        betEarnings = getMoneyBet() * 1000;
                        totalEarnings = betEarnings + getMoneyBet();
                        // give it to the player
                        addMinusPlayerMoney(totalEarnings);
                        break;
                }
            }
        }
    }

    public void playerWon(ImageView slot1, ImageView slot2, ImageView slot3, ArrayList<Image> slotImages, Text betText) {
        // call wincheck
        Boolean win = winCheck(slot1, slot2, slot3);
        // if win is true then
        if ( win == true) {
            // call payout
            payoutCalculator(slot1, getMoneyBet(), slotImages);
        }
        // reset bet
        setMoneyBet(0);
        betText.setText(formatMoney.Format(getMoneyBet()));
    }
}
