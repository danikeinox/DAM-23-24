# Comptador de vocals Asíncrona i Síncrona amb Threads

Aquest és un petit programa Java que utilitza fils d'execució per fer recompte de vocals en un fitxer de text. Cada vocal té el seu propi fil per accelerar el procés de recompte. El codi està estructurat de la següent manera:

## Com s'ha creat el programa?

### `Main.java`

En el punt d'entrada del programa, es creen i inicien fils per a cadascuna de les vocals (A, E, I, O, U). El programa espera que tots els fils finalitzin abans de passar a la següent etapa. Després, aquest procés es repeteix sense esperar que cada fil finalitzi abans de crear el següent. Finalment, es calcula i mostra el temps d'execució per les execucions tant asíncrones com síncrones.

```java

public class Main {
    
	// Indiquem el directori del fitxer que es vol analitzar.
	public static String fitxer = "C:/Users/K3IN0X/Documents/GitHub/DAM-23-24/M09-PSP/UF2/Activities/M09_UF2_ACT01_Cabrera/ex1-comptador-vocals/src/main/java/daniel/Cabrera/Resources/test.txt";


    public static void main(String[] args) throws InterruptedException {
        // Creació dels fils per a cada vocal
        ACounter fA = new ACounter();
        ECounter fE = un ECounter();
        ICounter fI = un ICounter();
        OCounter fO = un OCounter();
        UCounter fU = un UCounter();

		// Iniciem la proba asíncrona
        System.out.println("Inici d'execució asíncron");

        // Indiquem variables per a la mesura del temps d'execució
        long resultat;
        long endTime;
        long startTime;
        try {
            startTime = System.currentTimeMillis();

            // Inici i espera de finalització per a cada fil
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

            // Final de la mesura del temps d'execució
            endTime = System.currentTimeMillis();
            resultat = endTime - startTime;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Mostra del temps d'execució asíncron
        System.out.println("Temps d'execució asíncron: " + resultat + " ms");

		// Iniciem la proba síncrona
        System.out.println("Inici d'execució síncron");

        // Inici de la mesura del temps d'execució síncron
        startTime = System.currentTimeMillis();

        // Inici de tots els fils simultàniament i espera de finalització
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

        // Final de la mesura del temps d'execució síncron
        endTime = System.currentTimeMillis();
        resultat = endTime - startTime;

        // Mostra del temps d'execució síncron
        System.out.println("Temps d'execució síncron: " + resultat + " ms");
    }
}
```

### `ACounter.java` (Similar per a les altres vocals)

Aquesta classe defineix el fil d'execució per a la recompte de la vocal 'A'. El recompte es realitza llegint el fitxer especificat i utilitzant algunes utilitats. 

```java

public class ACounter extends Thread {

    @Override
    public void run() {
        // Vocal a recomptar
        char vocal = 'a';
        try {
            // Llegir i mostrar el recompte de la vocal
            int counter = llegeixVocal(vocal, fitxer);
            System.out.printf("Recompte de " + vocal + "'s: %d\n", counter);
            // Pausa opcional (comentada en aquest cas)
            // pausa(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```

### `Utils.java`

Aquesta classe conté algunes utilitats que s'utilitzen en els fils d'execució.

```java
// ... (altres imports)

public class Utils {
    // ... (altres mètodes i utilitats)

    // Mètode per llegir una vocal específica en un fitxer
    public static int llegeixVocal(char vocal, String fitxer) {
        int counter = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fitxer));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.toLowerCase().charAt(i) == vocal) {
                        counter++;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    // Mètode per fer una pausa (no utilitzat en aquest exemple)
    public static void pausa(int milisegons) {
        try {
            Thread.sleep(milisegons);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```