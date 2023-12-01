package daniel.Cabrera.fils;

import static daniel.Cabrera.utils.Utils.pausa;

public class FilTipus2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("[%d] Sóc %s - %s\n",
                    i + 1,
                    this.getClass().getSimpleName(),
                    Thread.currentThread().getName()
            );
            pausa(1000);
        }
    }
}
