package dam.psp.xifrat.simetric.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * Gestiona les operacions de lectura i escriptura en fitxers per a l'aplicació.
 */
public class FileManager {

    /**
     * Llegeix el contingut d'un fitxer i el retorna com un array de bytes.
     *
     * @param filePath El camí del fitxer a llegir.
     * @return Un array de bytes amb el contingut del fitxer.
     * @throws IOException si ocorre algun problema en la lectura del fitxer.
     * @see <a href="https://howtodoinjava.com/java/io/read-file-content-into-byte-array/">howtodoinjava.com/</a>
     */
    public byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            // Crear un array de bytes per emmagatzemar el contingut del fitxer.
            byte[] fileContent = new byte[(int) file.length()]; // Atenció amb fitxers molt grans, podem tenir problemes amb la conversió a int.

            // Llegir el contingut del fitxer al nostre array.
            fileInputStream.read(fileContent);

            return fileContent;
        }
    }


    /**
     * Escriu un array de bytes a un fitxer. Si el fitxer no existeix, es crearà. Si el fitxer ja existeix, el seu contingut serà sobreescrit.
     *
     * @param filePath El camí del fitxer on s'escriuran les dades.
     * @param data     Les dades a escriure al fitxer.
     * @throws IOException si ocorre algun problema en l'escriptura al fitxer.
     */
    public void writeFile(String filePath, byte[] data) throws IOException {
        File file = new File(filePath);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            // Escriure data al fitxer.
            fileOutputStream.write(data);
        }
    }


    /**
     * Escriu una cadena a un fitxer. Si el fitxer no existeix, es crearà. Si el fitxer ja existeix, el seu contingut serà sobreescrit.
     *
     * @param filePath el camí cap al fitxer.
     * @param content  el contingut a escriure al fitxer.
     * @throws IOException si es produeix un error durant l'escriptura al fitxer.
     */
    public static void writeStringToFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);

        // Escriu el contingut al fitxer, creant el fitxer si no existeix o sobreescrivint el seu contingut si ja existeix.
        Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }


    public static String changeFileExtension(String filePath, String newExtension) {
        return filePath.substring(0, filePath.indexOf('.')) + "." + newExtension;
    }
}