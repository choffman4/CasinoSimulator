module pokemon.masters.casinosimulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens pokemon.masters.casinosimulator to javafx.fxml;
    exports pokemon.masters.casinosimulator;
    exports pokemon.masters.casinosimulator.controllers;
    opens pokemon.masters.casinosimulator.controllers to javafx.fxml;
    exports pokemon.masters.casinosimulator.games;
    opens pokemon.masters.casinosimulator.games to javafx.fxml;
}