package pokemon.masters.casinosimulator.gamelogic.slotmachine;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.gamelogic.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SlotMachine {

    private long animationStart;

    private long startTime = 0;

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

    public int randNum() {

        return ThreadLocalRandom.current().nextInt(0, 9);
    }

    public void setImages(ImageView slot1, ImageView slot2, ImageView slot3, ArrayList<Image> slotImages) {
        slot1.setImage(slotImages.get(randNum()));
        slot2.setImage(slotImages.get(randNum()));
        slot3.setImage(slotImages.get(randNum()));
    }

    public void showPlayerMoney(Text chipsDisplay) {
        int chips = Player.getChipMoney();
        chipsDisplay.setText("$" + chips);
    }
}
