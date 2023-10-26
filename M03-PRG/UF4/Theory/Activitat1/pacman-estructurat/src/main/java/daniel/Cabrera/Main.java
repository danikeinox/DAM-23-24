package daniel.Cabrera;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {


    //<editor-fold desc="variables estàtiques">
    static int direccio = 6;                        // 6->dreta  4 -> esquerra  8->amunt   2-> avall


    static String blauC = "\033[3;34m";             // per colorejar de blau
    static String roigN = "\033[1;31m";             // per colorejar de roig
    static String cafeN = "\033[1;33m";             // per colorejar de café
    static String purpuraN = "\033[1;35m";          // per colorejar de café
    static String colorF = purpuraN;                // color Fantasma
    static String verdN = "\033[1;32m";             // per colorejar de verd
    static String nc = "\033[0m";                   // per retornar al color normal
    static boolean pausa = false;                   // per pausar el joc

    static String sistemaOperatiu = System.getProperty("os.name");
    //</editor-fold>

    public static void main(String[] args) throws InterruptedException {

        //<editor-fold desc="Variables Locals">
        int maxF = 20, maxC = 24;
        int[][] taulell = new int[maxF][maxC];
        char pacman = '<';              // serà així: <-    ->   ^|   v|
        char fantasma = '&';            // fantasma
        int contaPunts = 0;             // per contar els punts que hi han a la matriu i els que ens hem menjat
        int pos_I_pacman = maxF / 2 - 5;// posició fila pacman
        int pos_J_pacman = maxC / 2;    // posició col  pacman
        //  int posIF1 = maxF / 2, posIF2 = maxF / 2, posIF3 = maxF / 2;       // posició fila fantasma 1, 2, 3
        // int posJF1 = maxC / 2, posJF2 = maxC / 2, posJF3 = maxC / 2;        // posició col  fantasma 1, 2, 3
        int qMoviments = 0;             // Quantitat de Moviments
        int velocitat = 500;            // velocitat de moviments. S'incrementarà poc a poc
        int maxFantasmes = 4;
        int[][] fantasmes = new int[maxFantasmes][3];   // fantasmes, posició i direcció
        // i -> número de fantasmes
        // j -> (0) - posició X (i)   (1) - posició Y (j)   (2) - direcció (2, 4, 6, 8)
        boolean jocAcabat = false;
        int tempsOuGran = 0;            // temps que té el pacman per menjar-se un fantasma després d'agafar un ou Gran
        //</editor-fold>

        //<editor-fold desc="codi Event Botó">
        Frame f = new Frame("Taulell de control");
        f.setLayout(new FlowLayout());
        f.setSize(500, 100);        // TAMAY DEL FRAME
        Label l = new Label();
        l.setText("Posa ací el ratolí i prem botons dreta o esquera del teclat");
        f.add(l);
        f.setVisible(true);


        // POSEM EL CODI DEL LISTENER (cada cop que premem algun botó)
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent event) {
//                if (espai[maxF - 1][llocNau] == -1) {
//
//                }
                if (event.getKeyCode() == KeyEvent.VK_RIGHT) {      // al prèmer tecla dreta
                    direccio = 6;
                }
                if (event.getKeyCode() == KeyEvent.VK_LEFT) {       // al prèmer la tecla esquerra
                    direccio = 4;
                }
                if (event.getKeyCode() == KeyEvent.VK_UP) {       // al prèmer la tecla AMUNT
                    direccio = 8;
                }
                if (event.getKeyCode() == KeyEvent.VK_DOWN) {       // al prèmer la tecla AVALL
                    direccio = 2;
                }
                if (event.getKeyCode() == KeyEvent.VK_P) {      // al prèmer tecla dreta
                    pausa = true;
                }
                if (event.getKeyCode() == KeyEvent.VK_R) {      // al prèmer tecla dreta
                    pausa = false;
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {
                //       printEventInfo("Key Released", event);
            }

            @Override
            public void keyTyped(KeyEvent event) {
                //      printEventInfo("Key Typed", event);
            }

            private void printEventInfo(String str, KeyEvent e) {
//                System.out.println(str);
//                int code = e.getKeyCode();
//                System.out.println("   Code: " + KeyEvent.getKeyText(code));
//                System.out.println("   Char: " + e.getKeyChar());
//                int mods = e.getModifiersEx();
//                System.out.println("    Mods: "
//                        + KeyEvent.getModifiersExText(mods));
//                System.out.println("    Location: "
//                        + keyboardLocation(e.getKeyLocation()));
//                System.out.println("    Action? " + e.isActionKey());
            }

            private String keyboardLocation(int keybrd) throws InterruptedException {
                switch (keybrd) {
                    case KeyEvent.KEY_LOCATION_RIGHT:

                        // return "Right";

                    case KeyEvent.KEY_LOCATION_LEFT:
                        // canviaPos(false);
                        //   return "Left";

                    case KeyEvent.KEY_LOCATION_NUMPAD:
                        return "NumPad";
                    case KeyEvent.KEY_LOCATION_STANDARD:
                        return "Standard";
                    case KeyEvent.KEY_LOCATION_UNKNOWN:
                    default:
                        return "Unknown";
                }
            }
        };

        // AFEGIM EL listener AL JPANELL CREAT DALT
        f.addKeyListener(listener);


        if (sistemaOperatiu.contains("indows")) {
            //  blauC = roigN = cafeN = purpuraN = colorF = nc = "";          // tristament windows no té colors a la terminal
            System.out.println("DETECTAT SISTEMA OPERATIU WINDOWS");
            System.out.println(" NO FUNCIONARÀ AMB cmd NI POWER SHELL");
            System.out.println("INSTAL·LA LA CONSOLA git bash I EXECUTA DES D'ALLÀ");
            Thread.sleep(7000);

        }


        //</editor-fold>

        /** CODIFICACIÓ DEL TAULELL
         *
         *
         * inicialitzem taulell amb parets
         * -1 -> paret  -> #
         *  0 -> punts  -> ·
         *  1 -> espai en blanc (no hi han punts)
         * 2 -> Ou gran-> Arroba (@)
         * 3 -> pacman ->   <   o   -
         * fantasmes[numFantasma][PosicioX,PosicioY,direccio] -> fantasma -> &
         */

        //<editor-fold desc="CREACIÓ TAULELL">
        for (int i = 0; i < maxF; i++) {
            for (int j = 0; j < maxC; j++) {


                // POSEM ELS OUS GRANS (@) en les cantonades!!!
                if (
                        i == 2 && j == 2 ||
                                i == 2 && j == maxC - 3 ||
                                i == maxF - 3 && j == 2 ||
                                i == maxF - 3 && j == maxC - 3
                )

                    taulell[i][j] = 2;

                else if (

                        (i >= maxF / 2 - 2 && i <= maxF / 2 + 1) && (j >= maxC / 2 - 2 && j <= maxC - 11)   // posem les parets del mig
                                ||
                                (i >= maxF / 2 - 2 && i <= maxF / 2 + 1 && (j <= 3 || j >= maxC - 4))       // parets laterals del mig esquerra i dreta
                                ||
                                (i == 0 || j == 0 || i == maxF - 1 || j == maxC - 1)                        // parets externes (quadrat marc)
                                ||
                                ((i == 4 || i == maxF - 5) && j > 1 && j < maxC - 2)                        // paret de la fila 4 i maxF-5
                                ||
                                (((j == 6 || j == 8 || j == 15 || j == 17) && i > 5 && i < maxF - 6))       // parets de les columnes 6,8,15 i 17
                                ||
                                ((i == 2 || i == maxF - 3) && j > 3 && j < maxC - 4)                        // parets de la fila 2 i maxF-3

                )

                    taulell[i][j] = -1;                                         // posem paret

                else if (i == pos_I_pacman && j == pos_J_pacman)                // lloc inicial pacman
                    taulell[i][j] = pacman;
                else
                    taulell[i][j] = 0;                                          // la resta posem ous petits (0's)
            }
        }
        //</editor-fold>


        // Crea una instancia de PacmanGame
        PacmanGame juego = new PacmanGame(maxF, maxC);

        // Inicia el juego
        juego.iniciarJuego();
    }
}
