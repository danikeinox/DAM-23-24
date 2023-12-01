package daniel.Cabrera.fils;

import static daniel.Cabrera.utils.Utils.pausa;

public class FilTipus1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("[%d] Sóc %s\n", i + 1, this.getClass().getSimpleName());
            pausa(1000);
        }
    }
}
