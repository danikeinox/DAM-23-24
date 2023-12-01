package dam.psp.xifrat.simetric.crypto;

public enum KeySize {
    LOW(128),
    MEDIUM(192),
    HIGH(256);

    private final int keySize;

    KeySize(int keysize) {
        this.keySize = keysize;
    }

    public int getKeySize() {
        return keySize;
    }
}