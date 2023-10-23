package daniel.Cabrera;

import daniel.Cabrera.classes.Cesar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" _______ _______ _______ _______  ______\n" +
                    " |       |______ |______ |_____| |_____/\n" +
                    " |_____  |______ ______| |     | |    \\_\n" +
                    "       Benvingut al programa Cesar\n");

            System.out.println("1. Activitat 1 Cesar");
            System.out.println("2. Activitat 2 Cesar");
            System.out.println("3. Activitat 3 Cesar");
            System.out.println("4. Sortir");
            System.out.print("Indica que activitat vols executar: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int key = 7;
                    String value = "La sort està tirada";
                    Cesar cesar = new Cesar(key, value.toLowerCase());
                    System.out.println("Text original: " + value);
                    System.out.println("Text encriptat: " + cesar.encryptCesar());
                    cesar = new Cesar(key, cesar.encryptCesar());
                    System.out.println("Text desencriptat: " + cesar.decryptCesar());
                    break;

                case 2:
                    while (true) {
                        System.out.println("1. Encriptar");
                        System.out.println("2. Desencriptar");
                        System.out.println("3. Sortir");
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();

                        if (choice == 1) {
                            while (true) {
                                try {
                                    System.out.print("Afegeix la key secreta: ");
                                    key = scanner.nextInt();
                                    scanner.nextLine(); // Consumir la nueva línea
                                    System.out.print("Afegeix el text a encriptar: ");
                                    value = scanner.nextLine();
                                    cesar = new Cesar(key, value.toLowerCase());
                                    System.out.println(cesar.encryptCesar());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Error: Introdueix una key valida (Numero)");
                                }
                            }
                        } else if (choice == 2) {
                            while (true) {
                                try {
                                    System.out.print("Afegeix la key secreta: ");
                                    key = scanner.nextInt();
                                    scanner.nextLine(); // Consumir la nueva línea
                                    System.out.print("Afegeix el text a desencriptar: ");
                                    value = scanner.nextLine();
                                    cesar = new Cesar(key, value);
                                    System.out.println(cesar.decryptCesar());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Error: Introdueix una key valida (Numero)");
                                }
                            }
                        } else if (choice == 3) {
                            break;
                        } else {
                            System.out.println("Sel·lecció incorrecta");
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        System.out.println("1. Encriptar");
                        System.out.println("2. Desencriptar");
                        System.out.println("3. Sortir");
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();

                        if (choice == 1) {
                            try {
                                FileWriter textValuesFile = new FileWriter("text_values.txt");
                                FileWriter textValuesEncryptedFile = new FileWriter("text_values_encrypted.txt");
                                textValuesFile.close();
                                textValuesEncryptedFile.close();
                                System.out.print("Afegeix la key secreta: ");
                                key = scanner.nextInt();
                                scanner.nextLine(); // Consumir la nueva línea
                                System.out.println("Afegeix el text a encriptar (Dona <enter> amb text en blanc per finalitzar): ");
                                while (true) {
                                    System.out.print("> ");
                                    value = scanner.nextLine();
                                    if (value.isEmpty()) {
                                        break;
                                    }
                                    cesar = new Cesar(key, value);
                                    textValuesFile = new FileWriter("text_values.txt", true);
                                    textValuesFile.write(value + "\n");
                                    textValuesFile.close();
                                    textValuesEncryptedFile = new FileWriter("text_values_encrypted.txt", true);
                                    textValuesEncryptedFile.write(cesar.encryptCesar() + "\n");
                                    textValuesEncryptedFile.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (choice == 2) {
                            System.out.print("Afegeix la key secreta: ");
                            key = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            try {
                                FileWriter textValuesDecryptedFile = new FileWriter("text_values_decrypted.txt");
                                textValuesDecryptedFile.close();
                                Scanner textValuesEncryptedScanner = new Scanner(new File("text_values_encrypted.txt"));
                                while (textValuesEncryptedScanner.hasNextLine()) {
                                    String line = textValuesEncryptedScanner.nextLine();
                                    cesar = new Cesar(key, line);
                                    textValuesDecryptedFile = new FileWriter("text_values_decrypted.txt", true);
                                    textValuesDecryptedFile.write(cesar.decryptCesar() + "\n");
                                    textValuesDecryptedFile.close();
                                }
                                textValuesEncryptedScanner.close();
                                Scanner textValuesDecryptedScanner = new Scanner(new File("text_values_decrypted.txt"));
                                System.out.println();
                                while (textValuesDecryptedScanner.hasNextLine()) {
                                    System.out.println(textValuesDecryptedScanner.nextLine());
                                }
                                textValuesDecryptedScanner.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (choice == 3) {
                            break;
                        } else {
                            System.out.println("Sel·lecció incorrecta");
                        }
                    }
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Sel·lecció incorrecta");
                    break;
            }
        }
    }
}
