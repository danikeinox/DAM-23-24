package cat.dam.psp.uf2.fils.fils;

import static cat.dam.psp.uf2.fils.utils.Utils.pause;

public class FilTipus4 extends Thread {

    public FilTipus4(String missatge) {
        super(missatge);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("[%d] Sóc %s (%s)\n", i, this.getClass().getSimpleName(), this.getName());
            pause(1000);
        }
    }
}
