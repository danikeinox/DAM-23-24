package dam.psp.xifrat.simetric.crypto;

import dam.psp.xifrat.simetric.utils.FileManager;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Gestiona les operacions de criptografia per a l'aplicació.
 */
public class CryptoManager {

    private final FileManager fileManager = new FileManager();

    /**
     * @param password  paraula secreta (contrasenya) en text clar
     * @param keySize   grau de la clau
     * @param algorithm algorisme que s'utitlizarà per xifrar (per defecte AES)
     * @return clau secreta
     * @throws CryptoException si ocorre un error durant l'encriptació.
     */
    public static SecretKey stringToSecretKey(String password, KeySize keySize, String algorithm, String digest) throws CryptoException {
        SecretKey clau = null;
        MessageDigest md;

        // Genera una clau simètrica de 16 bytes(128), 24 bytes(192) o 32 bytes(256)
        if ((keySize == KeySize.LOW) || (keySize == KeySize.MEDIUM) || (keySize == KeySize.HIGH)) {
            byte[] data = password.getBytes(StandardCharsets.UTF_8);
            try {
                md = MessageDigest.getInstance(digest);
            } catch (NoSuchAlgorithmException e) {
                throw new CryptoException("Error en la generació de la clau secreta", e);
            }
            if (md != null) {
                byte[] hash = md.digest(data);
                byte[] key = Arrays.copyOf(hash, keySize.getKeySize() / 8); //clau de KeySize/8 bytes
                clau = new SecretKeySpec(key, algorithm);
            }
        }
        return clau;
    }

    /**
     * Encripta el fitxer d'entrada i genera un fitxer encriptat.
     *
     * @param inputFile  El fitxer d'entrada a encriptar.
     * @param outputFile El fitxer de sortida on es guardarà el fitxer encriptat.
     * @param secretKey  La clau secreta utilitzada per a l'encriptació.
     * @param algorithm  L'algorisme a utilitzar
     * @throws CryptoException si ocorre un error durant l'encriptació.
     */
    public void encryptFile(String inputFile, String outputFile, String secretKey, KeySize keySize, String algorithm, String digest) throws CryptoException {
        processFile(Cipher.ENCRYPT_MODE, inputFile, outputFile, secretKey, keySize, algorithm, digest);
    }

    /**
     * Desencripta el fitxer d'entrada i genera un fitxer desencriptat.
     *
     * @param inputFile  El fitxer d'entrada a desencriptar.
     * @param outputFile El fitxer de sortida on es guardarà el fitxer desencriptat.
     * @param secretKey  La clau secreta utilitzada per a la desencriptació.
     * @param algorithm  L'algorisme a utilitzar
     * @throws CryptoException si ocorre un error durant la desencriptació.
     */
    public void decryptFile(String inputFile, String outputFile, String secretKey, KeySize keySize, String algorithm, String digest) throws CryptoException {
        processFile(Cipher.DECRYPT_MODE, inputFile, outputFile, secretKey, keySize, algorithm, digest);
    }

    /**
     * Processa el fitxer d'entrada per a encriptar o desencriptar.
     *
     * @param cipherMode Mode del cipher (encriptar/desencriptar).
     * @param inputFile  El fitxer d'entrada.
     * @param outputFile El fitxer de sortida.
     * @param secretKey  La clau secreta.
     * @param algorithm  L'algorisme a utilitzar
     * @throws CryptoException si ocorre un error en el procés.
     */
    private void processFile(int cipherMode, String inputFile, String outputFile, String secretKey, KeySize keySize, String algorithm, String digest) throws CryptoException {
        try {
            SecretKey key = stringToSecretKey(secretKey, keySize, algorithm, digest);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(cipherMode, key);

            // Utilitzar FileManager per llegir i escriure fitxers
            byte[] inputBytes = fileManager.readFile(inputFile);
            byte[] outputBytes = cipher.doFinal(inputBytes);

            // Escriure el resultat al fitxer de sortida
            fileManager.writeFile(outputFile, outputBytes);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException |
                 InvalidKeyException e) {
            throw new CryptoException("Error durant el processament criptogràfic", e);
        } catch (BadPaddingException e) {
            throw new CryptoException("Error la clau secreta no coincideix", e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
