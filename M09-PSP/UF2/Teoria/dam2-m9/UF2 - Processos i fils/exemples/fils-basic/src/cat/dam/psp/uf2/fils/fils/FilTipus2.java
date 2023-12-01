package cat.dam.psp.uf2.fils.fils;

import static cat.dam.psp.uf2.fils.utils.Utils.pause;

public class FilTipus2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("[%d] Sóc %s (%s)\n", i, this.getClass().getSimpleName(), Thread.currentThread().getName());
            pause(1000);
        }
    }
}
