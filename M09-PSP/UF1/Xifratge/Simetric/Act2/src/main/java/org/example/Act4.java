package org.example;

import java.security.MessageDigest;
import java.util.Scanner;

public class Act4 {
    public static void act4() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introdueix el missatge per verificar el hash: ");
            String messageAComprobar = sc.nextLine();

            // Crea una instància de MessageDigest amb l'algorisme desitjat (p. ex., SHA-256)
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Converteix el missatge en bytes i genera el hash
            byte[] hashedBytes = digest.digest(messageAComprobar.getBytes());

            // Converteix els bytes del hash a una representació en cadena hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            String hash = sb.toString();

            // Verifica el hash generat amb un hash predefinit
            String hashChecker;
            System.out.println("Introdueix el hash que vols comprovar amb el missatje");
            hashChecker = sc.nextLine();
            if (hash.equals(hashChecker)) {
                System.out.println("El hash es igual al missatje hasejat.");
            } else {
                System.out.println("El hash no ha sigut modificat!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("S'ha produït un error verificant el hash");
        }
    }
}