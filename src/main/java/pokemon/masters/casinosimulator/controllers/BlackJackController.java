package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.*;
import java.util.*;

public class BlackJackController {
    //This function initialize runs whenever the scene loads

    @FXML
    ImageView playerCard1, playerCard2, playerCard3, playerCard4, playerCard5, dealerCard1, dealerCard2, dealerCard3, dealerCard4, dealerCard5,
            imgStackofCards, imgCenterChip;

    @FXML
    Text txtScore, txtDealerScore, txtMessage, txtDeal;

    @FXML
    StackPane btnBack;

    File cardFolder = new File("src/main/resources/pokemon/masters/casinosimulator/casinoassets/BlackJack/Cards");
    List<File> cardFiles = Arrays.asList(cardFolder.listFiles());

    File chipFolder = new File("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI");
    List<File> chipFiles = Arrays.asList(chipFolder.listFiles());

    List<Image> cardImages = new ArrayList<>();
    List<Image> chipImages = new ArrayList<>();

    boolean newGame;
    boolean gameOver;
    boolean placedBet;

    List<Integer> playerHand = new ArrayList<>();
    List<Integer> dealerHand = new ArrayList<>();
    int dealerHidden;

    boolean playerBust;
    boolean dealerBust;

    @FXML
    protected void initialize() {
        Reset();
    }

    private void Reset() {
        playerCard1.setImage(null);
        playerCard2.setImage(null);
        playerCard3.setImage(null);
        playerCard4.setImage(null);
        playerCard5.setImage(null);
        try {
            FileInputStream fs = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/BlackJack/Cards/cardBack_blue4.png");
            dealerCard1.setImage(new Image(fs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        placedBet = false;
        dealerCard2.setImage(null);
        dealerCard3.setImage(null);
        dealerCard4.setImage(null);
        dealerCard5.setImage(null);
        GetImages();
        newGame = true;
        gameOver = false;
        playerBust = false;
        dealerBust = false;
        playerHand.clear();
        txtScore.setText("");
        txtDeal.setText("Deal");
        txtMessage.setText("");
        txtDealerScore.setText("");
        playerHand.clear();
        dealerHand.clear();
        imgCenterChip.setImage(null);
    }

    //This button goes back a page to game selection
    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }

    @FXML
    void onStand(MouseEvent event) {
        if (!gameOver && !newGame) {
            gameOver = true;
            DealerTurn();
            CheckWin();
        }
    }

    @FXML
    void onDeal(MouseEvent event) {
        if (playerHand.size() < 5 && PlayerSum(playerHand) < 21 && !gameOver && placedBet) {
            if (newGame) {
                for (int i = 0; i < 2; i++) {
                    int randomNum = (int) (Math.random() * 52);
                    int cardRef = randomNum / 13;
                    int cardValue = (randomNum - (13 * cardRef));

                    if (i == 0) playerCard1.setImage(cardImages.get(randomNum));
                    else playerCard2.setImage(cardImages.get(randomNum));

                    playerHand.add(CalculateScore(cardValue));
                }
                DealerTurn();
                txtDeal.setText("Hit");
                newGame = false;
            } else {
                int randomNum = (int) (Math.random() * 52);
                int cardRef = randomNum / 13;
                int cardValue = (randomNum - (13 * cardRef));

                if (playerHand.size() == 2) playerCard3.setImage(cardImages.get(randomNum));
                if (playerHand.size() == 3) playerCard4.setImage(cardImages.get(randomNum));
                if (playerHand.size() == 4) playerCard5.setImage(cardImages.get(randomNum));
                playerHand.add(CalculateScore(cardValue));
            }
            if (PlayerSum(playerHand) > 21) playerBust = true;
            txtScore.setText(String.valueOf(PlayerSum(playerHand)));
        }
        if (gameOver) {
            Reset();
        }
    }

    private int PlayerSum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    private int CalculateScore(int value) {
        if (value == 0 || value > 9) return 10;
        if (value > 0 && value < 9) return (value + 1);
        if (value == 9) return 1;
        else return -1;
    }

    private void DealerTurn() {
        if (newGame) {
            for (int i = 0; i < 2; i++) {
                int randomNum = (int) (Math.random() * 52);
                int cardRef = randomNum / 13;
                int cardValue = (randomNum - (13 * cardRef));

                if (i == 0) dealerHidden = randomNum;
                else dealerCard2.setImage(cardImages.get(randomNum));

                dealerHand.add(CalculateScore(cardValue));
            }
        } else {
            dealerCard1.setImage(cardImages.get(dealerHidden));
            while (PlayerSum(dealerHand) < 17) {
                int randomNum = (int) (Math.random() * 52);
                int cardRef = randomNum / 13;
                int cardValue = (randomNum - (13 * cardRef));

                if (dealerHand.size() == 2) dealerCard3.setImage(cardImages.get(randomNum));
                if (dealerHand.size() == 3) dealerCard4.setImage(cardImages.get(randomNum));
                if (dealerHand.size() == 4) dealerCard5.setImage(cardImages.get(randomNum));
                dealerHand.add(CalculateScore(cardValue));
            }

        }
        if (PlayerSum(dealerHand) > 21) dealerBust = true;
    }

    private void CheckWin() {
        txtDealerScore.setText(String.valueOf(PlayerSum(dealerHand)));
        txtDeal.setText("Restart");
        if (dealerBust && !playerBust) {
            txtMessage.setText("YOU WIN!");
        } else if (!dealerBust && playerBust) {
            txtMessage.setText("YOU LOSE");
        } else if (playerBust && dealerBust) {
            txtMessage.setText("YOU TIED");
        } else if (PlayerSum(playerHand) == PlayerSum(dealerHand)) {
            txtMessage.setText("YOU TIED");
        } else if (PlayerSum(playerHand) > PlayerSum(dealerHand)) {
            txtMessage.setText("YOU WIN!");
        } else if (PlayerSum(playerHand) < PlayerSum(dealerHand)) {
            txtMessage.setText("YOU LOSE");
        }
    }

    @FXML
    void betFifty(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(6));
            placedBet = true;
        }
    }

    @FXML
    void betFive(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(5));
            placedBet = true;
        }
    }

    @FXML
    void betFiveHundred(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(7));
            placedBet = true;
        }
    }

    @FXML
    void betFiveThousand(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(8));
            placedBet = true;
        }
    }

    @FXML
    void betOne(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(0));
            placedBet = true;
        }
    }

    @FXML
    void betOneHundred(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(2));
            placedBet = true;
        }
    }

    @FXML
    void betOneThousand(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(3));
            placedBet = true;
        }
    }

    @FXML
    void betTen(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(1));
            placedBet = true;
        }
    }

    @FXML
    void betTwenty(MouseEvent event) {
        if (newGame) {
            imgCenterChip.setImage(chipImages.get(4));
            placedBet = true;
        }
    }

    @FXML
    void onRules(MouseEvent event) {

    }

    private void GetImages() {

        try {
            for (File cardFile : cardFiles) {
                if (!cardFile.toString().contains("Joker") && !cardFile.toString().contains("Back")) {
                    FileInputStream fs = new FileInputStream(cardFile);
                    cardImages.add(new Image(fs));
                }
            }
            for (File chipFile : chipFiles) {
                if (chipFile.toString().contains("Chip")) {
                    FileInputStream fs = new FileInputStream(chipFile);
                    chipImages.add(new Image(fs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
