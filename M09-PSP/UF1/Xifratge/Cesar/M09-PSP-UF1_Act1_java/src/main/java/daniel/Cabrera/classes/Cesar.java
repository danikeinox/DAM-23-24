package daniel.Cabrera.classes;

public class Cesar {
    private int key;
    private String value;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public Cesar(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String encryptCesar() {
        StringBuilder encrypted = new StringBuilder();
        for (char c : value.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) (base + (c - base + key) % 26));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public String decryptCesar() {
        StringBuilder decrypted = new StringBuilder();
        for (char c : value.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) (base + (c - base - key + 26) % 26));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
