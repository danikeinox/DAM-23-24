package daniel.Cabrera;

import java.io.IOException;

import static daniel.Cabrera.classes.App.*;

public class Main {
    public static void main(String[] args) {
        String fitxerAGuardar = "C:/Users/K3IN0X/Documents/GitHub/DAM-23-24/M06-AD/UF3/JSON/Activities/M06_UF3_JSON_Cabrera/src/main/java/daniel/Cabrera/Resources/DAM.json";
        String fitxerTest = "C:/Users/K3IN0X/Documents/GitHub/DAM-23-24/M06-AD/UF3/JSON/Activities/M06_UF3_JSON_Cabrera/src/main/java/daniel/Cabrera/Resources/test.json";
        try {
            header();
            date();
            parellClau(fitxerAGuardar);
            llegeixFitxer(fitxerTest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}