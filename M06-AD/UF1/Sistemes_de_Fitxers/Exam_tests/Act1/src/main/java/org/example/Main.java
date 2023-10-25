package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        while (true) {
            Logotype();
            System.out.println("Escoge un ejercicio: (1,2,3,4) o pulsa (0) para salir");
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        Act1.Act1();
                        break;
                    case 2:
                        Act2.Act2();
                        break;
                    case 3:
                        System.out.println("not implemented 3");
                        break;
                    case 4:
                        System.out.println("not implemented 4");
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida");
            }
        }
    }

    private static void Logotype() {
        System.out.println("\n" +
                ".88b  d88.  .d88b.     dD           db    db d88888b  db \n" +
                "88'YbdP`88 .8P  88.   d8'           88    88 88'     o88 \n" +
                "88  88  88 88  d'88  d8'            88    88 88ooo    88 \n" +
                "88  88  88 88 d' 88 d8888b.  C8888D 88    88 88~~~    88 \n" +
                "88  88  88 `88  d8' 88' `8D         88b  d88 88       88 \n" +
                "YP  YP  YP  `Y88P'  `8888P          ~Y8888P' YP       VP \n" +
                "                                                         \n" +
                "                                                         ");
    }
}
