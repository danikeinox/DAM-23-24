package cat.dam.psp.ex3pilotesrebotones.controller;

import cat.dam.psp.ex3pilotesrebotones.classes.Pilota;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Objects;

public class PilotaController {
    protected static Pane pane = new Pane();
    private final double limitX, limitY;

    public PilotaController(Pane pane, double limitX, double limitY) {
        PilotaController.pane = pane;
        this.limitX = limitX;
        this.limitY = limitY;
    }

    public static Pilota findPilota(Color color) {
        for (Node node : pane.getChildren()) {
            if (node instanceof Pilota && ((Pilota) node).getFill().equals(color)) {
                return (Pilota) node;
            }
        }
        return null;
    }

    public void addPilota(Color color, int radius) {
        Pilota pilota = new Pilota(color, radius, limitX, limitY);
        pane.getChildren().add(pilota);
        new Thread(pilota).start();
    }


    public void stopPilota(Color color) {
        Pilota pilota = PilotaController.findPilota(color);
        pilota.running = false;
    }


    public void resumePilota(Color color) {
        Pilota pilota = PilotaController.findPilota(color);
        pilota.running = true;
        new Thread(pilota).start();
    }
}