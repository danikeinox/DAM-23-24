package daniel.Cabrera.Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static daniel.Cabrera.Main.fitxer;
import static daniel.Cabrera.Utils.Utils.llegeixVocal;
import static daniel.Cabrera.Utils.Utils.pausa;

public class ACounter extends Thread {

    @Override
    public void run() {
        char vocal = 'a';
        try {
            int counter = llegeixVocal(vocal, fitxer);
            System.out.printf("Recompte de " + vocal + "'s: %d\n", counter);
            //pausa(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
