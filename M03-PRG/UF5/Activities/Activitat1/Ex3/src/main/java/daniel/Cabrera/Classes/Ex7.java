package daniel.Cabrera.Classes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Ex7 {
    public static void start() {
        String localitzacio = String.valueOf(ZoneId.systemDefault());
        String data = String.valueOf(LocalDate.now());
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Estem en: " + localitzacio + " amb Data local: " + data + " Hora local: " + hora);

        String diaPhoenix = String.valueOf(LocalDate.ofInstant(Instant.now(), ZoneId.of("America/Phoenix")));
        String horaPhoenix = LocalTime.now(ZoneId.of("America/Phoenix")).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Dia Phoenix: " + diaPhoenix + " Hora Phoenix: " + horaPhoenix);

        String diaTokio = String.valueOf(LocalDate.ofInstant(Instant.now(), ZoneId.of("Asia/Tokyo")));
        String horaTokio = LocalTime.now(ZoneId.of("Asia/Tokyo")).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Dia Tokio: " + diaTokio + " Hora Tokio: " + horaTokio);

        String diaMelbourne = String.valueOf(LocalDate.ofInstant(Instant.now(), ZoneId.of("Australia/Melbourne")));
        String horaMelbourne = LocalTime.now(ZoneId.of("Australia/Melbourne")).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Dia Melbourne: " + diaMelbourne + " Hora Melbourne: " + horaMelbourne);
    }
}
