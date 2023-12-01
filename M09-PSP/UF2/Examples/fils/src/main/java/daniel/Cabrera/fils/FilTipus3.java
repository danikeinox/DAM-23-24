package daniel.Cabrera.fils;

import static daniel.Cabrera.utils.Utils.pausa;

public class FilTipus3 implements Runnable{
    @Override
    public void run() {
        // No s'utilitza per aquest exemple:
        // S'aplica en el Fil2 per a que surti com a fil2 i fil3
        // d'aquesta manera executa un Sub Fil2 i un Sub Fil3 amb missatge
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
