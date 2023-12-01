package cat.dam.psp.xifrat.cesar;

import java.util.Scanner;

import static cat.dam.psp.xifrat.cesar.security.CaesarCipher.decrypt;
import static cat.dam.psp.xifrat.cesar.security.CaesarCipher.encrypt;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String clearMessage, encryptedMessage, reverse, decryptedMessage;
        int key;
        System.out.print("Introdueix una paraula per xifrar: ");
        clearMessage = sc.next();

        System.out.print("\nIntrodueix el desplaçament: ");
        key = sc.nextInt();
        encryptedMessage = encrypt(clearMessage, key);
        System.out.printf("\nEl missatge xifrat és: %s\n", encryptedMessage);
        System.out.print("\nVols desxifrar el missatge? (s/n): ");
        reverse = sc.next().toLowerCase();

        if (reverse.equals("s")) {
            decryptedMessage = decrypt(encryptedMessage, key);
            System.out.printf("\nEl missatge desxifrat és: %s", decryptedMessage);
        }
        System.out.println("\n\nPrograma finalitzat");
        // Per provar el xifratge de fitxers ...
        // CaesarCipher.encryptFile("text_clar.txt", 5, "enc");

    }

}