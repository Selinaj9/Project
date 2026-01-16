public class Encryption {
    private final String[] cipherTypes;
    private final Alphabet alphabet;
    private String encryptedWord;

    public Encryption() {
        cipherTypes = new String[]{"Caesar Cipher", "Atbash Cipher", "Affine Cipher"};
        alphabet = new Alphabet();
        encryptedWord = "";
    }

    public String[] getCipherTypes() {
        return cipherTypes;
    }

    public String caesarCipher(String word, int shift) {
        String crypt = alphabet.getCaesarAlphabet(shift);
        return getEncryptedWord(word,crypt);
    }

    public String atbashCipher(String word) {
        String crypt = alphabet.getAtbashAlphabet();
        return getEncryptedWord(word,crypt);
    }

    public String affineCipher(String word) {
        String crypt = alphabet.getAffineAlphabet();
        return getEncryptedWord(word,crypt);
    }

    private String getEncryptedWord(String word, String crypt) {
        encryptedWord = "";
        for (int i = 0; i < word.length(); i ++) {
            String letter = word.substring(i, i + 1);
            if (!letter.matches("[a-zA-z]")) {
                encryptedWord += letter;
            } else {
                String a = alphabet.getAlphabet();
                int idx = a.indexOf(letter);
                encryptedWord += crypt.substring(idx, idx + 1);
            }
        }
        return encryptedWord;
    }
}