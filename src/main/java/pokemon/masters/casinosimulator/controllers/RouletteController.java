package pokemon.masters.casinosimulator.controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.gamelogic.Roulette.Cell;
import pokemon.masters.casinosimulator.gamelogic.Roulette.RouletteBoard;
import pokemon.masters.casinosimulator.gamelogic.Roulette.SpinResult;
import pokemon.masters.casinosimulator.services.ChangeScene;
import pokemon.masters.casinosimulator.services.FormatMoney;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class RouletteController {

    private final Image[] chipImage = new Image[10];
    private RouletteBoard gameBoard = new RouletteBoard();

    private boolean displayRules = false;
    TextArea rulesTextArea;



    @FXML
    private Pane rootPane;

    @FXML
    private GridPane gridNumbers;
    @FXML
    private ImageView img19to36, img1st12, img1to18, img2nd12, img2to1bottom, img2to1middle,
            img2to1top, img3rd12, imgArrowMarker1, imgArrowMarker10, imgArrowMarker20, imgArrowMarker50, imgArrowMarker100,
            imgArrowMarker5, imgArrowMarker500, imgArrowMarker1k, imgArrowMarker5k, imgBlackDiamond, imgEVEN, imgODD,
            imgRedDiamond, imgBack, imgRules, imgSpin, imgWheel;

    @FXML
    private StackPane btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16,
            btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32,
            btn33, btn34, btn35, btn36, btnBack, btnRules, btnSpin, btn1st12, btn1to18, btnEVEN, btn2nd12, btn3rd12,
            btnRedDiamond, btnBlackDiamond, btnODD, btn19to36, btn2to1bottom, btn2to1middle, btn2to1top;

    @FXML
    private ImageView img0, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16,
            img17, img18, img19, img20, img21, img22, img23, img24, img25, img26, img27, img28, img29, img30, img31, img32,
            img33, img34, img35, img36;

    @FXML
    private Text txtChipsAmount, txtResultNumber;
    @FXML
    private Circle circleResultColor;

    //Initialize controller from fxml file
    @FXML
    protected void initialize() {
        resetArrows();
        System.out.println("Welcome to Roulette");

        //get poker-chip images
        getChipImages();

        //loop through grid and add a stackPane with child image
        getGridButtons();

        //Initialize buttons in grid number 1-36
        initializeGridButtons();

        //set chip money
        txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));

        circleResultColor.setVisible(false);
        txtResultNumber.setVisible(false);
    }

    //loop through grid and add a stack pane with child image
    private void getGridButtons() {
        for (int col = 0; col < 12; col++) {
            for (int row = 2; row >= 0; row--) {
                StackPane stackPane = new StackPane();
                ImageView imageView = new ImageView();

                imageView.setFitHeight(46);
                imageView.setFitWidth(46);
                stackPane.getChildren().add(imageView);

                gridNumbers.add(stackPane, col, row);

            }
        }
    }

    //These are all the buttons and images associated with each of the numbers 1-36
    private void initializeGridButtons() {
        btn1 = (StackPane) gridNumbers.getChildren().get(0);
        img1 = (ImageView) btn1.getChildren().get(0);
        btn2 = (StackPane) gridNumbers.getChildren().get(1);
        img2 = (ImageView) btn2.getChildren().get(0);
        btn3 = (StackPane) gridNumbers.getChildren().get(2);
        img3 = (ImageView) btn3.getChildren().get(0);
        btn4 = (StackPane) gridNumbers.getChildren().get(3);
        img4 = (ImageView) btn4.getChildren().get(0);
        btn5 = (StackPane) gridNumbers.getChildren().get(4);
        img5 = (ImageView) btn5.getChildren().get(0);
        btn6 = (StackPane) gridNumbers.getChildren().get(5);
        img6 = (ImageView) btn6.getChildren().get(0);
        btn7 = (StackPane) gridNumbers.getChildren().get(6);
        img7 = (ImageView) btn7.getChildren().get(0);
        btn8 = (StackPane) gridNumbers.getChildren().get(7);
        img8 = (ImageView) btn8.getChildren().get(0);
        btn9 = (StackPane) gridNumbers.getChildren().get(8);
        img9 = (ImageView) btn9.getChildren().get(0);
        btn10 = (StackPane) gridNumbers.getChildren().get(9);
        img10 = (ImageView) btn10.getChildren().get(0);
        btn11 = (StackPane) gridNumbers.getChildren().get(10);
        img11 = (ImageView) btn11.getChildren().get(0);
        btn12 = (StackPane) gridNumbers.getChildren().get(11);
        img12 = (ImageView) btn12.getChildren().get(0);

        btn13 = (StackPane) gridNumbers.getChildren().get(12);
        img13 = (ImageView) btn13.getChildren().get(0);
        btn14 = (StackPane) gridNumbers.getChildren().get(13);
        img14 = (ImageView) btn14.getChildren().get(0);
        btn15 = (StackPane) gridNumbers.getChildren().get(14);
        img15 = (ImageView) btn15.getChildren().get(0);
        btn16 = (StackPane) gridNumbers.getChildren().get(15);
        img16 = (ImageView) btn16.getChildren().get(0);
        btn17 = (StackPane) gridNumbers.getChildren().get(16);
        img17 = (ImageView) btn17.getChildren().get(0);
        btn18 = (StackPane) gridNumbers.getChildren().get(17);
        img18 = (ImageView) btn18.getChildren().get(0);
        btn19 = (StackPane) gridNumbers.getChildren().get(18);
        img19 = (ImageView) btn19.getChildren().get(0);
        btn20 = (StackPane) gridNumbers.getChildren().get(19);
        img20 = (ImageView) btn20.getChildren().get(0);
        btn21 = (StackPane) gridNumbers.getChildren().get(20);
        img21 = (ImageView) btn21.getChildren().get(0);
        btn22 = (StackPane) gridNumbers.getChildren().get(21);
        img22 = (ImageView) btn22.getChildren().get(0);
        btn23 = (StackPane) gridNumbers.getChildren().get(22);
        img23 = (ImageView) btn23.getChildren().get(0);
        btn24 = (StackPane) gridNumbers.getChildren().get(23);
        img24 = (ImageView) btn24.getChildren().get(0);

        btn25 = (StackPane) gridNumbers.getChildren().get(24);
        img25 = (ImageView) btn25.getChildren().get(0);
        btn26 = (StackPane) gridNumbers.getChildren().get(25);
        img26 = (ImageView) btn26.getChildren().get(0);
        btn27 = (StackPane) gridNumbers.getChildren().get(26);
        img27 = (ImageView) btn27.getChildren().get(0);
        btn28 = (StackPane) gridNumbers.getChildren().get(27);
        img28 = (ImageView) btn28.getChildren().get(0);
        btn29 = (StackPane) gridNumbers.getChildren().get(28);
        img29 = (ImageView) btn29.getChildren().get(0);
        btn30 = (StackPane) gridNumbers.getChildren().get(29);
        img30 = (ImageView) btn30.getChildren().get(0);
        btn31 = (StackPane) gridNumbers.getChildren().get(30);
        img31 = (ImageView) btn31.getChildren().get(0);
        btn32 = (StackPane) gridNumbers.getChildren().get(31);
        img32 = (ImageView) btn32.getChildren().get(0);
        btn33 = (StackPane) gridNumbers.getChildren().get(32);
        img33 = (ImageView) btn33.getChildren().get(0);
        btn34 = (StackPane) gridNumbers.getChildren().get(33);
        img34 = (ImageView) btn34.getChildren().get(0);
        btn35 = (StackPane) gridNumbers.getChildren().get(34);
        img35 = (ImageView) btn35.getChildren().get(0);
        btn36 = (StackPane) gridNumbers.getChildren().get(35);
        img36 = (ImageView) btn36.getChildren().get(0);

        resetChipsOnBoard();

        //sets onClick functions to each dynamically generated button
        //Places chip on button when clicked
        btn1.setOnMouseClicked(event -> {
            placeChip(btn1, img1, gameBoard.getChipValueInHand(), 1);
            System.out.println("btn1 clicked!");
        });
        btn2.setOnMouseClicked(event -> {
            placeChip(btn2, img2, gameBoard.getChipValueInHand(), 2);
            System.out.println("btn2 clicked!");
        });
        btn3.setOnMouseClicked(event -> {
            placeChip(btn3, img3, gameBoard.getChipValueInHand(), 3);
            System.out.println("btn3 clicked!");
        });
        btn4.setOnMouseClicked(event -> {
            placeChip(btn4, img4, gameBoard.getChipValueInHand(), 4);
            System.out.println("btn4 clicked!");
        });
        btn5.setOnMouseClicked(event -> {
            placeChip(btn5, img5, gameBoard.getChipValueInHand(), 5);
            System.out.println("btn5 clicked!");
        });
        btn6.setOnMouseClicked(event -> {
            placeChip(btn6, img6, gameBoard.getChipValueInHand(), 6);
            System.out.println("btn6 clicked!");
        });
        btn7.setOnMouseClicked(event -> {
            placeChip(btn7, img7, gameBoard.getChipValueInHand(), 7);
            System.out.println("btn7 clicked!");
        });
        btn8.setOnMouseClicked(event -> {
            placeChip(btn8, img8, gameBoard.getChipValueInHand(), 8);
            System.out.println("btn8 clicked!");
        });
        btn9.setOnMouseClicked(event -> {
            placeChip(btn9, img9, gameBoard.getChipValueInHand(), 9);
            System.out.println("btn9 clicked!");
        });
        btn10.setOnMouseClicked(event -> {
            placeChip(btn10, img10, gameBoard.getChipValueInHand(), 10);
            System.out.println("btn10 clicked!");
        });
        btn11.setOnMouseClicked(event -> {
            placeChip(btn11, img11, gameBoard.getChipValueInHand(), 11);
            System.out.println("btn11 clicked!");
        });
        btn12.setOnMouseClicked(event -> {
            placeChip(btn12, img12, gameBoard.getChipValueInHand(), 12);
            System.out.println("btn12 clicked!");
        });
        btn13.setOnMouseClicked(event -> {
            placeChip(btn13, img13, gameBoard.getChipValueInHand(), 13);
            System.out.println("btn13 clicked!");
        });
        btn14.setOnMouseClicked(event -> {
            placeChip(btn14, img14, gameBoard.getChipValueInHand(), 14);
            System.out.println("btn14 clicked!");
        });
        btn15.setOnMouseClicked(event -> {
            placeChip(btn15, img15, gameBoard.getChipValueInHand(), 15);
            System.out.println("btn15 clicked!");
        });
        btn16.setOnMouseClicked(event -> {
            placeChip(btn16, img16, gameBoard.getChipValueInHand(), 16);
            System.out.println("btn16 clicked!");
        });
        btn17.setOnMouseClicked(event -> {
            placeChip(btn17, img17, gameBoard.getChipValueInHand(), 17);
            System.out.println("btn17 clicked!");
        });
        btn18.setOnMouseClicked(event -> {
            placeChip(btn18, img18, gameBoard.getChipValueInHand(), 18);
            System.out.println("btn18 clicked!");
        });
        btn19.setOnMouseClicked(event -> {
            placeChip(btn19, img19, gameBoard.getChipValueInHand(), 19);
            System.out.println("btn19 clicked!");
        });
        btn20.setOnMouseClicked(event -> {
            placeChip(btn20, img20, gameBoard.getChipValueInHand(), 20);
            System.out.println("btn20 clicked!");
        });
        btn21.setOnMouseClicked(event -> {
            placeChip(btn21, img21, gameBoard.getChipValueInHand(), 21);
            System.out.println("btn21 clicked!");
        });
        btn22.setOnMouseClicked(event -> {
            placeChip(btn22, img22, gameBoard.getChipValueInHand(), 22);
            System.out.println("btn22 clicked!");
        });
        btn23.setOnMouseClicked(event -> {
            placeChip(btn23, img23, gameBoard.getChipValueInHand(), 23);
            System.out.println("btn23 clicked!");
        });
        btn24.setOnMouseClicked(event -> {
            placeChip(btn24, img24, gameBoard.getChipValueInHand(), 24);
            System.out.println("btn24 clicked!");
        });
        btn25.setOnMouseClicked(event -> {
            placeChip(btn25, img25, gameBoard.getChipValueInHand(), 25);
            System.out.println("btn25 clicked!");
        });
        btn26.setOnMouseClicked(event -> {
            placeChip(btn26, img26, gameBoard.getChipValueInHand(), 26);
            System.out.println("btn26 clicked!");
        });
        btn27.setOnMouseClicked(event -> {
            placeChip(btn27, img27, gameBoard.getChipValueInHand(), 27);
            System.out.println("btn27 clicked!");
        });
        btn28.setOnMouseClicked(event -> {
            placeChip(btn28, img28, gameBoard.getChipValueInHand(), 28);
            System.out.println("btn28 clicked!");
        });
        btn29.setOnMouseClicked(event -> {
            placeChip(btn29, img29, gameBoard.getChipValueInHand(), 29);
            System.out.println("btn29 clicked!");
        });
        btn30.setOnMouseClicked(event -> {
            placeChip(btn30, img30, gameBoard.getChipValueInHand(), 30);
            System.out.println("btn30 clicked!");
        });
        btn31.setOnMouseClicked(event -> {
            placeChip(btn31, img31, gameBoard.getChipValueInHand(), 31);
            System.out.println("btn31 clicked!");
        });
        btn32.setOnMouseClicked(event -> {
            placeChip(btn32, img32, gameBoard.getChipValueInHand(), 32);
            System.out.println("btn32 clicked!");
        });
        btn33.setOnMouseClicked(event -> {
            placeChip(btn33, img33, gameBoard.getChipValueInHand(), 33);
            System.out.println("btn33 clicked!");
        });
        btn34.setOnMouseClicked(event -> {
            placeChip(btn34, img34, gameBoard.getChipValueInHand(), 34);
            System.out.println("btn34 clicked!");
        });
        btn35.setOnMouseClicked(event -> {
            placeChip(btn35, img35, gameBoard.getChipValueInHand(), 35);
            System.out.println("btn35 clicked!");
        });
        btn36.setOnMouseClicked(event -> {
            System.out.println("btn36 clicked!");
            placeChip(btn36, img36, gameBoard.getChipValueInHand(), 36);
        });
    }

    //Places chip on roulette table
    private void placeChip(StackPane pane, ImageView img, int chipValueInHand, int cellID) {
        if(gameBoard.getChipValueInHand() != 0) {
            if (gameBoard.cells[cellID - 1].getChipValue() == 0 && Player.getChipMoney() > 0) {
                gameBoard.cells[cellID - 1].setHasChip(true);
                gameBoard.cells[cellID - 1].setChipValue(chipValueInHand);
                System.out.println(gameBoard.cells[cellID - 1]);

                switch (chipValueInHand) {
                    case 1:
                        setImage(img, 0, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 5:
                        setImage(img, 1, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 10:
                        setImage(img, 2, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 20:
                        setImage(img, 3, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 50:
                        setImage(img, 4, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 100:
                        setImage(img, 5, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 500:
                        setImage(img, 6, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 1000:
                        setImage(img, 7, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 5000:
                        setImage(img, 8, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                }
                txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
            } else if (gameBoard.cells[cellID - 1].getChipValue() > 0) {
                returnMoneyUpdateDisplay(gameBoard.cells[cellID - 1].getChipValue());
                gameBoard.cells[cellID - 1].setChipValue(0);


                //voids chip image
                setImage(img, 10, pane);
            }
        } else {
            System.out.println("No Chip in Hand");
        }
    }

    private void placeChipOnSpecials(StackPane pane, ImageView img, int chipValueInHand, int cellID) {
        if(gameBoard.getChipValueInHand() != 0) {
            if (gameBoard.specialCells[cellID].getChipValue() == 0  && Player.getChipMoney() > 0) {
                gameBoard.specialCells[cellID].setHasChip(true);
                gameBoard.specialCells[cellID].setChipValue(chipValueInHand);
                System.out.println(gameBoard.specialCells[cellID]);

                switch (chipValueInHand) {
                    case 1:
                        setImage(img, 0, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 5:
                        setImage(img, 1, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 10:
                        setImage(img, 2, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 20:
                        setImage(img, 3, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 50:
                        setImage(img, 4, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 100:
                        setImage(img, 5, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 500:
                        setImage(img, 6, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 1000:
                        setImage(img, 7, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                    case 5000:
                        setImage(img, 8, pane);
                        Player.setChipMoney(Player.getChipMoney() - chipValueInHand);
                        break;
                }
                txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
            } else if (gameBoard.specialCells[cellID].getChipValue() > 0) {
                System.out.println(gameBoard.specialCells[cellID].getChipValue());
                returnMoneyUpdateDisplay(gameBoard.specialCells[cellID].getChipValue());
                gameBoard.specialCells[cellID].setChipValue(0);


                //voids chip image
                setImage(img, 10, pane);
            }
        } else {
            System.out.println("No Chip in Hand");
        }

    }


    private void returnMoneyUpdateDisplay(int chipValue) {
        Player.setChipMoney(Player.getChipMoney() + chipValue);
        txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
    }

    private void setImage(ImageView img, int imageId, StackPane pane) {
        if (img.getImage() == null) {
            img.setImage(chipImage[imageId]);
            //BorderWidths borderWidths = new BorderWidths(2, 2, 2, 2);
            //pane.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, borderWidths)));
        } else if (img.getImage() != null) {
            img.setImage(null);
            //BorderWidths borderWidths = new BorderWidths(2, 2, 2, 2);
            pane.setBorder(null);
        }
    }


    //Check if grid cell has chip already,
    private boolean checkIfCellHasImage(ImageView img) {
        boolean hasImage = false;
        if (img.getImage() == null) {
            hasImage = false;
            return hasImage;
        } else if (img.getImage() != null) {
            hasImage = true;
            return hasImage;
        }
        return hasImage;
    }

    //
    //This function spins the wheel
    @FXML
    void onSpin(MouseEvent event) {
        SpinResult newSpin = gameBoard.SpinWheel();

        //Spin Wheel
        ////////////////////
        System.out.println("Wheel is spinning");
        System.out.println(newSpin);

        //Set spin wheel animation time
        Random random = new Random();
        int spinDuration = random.nextInt(3, 5); // generates a random number between 3 and 5

        //create timeline
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                //set animations
                new KeyFrame(Duration.ZERO, new KeyValue(imgWheel.rotateProperty(), 0)),
                new KeyFrame(Duration.seconds(spinDuration), new KeyValue(imgWheel.rotateProperty(), 360))
        );
        //starts animation
        timeline.play();
        ////////////////////
        //updateResults after finishing timeline
        timeline.setOnFinished(e -> updateCircleColorAndNumber(newSpin));


    }

    //sets color of circle to roll result color
    private void updateCircleColorAndNumber(SpinResult spin) {
        switch (spin.getColor()) {
            case "green":
                circleResultColor.setFill(Color.GREEN);
                txtResultNumber.setText(String.valueOf(spin.getNumber()));
                break;
            case "red":
                circleResultColor.setFill(Color.RED);
                txtResultNumber.setText(String.valueOf(spin.getNumber()));
                break;
            case "black":
                circleResultColor.setFill(Color.BLACK);
                txtResultNumber.setText(String.valueOf(spin.getNumber()));
                break;
        }

        circleResultColor.setVisible(true);
        txtResultNumber.setVisible(true);

        int payout = gameBoard.checkWinnerPayout(spin);
        payoutWinnings(payout);
        resetChipsOnBoard();
    }

    private void checkWinningTile(SpinResult spin) {

    }

    //Checks every tile, if roleNumber or any boolean value (red,black,1st12, etc is true) and
    //chipPos has a chip, payout to player.
    private void checkWinner(SpinResult spin) {
        //Win condition 0-36


        //after paying out, reset board
        resetChipsOnBoard();
    }

    //Gets chips value from image
    private int getChipsValue(ImageView img) {
        int temp = 0;
        if (img.getImage() == chipImage[0]) {
            temp = 1;
        } else if (img.getImage() == chipImage[1]) {
            temp = 5;
        } else if (img.getImage() == chipImage[2]) {
            temp = 10;
        } else if (img.getImage() == chipImage[3]) {
            temp = 20;
        } else if (img.getImage() == chipImage[4]) {
            temp = 50;
        } else if (img.getImage() == chipImage[5]) {
            temp = 100;
        } else if (img.getImage() == chipImage[6]) {
            temp = 500;
        } else if (img.getImage() == chipImage[7]) {
            temp = 1000;
        } else if (img.getImage() == chipImage[8]) {
            temp = 5000;
        }
        System.out.println(temp);
        return temp;
    }

    //Pays out winnings
    private void payoutWinnings(int payout) {
        Player.setChipMoney(Player.getChipMoney() + payout);
        txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
    }

    //This button goes back a page to game selection
    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }


    //This function opens a rule window
    @FXML
    void onRules(MouseEvent event1) {
        if (!displayRules) {
            // Create the TextArea and set rulesVisible to true
            rulesTextArea = new TextArea("Payouts based on Bet/Result:\n" +
                    "\n" +
                    "    Red/Black - 1:1\n" +
                    "    Odd/Even - 1:1\n" +
                    "    High/Low - 1:1\n" +
                    "    Dozen - 2:1\n" +
                    "    Column - 2:1\n" +
                    "    Square Number (4-Number) - 8:1\n" +
                    "    Split Number (2-Number) - 17:1\n" +
                    "    Straight Number (1-Number) - 35:1\n");
            rulesTextArea.setPrefSize(600, 600);
            rulesTextArea.setEditable(false);
            rulesTextArea.setLayoutX((rootPane.getWidth() - rulesTextArea.getPrefWidth()) / 2);
            rulesTextArea.setLayoutY((rootPane.getHeight() - rulesTextArea.getPrefHeight()) / 2);
            rootPane.getChildren().add(rulesTextArea);
            displayRules = true;
        } else {
            // Delete the TextArea and set rulesVisible to false
            rootPane.getChildren().remove(rulesTextArea);
            displayRules = false;
        }
    }

    @FXML
    void onZero(MouseEvent event) {
        placeChipOnSpecials(btn0, img0, gameBoard.getChipValueInHand(), 0);
        System.out.println("btn0 clicked!");
    }

    @FXML
    void onBlack(MouseEvent event) {
        placeChipOnSpecials(btnBlackDiamond, imgBlackDiamond, gameBoard.getChipValueInHand(), 4);
        System.out.println("btnBlackDiamond clicked!");
    }

    @FXML
    void onEven(MouseEvent event) {
        placeChipOnSpecials(btnEVEN, imgEVEN, gameBoard.getChipValueInHand(), 6);
        System.out.println("btnEven clicked!");
    }

    @FXML
    void onOdd(MouseEvent event) {
        placeChipOnSpecials(btnODD, imgODD, gameBoard.getChipValueInHand(), 5);
        System.out.println("btnOdd clicked!");
    }

    @FXML
    void onRed(MouseEvent event) {
        placeChipOnSpecials(btnRedDiamond, imgRedDiamond, gameBoard.getChipValueInHand(), 3);
        System.out.println("btnRedDiamond clicked!");
    }

    @FXML
    void on19to36(MouseEvent event) {
        placeChipOnSpecials(btn19to36, img19to36, gameBoard.getChipValueInHand(), 2);
        System.out.println("btn19to36 clicked!");
    }

    @FXML
    void on1st12(MouseEvent event) {
        placeChipOnSpecials(btn1st12, img1st12, gameBoard.getChipValueInHand(), 7);
        System.out.println("btn1st12 clicked!");
    }

    @FXML
    void on1to18(MouseEvent event) {
        placeChipOnSpecials(btn1to18, img1to18, gameBoard.getChipValueInHand(), 1);
        System.out.println("btn1to18 clicked!");
    }

    @FXML
    void on2nd12(MouseEvent event) {
        placeChipOnSpecials(btn2nd12, img2nd12, gameBoard.getChipValueInHand(), 8);
        System.out.println("btn2nd12 clicked!");
    }

    @FXML
    void on2to1bot(MouseEvent event) {
        placeChipOnSpecials(btn2to1bottom, img2to1bottom, gameBoard.getChipValueInHand(), 12);
        System.out.println("btn2to1bottom clicked!");
    }

    @FXML
    void on2to1mid(MouseEvent event) {
        placeChipOnSpecials(btn2to1middle, img2to1middle, gameBoard.getChipValueInHand(), 11);
        System.out.println("btn2to1middle clicked!");
    }

    @FXML
    void on2to1top(MouseEvent event) {
        placeChipOnSpecials(btn2to1top, img2to1top, gameBoard.getChipValueInHand(), 10);
        System.out.println("btn2to1top clicked!");
    }

    @FXML
    void on3rd12(MouseEvent event) {
        placeChipOnSpecials(btn3rd12, img3rd12, gameBoard.getChipValueInHand(), 9);
        System.out.println("btn3rd12 clicked!");
    }

    //Gets chip images from resources
    private void getChipImages() {
        try {
            InputStream chip1 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip1.png");
            chipImage[0] = new Image(chip1);
            InputStream chip5 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip5.png");
            chipImage[1] = new Image(chip5);
            InputStream chip10 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip10.png");
            chipImage[2] = new Image(chip10);
            InputStream chip20 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip20.png");
            chipImage[3] = new Image(chip20);
            InputStream chip50 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip50.png");
            chipImage[4] = new Image(chip50);
            InputStream chip100 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip100.png");
            chipImage[5] = new Image(chip100);
            InputStream chip500 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip500.png");
            chipImage[6] = new Image(chip500);
            InputStream chip1000 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip1000.png");
            chipImage[7] = new Image(chip1000);
            InputStream chip5000 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip5000.png");
            chipImage[8] = new Image(chip5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Resets chips on board
    private void resetChipsOnBoard() {
        img0.setImage(null);
        img1.setImage(null);
        img2.setImage(null);
        img3.setImage(null);
        img4.setImage(null);
        img5.setImage(null);
        img6.setImage(null);
        img7.setImage(null);
        img8.setImage(null);
        img9.setImage(null);
        img10.setImage(null);
        img11.setImage(null);
        img12.setImage(null);
        img13.setImage(null);
        img14.setImage(null);
        img15.setImage(null);
        img16.setImage(null);
        img17.setImage(null);
        img18.setImage(null);
        img19.setImage(null);
        img20.setImage(null);
        img21.setImage(null);
        img22.setImage(null);
        img23.setImage(null);
        img24.setImage(null);
        img25.setImage(null);
        img26.setImage(null);
        img27.setImage(null);
        img28.setImage(null);
        img29.setImage(null);
        img30.setImage(null);
        img11.setImage(null);
        img32.setImage(null);
        img33.setImage(null);
        img34.setImage(null);
        img35.setImage(null);
        img36.setImage(null);
        img3rd12.setImage(null);
        img2to1top.setImage(null);
        img2to1middle.setImage(null);
        img2to1bottom.setImage(null);
        img2nd12.setImage(null);
        img1to18.setImage(null);
        img1st12.setImage(null);
        img19to36.setImage(null);
        img19to36.setImage(null);
        imgRedDiamond.setImage(null);
        imgBlackDiamond.setImage(null);
        imgODD.setImage(null);
        imgEVEN.setImage(null);

        for(Cell cell : gameBoard.cells) {
            cell.setChipValue(0);
            cell.setHasChip(false);
        }
        for(Cell cell : gameBoard.specialCells) {
            cell.setChipValue(0);
            cell.setHasChip(false);
        }
    }

    //sets arrows to invisible
    private void resetArrows() {
        imgArrowMarker1.setVisible(false);
        imgArrowMarker5.setVisible(false);
        imgArrowMarker10.setVisible(false);
        imgArrowMarker20.setVisible(false);
        imgArrowMarker50.setVisible(false);
        imgArrowMarker100.setVisible(false);
        imgArrowMarker500.setVisible(false);
        imgArrowMarker1k.setVisible(false);
        imgArrowMarker5k.setVisible(false);
    }

    //These buttons are used for changing the bet amount
    @FXML
    void betFifty(MouseEvent event) {
        resetArrows();
        imgArrowMarker50.setVisible(true);
        gameBoard.setChipValueInHand(50);
    }


    @FXML
    void betFive(MouseEvent event) {
        resetArrows();
        imgArrowMarker5.setVisible(true);
        gameBoard.setChipValueInHand(5);
    }

    @FXML
    void betFiveHundred(MouseEvent event) {
        resetArrows();
        imgArrowMarker500.setVisible(true);
        gameBoard.setChipValueInHand(500);
    }

    @FXML
    void betFiveThousand(MouseEvent event) {
        resetArrows();
        imgArrowMarker5k.setVisible(true);
        gameBoard.setChipValueInHand(5000);
    }

    @FXML
    void betOne(MouseEvent event) {
        resetArrows();
        imgArrowMarker1.setVisible(true);
        gameBoard.setChipValueInHand(1);
    }

    @FXML
    void betOneHundred(MouseEvent event) {
        resetArrows();
        imgArrowMarker100.setVisible(true);
        gameBoard.setChipValueInHand(100);
    }

    @FXML
    void betOneThousand(MouseEvent event) {
        resetArrows();
        imgArrowMarker1k.setVisible(true);
        gameBoard.setChipValueInHand(1000);
    }

    @FXML
    void betTen(MouseEvent event) {
        resetArrows();
        imgArrowMarker10.setVisible(true);
        gameBoard.setChipValueInHand(10);
    }

    @FXML
    void betTwenty(MouseEvent event) {
        resetArrows();
        imgArrowMarker20.setVisible(true);
        gameBoard.setChipValueInHand(20);
    }
}
