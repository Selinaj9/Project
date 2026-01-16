public class Alphabet {
    private final String alphabet;
    private String caesarAlphabet;
    private String atbashAlphabet;
    private String affineAlphabet;

    public Alphabet() {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        caesarAlphabet = "";
        atbashAlphabet = "";
        affineAlphabet = "";
    }

    public String getAlphabet() {
        return alphabet;
    }

    public String getCaesarAlphabet(int shift) {
        caesarAlphabet = alphabet.substring(shift) + alphabet.substring(0,shift);
        return caesarAlphabet;
    }

    public String getAtbashAlphabet() {
        atbashAlphabet = "";
        for (int i = alphabet.length() - 1; i >= 0; i--) {
            atbashAlphabet += alphabet.substring(i, i + 1);
        }
        return atbashAlphabet;
    }

    public String getAffineAlphabet() {
        affineAlphabet = "";
        for (int i = 0; i < alphabet.length(); i++) {
            int idx = (5 * i + 8) % 26;
            affineAlphabet += alphabet.substring(idx, idx + 1);
        }
        return affineAlphabet;
    }
}