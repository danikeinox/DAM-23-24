package daniel.Cabrera;

import daniel.Cabrera.Classes.*;

public class Main {
    public static String fitxer = "C:/Users/K3IN0X/Documents/GitHub/DAM-23-24/M09-PSP/UF2/Activities/ex1-comptador-vocals/src/main/java/daniel/Cabrera/Resources/test.txt";

    public static void main(String[] args) throws InterruptedException {
        ACounter fA = new ACounter();
        ECounter fE = new ECounter();
        ICounter fI = new ICounter();
        OCounter fO = new OCounter();
        UCounter fU = new UCounter();
        System.out.println("Inici d'execució asíncron");
        long resultat;
        long endTime;
        long startTime;
        try {
            startTime = System.currentTimeMillis();
            fA.start();
            fA.join();
            fE.start();
            fE.join();
            fI.start();
            fI.join();
            fO.start();
            fO.join();
            fU.start();
            fU.join();
            endTime = System.currentTimeMillis();
            resultat = endTime - startTime;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Temps d'execució asíncron: " + resultat + " ms");
        fA = new ACounter();
        fE = new ECounter();
        fI = new ICounter();
        fO = new OCounter();
        fU = new UCounter();
        System.out.println();
        System.out.println("Inici d'execució síncron");
        startTime = System.currentTimeMillis();
        fA.start();
        fE.start();
        fI.start();
        fO.start();
        fU.start();
        fA.join();
        fE.join();
        fI.join();
        fO.join();
        fU.join();
        endTime = System.currentTimeMillis();
        resultat = endTime - startTime;
        System.out.println("Temps d'execució síncron: " + resultat + " ms");
    }
}