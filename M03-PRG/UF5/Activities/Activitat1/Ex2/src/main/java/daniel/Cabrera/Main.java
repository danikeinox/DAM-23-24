package daniel.Cabrera;

import daniel.Cabrera.Classes.IDades;
import daniel.Cabrera.Classes.Persona;
import daniel.Cabrera.Classes.ex1.provarMetodes;
import daniel.Cabrera.Classes.ex2.SepararCadena;
import daniel.Cabrera.Classes.ex3.MenuStrings;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input;

        while (true) {
            System.out.println("Escolleig un exercici: ");
            System.out.println("1. Exercici 1");
            System.out.println("2. Exercici 2");
            System.out.println("3. Exercici 3");
            System.out.println("0. Sortir");
            try {
                input = scan.nextInt();

                switch (input) {
                    case 1:
                        provarMetodes.main();
                        break;
                    case 2:
                        SepararCadena.main();
                        break;
                    case 3:
                        MenuStrings.main();
                        break;
                    case 0:
                        System.out.println("Programa finalitzat.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcio no valida. Torna a intentar.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcio no valida. Torna a intentar.");
                scan.nextLine();
            }
        }
    }
}
