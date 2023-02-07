module pokemon.masters.casinosimulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens pokemon.masters.casinosimulator to javafx.fxml;
    exports pokemon.masters.casinosimulator;
}