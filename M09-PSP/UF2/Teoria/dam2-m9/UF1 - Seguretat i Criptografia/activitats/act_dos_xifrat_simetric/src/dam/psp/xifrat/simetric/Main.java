package dam.psp.xifrat.simetric;

import dam.psp.xifrat.simetric.crypto.CryptoManager;
import dam.psp.xifrat.simetric.crypto.HashManager;
import dam.psp.xifrat.simetric.utils.AppDefaults;
import dam.psp.xifrat.simetric.utils.FileManager;
import dam.psp.xifrat.simetric.utils.OSUtils;

import javax.crypto.Cipher;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CryptoManager cryptoManager = new CryptoManager();
    private static final HashManager hashManager = new HashManager();


    private static void showMenu() {
        System.out.println("+------------------------------------+");
        System.out.println("|          e·ni-gm·a system          |");
        System.out.println("+------------------------------------+");
        System.out.println("| 1. Encriptar fitxer                |");
        System.out.println("| 2. Desencriptar fitxer             |");
        System.out.println("| 3. Generar un hash d'un missatge   |");
        System.out.println("| 4. Verificar el hash d'un missatge |");
        System.out.println("| 5. Sortir                          |");
        System.out.println("+------------------------------------+");
        System.out.print("Selecciona una opció: ");
    }

    private static void processFile(int cipherMode, boolean generateHash) {
        Scanner scanner = new Scanner(System.in);
        String mode = "encriptar";
        String extension = AppDefaults.EXTENSION_ENCRYPTED;
        if (cipherMode == Cipher.DECRYPT_MODE) {
            mode = "desencriptar";
            extension = AppDefaults.EXTENSION_DECRYPTED;
        }

        System.out.print("Introdueix el camí del fitxer a " + mode + ": ");
        String path = scanner.nextLine();
        File f = new File(path);
        if (f.exists() && !f.isDirectory()) {
            String outputFileName = FileManager.changeFileExtension(f.getPath(), extension);
            System.out.print("\nIntrodueix la clau secreta: ");
            String secretKey = scanner.nextLine();
            try {
                switch (cipherMode) {
                    case 1:
                        cryptoManager.encryptFile(path, outputFileName, secretKey, AppDefaults.HIGH, AppDefaults.DEFAULT_ALGORITHM, AppDefaults.DEFAULT_DIGEST);
                        System.out.println("Procés realitzat correctament: " + outputFileName);
                        break;
                    case 2:
                        cryptoManager.decryptFile(path, outputFileName, secretKey, AppDefaults.HIGH, AppDefaults.DEFAULT_ALGORITHM, AppDefaults.DEFAULT_DIGEST);
                        System.out.println("Procés realitzat correctament: " + outputFileName);
                        System.out.println("Comprovant si el missatge ha estat alterat ...");
                        System.out.print("Introdueix la ruta al fitxer de resum  _" + AppDefaults.EXTENSION_DIGEST + "_: ");
                        String hashFile = scanner.nextLine();
                        if (hashManager.verifyHashForFile(hashFile, outputFileName, AppDefaults.DEFAULT_DIGEST)) {
                            System.out.println("El missatge no ha estat alterat.");
                        } else {
                            System.out.println("ALERTA: El missatge ha estat alterat.");
                        }
                        break;
                    default:
                        System.out.println("Error al procés de selecció");
                }
            } catch (Exception e) {
                // Capturem qualsevol excepció per simplificar, però és recomanable gestionar excepcions específiques.
                System.out.println("Error en processament del fitxer: " + e.getMessage());
            }
        } else {
            System.out.println("El fitxer no existeix.");
        }

        if (generateHash) {
            try {
                String hash = hashManager.generateSHA256HashForFile(path);
                String hashFile = FileManager.changeFileExtension(f.getPath(), AppDefaults.EXTENSION_DIGEST);
                System.out.println("S'ha generat un fitxer de hash <" + hashFile + ">: " + hash);
                FileManager.writeStringToFile(hashFile, hash);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void verifyHash() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el missatge a verificar: ");
        String message = scanner.nextLine();
        System.out.print("Introdueix el hash del missatge: ");
        String hash = scanner.nextLine();
        try {
            if (hashManager.verifyHash(message, hash, AppDefaults.DEFAULT_DIGEST)) {
                System.out.println("El missatge coincideix amb el hash.");
            } else {
                System.out.println("El missatge no coincideix amb el hash.");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static void hashMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el missatge a resumir: ");
        String message = scanner.nextLine();
        try {
            System.out.println("Resum del missatge (SHA-256): " + hashManager.generateSHA256Hash(message));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            OSUtils.clearScreen();
            showMenu();
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        processFile(Cipher.ENCRYPT_MODE, true);
                        break;
                    case 2:
                        processFile(Cipher.DECRYPT_MODE, false);
                        break;
                    case 3:
                        hashMessage();
                        break;
                    case 4:
                        verifyHash();
                        break;
                    case 5:
                        System.out.println("Sortint de l'aplicació...");
                        running = false;
                        break;
                    default:
                        System.out.println("Opció no reconeguda. Si us plau, intenta-ho de nou.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Opció no reconeguda. Si us plau, intenta-ho de nou.");
            }
        }
        scanner.close();
    }
}