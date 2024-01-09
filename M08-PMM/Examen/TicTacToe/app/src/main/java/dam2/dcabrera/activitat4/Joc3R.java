package dam2.dcabrera.activitat4;

import java.util.Random;

public class Joc3R {
    private final int difJoc;
    public int jugador;
    public int[] statCasella;
    public final int[][] R3Possib = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    public final int[] esquines = {0, 3, 6, 8};

    public Joc3R(int difJoc) {
        this.difJoc = difJoc;
        jugador = 1;
        statCasella = new int[9];
        for (int j = 0; j < 9; j++) {
            statCasella[j] = 0;
        }
    }

    public int torn() {
        boolean tablas = true;
        boolean puntFinal = true;
        for (int i = 0; i < R3Possib.length; i++) {
            for (int pos : R3Possib[i]) {
                if (statCasella[pos] != jugador) {
                    puntFinal = false;
                }
                if (statCasella[pos] == 0) {
                    tablas = false;
                }
            }
            if (puntFinal) {
                return jugador;
            }
            puntFinal = true;
        }
        if (tablas) {
            return 3;
        }
        jugador++;
        if (jugador > 2) {
            jugador = 1;
        }
        return 0;
    }

    public int jugaMaquina() {
        int casella;
        if (difJoc > 0) {
            casella = cerca2R(2);
            if (casella != -1) {
                return casella;
            }
            casella = cerca2R(1);
            if (casella != -1) {
                return casella;
            }
        }
        if (difJoc == 2) {
            if (statCasella[0] == 0)
                return 0;
            if (statCasella[2] == 0)
                return 2;
            if (statCasella[6] == 0)
                return 6;
            if (statCasella[8] == 0)
                return 8;
        }
        Random r = new Random();
        casella = r.nextInt(9);
        return casella;
    }


    public boolean checkCasella(int casella) {
        if (statCasella[casella] != 0) {
            return false;
        } else {
            statCasella[casella] = jugador;
        }
        return true;
    }

    public boolean checkCasellaPropia(int casella) {
        if (statCasella[casella] == jugador) {
            return true;
        } else {
            return false;
        }
    }

    public int cerca2R(int jugador) {
        int casActual = -1;
        int contador = 0;
        for (int i = 0; i < R3Possib.length; i++) {
            for (int pos : R3Possib[i]) {
                if (statCasella[pos] == jugador) {
                    contador++;
                }
                if (statCasella[pos] == 0) {
                    casActual = pos;
                }
            }
            if ((contador == 2) && (casActual != -1)) {
                return casActual;
            }
            casActual = -1;
            contador = 0;
        }
        System.out.println("cerca2R Retorna -1");
        return -1;
    }
}
