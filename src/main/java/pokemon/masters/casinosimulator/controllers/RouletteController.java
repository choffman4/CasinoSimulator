package pokemon.masters.casinosimulator.controllers;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
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
import java.util.Stack;

public class RouletteController {

    private final Image[] chipImage = new Image[36];

    private final Roulette game = new Roulette();

    @FXML
    private GridPane gridNumbers;
    @FXML
    private ImageView img19to36, img1st12, img1to18, img2nd12, img2to1bottom, img2to1middle,
            img2to1top, img3rd12, imgArrowMarker1, imgArrowMarker10, imgArrowMarker20, imgArrowMarker50, imgArrowMarker100,
            imgArrowMarker5, imgArrowMarker500, imgArrowMarker1k, imgArrowMarker5k, imgBlackDiamond, imgEVEN, imgODD,
            imgRedDiamond, imgBack, imgRules, imgSpin, imgWheel;


    @FXML
    private StackPane btn0, btn1,  btn2,  btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16,
    btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32,
    btn33, btn34, btn35, btn36;

    @FXML
    private ImageView img0, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16,
    img17, img18, img19, img20, img21, img22, img23, img24, img25, img26, img27, img28, img29, img30, img31, img32,
    img33, img34, img35, img36;

    @FXML
    private StackPane btnBack, btnRules, btnSpin;
    @FXML
    private Text txtChipsAmount, txtResultNumber;
    @FXML
    private Circle circleResultColor;

    @FXML
    protected void initialize() {
        System.out.println("Welcome to Roulette");

        //get pokerchip images
        getGameImages();

        //loop through grid and add a stackPane with child image
        getGridButtons();

        //Initialize buttons in grid number 1-36
        initializeBettingButtons();

        txtChipsAmount.setText(FormatMoney.Format(Player.getChipMoney()));

        circleResultColor.setVisible(false);
        txtResultNumber.setVisible(false);

        resetArrows();
    }

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
    private void initializeBettingButtons() {
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

        btn1.setOnMouseClicked(event -> {
            placeChip(img1, game.getCurrentChipBets());
            System.out.println("btn1 clicked!");
        });
        btn2.setOnMouseClicked(event -> {
            placeChip(img2, game.getCurrentChipBets());
            System.out.println("btn2 clicked!");
        });
        btn3.setOnMouseClicked(event -> {
            placeChip(img3, game.getCurrentChipBets());
            System.out.println("btn3 clicked!");
        });
        btn4.setOnMouseClicked(event -> {
            placeChip(img4, game.getCurrentChipBets());
            System.out.println("btn4 clicked!");
        });
        btn5.setOnMouseClicked(event -> {
            placeChip(img5, game.getCurrentChipBets());
            System.out.println("btn5 clicked!");
        });
        btn6.setOnMouseClicked(event -> {
            placeChip(img6, game.getCurrentChipBets());
            System.out.println("btn6 clicked!");
        });
        btn7.setOnMouseClicked(event -> {
            placeChip(img7, game.getCurrentChipBets());
            System.out.println("btn7 clicked!");
        });
        btn8.setOnMouseClicked(event -> {
            placeChip(img8, game.getCurrentChipBets());
            System.out.println("btn8 clicked!");
        });
        btn9.setOnMouseClicked(event -> {
            placeChip(img9, game.getCurrentChipBets());
            System.out.println("btn9 clicked!");
        });
        btn10.setOnMouseClicked(event -> {
            placeChip(img10, game.getCurrentChipBets());
            System.out.println("btn10 clicked!");
        });
        btn11.setOnMouseClicked(event -> {
            placeChip(img11, game.getCurrentChipBets());
            System.out.println("btn11 clicked!");
        });
        btn12.setOnMouseClicked(event -> {
            placeChip(img12, game.getCurrentChipBets());
            System.out.println("btn12 clicked!");
        });
        btn13.setOnMouseClicked(event -> {
            placeChip(img13, game.getCurrentChipBets());
            System.out.println("btn13 clicked!");
        });
        btn14.setOnMouseClicked(event -> {
            placeChip(img14, game.getCurrentChipBets());
            System.out.println("btn14 clicked!");
        });
        btn15.setOnMouseClicked(event -> {
            placeChip(img15, game.getCurrentChipBets());
            System.out.println("btn15 clicked!");
        });
        btn16.setOnMouseClicked(event -> {
            placeChip(img16, game.getCurrentChipBets());
            System.out.println("btn16 clicked!");
        });
        btn17.setOnMouseClicked(event -> {
            placeChip(img17, game.getCurrentChipBets());
            System.out.println("btn17 clicked!");
        });
        btn18.setOnMouseClicked(event -> {
            placeChip(img18, game.getCurrentChipBets());
            System.out.println("btn18 clicked!");
        });
        btn19.setOnMouseClicked(event -> {
            placeChip(img19, game.getCurrentChipBets());
            System.out.println("btn19 clicked!");
        });
        btn20.setOnMouseClicked(event -> {
            placeChip(img20, game.getCurrentChipBets());
            System.out.println("btn20 clicked!");
        });
        btn21.setOnMouseClicked(event -> {
            placeChip(img21, game.getCurrentChipBets());
            System.out.println("btn21 clicked!");
        });
        btn22.setOnMouseClicked(event -> {
            placeChip(img22, game.getCurrentChipBets());
            System.out.println("btn22 clicked!");
        });
        btn23.setOnMouseClicked(event -> {
            placeChip(img23, game.getCurrentChipBets());
            System.out.println("btn23 clicked!");
        });
        btn24.setOnMouseClicked(event -> {
            placeChip(img24, game.getCurrentChipBets());
            System.out.println("btn24 clicked!");
        });
        btn25.setOnMouseClicked(event -> {
            placeChip(img25, game.getCurrentChipBets());
            System.out.println("btn25 clicked!");
        });
        btn26.setOnMouseClicked(event -> {
            placeChip(img26, game.getCurrentChipBets());
            System.out.println("btn26 clicked!");
        });
        btn27.setOnMouseClicked(event -> {
            placeChip(img27, game.getCurrentChipBets());
            System.out.println("btn27 clicked!");
        });
        btn28.setOnMouseClicked(event -> {
            placeChip(img28, game.getCurrentChipBets());
            System.out.println("btn28 clicked!");
        });
        btn29.setOnMouseClicked(event -> {
            placeChip(img29, game.getCurrentChipBets());
            System.out.println("btn29 clicked!");
        });
        btn30.setOnMouseClicked(event -> {
            placeChip(img30, game.getCurrentChipBets());
            System.out.println("btn30 clicked!");
        });
        btn31.setOnMouseClicked(event -> {
            placeChip(img31, game.getCurrentChipBets());
            System.out.println("btn31 clicked!");
        });
        btn32.setOnMouseClicked(event -> {
            placeChip(img32, game.getCurrentChipBets());
            System.out.println("btn32 clicked!");
        });
        btn33.setOnMouseClicked(event -> {
            placeChip(img33, game.getCurrentChipBets());
            System.out.println("btn33 clicked!");
        });
        btn34.setOnMouseClicked(event -> {
            placeChip(img34, game.getCurrentChipBets());
            System.out.println("btn34 clicked!");
        });
        btn35.setOnMouseClicked(event -> {
            placeChip(img35, game.getCurrentChipBets());
            System.out.println("btn35 clicked!");
        });
        btn36.setOnMouseClicked(event -> {
            placeChip(img36, game.getCurrentChipBets());
            System.out.println("btn36 clicked!");
        });


    }

    private void setChipImage(ImageView img, int id) {
        if(img.getImage() == null) {
            img.setImage(chipImage[id]);
        } else {
            img.setImage(null);
        }

    }

    private void placeChip(ImageView img, int currentChip) {
        switch (currentChip) {
            case 1:
                setChipImage(img, 0);
                break;
            case 5:
                setChipImage(img, 1);
                break;
            case 10:
                setChipImage(img, 2);
                break;
            case 20:
                setChipImage(img, 3);
                break;
            case 50:
                setChipImage(img, 4);
                break;
            case 100:
                setChipImage(img, 5);
                break;
            case 500:
                setChipImage(img, 6);
                break;
            case 1000:
                setChipImage(img, 7);
                break;
            case 5000:
                setChipImage(img, 8);
                break;
        }
    }

    //Get's game images from resources
    private void getGameImages() {
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

    //This button goes back a page to game selection
    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }

    //These buttons are used for changing the bet amount
    @FXML
    void betFifty(MouseEvent event) {
        resetArrows();
        imgArrowMarker50.setVisible(true);
        game.setCurrentChipBets(50);
    }

    @FXML
    void betFive(MouseEvent event) {
        resetArrows();
        imgArrowMarker5.setVisible(true);
        game.setCurrentChipBets(5);
    }

    @FXML
    void betFiveHundred(MouseEvent event) {
        resetArrows();
        imgArrowMarker500.setVisible(true);
        game.setCurrentChipBets(500);
    }

    @FXML
    void betFiveThousand(MouseEvent event) {
        resetArrows();
        imgArrowMarker5k.setVisible(true);
        game.setCurrentChipBets(5000);
    }

    @FXML
    void betOne(MouseEvent event) {
        resetArrows();
        imgArrowMarker1.setVisible(true);
        game.setCurrentChipBets(1);
    }

    @FXML
    void betOneHundred(MouseEvent event) {
        resetArrows();
        imgArrowMarker100.setVisible(true);
        game.setCurrentChipBets(100);
    }

    @FXML
    void betOneThousand(MouseEvent event) {
        resetArrows();
        imgArrowMarker1k.setVisible(true);
        game.setCurrentChipBets(1000);
    }

    @FXML
    void betTen(MouseEvent event) {
        resetArrows();
        imgArrowMarker10.setVisible(true);
        game.setCurrentChipBets(10);
    }

    @FXML
    void betTwenty(MouseEvent event) {
        resetArrows();
        imgArrowMarker20.setVisible(true);
        game.setCurrentChipBets(20);
    }

    //This function opens a rule window
    @FXML
    void onRules(MouseEvent event) {

    }


    @FXML
    void onZero(MouseEvent event) {

    }

    @FXML
    void onBlack(MouseEvent event) {

    }

    @FXML
    void onEven(MouseEvent event) {

    }

    @FXML
    void onOdd(MouseEvent event) {

    }

    @FXML
    void onRed(MouseEvent event) {

    }

    @FXML
    void on19to36(MouseEvent event) {

    }

    @FXML
    void on1st12(MouseEvent event) {

    }

    @FXML
    void on1to18(MouseEvent event) {

    }

    @FXML
    void on2nd12(MouseEvent event) {

    }

    @FXML
    void on2to1bot(MouseEvent event) {

    }

    @FXML
    void on2to1mid(MouseEvent event) {

    }

    @FXML
    void on2to1top(MouseEvent event) {

    }

    @FXML
    void on3rd12(MouseEvent event) {

    }


    //This function spins the wheel
    @FXML
    void onSpin(MouseEvent event) {

        //Spin Wheel
        ////////////////////
        System.out.println("Wheel is spinning");
        Random random = new Random();
        int spinDuration = random.nextInt(2) + 3; // generates a random number between 3 and 5

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(imgWheel.rotateProperty(), 0)),
                new KeyFrame(Duration.seconds(spinDuration), new KeyValue(imgWheel.rotateProperty(), 360))
        );
        timeline.play();
        ////////////////////
        int role = game.getRoleNumber();
        timeline.setOnFinished(e -> updateResult(role));

    }

    private void updateResult(int role) {
        if(role == 0) {
            game.setRoleColor(0);
            updateSpinResult(role, game.getRoleColor());
        } else if(role == 1 || role == 3 || role == 5 || role == 7 || role == 9 || role == 12 || role == 14
                || role == 16 || role == 18 || role == 19 || role == 21 || role == 23 || role == 25 || role == 27
                || role == 30 || role == 32 || role == 34 || role == 36) {
            game.setRoleColor(1);
            updateSpinResult(role, game.getRoleColor());
        } else {
            game.setRoleColor(2);
            updateSpinResult(role, game.getRoleColor());
        }
        circleResultColor.setVisible(true);
        txtResultNumber.setVisible(true);
    }

    private void updateSpinResult(int role, int color) {
        switch (color) {
            case 0:
                circleResultColor.setFill(Color.GREEN);
                txtResultNumber.setText(String.valueOf(role));
                break;
            case 1:
                circleResultColor.setFill(Color.RED);
                txtResultNumber.setText(String.valueOf(role));
                break;
            case 2:
                circleResultColor.setFill(Color.BLACK);
                txtResultNumber.setText(String.valueOf(role));
                break;
            // ...
            default:
                circleResultColor.setFill(Color.YELLOW);
                txtResultNumber.setText(String.valueOf(role));
                break;
        }
    }
}
