package daniel.Cabrera.ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Donam un numero: ");
            int num = scan.nextInt();
            System.out.println("Numero introduit: " + num);
        } catch (InputMismatchException e) {
            System.out.println("No es pot posar cap lletra sinò un número");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scan.close();
        }
    }
}