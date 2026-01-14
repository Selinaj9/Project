public class Encryption {
    private String[] cipherTypes;
    private String alphabet;

    public Encryption() {
        cipherTypes = new String[]{"Caesar Cipher", "Atbash Cipher", "Affine Cipher"};
        alphabet = "abcdefghijklmnopqrstuvwxyz";
    }

    public String[] getCipherTypes() {
        return cipherTypes;
    }

    public String caesarCipher(String word, int shift) {
        String encrypt = "";
        String crypt = alphabet.substring(shift) + alphabet.substring(0,shift);
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            if (!letter.matches("[a-zA-z]")) {
                encrypt += letter;
            } else {
                int idx = alphabet.indexOf(letter);
                encrypt += crypt.substring(idx, idx + 1);
            }
        }
        return encrypt;
    }

    public String atbashCipher(String word) {
        String encrypt = "";
        String crypt = "";
        for (int i = alphabet.length() - 1; i >= 0; i--) {
            crypt += alphabet.substring(i, i + 1);
        }
        for (int i = 0; i < word.length(); i ++) {
            String letter = word.substring(i, i + 1);
            if (!letter.matches("[a-zA-z]")) {
                encrypt += letter;
            } else {
                int idx = alphabet.indexOf(letter);
                encrypt += crypt.substring(idx, idx + 1);
            }
        }
        return encrypt;
    }

    public String affineCipher(String word) {
        String encrypt = "";
        String crypt = "";
        for (int i = 0; i < alphabet.length(); i++) {
            int idx = (5 * i + 8) % 26;
            crypt += alphabet.substring(idx, idx + 1);
        }
        for (int i = 0; i < word.length(); i ++) {
            String letter = word.substring(i, i + 1);
            if (!letter.matches("[a-zA-z]")) {
                encrypt += letter;
            } else {
                int idx = alphabet.indexOf(letter);
                encrypt += crypt.substring(idx, idx + 1);
            }
        }
        return encrypt;
    }
}