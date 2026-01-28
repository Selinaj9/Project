/**
 * This class represents an alphabet object
 *
 * @author Selina Jiang
 */
public class Alphabet {
    /** The normal alphabet */
    private final String alphabet;

    /** The Caesar Cipher Version of the alphabet */
    private String caesarAlphabet;

    /** The Atbash Cipher Version of the alphabet */
    private String atbashAlphabet;

    /** The Affine Cipher Version of the alphabet */
    private String affineAlphabet;

    /**
     * Instantiates the alphabet object
     */
    public Alphabet() {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        caesarAlphabet = "";
        atbashAlphabet = "";
        affineAlphabet = "";
    }

    /**
     * Returns the alphabet.
     *
     * @return The alphabet
     */
    public String getAlphabet() {
        return alphabet;
    }

    /**
     * Returns the Caesar Cipher Version of the alphabet
     * by shifting the alphabet around.
     *
     * @param shift The shift that changes the alphabet.
     * @return The Caesar Cipher Version of the Alphabet
     */
    public String getCaesarAlphabet(int shift) {
        caesarAlphabet = alphabet.substring(shift) + alphabet.substring(0,shift);
        return caesarAlphabet;
    }

    /**
     * Returns the Atbash Cipher Version of the alphabet,
     * created by reversing the alphabetical order.
     *
     * @return The Atbash Cipher Version of the alphabet
     */
    public String getAtbashAlphabet() {
        atbashAlphabet = "";
        for (int i = alphabet.length() - 1; i >= 0; i--) {
            atbashAlphabet += alphabet.substring(i, i + 1);
        }
        return atbashAlphabet;
    }

    /**
     * Returns the Affine Cipher Version of the alphabet,
     * created by multiplying the number of each letter by 5,
     * adding 8, then finding mod 26 of that number.
     *
     * @return The Affine Cipher Version of the alphabet
     */
    public String getAffineAlphabet() {
        affineAlphabet = "";
        for (int i = 0; i < alphabet.length(); i++) {
            int idx = (5 * i + 8) % 26;
            affineAlphabet += alphabet.substring(idx, idx + 1);
        }
        return affineAlphabet;
    }
}