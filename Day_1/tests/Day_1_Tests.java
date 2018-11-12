import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day_1_Tests {
    private static Calculator calculator;

    @BeforeAll
    public static void initialize() {
        calculator = new Calculator();
    }
    @Test
    public void example_1122() {
        calculator.setInputSequence(new int[] {1,1,2,2});
        calculator.calculateResult();
        assertTrue(calculator.sum == 3);
    }
    @Test
    public void example_1111() {
        calculator.setInputSequence(new int[] {1,1,1,1});
        calculator.calculateResult();
        assertTrue(calculator.sum == 4);
    }
    @Test
    public void example_1234() {
        calculator.setInputSequence(new int[] {1,2,3,4});
        calculator.calculateResult();
        assertTrue(calculator.sum == 0);
    }
    @Test
    public void example_91212129() {
        calculator.setInputSequence(new int[] {9,1,2,1,2,1,2,9});
        calculator.calculateResult();
        assertTrue(calculator.sum == 9);
    }
    // Test two
    @Test
    public void example2_1212() {
        calculator.setInputSequence(new int[] {1,2,1,2});
        calculator.calculateResultHalfwayRound();
        assertTrue(calculator.sum == 6);
    }
    @Test
    public void example2_1221() {
        calculator.setInputSequence(new int[] {1,2,2,1});
        calculator.calculateResultHalfwayRound();
        assertTrue(calculator.sum == 0);
    }
    @Test
    public void example2_123425() {
        calculator.setInputSequence(new int[] {1,2,3,4,2,5});
        calculator.calculateResultHalfwayRound();
        assertTrue(calculator.sum == 4);
    }
    @Test
    public void example2_123123() {
        calculator.setInputSequence(new int[] {1,2,3,1,2,3});
        calculator.calculateResultHalfwayRound();
        assertTrue(calculator.sum == 12);
    }
    @Test
    public void example2_12131415() {
        calculator.setInputSequence(new int[] {1,2,1,3,1,4,1,5});
        calculator.calculateResultHalfwayRound();
        assertTrue(calculator.sum == 4);
    }
}
