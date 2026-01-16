public class Decryption {
    private final String[] cipherTypes;
    private final Alphabet alphabet;
    private String decryptedWord;

    public Decryption() {
        cipherTypes = new String[]{"Caesar Cipher", "Atbash Cipher", "Affine Cipher"};
        alphabet = new Alphabet();
        decryptedWord = "";
    }

    public String[] getCipherTypes() {
        return cipherTypes;
    }

    public String caesarCipher(String word, int shift) {
        String crypt = alphabet.getCaesarAlphabet(shift);
        return getDecryptedWord(word, crypt);
    }

    public String atbashCipher(String word) {
        String crypt = alphabet.getAtbashAlphabet();
        return getDecryptedWord(word,crypt);
    }

    public String affineCipher(String word) {
        String crypt = alphabet.getAffineAlphabet();
        return getDecryptedWord(word,crypt);
    }

    private String getDecryptedWord(String word, String crypt) {
        decryptedWord = "";
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            if (!letter.matches("[a-zA-z]")) {
                decryptedWord += letter;
            } else {
                String a = alphabet.getAlphabet();
                int idx = crypt.indexOf(letter);
                decryptedWord += a.substring(idx, idx + 1);
            }
        }
        return decryptedWord;
    }
}