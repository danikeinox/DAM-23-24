package daniel.Cabrera.Classes;

import static java.time.LocalDateTime.now;

public class Ex3 {
    public static void start() {
        // Calendari gregoria
        int diaSetmana = now().getDayOfWeek().getValue();
        int diaMes = now().getDayOfMonth();
        int mes = now().getMonth().getValue();
        int any = now().getYear();
        int hora = now().getHour();
        int minut = now().getMinute();
        int segon = now().getSecond();
        int milisegon = now().getNano();

        System.out.println("Dia setmana: " + diaSetmana);
        System.out.println("Dia mes: " + diaMes);
        System.out.println("Mes: " + mes);
        System.out.println("Any: " + any);
        System.out.println("Hora: " + hora);
        System.out.println("Minut: " + minut);
        System.out.println("Segon: " + segon);
        System.out.println("Milisegon: " + milisegon);

    }
}
