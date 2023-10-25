package daniel.Cabrera;

import daniel.Cabrera.classes.Satellit;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("fitxerRAF.dat", "rw");
        try {
            Satellit satellit = new Satellit();
            satellit.trobaSatelits(file, 4.0f, 4.0f, 4.0f, 1f, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}