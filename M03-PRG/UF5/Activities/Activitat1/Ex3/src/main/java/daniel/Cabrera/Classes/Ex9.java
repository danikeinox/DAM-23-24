package daniel.Cabrera.Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ex9 {
    public static void start() {
        String[] fitxer = {"2024-01-01", "2024-01-02", "2024-01-10", "2024-01-24", "2024-01-31", "2024-02-26"};
        LocalDate diaActual = LocalDate.now();

        for (String diaString : fitxer) {
            LocalDate dia = LocalDate.parse(diaString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            long diasDiferencia = ChronoUnit.DAYS.between(diaActual, dia);

            if (diasDiferencia < 0) {
                System.out.println(dia + "- passat: (han passat " + Math.abs(diasDiferencia) + " dies) --> " + dia.getDayOfWeek());
            } else {
                System.out.println(dia + "- futur: (falten " + diasDiferencia + " dies) --> " + dia.getDayOfWeek());
            }
        }
    }
}
