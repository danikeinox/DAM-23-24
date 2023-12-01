package dam.psp.xifrat.simetric.crypto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;


/**
 * Gestiona la creació de resums (hashes) per a l'aplicació.
 */
public class HashManager {

    public static final int DEFAULT_BUFFER = 8192;

    /**
     * Genera un hash a partir d'una cadena utilitzant l'algorisme especificat.
     *
     * @param input     la cadena d'entrada per a la qual es calcularà el hash.
     * @param algorithm l'algorisme de hash que s'utilitzarà (p. ex., "SHA-256").
     * @return el hash generat.
     * @throws NoSuchAlgorithmException si l'algorisme proporcionat no és reconegut pel sistema.
     */
    private String generateHash(String input, String algorithm) throws NoSuchAlgorithmException {
        // Obtenir una instància del generador de resum (hash) per a l'algorisme especificat
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        // Calcular el hash
        byte[] hash = messageDigest.digest(input.getBytes());

        // Convertir els bytes del hash a una representació com cadena
        // Aquí s'utilitza Base64 per simplicitat, però es podria usar també una representació hexadecimal
        return Base64.getEncoder().encodeToString(hash);
    }

    /**
     * Genera un hash SHA-256 per a una cadena.
     *
     * @param input la cadena d'entrada per a la qual es calcularà el hash.
     * @return el hash SHA-256 generat.
     * @throws NoSuchAlgorithmException si l'algorisme SHA-256 no està disponible.
     */
    public String generateSHA256Hash(String input) throws NoSuchAlgorithmException {
        return generateHash(input, "SHA-256");
    }

    /**
     * Verifica si una cadena i un hash corresponen, utilitzant l'algorisme de hash especificat.
     *
     * @param input     la cadena original.
     * @param hash      el hash per comparar.
     * @param algorithm l'algorisme de hash que s'utilitzarà.
     * @return true si la cadena i el hash corresponen; false altrament.
     * @throws NoSuchAlgorithmException si l'algorisme proporcionat no és reconegut pel sistema.
     */
    public boolean verifyHash(String input, String hash, String algorithm) throws NoSuchAlgorithmException {
        // Generar el hash de la cadena d'entrada
        String generatedHash = generateHash(input, algorithm);

        // Comparar el hash generat amb el hash proporcionat
        return generatedHash.equals(hash);
    }

    /**
     * Crea un hash SHA-256 per a un fitxer.
     *
     * @param filePath  El camí al fitxer que es vol hashejar.
     * @param algorithm L'algorisme de hash que s'utilitzarà.
     * @return El hash SHA-256 del fitxer com una cadena en Base64.
     * @throws Exception Si ocorre algun problema en la lectura del fitxer o en el procés de hashing.
     */
    private String generateHashForFile(String filePath, String algorithm) throws Exception {
        // Utilitza un buffer per llegir el fitxer en trossos i no sobrecarregar la memòria
        byte[] buffer = new byte[DEFAULT_BUFFER];
        int count;

        // Inicialitza el generador de hash
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        // Processa el fitxer
        try (InputStream fis = new FileInputStream(filePath)) {
            while ((count = fis.read(buffer)) > 0) {
                digest.update(buffer, 0, count);
            }
        }

        // Completa el càlcul del hash
        byte[] hash = digest.digest();

        // Converteix el hash a Base64
        return Base64.getEncoder().encodeToString(hash);
    }

    /**
     * Verifica si el contingut d'un fitxer coincideix amb un hash SHA-256 donat.
     *
     * @param hashFile     El camí al fitxer que conté el hash.
     * @param fileToVerify El camí al fitxer que conté el text a verificar.
     * @param algorithm    L'algorisme de hash que s'utilitzarà.
     * @return true si el hash del fitxer coincideix amb el hash original, false en cas contrari.
     * @throws HashException Si ocorre algun problema en la lectura del fitxer o en el procés de hashing.
     */
    public boolean verifyHashForFile(String hashFile, String fileToVerify, String algorithm) throws HashException {
        String generatedHash, calculatedHash;
        List<String> originalHash;

        try {
            originalHash = Files.readAllLines(Paths.get(hashFile), StandardCharsets.UTF_8);
            if (originalHash.size() != 1) {
                throw new HashException("El Procés de comprovació de hash ha fallat.");
            } else {
                generatedHash = originalHash.get(0);
                calculatedHash = generateHashForFile(fileToVerify, algorithm);
            }
        } catch (IOException e) {
            throw new HashException("El fitxer de resum no s'ha trobat. No es pot verificar el missatge.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return generatedHash.equals(calculatedHash);
    }

    /**
     * Crea un hash SHA-256 per a un fitxer.
     *
     * @param filePath El camí al fitxer que es vol hashejar.
     * @return El hash SHA-256 del fitxer com una cadena en Base64.
     * @throws Exception Si ocorre algun problema en la lectura del fitxer o en el procés de hashing.
     */
    public String generateSHA256HashForFile(String filePath) throws Exception {
        return generateHashForFile(filePath, "SHA-256");
    }
}


