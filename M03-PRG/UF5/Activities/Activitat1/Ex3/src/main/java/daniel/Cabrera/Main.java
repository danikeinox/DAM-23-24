package daniel.Cabrera;

import daniel.Cabrera.Classes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int input;
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.print("> ");
            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Opció incorrecta");
                scan.next();
                continue;
            }
            switch (input) {
                case 1:
                    Ex1.start();
                    break;
                case 2:
                    Ex2.start();
                    break;
                case 3:
                    Ex3.start();
                    break;
                case 4:
                    Ex4.start();
                    break;
                case 5:
                    Ex5.start();
                    break;
                case 6:
                    Ex6.start();
                    break;
                case 7:
                    Ex7.start();
                    break;
                case 8:
                    Ex8.start();
                    break;
                case 9:
                    Ex9.start();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: Opció incorrecta");
            }
        }
    }

    public static void menu() {
        System.out.println("MENU\n" +
                "----\n" +
                "\n" +
                "1) Captura la data d'avui i passa-la a String amb diferents formats\n" +
                "2) Compara 2 dates. La data d'avui i altres demanades per teclat\n" +
                "3) Prova calendari Gregori\n" +
                "4) Formata data amb Date (métodes anteriors a java 8)\n" +
                "5) Prova els métodes now de LocalDate, LocalTime i LocalDateTime\n" +
                "6) Prova els metodes of de LocalDate, LocalTime i LocalDateTime\n" +
                "7) Hora local, América/Fénix, Asia/Tokio, Australia/Melbourne\n" +
                "8) --- RES ---\n" +
                "9) Compara la data d'avui amb altres dates del fitxer\n" +
                "0) Sortir");
    }
}

