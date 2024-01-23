package daniel.Cabrera.Classes.ex2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SepararCadena {
    public static void main() {
        Scanner scan = new Scanner(System.in);
        // Cadena de texto
        String cadenaFitxer = "15.5$13.4$14.0$15.5$15";

        System.out.println("Introdueix una cadena de text: Default (" + cadenaFitxer + "): ");
        cadenaFitxer = scan.nextLine();
        if (cadenaFitxer.isEmpty()) {
            cadenaFitxer = "15.5$13.4$14.0$15.5$15";
        }
        System.out.println();

        // Usando StringTokenizer
        StringTokenizer tokenizer = new StringTokenizer(cadenaFitxer, "$");
        System.out.println("Usant StringTokenizer:");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

        // Usando split
        System.out.println("\nUsant split:");
        String[] partes = cadenaFitxer.split("\\$");
        for (String parte : partes) {
            System.out.println(parte);
        }
        System.out.println();
    }
}
