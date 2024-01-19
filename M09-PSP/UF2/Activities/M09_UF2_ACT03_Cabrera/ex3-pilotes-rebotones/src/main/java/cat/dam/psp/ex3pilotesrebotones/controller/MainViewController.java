package cat.dam.psp.ex3pilotesrebotones.controller;

import cat.dam.psp.ex3pilotesrebotones.classes.Pilota;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Objects;

public class MainViewController {
    @FXML
    private Pane pilotaPane;
    @FXML
    private Button[] buttons;
    @FXML
    private Button bt_exit;
    @FXML
    private Label lb_velocitat;
    @FXML
    private Slider sl_velocitat;

    private static final int DEFAULT_RADIUS = 20;
    private static final Color [] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE};
    PilotaController pilotaController;
    @FXML
    private Button bt_pilota1;
    @FXML
    private Button bt_pilota2;
    @FXML
    private Button bt_pilota3;
    @FXML
    private Button bt_pilota4;

    // Inicializa el controlador de pilotes
    public void initialize() {
        buttons = new Button[]{bt_pilota1, bt_pilota2, bt_pilota3, bt_pilota4};
        initButtons();

        if (pilotaPane != null) {
            pilotaController = new PilotaController(pilotaPane, pilotaPane.getPrefWidth(), pilotaPane.getPrefHeight());
            onSlideVelocity();
        } else {
            System.out.println("Error: pilotaPane no s'ha inicialitzat.");
        }
    }

    private void initButtons() {
        for (int i = 0; i < buttons.length; i++) {
            Button button = buttons[i];
            button.setBackground(new Background(new BackgroundFill(colors[i], null, null)));
            int finalI = i;
            button.setOnAction(e -> onClickButtonPilota(button, colors[finalI]));
        }
    }

    public void addPilota(String color) {
        if (PilotaController.findPilota(Color.valueOf(color)) == null) {
            pilotaController.addPilota(Color.valueOf(color), DEFAULT_RADIUS);
        } else {
            pilotaController.resumePilota(Color.valueOf(color));
        }
    }

    public void removePilota(Color color) {
        pilotaController.stopPilota(color);
    }

    public void resumePilota(Color color) {
        pilotaController.resumePilota(color);
    }

    public double velocitatPilota(double velocitat) {
        PilotaController.pane.getChildren().forEach(
                node -> {
                    if (node instanceof Pilota) {
                        Pilota.velocitat = velocitat;
                    }
                }
        );
        return velocitat;
    }

    public void onClickButtonPilota(Button button, Color color) {
        if (button == bt_exit) {
            onClickButtonExit();
            return;
        }

        if (PilotaController.findPilota(color) != null) {
            if (Objects.requireNonNull(PilotaController.findPilota(color)).running) {
                removePilota(color);
            } else {
                resumePilota(color);
            }
        } else {
            addPilota(color.toString());
        }
    }

    public void onClickButtonExit() {
        for(int i = 0; i < buttons.length; i++) {
            if (PilotaController.findPilota(colors[i]) != null)
                removePilota(Color.valueOf(colors[i].toString()));
        }
    }

    public void onSlideVelocity() {
        sl_velocitat.setMin(1);
        sl_velocitat.setMax(10);
        sl_velocitat.setValue(velocitatPilota(Pilota.velocitat));
        sl_velocitat.valueProperty().addListener((observable, oldValue, newValue) -> {
            lb_velocitat.setText(String.format(String.valueOf(newValue.doubleValue()), "%.1f"));
            velocitatPilota(newValue.doubleValue());
        });
    }
}