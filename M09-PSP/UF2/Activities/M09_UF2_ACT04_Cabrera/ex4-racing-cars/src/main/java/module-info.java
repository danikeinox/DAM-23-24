module cat.dam.psp.ex4racingcars.ex4racingcars {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens cat.dam.psp.ex4racingcars to javafx.fxml;
    opens cat.dam.psp.ex4racingcars.controller to javafx.fxml;

    exports cat.dam.psp.ex4racingcars;
    exports cat.dam.psp.ex4racingcars.controller;
    exports cat.dam.psp.ex4racingcars.classes;
    opens cat.dam.psp.ex4racingcars.classes to javafx.fxml;

}