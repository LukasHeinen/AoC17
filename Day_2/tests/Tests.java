import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Calculator calculator;

    @BeforeEach
    public void initialize() {
        calculator = new Calculator();
    }

    @Test
    public void example() {
        if (calculator.readInputSequence(Paths.get("tests/test.txt"))) {
            calculator.calculate();
            assertTrue(calculator.sum == 18);
        } else {
            assertTrue(false);
        }
    }

    @Test
    public void example_2() {
        if (calculator.readInputSequence(Paths.get("tests/test_2.txt"))) {
            calculator.calculateDivision();
            assertTrue(calculator.sum == 9);
        } else {
            assertTrue(false);
        }
    }
}
