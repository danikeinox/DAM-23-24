module cat.dam.psp.activitat_dos {
    requires javafx.controls;
    requires javafx.fxml;


    opens cat.dam.psp.activitat_dos.controllers to javafx.fxml;
    exports cat.dam.psp.activitat_dos;
}