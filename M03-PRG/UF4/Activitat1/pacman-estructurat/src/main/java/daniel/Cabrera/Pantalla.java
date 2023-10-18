package daniel.Cabrera;

public class Pantalla {
    private int[][] taulell;

    public Pantalla(int maxF, int maxC) {
        for (int i = 0; i < maxF; i++) {
            for (int j = 0; j < maxC; j++) {


                // POSEM ELS OUS GRANS (@) en les cantonades!!!
                int pos_I_pacman = maxF / 2 - 5;// posició fila pacman
                int pos_J_pacman = maxC / 2;
                char pacman = '<';
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
    }

    public void actualizarTablero(Personaje pacman, Personaje[] fantasmas) {
        // Actualización y pintado del tablero
    }

    // Otros métodos relacionados con el tablero
}
