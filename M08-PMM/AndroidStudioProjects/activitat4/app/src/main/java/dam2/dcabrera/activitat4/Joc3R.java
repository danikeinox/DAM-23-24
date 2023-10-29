package dam2.dcabrera.activitat4;

import java.util.Random;

public class Joc3R {
    private final int difJoc;
    public int jugador;
    public int[] statCasella;

    public Joc3R(int difJoc) {
        this.difJoc = difJoc;
        jugador=1;
        statCasella = new int[9];
        for (int j = 0; j<9;j++) {
            statCasella[j] = 0;
        }
    }

    public void torn(){
        jugador ++;
        if (jugador > 2) {
            jugador = 1;
        }
    }

    public int jugaMaquina() {
        Random r = new Random();
        return r.nextInt(9);
    }

    public boolean checkCasella(int casella) {
        if (casella < 0 || casella > 8) {
            return false;
        }
        return true;
    }
}
