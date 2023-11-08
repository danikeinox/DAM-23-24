module daniel.Cabrera.herenciaexemple {
    requires javafx.controls;
    requires javafx.fxml;
    requires Fitxers;


    opens daniel.Cabrera.herenciaexemple to javafx.fxml;
    exports daniel.Cabrera.herenciaexemple;
    opens daniel.Cabrera.herenciaexemple.controladors to javafx.fxml;

}