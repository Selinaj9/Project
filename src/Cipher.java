import java.util.Arrays;
import java.util.Scanner;

public class Cipher {
    private Encryption encryption;
    private Decryption decryption;
    private Scanner scan = new Scanner(System.in);
    private String word;
    private String cipher;
    private boolean stop;
    private String cryptionType;

    public Cipher() {
        encryption = new Encryption();
        decryption = new Decryption();
        word = "";
        cipher = "";
        stop = false;
    }

    public void play() {
        while (!stop) {
            System.out.print("Enter the word/sentence you would like to encrypt (lowercase only): ");
            word = scan.nextLine();
            System.out.print("Choose a cipher: " + Arrays.toString(encryption.getCipherTypes()) + " ");
            cipher = scan.nextLine();
            if (cipher.equals("Caesar Cipher")) {
                System.out.print("Enter number of shift: ");
                int shift = scan.nextInt();
                String encrypt = encryption.caesarCipher(word, shift);
                System.out.println("The encrypted word is: " + encrypt);
            } else if (cipher.equals("Atbash Cipher")) {
                String encrypt = encryption.atbashCipher(word);
                System.out.println("The encrypted word is: " + encrypt);
            } else if (cipher.equals("Affine Cipher")) {
                String encrypt = encryption.affineCipher(word);
                System.out.println("The encrypted word is: " + encrypt);
            }
            System.out.println("Would you like to encrypt another word/sentence?");
            String ans = scan.nextLine();
            if (ans.equals("no")) {
                stop = true;
            }
        }
    }
}