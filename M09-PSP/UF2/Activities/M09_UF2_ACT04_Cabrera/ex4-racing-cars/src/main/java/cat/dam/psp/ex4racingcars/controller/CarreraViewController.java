package cat.dam.psp.ex4racingcars.controller;

import cat.dam.psp.ex4racingcars.classes.CarreraController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CarreraViewController implements Initializable {
    public Button btnIniciar;
    public Button btnPausar;
    public Button btnReprendre;
    public Button btnReiniciar;
    @FXML
    private Pane pistaCarrera;

    private CarreraController carreraController;
    private final int limitX = 600; // L'ample de la pista de carrera
    private final int ampladaCarril = 75; // L'alçada de cada carril

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carreraController = new CarreraController(pistaCarrera, limitX, ampladaCarril);
    }

    @FXML
    private void handleIniciar() {
        throw new UnsupportedOperationException();
    }

    @FXML
    private void handlePausar() {
        throw new UnsupportedOperationException();
    }

    @FXML
    private void handleReprendre() {
        throw new UnsupportedOperationException();
    }

    @FXML
    private void handleReiniciar() {
        throw new UnsupportedOperationException();
    }

    @FXML
    private void handleSortir() {
        throw new UnsupportedOperationException();
    }
}