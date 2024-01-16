package cat.dam.psp.ex3pilotesrebotones.controller;

import cat.dam.psp.ex3pilotesrebotones.classes.Pilota;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
        Pilota pilota = PilotaController.findPilota(color);
        if (pilota != null) {
            pilota.running = true;
        } else {
            Pilota pilotaAdd = new Pilota(color, radius, limitX, limitY);
            pane.getChildren().add(pilotaAdd);
            new Thread(pilotaAdd).start();
        }
    }

    public void stopPilota(Color color) {
        Pilota pilota = PilotaController.findPilota(color);
        if (pilota != null) {
            pilota.running = false;
        }
    }


    public void resumePilota(Color color) {
        Pilota pilota = PilotaController.findPilota(color);
        if (pilota != null) {
            pilota.running = true;
        }
    }
}