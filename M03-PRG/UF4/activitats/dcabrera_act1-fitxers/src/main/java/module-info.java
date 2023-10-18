module daniel.Cabrera.act1_fitxers {
    requires javafx.controls;
    requires javafx.fxml;

    opens daniel.Cabrera.act1_fitxers to javafx.fxml;
    exports daniel.Cabrera.act1_fitxers;
    exports daniel.Cabrera.act1_fitxers.Controladors;
    opens daniel.Cabrera.act1_fitxers.Controladors to javafx.fxml;
}