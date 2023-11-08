package org.example;

import java.security.MessageDigest;
import java.util.Scanner;

public class Act3 {
    public static void act3() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introdueix el missate que vols hashejar: ");
            String message = sc.nextLine();

            // Create a MessageDigest instance with desired algorithm (e.g., SHA-256)
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert the message to bytes and generate the hash
            byte[] hashedBytes = digest.digest(message.getBytes());

            // Convert the hashed bytes to a hexadecimal string representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            String hash = sb.toString();

            System.out.println("S'ha generat un hash del messatge: " + hash);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("S'ha produit un error generant el hash...");
        }
    }
}