package dam.psp.xifrat.simetric.utils;

import dam.psp.xifrat.simetric.crypto.KeySize;

public class AppDefaults {
    public final static String DEFAULT_ALGORITHM = "AES";
    public static final String EXTENSION_ENCRYPTED = "encrypted";
    public static final String EXTENSION_DECRYPTED = "decrypted";
    public static final String EXTENSION_DIGEST = "digest";
    public final static String DEFAULT_DIGEST = "SHA-256";
    public final static KeySize LOW = KeySize.LOW;
    public final static KeySize MEDIUM = KeySize.MEDIUM;
    public final static KeySize HIGH = KeySize.HIGH;
}
