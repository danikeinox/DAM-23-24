# Syncronized Bank System - Simulació Bancària amb Concurrencia

## Descripció

Aquest programa simula un sistema bancari bàsic amb concurrència utilitzant fils. Es creen dos fils: un per al productor, que diposita fons en un compte bancari, i un altre per al consumidor, que realitza retirades. Operen simultàniament en un compte compartit, actualitzant el saldo de manera concurrent.

## Objectiu

Desenvolupar un sistema en Java per gestionar transaccions en un `CompteBancari` mitjançant fils, practicant la
sincronització de fils amb monitors i `ReentrantLock`.
L'aplicació ha de gestionar situacions de saldo negatiu.


## Com s'ha creat el programa?

### `Main.java`

En el punt d'entrada del programa, es creen i inicien fils per a cadascuna de les vocals (A, E, I, O, U). El programa espera que tots els fils finalitzin abans de passar a la següent etapa. Després, aquest procés es repeteix sense esperar que cada fil finalitzi abans de crear el següent. Finalment, es calcula i mostra el temps d'execució per les execucions tant asíncrones com síncrones.

```java

public class Main {
    public static void main(String[] args) {
        CompteBancari compte = new CompteBancari("EUR", 1000);  // S'indica la moneda i el saldo inicial en el compte bancari.

        Productor productor = new Productor(compte);
        Consumidor consumidor = new Consumidor(compte);

        Thread hiloProductor = new Thread(productor);
        Thread hiloConsumidor = new Thread(consumidor);

        hiloProductor.start();
        hiloConsumidor.start();
    }
}

```

### `CompteBancari.java`

Aquesta classe defineix Compte Bancari, encarregat de realitzar les operacións amb els valors indicats a les classes Consumidor i Productor. 

```java

// Creats mètodes d'ingrés i retirada de diners del compte, denegant la retirada del Consumidor si el saldo ja ha sigut sobrepassat i, per tant, és saldo negatiu.
// Obligant d'aquesta manera a què el Productor sigui el següent en fer ingrés.

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
    
```

### `OperacioBancaria.java`

S'ha creat una classe abstracta per reutilitzar el mètode *quantitatAleatoria()* indicat i utilitzat a les següents classes Consumidor i Productor.

```java

public abstract class OperacioBancaria {
    protected CompteBancari compte;

    public OperacioBancaria(CompteBancari compte) {
        this.compte = compte;
    }

    public abstract float quantitatAleatoria();
}

```

## Threads (fils)

---

### `Consumidor.java`

Aquesta classe defineix el fil d'execució pel Consumidor, on s'indica mitjançant un mètode de la llibreria Utils, el valor aleatori que retirarà i indica el saldo actual en cas de ser saldo negatiu.

```java

    @Override
    public void run() {
        while (true) {
            float quantitat = quantitatAleatoria();
            compte.retirar(quantitat);
            System.out.println("Consumidor retira: " + quantitat);
            pausa(500);
            if (compte.getSaldo() <= 0) {
                System.out.println("Saldo negatiu: " + compte.getSaldo());
            }
        }
    }

    @Override
    public float quantitatAleatoria() {
        // Implementa la generación de cantidades aleatorias
        return ValorRandom(0.00f, 1000.00f);
    }

```

### `Productor.java`

Aquesta classe defineix el fil d'execució pel Productor, on s'indica altre cop com en el Consumidor mitjançant un mètode de la llibreria Utils, el valor aleatori que en aquest càs s'ingressarà al compte bancari.

```java

    @Override
    public void run() {
        while (true) {
            float quantitat = quantitatAleatoria();
            compte.ingressar(quantitat);
            System.out.println("Productor ingresa: " + quantitat);
            pausa(500);
        }
    }

    @Override
    public float quantitatAleatoria() {
        // Implementa la generación de cantidades aleatorias
        return ValorRandom(0.00f, 1000.00f);
    }

```

#### Ambes classes utilitzen la llibreria Utils per evitar tenir codi repetit.

---


### `Utils.java`

Aquesta classe conté algunes utilitats que s'utilitzen en els fils d'execució.

```java

// Aquest mètode públic realitza una pausa dels mil·li-segons indicats en el moment d'executar-se.

public static void pausa(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

// Afegit nou mètode públic a Utils per generar números Float aleatoris.

public static float ValorRandom(float min, float max) {
        Random random = new Random();
        return random.nextFloat() * (max - min) + min;
    }
    
```