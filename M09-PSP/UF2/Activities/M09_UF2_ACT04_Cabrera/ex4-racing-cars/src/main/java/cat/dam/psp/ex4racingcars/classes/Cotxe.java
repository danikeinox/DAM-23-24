package cat.dam.psp.ex4racingcars.classes;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Cotxe extends Rectangle implements Runnable {
    public volatile boolean enMoviment;
    private final double velocitatMaxima;
    private double velocitatActual;
    private final double carrilY;
    private final int limitX;
    private final int ampladaCarril;
    public long tempsInici;
    public long tempsFinal;
    private final Color colorCotxe;
    private final CarreraController carreraController;
    private static final int VELOCITAT_REFRESC = 5;

    public Cotxe(Color color, double carrilY, int limitX, int ampladaCarril, double velocitatMaxima, CarreraController controller) {
        super(40, 20, color); // Mides del cotxe (amplada, altura)
        this.colorCotxe = color;
        this.carrilY = carrilY;
        this.limitX = limitX;
        this.ampladaCarril = ampladaCarril;
        this.velocitatMaxima = velocitatMaxima;
        this.velocitatActual = Math.random() * velocitatMaxima;
        this.carreraController = controller;
        setLayoutY(carrilY + (ampladaCarril - getHeight()) / 2); // Posicionament vertical dins del carril
    }

    @Override
    public void run() {
        while (enMoviment && !arribatAMeta()) {
            double x = getLayoutX() + velocitatActual;
            Platform.runLater(() -> setLayoutX(x));
            try {
                Thread.sleep(VELOCITAT_REFRESC); // Interval de temps per a l'actualització del moviment
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                enMoviment = false;
            }
        }
        if (enMoviment) {
            tempsFinal = System.currentTimeMillis() - tempsInici;
            enMoviment = false;
            carreraController.notificarFinalCarrera(this);
        }
    }

    private boolean arribatAMeta() {
        return getLayoutX() >= limitX - getWidth();
    }

    public Color getColorCotxe() {
        return colorCotxe;
    }

    public void canviarVelocitat(double novaVelocitat) {
        this.velocitatActual = Math.min(novaVelocitat, velocitatMaxima);
    }
}