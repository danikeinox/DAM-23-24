package daniel.Cabrera;

public class PacmanGame {
    private int direccio;
    private Pantalla tablero;
    private Personaje pacman;
    private Personaje[] fantasmas;
    private boolean jocAcabat;
    private int tempsOuGran;
    private boolean pausa;
    private int qMoviments;
    private int velocitat;

    public PacmanGame(int maxF, int maxC) {
        direccio = 6;
        tablero = new Pantalla(maxF, maxC);
        pacman = new Personaje('<', maxF / 2 - 5, maxC / 2);
        fantasmas = new Personaje[4];
        // TODO Inicializa los fantasmas
        // TODO Inicializa otras variables del juego
    }

    public void iniciarJuego() throws InterruptedException {

            // TODO Lógica del juego
            // TODO Control de pausa
            // TODO Actualización del tablero
            // TODO Actualización de personajes

                // TODO Condiciones para continuar el juego
    }

    // TODO Otros métodos relacionados con el juego
}
