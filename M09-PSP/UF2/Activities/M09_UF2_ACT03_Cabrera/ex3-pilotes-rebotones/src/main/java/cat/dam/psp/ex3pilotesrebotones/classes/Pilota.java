package cat.dam.psp.ex3pilotesrebotones.classes;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pilota extends Circle implements Runnable {
    private double dx, dy;  // Direccions de moviment
    private final double limitX, limitY;  // Límits de l'àrea de moviment
    public volatile boolean running = true;  // Controla si la pilota està en moviment
    public static double velocitat = 1.0;  // Velocitat comuna a totes les pilotes

    public Pilota(Color color, int radius, double limitX, double limitY) {
        super(radius, color);  // És filla de Circle. Li facilitem el color i el radi
        this.limitX = limitX;  // Límit dels eixos X i Y
        this.limitY = limitY;
        this.dx = 1 + Math.random() * 3;  // Velocitat inicial aleatòria en l'eix X
        this.dy = 1 + Math.random() * 3;  // Velocitat inicial aleatòria en l'eix Y
        // Posiciona la pilota en un lloc aleatori dins dels límits
        setLayoutX(radius + Math.random() * (limitX - 2 * radius));
        setLayoutY(radius + Math.random() * (limitY - 2 * radius));
    }

    @Override
    public void run() {
        while (running) {
            double x = getLayoutX() + dx * velocitat;
            double y = getLayoutY() + dy * velocitat;

            if (x <= getRadius() || x >= limitX - getRadius()) {
                dx *= -1;
            }
            if (y <= getRadius() || y >= limitY - getRadius()) {
                dy *= -1;
            }

            // Actualitza la posició de la pilota en el thread principal d'aplicació de JavaFX
            Platform.runLater(() -> {
                setLayoutX(x);
                setLayoutY(y);
            });

            // Introna un retard per la velocitat de la pilota. Així la veurem millor
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }
}