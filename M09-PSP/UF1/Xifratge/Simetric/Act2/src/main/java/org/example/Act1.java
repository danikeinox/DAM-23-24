package org.example;
// encriptar el fitxer a xifrar con el clau super secret !

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

public class Act1 {
    public static void act1() throws Exception {
        Scanner sc = new Scanner(System.in);
        try {
            String file = ""; // Replace with the actual file path
            System.out.println("Introdueix el camí del fitxer a encriptar: ");
            file = sc.nextLine();
            while (!Files.exists(Path.of(file))) {
                System.out.println("Introdueix el camí del fitxer a encriptar: ");
                file = System.console().readLine();
            }
            System.out.println("Introdueix la clau secreta: ");
            String clauSecreta = sc.nextLine(); // Read the secret key
            while (clauSecreta.isEmpty()) {
                System.out.println("Introdueix la clau secreta: ");
                clauSecreta = System.console().readLine();
            }
            SecretKeySpec secretKey = new SecretKeySpec(clauSecreta.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // Read the file content and encrypt it
            byte[] fileContent = Files.readAllBytes(Paths.get(file));
            byte[] textXifrat = cipher.doFinal(fileContent);
            // Create a new file to store the encrypted content with a modified file extension
            String encryptedFileName = file.replaceFirst("\\.[^.]+$", ".encrypted");
            Path encryptedFilePath = Paths.get(encryptedFileName);
            Files.write(encryptedFilePath, textXifrat);
            System.out.println("Procés realitzat correctament: "+encryptedFileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("S'ha produit un error xifrant el fitxer...");
        }

    }
}
