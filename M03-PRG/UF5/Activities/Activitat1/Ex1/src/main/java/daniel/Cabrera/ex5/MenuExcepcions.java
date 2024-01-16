package daniel.Cabrera.ex5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuExcepcions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcio;
        do {
            System.out.println("Escull el tipus d'Excepció:");
            System.out.println("1) Excepció divisió/0");
            System.out.println("2) Excepció array");
            System.out.println("3) Excepció de classe no trobada");
            System.out.println("4) Excepció de fitxer inexistent");
            System.out.println("0) SORTIR");

            try {
                opcio = scanner.nextInt();
                switch (opcio) {
                    case 1:
                        ferExcepcioDivisioZero();
                        break;
                    case 2:
                        ferExcepcioArray();
                        break;
                    case 3:
                        ferExcepcioClasseNoTrobada();
                        break;
                    case 4:
                        ferExcepcioFitxerInexistent();
                        break;
                    case 0:
                        System.out.println("Programa finalitzat.");
                        break;
                    default:
                        System.out.println("Opció no valida. Torna a intentar-ho.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: S'esperava un numero.");
                scanner.nextLine();
                opcio = -1;
            }
        } while (opcio != 0);

        scanner.close();
    }

    private static void ferExcepcioDivisioZero() {
        int numerador = 10;
        int denominador = 0;
        try {
            int resultat = numerador / denominador;
            System.out.println("Resultat de la divisio: " + resultat);
        } catch (ArithmeticException e) {
            System.out.println("No es pot dividir per zero.");
        }
    }

    private static void ferExcepcioArray() {
        try {
            int[] array = {1, 2, 3};
            int valor = array[5];  // Provoca ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index fora dels limits de l'array.");
        }
    }

    private static void ferExcepcioClasseNoTrobada() {
        try {
            // Supongamos que intentamos crear una instancia de una clase que no existe
            Class.forName("ClasseNoExistent");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Classe no trobada.");
        }
    }

    private static void ferExcepcioFitxerInexistent() {
        // Supongamos que intentamos acceder a un fitxer que no existe
        File fitxer = new File("fitxer_inexistent.txt");
        try {
            Scanner scanner = new Scanner(fitxer);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fitxer inexistent.");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
