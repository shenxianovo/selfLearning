/** This class outputs all palindromes in the words file in the current directory. */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        String fileName = "/home/shenxianovo/QuQ/test/words.txt";

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            Palindrome palindrome = new Palindrome();
            CharacterComparator cc = new OffByN(20);

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                    System.out.println(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}