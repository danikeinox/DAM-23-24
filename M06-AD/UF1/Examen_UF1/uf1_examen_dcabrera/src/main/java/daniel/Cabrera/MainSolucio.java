package daniel.Cabrera;

import daniel.Cabrera.classes.Satellit;
import daniel.Cabrera.classes.SatellitSolucio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MainSolucio {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("fitxerRAF.dat", "rw");
        try {
            SatellitSolucio satellit = new SatellitSolucio();
            satellit.trobaSatelits(file, 4.0f, 4.0f, 4.0f, 1f, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}