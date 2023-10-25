package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Act2 {
    public static void Act2() {
        while (true) {
            System.out.println("Indicar ruta del archivo: ");
            String filePath = new Scanner(System.in).nextLine();
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                try (FileReader fr = new FileReader(file)) {
                    int character;
                    StringBuilder fileContent = new StringBuilder();

                    while ((character = fr.read()) != -1) {
                        fileContent.append((char) character);
                    }

                    if (fileContent.length() > 0) {
                        System.out.println("Contenido del archivo:");
                        System.out.println(fileContent.toString());
                        break;
                    } else {
                        System.out.println("El archivo está vacío");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Ruta de archivo inválida o el archivo no existe.");
            }
        }
    }
}
