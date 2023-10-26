package cat.dam.psp.activitat_dos.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static void saveToFile(String path, String text) {
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
            try {
                out.write(text + "\n");
            } catch (IOException ex) {
                System.out.println("No s'ha pogut escriure al fitxer.");
            }
        } catch (FileNotFoundException ex2) {
            System.out.println("El fitxer no s'ha trobat.");
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException ex3) {
                System.out.println("ERROR. El fitxer no s'ha pogut tancar.");
            }
        }
    }
}
