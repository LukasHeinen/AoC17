import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    Jumper jumper;

    @BeforeEach
    void initialize() {
        jumper = new Jumper();
    }

    @Test
    void example() {
        jumper.setActions(new long[] {0,3,0,1,-3});
        jumper.run();
        assertTrue(jumper.result == 10);
    }
}
