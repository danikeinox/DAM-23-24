package daniel.Cabrera.Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static daniel.Cabrera.Main.scan;

public class Ex2 {
    public static void start() {
        System.out.print("Dona'm el dia: ");
        int dia = scan.nextInt();
        System.out.print("Dona'm el mes: ");
        int mes = scan.nextInt();
        System.out.print("Dona'm el any: ");
        int any = scan.nextInt();
        if (LocalDate.of(any, mes, dia).isEqual(LocalDate.now())) {
            System.out.println("La data és avui");
        } else {
            System.out.println("La data és: " + dia + "/" + mes + "/" + any);
        }
    }
}
