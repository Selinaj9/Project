public class Decryption {
    private String[] cipherTypes;
    private String alphabet;

    public Decryption() {
        cipherTypes = new String[]{"Caesar Cipher", "Atbash Cipher", "Affine Cipher"};
        alphabet = "abcdefghijklmnopqrstuvwxyz";
    }

    public String[] getCipherTypes() {
        return cipherTypes;
    }

    public String caesarCipher(String word, int shift) {
        String decrypt = "";
        int id = alphabet.length() - shift;
        String crypt = alphabet.substring(id) + alphabet.substring(0, id);
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            if (!letter.matches("[a-zA-z]")) {
                decrypt += letter;
            } else {
                int idx = alphabet.indexOf(letter);
                decrypt += crypt.substring(idx, idx + 1);
            }
        }
        return decrypt;
    }

    public String atbashCipher(String word) {
        String encrypt = "";
        String crypt = "";
        for (int i = alphabet.length() - 1; i >= 0; i--) {
            crypt += alphabet.substring(i, i + 1);
        }
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            if (!letter.matches("[a-zA-z]")) {
                encrypt += letter;
            } else {
                int idx = crypt.indexOf(letter);
                encrypt += alphabet.substring(idx, idx + 1);
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
                int idx = crypt.indexOf(letter);
                encrypt += alphabet.substring(idx, idx + 1);
            }
        }
        return encrypt;
    }
}