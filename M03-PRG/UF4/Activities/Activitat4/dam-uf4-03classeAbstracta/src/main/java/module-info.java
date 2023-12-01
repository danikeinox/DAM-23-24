module daniel.Cabrera.classeAbstractaPrototip {
    requires javafx.controls;
    requires javafx.fxml;
    requires Fitxers;


    opens daniel.Cabrera.classeAbstractaPrototip;
    exports daniel.Cabrera.classeAbstractaPrototip;
    exports daniel.Cabrera.classeAbstractaPrototip.controladors;
    opens daniel.Cabrera.classeAbstractaPrototip.controladors to javafx.fxml;

    opens daniel.Cabrera.classeAbstractaPrototip.classes;

}