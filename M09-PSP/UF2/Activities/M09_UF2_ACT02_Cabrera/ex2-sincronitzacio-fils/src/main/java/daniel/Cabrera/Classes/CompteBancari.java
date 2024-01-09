package daniel.Cabrera.Classes;

public class CompteBancari {
    private float saldo;
    private String moneda;

    public CompteBancari(String moneda, float saldoInicial) {
        this.moneda = moneda;
        this.saldo = saldoInicial;
    }

    public synchronized void ingressar(float quantitat) {
        saldo += quantitat;
        notifyAll();
    }

    public synchronized void retirar(float quantitat) {
        if (saldo <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        saldo -= quantitat;
        notifyAll();
    }

    public synchronized float getSaldo() {
        return saldo;
    }
}

