import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    @Test
    public void testOffByOne() {
        char[] a = {'a', 'r'};
        char[] b = {'b', 'q'};
        OffByOne obo= new OffByOne();
        for (int i = 0; i < a.length; ++i) {
            assertTrue(obo.equalChars(a[i], b[i]));
        }
    }
}
