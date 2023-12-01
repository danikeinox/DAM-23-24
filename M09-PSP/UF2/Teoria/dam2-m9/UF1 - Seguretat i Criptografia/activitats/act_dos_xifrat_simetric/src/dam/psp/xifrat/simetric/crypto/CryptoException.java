package dam.psp.xifrat.simetric.crypto;

/**
 * Classe d'excepció personalitzada per a errors de criptografia.
 */
public class CryptoException extends Exception {
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}