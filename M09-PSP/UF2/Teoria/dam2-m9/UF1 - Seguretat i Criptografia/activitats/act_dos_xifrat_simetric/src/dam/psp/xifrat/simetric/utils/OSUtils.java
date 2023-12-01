package dam.psp.xifrat.simetric.utils;

import java.io.IOException;

public class OSUtils {
    public static void clearScreen() {
        try {
            // Per a Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else { // Per a Unix i similars
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            // En cas d'excepció, simplement no es neteja la pantalla
        }
    }
}