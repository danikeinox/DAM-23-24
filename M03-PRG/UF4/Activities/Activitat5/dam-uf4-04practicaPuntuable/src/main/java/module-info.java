module daniel.Cabrera.practicaPuntuable {
    requires javafx.controls;
    requires javafx.fxml;
    requires Fitxers;


    opens daniel.Cabrera.practicaPuntuable;
    exports daniel.Cabrera.practicaPuntuable;
    exports daniel.Cabrera.practicaPuntuable.controladors;
    opens daniel.Cabrera.practicaPuntuable.controladors to javafx.fxml;

    opens daniel.Cabrera.practicaPuntuable.classes;

}