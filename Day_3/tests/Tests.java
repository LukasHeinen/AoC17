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
    public void example_1(){
        calculator.calculate(1);
        assertTrue(calculator.result == 0);
    }

    @Test
    public void example_12(){
        calculator.calculate(12);
        assertTrue(calculator.result == 3);
    }

    @Test
    public void example_23(){
        calculator.calculate(23);
        assertTrue(calculator.result == 2);
    }

    @Test
    public void example_1024(){
        calculator.calculate(1024);
        assertTrue(calculator.result == 31);
    }

    @Test
    public void example_test() {
        calculator2.calculateNextList(880);
        assertTrue(calculator2.result == 931);
    }

}
