package daniel.Cabrera.classes;


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Claus {
    public static String publicKey;
    public static String privateKey;

    public static void generaClaus() throws NoSuchAlgorithmException {
        System.out.println("Inicialitzant el motor d'encriptació...");
        if (publicKey == null && privateKey == null) {
            System.out.println("INFO: Encara no s'ha generat cap parell de claus. Creant un de nou...");
            setHash();
        } else {
            System.out.println("WARN: Ja s'han generat un parells de claus. No es pot crear de nou...");
        }
    }

    private static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setHash() throws NoSuchAlgorithmException {
        KeyPair parellClaus = generateKeyPair();
            if (parellClaus == null) throw new AssertionError("ERROR: No s'ha pogut crear el parell de claus");
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            publicKey = Base64.getEncoder().encodeToString(digest.digest(parellClaus.getPublic().getEncoded()));
            privateKey = Base64.getEncoder().encodeToString(digest.digest(parellClaus.getPrivate().getEncoded()));
    }


    public static void signaDocument() {
        
    }

    public static void verificaSignature() {
    }
}