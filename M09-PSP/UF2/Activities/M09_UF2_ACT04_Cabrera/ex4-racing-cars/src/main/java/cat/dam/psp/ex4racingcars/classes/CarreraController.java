package cat.dam.psp.ex4racingcars.classes;

import cat.dam.psp.ex4racingcars.controller.CarreraViewController;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class CarreraController {
    private int cochesFinalizados = 0;
    private final Pane pistaCarrera;
    private final int limitX;
    private final int ampladaCarril;
    private final double velocitatMaxima = 5.0; // Velocitat maxima del cotxe
    private ResultatCarrera[] resultats;
    private Cotxe cotxe;
    private Color[] colorsCotxes = {Color.RED, Color.GREEN, Color.BLUE, Color.PURPLE};
    public Cotxe[] cotxes = new Cotxe[4];

    public CarreraController(Pane pistaCarrera, int limitX, int ampladaCarril) {
        this.pistaCarrera = pistaCarrera;
        this.limitX = limitX;
        this.ampladaCarril = ampladaCarril;
        this.resultats = new ResultatCarrera[cotxes.length];
        for (int i = 0; i < cotxes.length; i++) {
            this.cotxe = new Cotxe(colorsCotxes[i], i * ampladaCarril, limitX, ampladaCarril, velocitatMaxima, this);
            cotxes[i] = this.cotxe;
            this.resultats[i] = new ResultatCarrera(this.cotxe.getColorCotxe(), 0); // Valor a modificar al final de la carrera
        }
        inicialitzarCotxes();
    }

    public void inicialitzarCotxes() {
        for (Cotxe cotxe : cotxes) {
            pistaCarrera.getChildren().add(cotxe);
        }
    }

    public void iniciarCarrera() {
        for (Cotxe cotxe : cotxes) {
            cotxe.tempsInici = System.currentTimeMillis();
            cotxe.enMoviment = true;
            new Thread(cotxe).start();
        }
    }

    public void pausarCarrera() {
        for (Cotxe cotxe : cotxes) {
            cotxe.enMoviment = false;
        }
    }

    public void continuarCarrera() {
        for (Cotxe cotxe : cotxes) {
            cotxe.enMoviment = true;
            new Thread(cotxe).start();
        }
    }

    public void reiniciarCarrera() {
        for (Cotxe cotxe : cotxes) {
            pistaCarrera.getChildren().remove(cotxe);
        }
        for (ResultatCarrera resultat : resultats) {
            pistaCarrera.getChildren().remove(resultat);
        }
    }


    public void notificarFinalCarrera(Cotxe cotxe) {
        int index = getCotxeIndex(cotxe);
        this.resultats[index] = new ResultatCarrera(cotxe.getColorCotxe(), cotxe.tempsFinal);

        cochesFinalizados++;

        if (cochesFinalizados == cotxes.length) {
            Platform.runLater(() -> {
                // Todos los coches han finalizado, mostrar el Alert
                mostrarResultats(resultats);
                cochesFinalizados = 0; // Reinicia el contador para la próxima carrera
                reiniciarCarrera();
                new CarreraController(this.pistaCarrera, this.limitX, this.ampladaCarril);
            });
        }

    }


    // Nou mètode para obtenir l'índex del cotxe
    private int getCotxeIndex(Cotxe cotxe) {
        for (int i = 0; i < cotxes.length; i++) {
            if (cotxes[i] == cotxe) {
                return i;
            }
        }
        return -1;
    }


    private void mostrarResultats(ResultatCarrera[] resultats) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultats");
        alert.setHeaderText("Resultats de la carrera");
        alert.initOwner(pistaCarrera.getScene().getWindow());
        alert.getDialogPane().setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        alert.getDialogPane().setPrefWidth(Region.USE_COMPUTED_SIZE);
        alert.getDialogPane().setPrefHeight(Region.USE_COMPUTED_SIZE);
        alert.getDialogPane().setMinWidth(Region.USE_COMPUTED_SIZE);
        alert.getDialogPane().setMinHeight(Region.USE_COMPUTED_SIZE);


        StringBuilder contentText = new StringBuilder();
        for (ResultatCarrera resultat : resultats) {
            contentText.append(resultat.toString()).append("\n");
        }

        alert.setContentText(contentText.toString());
        alert.showAndWait();
    }
}
