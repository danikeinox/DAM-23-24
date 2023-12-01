package cat.dam.psp.uf2.fils.fils;

import static cat.dam.psp.uf2.fils.utils.Utils.pause;

public class FilTipus1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("[%d] Sóc %s\n ", i, this.getClass().getSimpleName());
            pause(400);
        }
    }
}
