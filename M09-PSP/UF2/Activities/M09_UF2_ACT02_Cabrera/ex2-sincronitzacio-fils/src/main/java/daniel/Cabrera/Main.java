package daniel.Cabrera;

import daniel.Cabrera.Classes.CompteBancari;
import daniel.Cabrera.Classes.Consumidor;
import daniel.Cabrera.Classes.Productor;

public class Main {
    public static void main(String[] args) {
        CompteBancari compte = new CompteBancari("EUR", 1000);

        Productor productor = new Productor(compte);
        Consumidor consumidor = new Consumidor(compte);

        Thread hiloProductor = new Thread(productor);
        Thread hiloConsumidor = new Thread(consumidor);

        hiloProductor.start();
        hiloConsumidor.start();
    }
}