package dam.psp.xifrat.simetric.crypto;

/**
 * Classe d'excepció personalitzada per a errors de hash.
 */
public class HashException extends Exception {
    public HashException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public HashException(String message) {
        super(message);
    }
}