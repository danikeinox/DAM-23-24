package daniel.Cabrera.Classes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class Ex4 {
    public static void start() {
        try {
            System.out.println("Convertir Date a DataString");
            Date fecha = new Date("2021-12-10");
            int dia = fecha.getDate();
            int mes = fecha.getMonth() + 1; // Los meses en Date son de 0 a 11
            int any = fecha.getYear() + 1900; // Se le suma 1900 al año

            System.out.println("Dia: " + dia);
            System.out.println("Mes: " + mes);
            System.out.println("Any: " + any);

            System.out.println("Convertir Date (data d'avui) a format String i amb la plantilla yyyyMMddss:");
            Date fechaActual = Date.from(Instant.from(LocalDateTime.now()));
            String fechaActualString = convertirDateAString(fechaActual, "yyyyMMddss");
            System.out.println(fechaActualString);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Mètodes anteriors a Java 8. Deprecated!!");
        }
    }

    private static String convertirDateAString(Date fecha, String plantilla) {
        return String.format("%t" + plantilla, fecha);
    }
}
