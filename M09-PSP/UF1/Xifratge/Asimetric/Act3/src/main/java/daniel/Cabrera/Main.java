package daniel.Cabrera;

import java.util.Scanner;

import static daniel.Cabrera.classes.Claus.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try {
            while (true) {
                menu();
                System.out.print("Selecciona una opció: ");
                while (!scan.hasNextInt()) {
                    System.out.println("Opció no válida.");
                    System.out.print("Selecciona una opció: ");
                    scan.next();
                }
                int option = scan.nextInt();
                switch (option) {
                    case 1:
                        generaClaus();
                        break;
                    case 2:
                        if (publicKey != null)
                            System.out.println("La clau pública es: " + publicKey);
                        else
                            System.out.println("ERROR: No s'ha generat cap parell de claus.");
                        break;
                    case 3:
                        if (privateKey != null)
                            System.out.println("La clau privada es: " + privateKey);
                        else
                            System.out.println("ERROR: No s'ha generat cap parell de claus.");
                        break;
                    case 4:
                        signaDocument();
                        break;
                    case 5:
                        verificaSignatura();
                        break;
                    case 6:
                        System.out.println("Sortint de l'aplicació...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opció no válida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Opció no válida.");
        }
    }

    private static void menu() {
        System.out.println("" +
                "+-----------------------------------------+\n" +
                "|            e·ni-gm·a system             |\n" +
                "+----------------------------------------+|\n" +
                "| 1. Generar un nou parell de claus       |\n" +
                "| 2. Mostra la clau pública               |\n" +
                "| 3. Mostra la clau privada               |\n" +
                "| 4. Signar un document                   |\n" +
                "| 5. Verificar la signatura d'un document |\n" +
                "| 6. Sortir                               |\n" +
                "+-----------------------------------------+\n");
    }
}