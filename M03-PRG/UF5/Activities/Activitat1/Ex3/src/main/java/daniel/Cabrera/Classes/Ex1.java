package daniel.Cabrera.Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Ex1 {
    public static void start() {
        LocalDateTime data = LocalDateTime.now();
        String DataFormated = data.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("La data d'avui abans de ser formatada " + data);
        System.out.println("La data d'avui després de ser formatada " + DataFormated);
        System.out.println();
    }
}
