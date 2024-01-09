package daniel.Cabrera.Classes;

import daniel.Cabrera.Utils.Utils;

import java.util.Random;

import static daniel.Cabrera.Utils.Utils.ValorRandom;
import static daniel.Cabrera.Utils.Utils.pausa;

public class Consumidor extends OperacioBancaria implements Runnable {
    public Consumidor(CompteBancari compte) {
        super(compte);
    }

    @Override
    public void run() {
        while (true) {
            float quantitat = quantitatAleatoria();
            compte.retirar(quantitat);
            System.out.println("Consumidor retira: " + quantitat);
            pausa(500);
            if (compte.getSaldo() <= 0) {
                System.out.println("Saldo negatiu: " + compte.getSaldo());
            }
        }
    }

    @Override
    public float quantitatAleatoria() {
        // Implementa la generación de cantidades aleatorias
        return ValorRandom(0.00f, 1000.00f);
    }
}