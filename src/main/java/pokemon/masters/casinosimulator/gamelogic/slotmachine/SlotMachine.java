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
        // check if the name of the files is all the same
        // return true or false
        return false;
    }

    public void payoutCalculator(String itemWon, int betAmount) {
        // get what the item matched was
        // calculate bet amount by what the payout for that item is
        // give it to the player
    }

    public void playerWon(ImageView slot1, ImageView slot2, ImageView slot3) {
        // call wincheck
        // if win is true then
        // call payout and reset bet
    }
}
