package cat.dam.psp.ex3pilotesrebotones.controller;

import cat.dam.psp.ex3pilotesrebotones.classes.Pilota;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MainViewController {
    @FXML
    private Pane pilotaPane;
    @FXML
    private Button bt_pilota1;
    @FXML
    private Button bt_pilota2;
    @FXML
    private Button bt_pilota3;
    @FXML
    private Button bt_pilota4;
    @FXML
    private Button bt_exit;
    @FXML
    private Label lb_velocitat;
    @FXML
    private Slider sl_velocitat;


    private final PilotaController pilotaController = new PilotaController(pilotaPane, pilotaPane.getPrefWidth(), pilotaPane.getPrefHeight());

    private static final int DEFAULT_RADIUS = 20;

    // Inicialitza el controlador de pilotes
    public void initialize() {
        onSlideVelocity();
    }

    public void addPilota(String color) {
        pilotaController.addPilota(Color.valueOf(color), DEFAULT_RADIUS);
        Color.web("");
    }

    public void removePilota(String color) {
        pilotaController.stopPilota(Color.valueOf(color));
    }

    public void velocitatPilota(double velocitat) {
        Pilota pilota = (Pilota) PilotaController.pane.getChildren().stream();
        pilota.velocitat = velocitat;
    }

    public void onClickButtonPilota1() {
        if (PilotaController.findPilota(Color.RED) != null) {
            removePilota("RED");
        } else {
            addPilota("RED");
        }
    }
    public void onClickButtonPilota2() {
        if (PilotaController.findPilota(Color.BLUE) != null) {
            removePilota("BLUE");
        } else {
            addPilota("BLUE");
        }
    }
    public void onClickButtonPilota3() {
        if (PilotaController.findPilota(Color.GREEN) != null) {
            removePilota("GREEN");
        } else {
            addPilota("GREEN");
        }
    }
    public void onClickButtonPilota4() {
        if (PilotaController.findPilota(Color.PURPLE) != null) {
            removePilota("PURPLE");
        } else {
            addPilota("PURPLE");
        }
    }

    public void onClickButtonExit() {
        System.exit(0);
    }

    public void onSlideVelocity(){
        sl_velocitat.valueProperty().addListener((observable, oldValue, newValue) -> {
            lb_velocitat.setText(newValue.toString());
            velocitatPilota(newValue.doubleValue());
        });
    }





}