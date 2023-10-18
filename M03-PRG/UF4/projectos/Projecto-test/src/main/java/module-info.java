module daniel.cabrera.projectotest {
    requires javafx.controls;
    requires javafx.fxml;


    opens daniel.cabrera.projectotest to javafx.fxml;
    exports daniel.cabrera.projectotest;
}