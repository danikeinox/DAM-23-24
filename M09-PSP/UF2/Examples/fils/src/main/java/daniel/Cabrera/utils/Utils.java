package daniel.Cabrera.utils;

public class Utils {

    public static void pausa(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
