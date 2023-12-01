package daniel.Cabrera;

import daniel.Cabrera.fils.FilTipus1;
import daniel.Cabrera.fils.FilTipus2;
import daniel.Cabrera.fils.FilTipus3;
import daniel.Cabrera.fils.FilTipus4;

public class Main {
    public static void main(String[] args) {
        FilTipus1 f1 = new FilTipus1();
        FilTipus2 r1 = new FilTipus2();
        FilTipus2 r2 = new FilTipus2();
        FilTipus4 f4 = new FilTipus4("Fil nº 4");
        Thread f2 = new Thread(r1);
        Thread f3 = new Thread(r2, "Fil nº 3");
        try {
            f4.start();
            f4.join();
            f3.start();
            f3.join();
            f2.start();
            f2.join();
            f1.start();
            f1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}