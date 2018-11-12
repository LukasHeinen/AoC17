import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Locator locator;

    @BeforeEach
    public void ini() {
        locator = new Locator();
    }

    @Test
    void example_1() {
        String[] moves = new String[] {"ne","ne","ne"};
        for(String m : moves) {
            locator.move(m);
        }
        long res = locator.calculateResult();
        assertTrue(res == 3);
    }

    @Test
    void example_2() {
        String[] moves = new String[] {"ne","ne","sw","sw"};
        for(String m : moves) {
            locator.move(m);
        }
        long res = locator.calculateResult();
        assertTrue(res == 0);
    }

    @Test
    void example_3() {
        String[] moves = new String[] {"ne","ne","s","s"};
        for(String m : moves) {
            locator.move(m);
        }
        long res = locator.calculateResult();
        assertTrue(res == 2);
    }

    @Test
    void example_4() {
        String[] moves = new String[] {"se","sw","se","sw","sw"};
        for(String m : moves) {
            locator.move(m);
        }
        long res = locator.calculateResult();
        assertTrue(res == 3);
    }
}
