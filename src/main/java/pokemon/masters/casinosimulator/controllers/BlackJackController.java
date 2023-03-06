package pokemon.masters.casinosimulator.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class BlackJackController {
    //This function initialize runs whenever the scene loads

    @FXML
    ImageView playerCard1, playerCard2, playerCard3, playerCard4, playerCard5, dealerCard1, dealerCard2, dealerCard3, dealerCard4, dealerCard5,
            imgStackofCards, imgCenterChip;

    @FXML
    Text txtScore, txtDealerScore, txtMessage, txtDeal, txtMoney;

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

    NumberFormat format = NumberFormat.getInstance(Locale.US);
    int betValue;

    List<Integer> chosenCards = new ArrayList<>();

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
        txtMoney.setText("$" + (format.format(Player.getChipMoney())));
        chosenCards.clear();
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
                    while (true) {
                        int randomNum = (int) (Math.random() * 52);
                        if(!chosenCards.contains(randomNum)) {
                            int cardRef = randomNum / 13;
                            int cardValue = (randomNum - (13 * cardRef));

                            if (i == 0) playerCard1.setImage(cardImages.get(randomNum));
                            else playerCard2.setImage(cardImages.get(randomNum));

                            playerHand.add(CalculateScore(cardValue));
                            break;
                        }
                    }
                }
                DealerTurn();
                txtDeal.setText("Hit");
                newGame = false;
                Player.setChipMoney(Player.getChipMoney() - betValue);
            } else {
                while(true) {
                    int randomNum = (int) (Math.random() * 52);
                    if(!chosenCards.contains(randomNum)) {
                        int cardRef = randomNum / 13;
                        int cardValue = (randomNum - (13 * cardRef));

                        if (playerHand.size() == 2) playerCard3.setImage(cardImages.get(randomNum));
                        if (playerHand.size() == 3) playerCard4.setImage(cardImages.get(randomNum));
                        if (playerHand.size() == 4) playerCard5.setImage(cardImages.get(randomNum));
                        playerHand.add(CalculateScore(cardValue));
                        break;
                    }
                }
            }
            txtScore.setText(String.valueOf(PlayerSum(playerHand)));
            if (PlayerSum(playerHand) > 21) {
                playerBust = true;
                gameOver = true;
                CheckWin();
                return;
            }

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
        if (value == 9) return 11;
        else return -1;
    }

    private void DealerTurn() {
        if (newGame) {
            for (int i = 0; i < 2; i++) {
                while(true) {
                    int randomNum = (int) (Math.random() * 52);
                    if(!chosenCards.contains(randomNum)){
                        chosenCards.add(randomNum);
                        int cardRef = randomNum / 13;
                        int cardValue = (randomNum - (13 * cardRef));

                        if (i == 0) dealerHidden = randomNum;
                        else dealerCard2.setImage(cardImages.get(randomNum));

                        dealerHand.add(CalculateScore(cardValue));
                        break;
                    }
                }
            }
        } else {
            dealerCard1.setImage(cardImages.get(dealerHidden));
            while (PlayerSum(dealerHand) < 17) {
                while (true) {
                    int randomNum = (int) (Math.random() * 52);
                    if (!chosenCards.contains(randomNum)) {
                        chosenCards.add(randomNum);
                        int cardRef = randomNum / 13;
                        int cardValue = (randomNum - (13 * cardRef));

                        if (dealerHand.size() == 2) dealerCard3.setImage(cardImages.get(randomNum));
                        if (dealerHand.size() == 3) dealerCard4.setImage(cardImages.get(randomNum));
                        if (dealerHand.size() == 4) dealerCard5.setImage(cardImages.get(randomNum));
                        dealerHand.add(CalculateScore(cardValue));
                        break;
                    }
                }
            }
        }
        if (PlayerSum(dealerHand) > 21) dealerBust = true;
    }

    private void CheckWin() {
        txtDealerScore.setText(String.valueOf(PlayerSum(dealerHand)));
        txtDeal.setText("Restart");
        if (playerBust || PlayerSum(dealerHand) > PlayerSum(playerHand) && !dealerBust) {
            txtMessage.setText("You LOSE");
        } else if (dealerBust || PlayerSum(playerHand) > PlayerSum(dealerHand)) {
            txtMessage.setText("YOU WIN");
            if(playerHand.size() == 5) Player.setChipMoney(Player.getChipMoney() + (betValue * 4));
            else if(PlayerSum(playerHand) != 21) Player.setChipMoney(Player.getChipMoney() + (betValue * 2));
            else Player.setChipMoney(Player.getChipMoney() + (betValue * 3));
            txtMoney.setText("$" + (format.format(Player.getChipMoney())));
        } else if (PlayerSum(playerHand) == PlayerSum(dealerHand)) {
            txtMessage.setText("YOU TIED");
            Player.setChipMoney(Player.getChipMoney() + betValue);
            txtMoney.setText("$" + (format.format(Player.getChipMoney())));
        }
    }

    @FXML
    void bet(MouseEvent event) {
        if (newGame) {
            ImageView iv = (ImageView) event.getSource();
            String id = iv.getId();
            int imgIndex = GetChipImages(Integer.parseInt(id));

            if (Player.getChipMoney() >= Integer.parseInt(id)) {
                betValue = Integer.parseInt(id);
                txtMoney.setText("$" + format.format(Player.getChipMoney() - betValue));
                imgCenterChip.setImage(chipImages.get(imgIndex));
                placedBet = true;
            }
        }
    }

    int GetChipImages(int chipValue) {
        return switch (chipValue) {
            case 1 -> 0;
            case 5 -> 5;
            case 10 -> 1;
            case 20 -> 4;
            case 50 -> 6;
            case 100 -> 2;
            case 500 -> 7;
            case 1000 -> 3;
            case 5000 -> 8;
            default -> -1;
        };
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
