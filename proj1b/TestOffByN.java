import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    OffByN OffBy5= new OffByN(5);
    @Test
    public void testOffBy5() {
        assertTrue(OffBy5.equalChars('a','f'));
        assertTrue(OffBy5.equalChars('f','a'));
        assertFalse(OffBy5.equalChars('a','h'));
    }
}
