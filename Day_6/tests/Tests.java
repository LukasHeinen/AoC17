import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Calculator calculator;
    private Calculator2 calculator2;

    @BeforeEach
    public void initialize() {
        calculator = new Calculator();
        calculator2 = new Calculator2();
    }

    @Test
    public void example() {
        calculator.setBanks(new long[]{0, 2, 7, 0});
        calculator.run();
        assertTrue(calculator.result == 5);
    }

    @Test
    public void example2() {
        calculator2.setBanks(new long[]{0, 2, 7, 0});
        calculator2.run();
        assertTrue(calculator2.result == 4);
    }
}
