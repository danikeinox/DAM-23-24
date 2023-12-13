package daniel.Cabrera.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static void pausa(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int llegeixVocal(char vocal, String fitxer) {
        int counter = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fitxer));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.toLowerCase().charAt(i) == vocal) {
                        counter++;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
