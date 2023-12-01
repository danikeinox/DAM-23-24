package cat.dam.psp.uf2.fils;

import cat.dam.psp.uf2.fils.fils.FilTipus1;
import cat.dam.psp.uf2.fils.fils.FilTipus2;
import cat.dam.psp.uf2.fils.fils.FilTipus4;

public class Main {
    public static void main(String[] args) {
        FilTipus1 f1 = new FilTipus1();

        FilTipus2 runnable = new FilTipus2();
        Thread f2 = new Thread(runnable);

        FilTipus2 runnable2 = new FilTipus2();
        Thread f3 = new Thread(runnable2, "Missatge passat des del thread");

        FilTipus4 f4 = new FilTipus4("Mira el missatge");

        f1.start();
        f2.start();
        f3.start();
        f4.start();
    }
}