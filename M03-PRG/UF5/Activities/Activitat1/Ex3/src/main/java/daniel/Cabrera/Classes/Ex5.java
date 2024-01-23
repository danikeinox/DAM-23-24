package daniel.Cabrera.Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex5 {
    public static void start() {
        LocalDate avui = LocalDate.now();
        LocalTime ara = LocalTime.now();
        LocalDateTime avuiAra = LocalDateTime.now();
        System.out.println("LocalDate: " + avui);
        System.out.println("LocalTime: " + ara);
        System.out.println("LocalDateTime: " + avuiAra);
    }
}
