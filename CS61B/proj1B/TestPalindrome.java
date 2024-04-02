import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("cat"));

        Deque d = palindrome.wordToDeque("otto");
        Deque d2 = palindrome.wordToDeque("ppapp");
        Deque d3 = palindrome.wordToDeque("shit");

        assertTrue(palindrome.isPalindrome(d));
        assertTrue(palindrome.isPalindrome(d2));
        assertFalse(palindrome.isPalindrome(d3));

        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));

    }


}