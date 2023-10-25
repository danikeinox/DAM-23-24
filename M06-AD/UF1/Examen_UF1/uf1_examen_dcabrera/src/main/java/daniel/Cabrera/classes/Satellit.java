package daniel.Cabrera.classes;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Satellit {
    public boolean trobaSatelits;
    char[] codi = new char[5];
    char[] pais = new char[10];

    float x;
    float y;
    float z;

    public boolean trobaSatelits(RandomAccessFile fitxerRAF, float x1, float y1, float z1, float Er, int posicioInicial) {
        try {
            fitxerRAF.seek(posicioInicial);
                for (int i = 0; i < 5; i++) {
                    codi[i] = fitxerRAF.readChar();
                }
                for (int i = 0; i < 10; i++) {
                    pais[i] = fitxerRAF.readChar();
                }
                x = fitxerRAF.readFloat();
                y = fitxerRAF.readFloat();
                z = fitxerRAF.readFloat();
                if (x - x1 <= Er && x + Er >= x1 && y - y1 <= Er && y + Er >= y1 && z - z1 <= Er && z + Er >= z1) {
                    System.out.println(this.toString());
                }
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return trobaSatelits;
    }


    @Override
    public String toString() {
        return "Satel·lit\n" +
                "- codi=" + Arrays.toString(codi) + "\n" +
                "- pais=" + Arrays.toString(pais) + "\n" +
                "- x=" + x + "\n" +
                "- y=" + y + "\n" +
                "- z=" + z + "\n" +
                '\n';
    }
}
