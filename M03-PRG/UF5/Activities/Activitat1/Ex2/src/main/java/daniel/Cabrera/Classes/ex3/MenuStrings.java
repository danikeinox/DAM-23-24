package daniel.Cabrera.Classes.ex3;

import daniel.Cabrera.Classes.Persona;

import java.util.Base64;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuStrings {
    private static final Scanner scan = new Scanner(System.in);

    public static void main() {
        while (true) {
            // Menú
            System.out.println("MENÚ");
            System.out.println("----");
            System.out.println("1) Compara 2 strings");
            System.out.println("2) Esbrina si un string és null");
            System.out.println("3) Genera un hash code a partir d'un string");
            System.out.println("4) Compara 2 objectes persona");
            System.out.println("5) Genera un hash code a partir d'un objecte persona");
            System.out.println("6) Talla una cadena a petició de l'usuari");
            System.out.println("7) Codifica un password demanat a l'usuari");
            System.out.println("0) SORTIR");

            // Elección del usuario
            System.out.print("Escull una opció: ");
            try {
                int opcion = scan.nextInt();

                // Operaciones según la elección
                switch (opcion) {
                    case 1:
                        compararStrings();
                        break;
                    case 2:
                        esNull();
                        break;
                    case 3:
                        generarHashCodeString();
                        break;
                    case 4:
                        compararObjetosPersona();
                        break;
                    case 5:
                        generarHashCodeObjetoPersona();
                        break;
                    case 6:
                        tallaCadenaUsuario();
                        break;
                    case 7:
                        codificarPassword();
                        break;
                    case 0:
                        System.out.println("Programa finalitzat.");
                        return;
                    default:
                        System.out.println("Opció no vàlida. Torna a intentar.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opció no valida. Torna a intentar.");
                scan.nextLine();
            }
        }
    }

    // Implementa aquí las funciones para cada opción del menú
    private static void compararStrings() {
        try {
            String string1;
            String string2;
            System.out.print("Introdueix el primer string: ");
            string1 = scan.next();

            System.out.print("Introdueix el segon string: ");
            string2 = scan.next();

            if (string1.equals(string2)) {
                System.out.println("Els strings son iguals");
            } else {
                System.out.println("Els strings no son iguals");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void esNull() {
        System.out.println("Introdueix un string:");
        String stringNull = scan.next();

        if (stringNull == null) {
            System.out.println("El string es null");
        } else {
            System.out.println("El string no es null");
        }
    }

    private static void generarHashCodeString() {
        System.out.println("Introdueix un string:");
        String string = scan.next();
        System.out.println(string.hashCode());
    }

    private static void compararObjetosPersona() {
        System.out.println("PERSONA 1:");
        System.out.println("Introdueix el DNI de la primera persona:");
        String dni1 = scan.next();
        System.out.println("Introdueix el nom de la primera persona:");
        String nom1 = scan.next();
        System.out.println("Introdueix el cognom de la primera persona:");
        String cognom1 = scan.next();
        System.out.println("Introdueix el correu de la primera persona:");
        String correu1 = scan.next();
        System.out.println("Introdueix l'edat de la primera persona:");
        int edat1 = scan.nextInt();

        System.out.println("PERSONA 2:");
        System.out.println("Introdueix el DNI de la segona persona:");
        String dni2 = scan.next();
        System.out.println("Introdueix el nom de la segona persona:");
        String nom2 = scan.next();
        System.out.println("Introdueix el cognom de la segona persona:");
        String cognom2 = scan.next();
        System.out.println("Introdueix el correu de la segona persona:");
        String correu2 = scan.next();
        System.out.println("Introdueix l'edat de la segona persona:");
        int edat2 = scan.nextInt();
        System.out.println();

        Persona persona1 = new Persona(dni1, nom1, cognom1, edat1, correu1, "file.txt");
        Persona persona2 = new Persona(dni2, nom2, cognom2, edat2, correu2, "file.txt");
        if (persona1.equals(persona2)) {
            System.out.println("Las personas son iguales");
        } else {
            System.out.println("Las personas no son iguales");
        }


    }

    private static void generarHashCodeObjetoPersona() {
        System.out.println("PERSONA:");
        System.out.println("Introdueix el DNI de la persona:");
        String dni1 = scan.next();
        System.out.println("Introdueix el nom de la persona:");
        String nom1 = scan.next();
        System.out.println("Introdueix el cognom de la persona:");
        String cognom1 = scan.next();
        System.out.println("Introdueix el correu de la persona:");
        String correu1 = scan.next();
        System.out.println("Introdueix l'edat de la persona:");
        int edat1 = scan.nextInt();

        Persona persona = new Persona(dni1, nom1, cognom1, edat1, correu1, "file.txt");
        System.out.println(persona.hashCode());
    }

    private static void tallaCadenaUsuario() {
        System.out.println("Introdueix un string:");
        String string = scan.next();
        System.out.println("Introdueix el caracter separador per el qual vols tallar:");
        String separador = scan.next();
        // if separador == . / ; / , / / ... string.split(String.format("\\%s", separador))
        // else string.split(separador)
        String[] symbols = {".", ";", ",", "/", "-", "_", "=", "+", "(", ")", "{", "}", "[", "]", "<", ">", "|", "!", "?", ":", "\"", "'", "&", "%"};
        for (String symbol : symbols) {
            if (symbol.equals(separador))
                separador = String.format("\\%s", symbol);
        }
        String[] partes = string.split(separador);
        for (String parte : partes) {
            System.out.println(parte);
        }
        System.out.println();
    }

    private static void codificarPassword() {
        System.out.println("Introdueix una contrasenya:");
        String contrasenya = scan.next();
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(contrasenya.getBytes());
        System.out.println(encodedString);
    }
}
