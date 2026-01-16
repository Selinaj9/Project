import java.util.Arrays;
import java.util.Scanner;

public class Cipher {
    private final Encryption encryption;
    private final Decryption decryption;
    private final Scanner scan = new Scanner(System.in);
    private String word;
    private String cipher;
    private boolean encrypt;
    private boolean decrypt;

    public Cipher() {
        encryption = new Encryption();
        decryption = new Decryption();
        word = "";
        cipher = "";
    }

    public void play() {
        getMode();
        while (encrypt) {
            System.out.print("Enter the word/sentence you would like to encrypt (lowercase only): ");
            word = scan.nextLine();
            System.out.print("Choose a cipher: " + Arrays.toString(encryption.getCipherTypes()) + " ");
            cipher = scan.nextLine();
            System.out.println("The encrypted word is: " + getEncryption());
            System.out.println("Would you like to encrypt another word/sentence?");
            String ans = scan.nextLine();
            if (ans.equals("no")) {
                encrypt = false;
            }
        }
        while (decrypt) {
            System.out.print("Enter the word/sentence you would like to decrypt (lowercase only): ");
            word = scan.nextLine();
            System.out.print("Choose a cipher: " + Arrays.toString(encryption.getCipherTypes()) + " ");
            cipher = scan.nextLine();
            System.out.println("The encrypted word is: " + getDecryption());
            System.out.println();
            System.out.println("Would you like to decrypt another word/sentence?");
            String ans = scan.nextLine();
            if (ans.equals("no")) {
                decrypt = false;
            }
        }

    }

    private void getMode() {
        System.out.println("Would you like to encrypt or decrypt a word: ");
        String crypt = scan.nextLine();
        if (crypt.equals("decrypt")) {
            encrypt = false;
            decrypt = true;
        } else {
            encrypt = true;
            decrypt = false;
        }
    }

     private String getEncryption() {
         String encryptWord = "";
        if (cipher.equals("Caesar Cipher")) {
            System.out.print("Enter number of shift: ");
            int shift = scan.nextInt();
            scan.nextLine();
            encryptWord = encryption.caesarCipher(word, shift);
        } else if (cipher.equals("Atbash Cipher")) {
            encryptWord = encryption.atbashCipher(word);
        } else if (cipher.equals("Affine Cipher")) {
            encryptWord = encryption.affineCipher(word);
        }
        return encryptWord;
    }

    private String getDecryption() {
        String encryptWord = "";
        if (cipher.equals("Caesar Cipher")) {
            System.out.print("Enter number of shift: ");
            int shift = scan.nextInt();
            scan.nextLine();
            encryptWord = decryption.caesarCipher(word, shift);
        } else if (cipher.equals("Atbash Cipher")) {
            encryptWord = decryption.atbashCipher(word);
        } else if (cipher.equals("Affine Cipher")) {
            encryptWord = decryption.affineCipher(word);
        }
        return encryptWord;
    }
}