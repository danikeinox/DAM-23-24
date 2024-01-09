package daniel.Cabrera.Classes;

import static daniel.Cabrera.Utils.Utils.ValorRandom;
import static daniel.Cabrera.Utils.Utils.pausa;

public class Productor extends OperacioBancaria implements Runnable {
    public Productor(CompteBancari compte) {
        super(compte);
    }

    @Override
    public void run() {
        while (true) {
            float quantitat = quantitatAleatoria();
            compte.ingressar(quantitat);
            System.out.println("Productor ingresa: " + quantitat);
            pausa(500);
        }
    }

    @Override
    public float quantitatAleatoria() {
        // Implementa la generación de cantidades aleatorias
        return ValorRandom(0.00f, 1000.00f);
    }
}