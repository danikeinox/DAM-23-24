package org.example;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Act1 {
    public static void act1() throws Exception {
        String clau = "clau_secreta_aes";  // Asegura't que la clau és de 16 caràcters (128 bits)
        SecretKeySpec secretKey = new SecretKeySpec(clau.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] textXifrat = cipher.doFinal("Text secret".getBytes());
        System.out.println("Text xifrat: " + Base64.getEncoder().encodeToString(textXifrat));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] textDesxifrat = cipher.doFinal(textXifrat);
        System.out.println("Text desxifrat: " + new String(textDesxifrat));
    }
}
