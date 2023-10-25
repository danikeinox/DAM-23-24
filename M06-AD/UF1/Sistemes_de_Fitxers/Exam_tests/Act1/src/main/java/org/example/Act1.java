package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Act1 {
    public static void Act1() {
        System.out.println("\n\nBienvenido al programa de copia de archivos\n\n");
        Scanner sc = new Scanner(System.in);
        String ruta1 = "";
        String ruta2 = "";
        while (true) {
            try {
                System.out.println("Indique la ruta del directorio a copiar: ");
                ruta1 = sc.nextLine();
                System.out.println("Indique la ruta del directorio de destino: ");
                ruta2 = sc.nextLine();
                System.out.println();
                System.out.println("Ruta 1: " + ruta1);
                System.out.println("Ruta 2: " + ruta2);
                System.out.println();
                File sourceDir = new File(ruta1);
                File destinationDir = new File(ruta2);

                if (sourceDir.isDirectory() && destinationDir.isDirectory()) {
                    System.out.print("Copiando directorio");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        Thread.sleep(1000);
                    }
                    System.out.println();
                    System.out.println(sourceDir.getName() + " ===> " + destinationDir.getName());
                    copyFiles(sourceDir, destinationDir);
                    System.out.println("Directorio copiado!");
                    break;
                } else {
                    System.out.println("Recuerda utilizar directorios válidos");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    private static void copyFiles (File sourceDir, File destinationDir) throws IOException {
        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Files.copy(file.toPath(), new File(destinationDir, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } else if (file.isDirectory()) {
                    File newDestinationDir = new File(destinationDir, file.getName());
                    newDestinationDir.mkdir();
                    copyFiles(file, newDestinationDir);
                }
            }
        }
    }
}