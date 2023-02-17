package pokemon.masters.casinosimulator.gamelogic.slotmachine;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SlotMachine {

    private long animationStart;

    private boolean restart;

    public long getAnimationStart() {
        return animationStart;
    }

    public void setAnimationStart(long animationStart) {
        this.animationStart = animationStart;
    }

    public boolean isRestart() {
        return restart;
    }

    public void setRestart(boolean restart) {
        this.restart = restart;
    }

    public int randNum() {

        return ThreadLocalRandom.current().nextInt(0, 9);
    }

    public void slotAnimationTimer(ImageView slot1, ImageView slot2, ImageView slot3, ArrayList<Image> slotImages) {
        AnimationTimer tm = new AnimationTimer() {

            @Override
            public void handle(long now) {
                setAnimationStart(now);
                setImages(slot1, slot2, slot3, slotImages);
            }
        };
        tm.start();
    }

    public void setImages(ImageView slot1, ImageView slot2, ImageView slot3, ArrayList<Image> slotImages) {
        slot1.setImage(slotImages.get(randNum()));
        slot2.setImage(slotImages.get(randNum()));
        slot3.setImage(slotImages.get(randNum()));
    }
}
