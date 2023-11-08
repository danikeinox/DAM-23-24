package org.example;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

public class Act2 {
    public static void act2() throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
        String file;
        String clauSecreta = ""; // Replace with the actual secret key
        System.out.println("Introdueix el camí del fitxer a desencriptar: ");
        file = sc.nextLine();
        while (!Files.exists(Path.of(file))) {
            System.out.println("Introdueix el camí del fitxer a desencriptar: ");
            file = sc.nextLine();
        }
        System.out.println("Introdueix la clau secreta: ");
        clauSecreta = sc.nextLine(); // Read the secret key

        SecretKeySpec secretKey = new SecretKeySpec(clauSecreta.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        // Read the encrypted file content
        byte[] encryptedFileContent = Files.readAllBytes(Path.of(file));
        // Decrypt the file content
        byte[] decryptedFileContent = cipher.doFinal(encryptedFileContent);
        // Create a new file to store the decrypted content with a modified file extension
        String decryptedFileName = file.replaceFirst("\\.[^.]+$", ".decrypted");
        Path decryptedFilePath = Path.of(decryptedFileName);
        Files.write(decryptedFilePath, decryptedFileContent);
        System.out.println("Procés realitzat correctament: "+decryptedFileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("S'ha produit un error desxifrant el fitxer");
        }

    }
}