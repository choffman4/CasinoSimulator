package pokemon.masters.casinosimulator.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import pokemon.masters.casinosimulator.services.ChangeScene;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RouletteController {

    private final Image[] chipImage = new Image[3];

    @FXML
    GridPane gridNumbers;
    @FXML
    ImageView img0, btnBack, btnRules, btnSpin, img19to36, img1st12, img1to18, img2nd12, img2to1bottom, img2to1middle,
            img2to1top, img3rd12, imgArrowMarker1, imgArrowMarker10, imgArrowMarker20, imgArrowMarker30,
            imgArrowMarker5, imgArrowMarker6, imgArrowMarker7, imgArrowMarker8, imgBlackDiamond, imgEVEN, imgODD,
            imgRedDiamond;
    @FXML
    private Text txtChipsAmount, txtResultNumber;
    @FXML
    private Circle circleResultColor;

    @FXML
    protected void initialize() {
        System.out.println("Hello World");

        //get pokerchip images
        getGameImages();

        //loop through grid and add a stackPane with child image
        getGridButtons();

        //Initialize buttons in grid number 1-36
        initializeBettingButtons();
    }

    //loop through grid and add a stackpane with child image
    private void getGridButtons() {
        //padding and size of gridpane units
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

    private void initializeBettingButtons() {
        //These are all the buttons and images associated with each of the numbers 1-36
        StackPane btn1 = (StackPane) gridNumbers.getChildren().get(0);
        ImageView img1 = (ImageView) btn1.getChildren().get(0);
        StackPane btn2 = (StackPane) gridNumbers.getChildren().get(1);
        ImageView img2 = (ImageView) btn2.getChildren().get(0);
        StackPane btn3 = (StackPane) gridNumbers.getChildren().get(2);
        ImageView img3 = (ImageView) btn3.getChildren().get(0);
        StackPane btn4 = (StackPane) gridNumbers.getChildren().get(3);
        ImageView img4 = (ImageView) btn4.getChildren().get(0);
        StackPane btn5 = (StackPane) gridNumbers.getChildren().get(4);
        ImageView img5 = (ImageView) btn5.getChildren().get(0);
        StackPane btn6 = (StackPane) gridNumbers.getChildren().get(5);
        ImageView img6 = (ImageView) btn6.getChildren().get(0);
        StackPane btn7 = (StackPane) gridNumbers.getChildren().get(6);
        ImageView img7 = (ImageView) btn7.getChildren().get(0);
        StackPane btn8 = (StackPane) gridNumbers.getChildren().get(7);
        ImageView img8 = (ImageView) btn8.getChildren().get(0);
        StackPane btn9 = (StackPane) gridNumbers.getChildren().get(8);
        ImageView img9 = (ImageView) btn9.getChildren().get(0);
        StackPane btn10 = (StackPane) gridNumbers.getChildren().get(9);
        ImageView img10 = (ImageView) btn10.getChildren().get(0);
        StackPane btn11 = (StackPane) gridNumbers.getChildren().get(10);
        ImageView img11 = (ImageView) btn11.getChildren().get(0);
        StackPane btn12 = (StackPane) gridNumbers.getChildren().get(11);
        ImageView img12 = (ImageView) btn12.getChildren().get(0);

        StackPane btn13 = (StackPane) gridNumbers.getChildren().get(12);
        ImageView img13 = (ImageView) btn13.getChildren().get(0);
        StackPane btn14 = (StackPane) gridNumbers.getChildren().get(13);
        ImageView img14 = (ImageView) btn14.getChildren().get(0);
        StackPane btn15 = (StackPane) gridNumbers.getChildren().get(14);
        ImageView img15 = (ImageView) btn15.getChildren().get(0);
        StackPane btn16 = (StackPane) gridNumbers.getChildren().get(15);
        ImageView img16 = (ImageView) btn16.getChildren().get(0);
        StackPane btn17 = (StackPane) gridNumbers.getChildren().get(16);
        ImageView img17 = (ImageView) btn17.getChildren().get(0);
        StackPane btn18 = (StackPane) gridNumbers.getChildren().get(17);
        ImageView img18 = (ImageView) btn18.getChildren().get(0);
        StackPane btn19 = (StackPane) gridNumbers.getChildren().get(18);
        ImageView img19 = (ImageView) btn19.getChildren().get(0);
        StackPane btn20 = (StackPane) gridNumbers.getChildren().get(19);
        ImageView img20 = (ImageView) btn20.getChildren().get(0);
        StackPane btn21 = (StackPane) gridNumbers.getChildren().get(20);
        ImageView img21 = (ImageView) btn21.getChildren().get(0);
        StackPane btn22 = (StackPane) gridNumbers.getChildren().get(21);
        ImageView img22 = (ImageView) btn22.getChildren().get(0);
        StackPane btn23 = (StackPane) gridNumbers.getChildren().get(22);
        ImageView img23 = (ImageView) btn23.getChildren().get(0);
        StackPane btn24 = (StackPane) gridNumbers.getChildren().get(23);
        ImageView img24 = (ImageView) btn24.getChildren().get(0);

        StackPane btn25 = (StackPane) gridNumbers.getChildren().get(24);
        ImageView img25 = (ImageView) btn25.getChildren().get(0);
        StackPane btn26 = (StackPane) gridNumbers.getChildren().get(25);
        ImageView img26 = (ImageView) btn26.getChildren().get(0);
        StackPane btn27 = (StackPane) gridNumbers.getChildren().get(26);
        ImageView img27 = (ImageView) btn27.getChildren().get(0);
        StackPane btn28 = (StackPane) gridNumbers.getChildren().get(27);
        ImageView img28 = (ImageView) btn28.getChildren().get(0);
        StackPane btn29 = (StackPane) gridNumbers.getChildren().get(28);
        ImageView img29 = (ImageView) btn29.getChildren().get(0);
        StackPane btn30 = (StackPane) gridNumbers.getChildren().get(29);
        ImageView img30 = (ImageView) btn30.getChildren().get(0);
        StackPane btn31 = (StackPane) gridNumbers.getChildren().get(30);
        ImageView img31 = (ImageView) btn31.getChildren().get(0);
        StackPane btn32 = (StackPane) gridNumbers.getChildren().get(31);
        ImageView img32 = (ImageView) btn32.getChildren().get(0);
        StackPane btn33 = (StackPane) gridNumbers.getChildren().get(32);
        ImageView img33 = (ImageView) btn33.getChildren().get(0);
        StackPane btn34 = (StackPane) gridNumbers.getChildren().get(33);
        ImageView img34 = (ImageView) btn34.getChildren().get(0);
        StackPane btn35 = (StackPane) gridNumbers.getChildren().get(34);
        ImageView img35 = (ImageView) btn35.getChildren().get(0);
        StackPane btn36 = (StackPane) gridNumbers.getChildren().get(35);
        ImageView img36 = (ImageView) btn36.getChildren().get(0);
    }


    private void getGameImages() {
        try {
            InputStream chip1 = new FileInputStream("src/main/resources/pokemon/masters/casinosimulator/casinoassets/OverallUI/Chip1.png");
            chipImage[0] = new Image(chip1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //This button goes back a page to game selection
    @FXML
    protected void onBackPage(MouseEvent event) throws IOException {
        ChangeScene.changeScene(event, "chooseGameView.fxml");
    }

    @FXML
    void betFifty(MouseEvent event) {

    }

    @FXML
    void betFive(MouseEvent event) {

    }

    @FXML
    void betFiveHundred(MouseEvent event) {

    }

    @FXML
    void betFiveThousand(MouseEvent event) {

    }

    @FXML
    void betOne(MouseEvent event) {

    }

    @FXML
    void betOneHundred(MouseEvent event) {

    }

    @FXML
    void betOneThousand(MouseEvent event) {

    }

    @FXML
    void betTen(MouseEvent event) {

    }

    @FXML
    void betTwenty(MouseEvent event) {

    }

    @FXML
    void onRules(MouseEvent event) {

    }
}
