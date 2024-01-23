package cat.dam.psp.ex4racingcars.classes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class CarreraController {
    private final Pane pistaCarrera;
    private final int limitX;
    private final int ampladaCarril;
    private final double velocitatMaxima = 5.0; // Velocitat maxima del cotxe
    private ResultatCarrera resultat;
    private Cotxe cotxe;

    public CarreraController(Pane pistaCarrera, int limitX, int ampladaCarril) {
        this.pistaCarrera = pistaCarrera;
        this.limitX = limitX;
        this.ampladaCarril = ampladaCarril;
        // Carril 0, primer panell, Carril 1, segon panell, etc (si dupliques els carrils, el Pane)
        this.cotxe = new Cotxe(Color.RED, 0 * ampladaCarril, limitX, ampladaCarril, velocitatMaxima, this);
        this.resultat = new ResultatCarrera(cotxe.getColorCotxe(), 0); // Valor a modificar al final de la carrera
        inicialitzarCotxes();
    }

    private void inicialitzarCotxes() {
        pistaCarrera.getChildren().add(cotxe);
    }


    public void notificarFinalCarrera(Cotxe cotxe) {
        throw new UnsupportedOperationException();
    }

    private void mostrarResultats() {
        throw new UnsupportedOperationException();
    }
}
