import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    //add annotation test no static remove main
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);

    }

    @Test
    public void testIsPalindrome1() {
        CharacterComparator cc= new OffByOne();
        assertTrue(palindrome.isPalindrome("bacba", cc));

    }
    @Test
    public void testIsPalindrome2() {
        CharacterComparator cc= new OffByN(3);
        assertFalse(palindrome.isPalindrome("fbkkei", cc));
    }
}
