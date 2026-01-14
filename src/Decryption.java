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
        String encrypt = "";
        int id = alphabet.length() - shift;
        String crypt = alphabet.substring(id) + alphabet.substring(0, id);
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
}