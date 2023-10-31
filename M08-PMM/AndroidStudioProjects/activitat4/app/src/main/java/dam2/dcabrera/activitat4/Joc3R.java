package dam2.dcabrera.activitat4;

import java.util.Random;

public class Joc3R {
    private final int difJoc;
    public int jugador;
    public int[] statCasella;
    public final int[][] R3Possib = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public Joc3R(int difJoc) {
        this.difJoc = difJoc;
        jugador=1;
        statCasella = new int[9];
        for (int j = 0; j<9;j++) {
            statCasella[j] = 0;
        }
    }

    public int torn(){
        boolean tablas = true;
        boolean puntFinal = true;
        for (int i = 0; i< R3Possib.length;i++){
            for(int pos:R3Possib[i]){
                if(statCasella[pos]!=jugador){
                    puntFinal = false;
                }
                if(statCasella[pos]==0){
                    tablas = false;
                }
            }
            if (puntFinal){
                return jugador;
            }
            puntFinal = true;
        }
        if (tablas){
            return 3;
        }
        jugador ++;
        if (jugador > 2) {
            jugador = 1;
        }
        return 0;
    }

    public int jugaMaquina() {
        Random r = new Random();
        return r.nextInt(9);
    }

    public boolean checkCasella(int casella) {
        if (statCasella[casella] != 0) {
            return false;
        } else {
            statCasella[casella] = jugador;
        }
        return true;
    }
}
