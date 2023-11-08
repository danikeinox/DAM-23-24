package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            menu();
            Scanner sc = new Scanner(System.in);
            int option;
            System.out.print("Selecciona una opció: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    Act1.act1();
                    break;
                case 2:
                    Act2.act2();
                    break;
                case 3:
                    Act3.act3();
                    break;
                case 4:
                    Act4.act4();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcio incorrecta");
            }

        }
    }

    private static void menu() {
        System.out.println("+------------------------------------+\n" +
                "|          e·ni-gm·a system          |\n" +
                "+------------------------------------+\n" +
                "| 1. Encriptar fitxer                |\n" +
                "| 2. Desencriptar fitxer             |\n" +
                "| 3. Generar un hash d'un missatge   |\n" +
                "| 4. Verificar el hash d'un missatge |\n" +
                "| 5. Sortir                          |\n" +
                "+------------------------------------+\n");
    }
}