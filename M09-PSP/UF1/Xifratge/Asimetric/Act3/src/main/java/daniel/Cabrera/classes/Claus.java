package daniel.Cabrera.classes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class Claus {
    public static String publicKey;
    public static String privateKey;
    private static KeyPair keyPair;
    private static Scanner scan = new Scanner(System.in);

    public static void generaClaus() {
        System.out.println("Inicialitzant el motor d'encriptació...");
        if (keyPair == null) {
            System.out.println("INFO: Encara no s'ha generat cap parell de claus. Creant un de nou...");
            keyPair = generateKeyPair();
            guardaClaus();
        } else {
            System.out.println("WARN: Ja s'han generat un parells de claus. No es pot crear de nou...");
        }
    }

    private static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void guardaClaus() {
        if (keyPair != null) {
            PublicKey publicKeyObj = keyPair.getPublic();
            PrivateKey privateKeyObj = keyPair.getPrivate();
            ;

            publicKey = Base64.getEncoder().encodeToString(publicKeyObj.getEncoded());
            privateKey = Base64.getEncoder().encodeToString(privateKeyObj.getEncoded());
        } else {
            System.out.println("ERROR: No s'ha generat cap parell de claus.");
        }
    }

    public static void signaDocument() throws Exception {
        String ruta = "";
        try {
            if (keyPair != null) {
                System.out.println("Introdueix la ruta del document a signar: ");
                ruta = scan.nextLine();
                while (!Paths.get(ruta).toFile().exists()) {
                    System.out.println("Introdueix una ruta del document a signar vàlida: ");
                    ruta = scan.nextLine();
                }
                if (Files.exists(Paths.get(ruta))) {
                    byte[] bytes = Files.readAllBytes(Paths.get(ruta));
                    Signature signature = Signature.getInstance("SHA256withRSA");
                    signature.initSign(keyPair.getPrivate());
                    signature.update(bytes);
                    byte[] signat = signature.sign();
                    System.out.println("Document signat amb èxit. Signatura (en format base64):");
                    System.out.println("Signatura: " + Base64.getEncoder().encodeToString(signat));
                    Files.write(Paths.get(ruta + ".sig"), signat).toFile();
                    System.out.println("Generat fitxer: " + ruta + ".sig");
                }
            } else {
                System.out.println("ERROR: No s'ha generat cap parell de claus.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verificaSignatura() throws Exception {
        try {
            if (keyPair != null) {
                System.out.println("Introdueix la ruta del document original: ");
                String rutaOG = scan.nextLine();
                while (!Paths.get(rutaOG).toFile().exists()) {
                    System.out.println("Introdueix una ruta del document original vàlida: ");
                    rutaOG = scan.nextLine();
                }
                System.out.println("Introdueix la ruta del document amb la signatura: ");
                String ruta = scan.nextLine();
                while (!Files.exists(Paths.get(ruta))) {
                    System.out.println("Introdueix una ruta del document amb la signatura vàlida: ");
                    ruta = scan.nextLine();
                }
                if (Files.exists(Paths.get(ruta))) {
                    byte[] bytesOG = Files.readAllBytes(Paths.get(rutaOG));
                    byte[] bytes = Files.readAllBytes(Paths.get(ruta));
                    Signature signature = Signature.getInstance("SHA256withRSA");
                    signature.initVerify(keyPair.getPublic());
                    signature.update(bytesOG);
                    boolean verify = signature.verify(bytes);
                    if (verify)
                        System.out.println("Document verificat amb èxit.");
                    else
                        System.out.println("No s'ha pogut verificar correctament, el document Original ha sigut modificat.");
                } else {
                    System.out.println("No s'ha trobat el document.");
                }
            } else {
                System.out.println("ERROR: No s'ha generat cap parell de claus.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}