package pokemon.masters.casinosimulator.controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pokemon.masters.casinosimulator.gamelogic.Player;
import pokemon.masters.casinosimulator.gamelogic.Roulette;
import pokemon.masters.casinosimulator.services.ChangeScene;
import pokemon.masters.casinosimulator.services.FormatMoney;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class RouletteController {

    private final Image[] chipImage = new Image[10];
    private final Roulette game = new Roulette();

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
            btn33, btn34, btn35, btn36, btnBack, btnRules, btnSpin;

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
        //padding and size of grid pane units
        gridNumbers.setPadding(new Insets(5, 5, 5, 5));
        gridNumbers.setHgap(5);
        gridNumbers.setVgap(5);

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
            updateGridCell(img1, game.getCurrentChipInHand());
            System.out.println("btn1 clicked!");
        });
        btn2.setOnMouseClicked(event -> {
            updateGridCell(img2, game.getCurrentChipInHand());
            System.out.println("btn2 clicked!");
        });
        btn3.setOnMouseClicked(event -> {
            updateGridCell(img3, game.getCurrentChipInHand());
            System.out.println("btn3 clicked!");
        });
        btn4.setOnMouseClicked(event -> {
            updateGridCell(img4, game.getCurrentChipInHand());
            System.out.println("btn4 clicked!");
        });
        btn5.setOnMouseClicked(event -> {
            updateGridCell(img5, game.getCurrentChipInHand());
            System.out.println("btn5 clicked!");
        });
        btn6.setOnMouseClicked(event -> {
            updateGridCell(img6, game.getCurrentChipInHand());
            System.out.println("btn6 clicked!");
        });
        btn7.setOnMouseClicked(event -> {
            updateGridCell(img7, game.getCurrentChipInHand());
            System.out.println("btn7 clicked!");
        });
        btn8.setOnMouseClicked(event -> {
            updateGridCell(img8, game.getCurrentChipInHand());
            System.out.println("btn8 clicked!");
        });
        btn9.setOnMouseClicked(event -> {
            updateGridCell(img9, game.getCurrentChipInHand());
            System.out.println("btn9 clicked!");
        });
        btn10.setOnMouseClicked(event -> {
            updateGridCell(img10, game.getCurrentChipInHand());
            System.out.println("btn10 clicked!");
        });
        btn11.setOnMouseClicked(event -> {
            updateGridCell(img11, game.getCurrentChipInHand());
            System.out.println("btn11 clicked!");
        });
        btn12.setOnMouseClicked(event -> {
            updateGridCell(img12, game.getCurrentChipInHand());
            System.out.println("btn12 clicked!");
        });
        btn13.setOnMouseClicked(event -> {
            updateGridCell(img13, game.getCurrentChipInHand());
            System.out.println("btn13 clicked!");
        });
        btn14.setOnMouseClicked(event -> {
            updateGridCell(img14, game.getCurrentChipInHand());
            System.out.println("btn14 clicked!");
        });
        btn15.setOnMouseClicked(event -> {
            updateGridCell(img15, game.getCurrentChipInHand());
            System.out.println("btn15 clicked!");
        });
        btn16.setOnMouseClicked(event -> {
            updateGridCell(img16, game.getCurrentChipInHand());
            System.out.println("btn16 clicked!");
        });
        btn17.setOnMouseClicked(event -> {
            updateGridCell(img17, game.getCurrentChipInHand());
            System.out.println("btn17 clicked!");
        });
        btn18.setOnMouseClicked(event -> {
            updateGridCell(img18, game.getCurrentChipInHand());
            System.out.println("btn18 clicked!");
        });
        btn19.setOnMouseClicked(event -> {
            updateGridCell(img19, game.getCurrentChipInHand());
            System.out.println("btn19 clicked!");
        });
        btn20.setOnMouseClicked(event -> {
            updateGridCell(img20, game.getCurrentChipInHand());
            System.out.println("btn20 clicked!");
        });
        btn21.setOnMouseClicked(event -> {
            updateGridCell(img21, game.getCurrentChipInHand());
            System.out.println("btn21 clicked!");
        });
        btn22.setOnMouseClicked(event -> {
            updateGridCell(img22, game.getCurrentChipInHand());
            System.out.println("btn22 clicked!");
        });
        btn23.setOnMouseClicked(event -> {
            updateGridCell(img23, game.getCurrentChipInHand());
            System.out.println("btn23 clicked!");
        });
        btn24.setOnMouseClicked(event -> {
            updateGridCell(img24, game.getCurrentChipInHand());
            System.out.println("btn24 clicked!");
        });
        btn25.setOnMouseClicked(event -> {
            updateGridCell(img25, game.getCurrentChipInHand());
            System.out.println("btn25 clicked!");
        });
        btn26.setOnMouseClicked(event -> {
            updateGridCell(img26, game.getCurrentChipInHand());
            System.out.println("btn26 clicked!");
        });
        btn27.setOnMouseClicked(event -> {
            updateGridCell(img27, game.getCurrentChipInHand());
            System.out.println("btn27 clicked!");
        });
        btn28.setOnMouseClicked(event -> {
            updateGridCell(img28, game.getCurrentChipInHand());
            System.out.println("btn28 clicked!");
        });
        btn29.setOnMouseClicked(event -> {
            updateGridCell(img29, game.getCurrentChipInHand());
            System.out.println("btn29 clicked!");
        });
        btn30.setOnMouseClicked(event -> {
            updateGridCell(img30, game.getCurrentChipInHand());
            System.out.println("btn30 clicked!");
        });
        btn31.setOnMouseClicked(event -> {
            updateGridCell(img31, game.getCurrentChipInHand());
            System.out.println("btn31 clicked!");
        });
        btn32.setOnMouseClicked(event -> {
            updateGridCell(img32, game.getCurrentChipInHand());
            System.out.println("btn32 clicked!");
        });
        btn33.setOnMouseClicked(event -> {
            updateGridCell(img33, game.getCurrentChipInHand());
            System.out.println("btn33 clicked!");
        });
        btn34.setOnMouseClicked(event -> {
            updateGridCell(img34, game.getCurrentChipInHand());
            System.out.println("btn34 clicked!");
        });
        btn35.setOnMouseClicked(event -> {
            updateGridCell(img35, game.getCurrentChipInHand());
            System.out.println("btn35 clicked!");
        });
        btn36.setOnMouseClicked(event -> {
            updateGridCell(img36, game.getCurrentChipInHand());
            System.out.println("btn36 clicked!");
        });
    }

    @FXML
    void onZero(MouseEvent event) {
        updateGridCell(img0, game.getCurrentChipInHand());
        System.out.println("btn0 clicked!");
    }

    @FXML
    void onBlack(MouseEvent event) {
        updateGridCell(imgBlackDiamond, game.getCurrentChipInHand());
        System.out.println("btnBlackDiamond clicked!");
    }

    @FXML
    void onEven(MouseEvent event) {
        updateGridCell(imgEVEN, game.getCurrentChipInHand());
        System.out.println("btnEven clicked!");
    }

    @FXML
    void onOdd(MouseEvent event) {
        updateGridCell(imgODD, game.getCurrentChipInHand());
        System.out.println("btnOdd clicked!");
    }

    @FXML
    void onRed(MouseEvent event) {
        updateGridCell(imgRedDiamond, game.getCurrentChipInHand());
        System.out.println("btnRedDiamond clicked!");
    }

    @FXML
    void on19to36(MouseEvent event) {
        updateGridCell(img19to36, game.getCurrentChipInHand());
        System.out.println("btn19to36 clicked!");
    }

    @FXML
    void on1st12(MouseEvent event) {
        updateGridCell(img1st12, game.getCurrentChipInHand());
        System.out.println("btn1st12 clicked!");
    }

    @FXML
    void on1to18(MouseEvent event) {
        updateGridCell(img1to18, game.getCurrentChipInHand());
        System.out.println("btn1to18 clicked!");
    }

    @FXML
    void on2nd12(MouseEvent event) {
        updateGridCell(img2nd12, game.getCurrentChipInHand());
        System.out.println("btn2nd12 clicked!");
    }

    @FXML
    void on2to1bot(MouseEvent event) {
        updateGridCell(img2to1bottom, game.getCurrentChipInHand());
        System.out.println("btn2to1bottom clicked!");
    }

    @FXML
    void on2to1mid(MouseEvent event) {
        updateGridCell(img2to1middle, game.getCurrentChipInHand());
        System.out.println("btn2to1middle clicked!");
    }

    @FXML
    void on2to1top(MouseEvent event) {
        updateGridCell(img2to1top, game.getCurrentChipInHand());
        System.out.println("btn2to1top clicked!");
    }

    @FXML
    void on3rd12(MouseEvent event) {
        updateGridCell(img3rd12, game.getCurrentChipInHand());
        System.out.println("btn3rd12 clicked!");
    }

    //These buttons are used for changing the bet amount
    @FXML
    void betFifty(MouseEvent event) {
        resetArrows();
        imgArrowMarker50.setVisible(true);
        game.setCurrentChipInHand(50);
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

    @FXML
    void betFive(MouseEvent event) {
        resetArrows();
        imgArrowMarker5.setVisible(true);
        game.setCurrentChipInHand(5);
    }

    @FXML
    void betFiveHundred(MouseEvent event) {
        resetArrows();
        imgArrowMarker500.setVisible(true);
        game.setCurrentChipInHand(500);
    }

    @FXML
    void betFiveThousand(MouseEvent event) {
        resetArrows();
        imgArrowMarker5k.setVisible(true);
        game.setCurrentChipInHand(5000);
    }

    @FXML
    void betOne(MouseEvent event) {
        resetArrows();
        imgArrowMarker1.setVisible(true);
        game.setCurrentChipInHand(1);
    }

    @FXML
    void betOneHundred(MouseEvent event) {
        resetArrows();
        imgArrowMarker100.setVisible(true);
        game.setCurrentChipInHand(100);
    }

    @FXML
    void betOneThousand(MouseEvent event) {
        resetArrows();
        imgArrowMarker1k.setVisible(true);
        game.setCurrentChipInHand(1000);
    }

    @FXML
    void betTen(MouseEvent event) {
        resetArrows();
        imgArrowMarker10.setVisible(true);
        game.setCurrentChipInHand(10);
    }

    @FXML
    void betTwenty(MouseEvent event) {
        resetArrows();
        imgArrowMarker20.setVisible(true);
        game.setCurrentChipInHand(20);
    }

    //Check if grid cell has chip already,
    private boolean checkIfCellHasImage(ImageView img) {
        boolean b = false;
        if(img.getImage() == null) {
            b = false;
            return b;
        } else if (img.getImage() != null) {
            b = true;
            return b;
        }
        return b;
    }

    //Sets or moves image from grid
    private void setGridImage(ImageView img, int id) {
        if(!checkIfCellHasImage(img)) {
            img.setImage(chipImage[id]);
        } else {
            img.setImage(null);
        }
    }

    //if grid doesn't have image, sets it, else removes it
    private void updateGridCell(ImageView img, int chipInHand) {
        if(chipInHand < Player.getChipMoney() && img.getImage() == null) {
            switch (chipInHand) {
                case 1:
                    setGridImage(img, 0);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 5:
                    setGridImage(img, 1);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 10:
                    setGridImage(img, 2);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 20:
                    setGridImage(img, 3);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 50:
                    setGridImage(img, 4);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 100:
                    setGridImage(img, 5);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 500:
                    setGridImage(img, 6);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 1000:
                    setGridImage(img, 7);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 5000:
                    setGridImage(img, 8);
                    Player.setChipMoney(Player.getChipMoney() - chipInHand);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
            }

        //    else removes chipImage from cell
        } else if (img.getImage() != null) {
            int chipValue = getChipsValue(img);
            switch (chipValue) {
                case 1:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 5:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 10:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 20:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 50:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 100:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 500:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 1000:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
                case 5000:
                    Player.setChipMoney(Player.getChipMoney() + chipValue);
                    txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
                    break;
            }
            //voids chip image
            setGridImage(img, 10);
        }
    }


    //This function spins the wheel
    @FXML
    void onSpin(MouseEvent event) {

        //Spin Wheel
        ////////////////////
        System.out.println("Wheel is spinning");
        game.setRoleNumber();
        Random random = new Random();
        int spinDuration = random.nextInt(3, 5); // generates a random number between 3 and 5

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(imgWheel.rotateProperty(), 0)),
                new KeyFrame(Duration.seconds(spinDuration), new KeyValue(imgWheel.rotateProperty(), 360))
        );
        timeline.play();
        ////////////////////
        //updateResults after finishing time loop
        timeline.setOnFinished(e -> updateResult(game.isBlack(), game.isRed(), game.isGreen(), game.getRoleNumber()));

    }

    //sets color of circle to roll result color
    private void updateResult(boolean black, boolean red, boolean green, int role) {
        if (green) {
            circleResultColor.setFill(Color.GREEN);
            txtResultNumber.setText(String.valueOf(role));
        } else if (red) {
            circleResultColor.setFill(Color.RED);
            txtResultNumber.setText(String.valueOf(role));
        } else if (black) {
            circleResultColor.setFill(Color.BLACK);
            txtResultNumber.setText(String.valueOf(role));
        }
        circleResultColor.setVisible(true);
        txtResultNumber.setVisible(true);

        //checks winner immediately after
        checkWinner(game.getRoleNumber());
    }

    //Checks every tile, if roleNumber or any boolean value (red,black,1st12, etc is true) and
    //chipPos has a chip, payout to player.
    private void checkWinner(int roleNumber) {
        System.out.println(roleNumber);
        //Win codition 0-36
        if(checkIfCellHasImage(img0) && roleNumber == 0) {
            payoutWinnings(35, getChipsValue(img0));
        }
        if(checkIfCellHasImage(img1) && roleNumber == 1) {
            payoutWinnings(35, getChipsValue(img1));
        }
        if(checkIfCellHasImage(img2) && roleNumber == 2) {
            payoutWinnings(35, getChipsValue(img2));
        }
        if(checkIfCellHasImage(img3) && roleNumber == 3) {
            payoutWinnings(35, getChipsValue(img3));
        }
        if(checkIfCellHasImage(img4) && roleNumber == 4) {
            payoutWinnings(35, getChipsValue(img4));
        }
        if(checkIfCellHasImage(img5) && roleNumber == 5) {
            payoutWinnings(35, getChipsValue(img5));
        }
        if(checkIfCellHasImage(img6) && roleNumber == 6) {
            payoutWinnings(35, getChipsValue(img6));
        }
        if(checkIfCellHasImage(img7) && roleNumber == 7) {
            payoutWinnings(35, getChipsValue(img7));
        }
        if(checkIfCellHasImage(img8) && roleNumber == 8) {
            payoutWinnings(35, getChipsValue(img8));
        }
        if(checkIfCellHasImage(img9) && roleNumber == 9) {
            payoutWinnings(35, getChipsValue(img9));
        }
        if(checkIfCellHasImage(img10) && roleNumber == 10) {
            payoutWinnings(35, getChipsValue(img10));
        }
        if(checkIfCellHasImage(img11) && roleNumber == 11) {
            payoutWinnings(35, getChipsValue(img11));
        }
        if(checkIfCellHasImage(img12) && roleNumber == 12) {
            payoutWinnings(35, getChipsValue(img12));
        }
        if(checkIfCellHasImage(img13) && roleNumber == 13) {
            payoutWinnings(35, getChipsValue(img13));
        }
        if(checkIfCellHasImage(img14) && roleNumber == 14) {
            payoutWinnings(35, getChipsValue(img14));
        }
        if(checkIfCellHasImage(img15) && roleNumber == 15) {
            payoutWinnings(35, getChipsValue(img15));
        }
        if(checkIfCellHasImage(img16) && roleNumber == 16) {
            payoutWinnings(35, getChipsValue(img16));
        }
        if(checkIfCellHasImage(img17) && roleNumber == 17) {
            payoutWinnings(35, getChipsValue(img17));
        }
        if(checkIfCellHasImage(img18) && roleNumber == 18) {
            payoutWinnings(35, getChipsValue(img18));
        }
        if(checkIfCellHasImage(img19) && roleNumber == 19) {
            payoutWinnings(35, getChipsValue(img19));
        }
        if(checkIfCellHasImage(img20) && roleNumber == 20) {
            payoutWinnings(35, getChipsValue(img20));
        }
        if(checkIfCellHasImage(img21) && roleNumber == 21) {
            payoutWinnings(35, getChipsValue(img21));
        }
        if(checkIfCellHasImage(img22) && roleNumber == 22) {
            payoutWinnings(35, getChipsValue(img22));
        }
        if(checkIfCellHasImage(img23) && roleNumber == 23) {
            payoutWinnings(35, getChipsValue(img23));
        }
        if(checkIfCellHasImage(img24) && roleNumber == 24) {
            payoutWinnings(35, getChipsValue(img24));
        }
        if(checkIfCellHasImage(img25) && roleNumber == 25) {
            payoutWinnings(35, getChipsValue(img25));
        }
        if(checkIfCellHasImage(img26) && roleNumber == 26) {
            payoutWinnings(35, getChipsValue(img26));
        }
        if(checkIfCellHasImage(img27) && roleNumber == 27) {
            payoutWinnings(35, getChipsValue(img27));
        }
        if(checkIfCellHasImage(img28) && roleNumber == 28) {
            payoutWinnings(35, getChipsValue(img28));
        }
        if(checkIfCellHasImage(img29) && roleNumber == 29) {
            payoutWinnings(35, getChipsValue(img29));
        }
        if(checkIfCellHasImage(img30) && roleNumber == 30) {
            payoutWinnings(35, getChipsValue(img30));
        }
        if(checkIfCellHasImage(img31) && roleNumber == 31) {
            payoutWinnings(35, getChipsValue(img31));
        }
        if(checkIfCellHasImage(img32) && roleNumber == 32) {
            payoutWinnings(35, getChipsValue(img32));
        }
        if(checkIfCellHasImage(img33) && roleNumber == 33) {
            payoutWinnings(35, getChipsValue(img33));
        }
        if(checkIfCellHasImage(img34) && roleNumber == 34) {
            payoutWinnings(35, getChipsValue(img34));
        }
        if(checkIfCellHasImage(img35) && roleNumber == 35) {
            payoutWinnings(35, getChipsValue(img35));
        }
        if(checkIfCellHasImage(img36) && roleNumber == 36) {
            payoutWinnings(35, getChipsValue(img36));
        }
        ///////////////////////////////////////////////////
        //Special Win conditions

        if(checkIfCellHasImage(img1st12) && game.isFirst12()) {
            payoutWinnings(2, getChipsValue(img1st12));
        }
        if(checkIfCellHasImage(img2nd12) && game.isSecond12()) {
            payoutWinnings(2, getChipsValue(img2nd12));
        }
        if(checkIfCellHasImage(img3rd12) && game.isThird12()) {
            payoutWinnings(2, getChipsValue(img3rd12));
        }
        if(checkIfCellHasImage(img2to1top) && game.isTop12()) {
            payoutWinnings(2, getChipsValue(img2to1top));
        }
        if(checkIfCellHasImage(img2to1middle) && game.isMiddle12()) {
            payoutWinnings(2, getChipsValue(img2to1middle));
        }
        if(checkIfCellHasImage(img2to1bottom) && game.isBottom12()) {
            payoutWinnings(2, getChipsValue(img2to1bottom));
        }


        //
        if(checkIfCellHasImage(img1to18) && game.isFirstHalf()) {
            payoutWinnings(1, getChipsValue(img1to18));
        }
        if(checkIfCellHasImage(img19to36) && !game.isFirstHalf()) {
            payoutWinnings(1, getChipsValue(img19to36));
        }
        if(checkIfCellHasImage(imgRedDiamond) && game.isRed()) {
            payoutWinnings(1, getChipsValue(imgRedDiamond));
        }
        if(checkIfCellHasImage(imgBlackDiamond) && game.isBlack()) {
            payoutWinnings(1, getChipsValue(imgBlackDiamond));
        }
        if(checkIfCellHasImage(imgEVEN) && game.isEven()) {
            payoutWinnings(1, getChipsValue(imgEVEN));
        }
        if(checkIfCellHasImage(imgODD) && !game.isEven()) {
            payoutWinnings(1, getChipsValue(imgODD));
        }

        //after paying out, reset board
        resetChipsOnBoard();
    }

    //Gets chips value from image
    private int getChipsValue(ImageView img) {
        int temp = 0;
        if(img.getImage() == chipImage[0]) {
            temp = 1;
        } else if(img.getImage() == chipImage[1]) {
            temp = 5;
        } else if(img.getImage() == chipImage[2]) {
            temp = 10;
        } else if(img.getImage() == chipImage[3]) {
            temp = 20;
        } else if(img.getImage() == chipImage[4]) {
            temp = 50;
        } else if(img.getImage() == chipImage[5]) {
            temp = 100;
        } else if(img.getImage() == chipImage[6]) {
            temp = 500;
        } else if(img.getImage() == chipImage[7]) {
            temp = 1000;
        } else if(img.getImage() == chipImage[8]) {
            temp = 5000;
        }
        System.out.println(temp);
        return temp;
    }

    //Pays out winnings
    private void payoutWinnings(int payout, int chipValue) {
        int winnings = ((chipValue * payout) + chipValue);
        Player.setChipMoney(Player.getChipMoney() + winnings);
        txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));
    }

    //This button goes back a page to game selection
    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }


    //This function opens a rule window
    @FXML
    void onRules(MouseEvent event) {

    }

}
