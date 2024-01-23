package daniel.Cabrera.Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex6 {
    public static void start() {
        LocalDate data = LocalDate.of(2020, 1, 1);
        LocalTime hora = LocalTime.of(5, 3, 12);
        LocalDateTime dataHora = LocalDateTime.of(data, hora);
        System.out.println("LocalDate: " + data);
        System.out.println("LocalTime: " + hora);
        System.out.println("LocalDateTime: " + dataHora);
    }
}
