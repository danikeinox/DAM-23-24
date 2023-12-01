package cat.dam.psp.xifrat.cesar.security;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /***
     * Xifra una cadena de text utilitzant la codificació Cèsar o decalatge de Cèsar
     * <a href="https://ca.wikipedia.org/wiki/Xifratge_de_C%C3%A8sar">...</a>
     * @param clearMessage missatge en text clar
     * @param shiftKey desplaçament
     * @return missatge xifrat
     */
    public static String encrypt(String clearMessage, int shiftKey) {
        clearMessage = clearMessage.toLowerCase();
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < clearMessage.length(); i++) {
            int charPosition = ALPHABET.indexOf(clearMessage.charAt(i));
            int keyVal = (shiftKey + charPosition) % ALPHABET.length();
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText.append(replaceVal);
        }
        return cipherText.toString();
    }

    /***
     * Desxifra una cadena de text codificada utitlizant el xifratge Cèsar
     * <a href="https://ca.wikipedia.org/wiki/Xifratge_de_C%C3%A8sar">...</a>
     * @param encryptedMessage missatge xifrat
     * @param shiftKey desplaçament
     * @return missatge desxifrat
     */
    public static String decrypt(String encryptedMessage, int shiftKey) {
        encryptedMessage = encryptedMessage.toLowerCase();
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            int charPosition = ALPHABET.indexOf(encryptedMessage.charAt(i));
            int keyVal = (charPosition - shiftKey) % ALPHABET.length();
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            message.append(replaceVal);
        }
        return message.toString();
    }

    /***
     * Xifra un fitxer passat com a paràmetre utilitzant el xifratge Cèsar
     * @param pathToClearFile Ruta al fitxer amb la llista de paraules
     * @param shitfKey desplaçament
     */
    public static void encryptFile(String pathToClearFile, int shitfKey, String extension) {
        List<String> clearMessage = readFile(pathToClearFile);
        List<String> encMessage = new ArrayList<>();
        clearMessage.forEach(s -> encMessage.add(encrypt(s, shitfKey)));
        writeFile(pathToClearFile, encMessage, extension);
    }

    /***
     * LLig un fitxer de text línia a línia
     * @param path Ruta al fitxer
     * @return Una llista amb les línies del fitxer
     */
    private static List<String> readFile(String path) {
        List<String> clearFile;
        try {
            clearFile = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clearFile;
    }

    /***
     * Escriu en un fitxer un conjunt de línies de text
     * @param path Ruta al fitxer
     * @param message Conjunt de línies a escriure
     * @param extension Extensió del nou fitxer
     */
    private static void writeFile(String path, List<String> message, String extension) {
        Path file = Paths.get(path);
        Path newFilePath = file.toAbsolutePath();
        String newFileName = newFilePath.getParent().toString() + File.separatorChar + file.getFileName().toString().substring(0, file.getFileName().toString().lastIndexOf(".")) + "." + extension;
        try {
            Files.write(Paths.get(newFileName), message, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}