package daniel.Cabrera.ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int[] array = {1, 2, 3};
            System.out.print("Introdueix l'índex de l'array: ");
            int index = scanner.nextInt();

            if (index < 0 || index >= array.length) {
                System.out.println("Error: Index fora dels limits de l'array.");
            } else {
                int valor = array[index];
                System.out.println("Valor de l'array en l'index " + index + ": " + valor);
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: S'esperava un numero enter.");
        } catch (Exception e) {
            System.out.println("Error inesperat: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
