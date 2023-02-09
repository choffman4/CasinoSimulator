module pokemon.masters.casinosimulator2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pokemon.masters.casinosimulator to javafx.fxml;
    exports pokemon.masters.casinosimulator;
    exports pokemon.masters.casinosimulator.controllers;
    opens pokemon.masters.casinosimulator.controllers to javafx.fxml;
    exports pokemon.masters.casinosimulator.gamelogic;
    opens pokemon.masters.casinosimulator.gamelogic to javafx.fxml;
    exports pokemon.masters.casinosimulator.services;
    opens pokemon.masters.casinosimulator.services to javafx.fxml;
}