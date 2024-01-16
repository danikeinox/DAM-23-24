module cat.dam.psp.ex3pilotesrebotones {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens cat.dam.psp.ex3pilotesrebotones to javafx.fxml;
    opens cat.dam.psp.ex3pilotesrebotones.classes to javafx.fxml;
    opens cat.dam.psp.ex3pilotesrebotones.controller to javafx.fxml;

    exports cat.dam.psp.ex3pilotesrebotones;
    exports cat.dam.psp.ex3pilotesrebotones.classes;
    exports cat.dam.psp.ex3pilotesrebotones.controller;
}