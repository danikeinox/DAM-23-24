module daniel.Cabrera.herenciaexemple {
    requires javafx.controls;
    requires javafx.fxml;
    requires Fitxers;


    opens daniel.Cabrera.herenciaexemple;
    exports daniel.Cabrera.herenciaexemple;
    exports daniel.Cabrera.herenciaexemple.controladors;
    opens daniel.Cabrera.herenciaexemple.controladors to javafx.fxml;

    opens daniel.Cabrera.herenciaexemple.classes;

}