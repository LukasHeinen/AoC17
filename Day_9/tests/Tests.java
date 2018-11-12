import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Tests {
    private Calculator calculator;

    @BeforeEach
    void ini() {
        calculator = new Calculator();
    }
    @Test
    void example1() {
        calculator.setSequence("{}");
        calculator.run();
        assertTrue(calculator.result == 1);
    }
    @Test
    void example2() {
        calculator.setSequence("{{{}}}");
        calculator.run();
        assertTrue(calculator.result == 6);
    }
    @Test
    void example3() {
        calculator.setSequence("{{},{}}");
        calculator.run();
        assertTrue(calculator.result == 5);
    }
    @Test
    void example4() {
        calculator.setSequence("{{{},{},{{}}}}");
        calculator.run();
        assertTrue(calculator.result == 16);
    }
    @Test
    void example5() {
        calculator.setSequence("{<a>,<a>,<a>,<a>}");
        calculator.run();
        assertTrue(calculator.result == 1);
    }
    @Test
    void example6() {
        calculator.setSequence("{{<ab>},{<ab>},{<ab>},{<ab>}}");
        calculator.run();
        assertTrue(calculator.result == 9);
    }
    @Test
    void example7() {
        calculator.setSequence("{{<!!>},{<!!>},{<!!>},{<!!>}}");
        calculator.run();
        assertTrue(calculator.result == 9);
    }
    @Test
    void example8() {
        calculator.setSequence("{{<a!>},{<a!>},{<a!>},{<ab>}}");
        calculator.run();
        assertTrue(calculator.result == 3);
    }

    @Test
    void example2_1() {
        calculator.setSequence("<random characters>");
        calculator.run();
        assertTrue(calculator.result2 == 17);
    }
    @Test
    void example2_2() {
        calculator.setSequence("<<<<>");
        calculator.run();
        assertTrue(calculator.result2 == 3);
    }
    @Test
    void example2_3() {
        calculator.setSequence("<{o\"i!a,<{i<a>");
        calculator.run();
        assertTrue(calculator.result2 == 10);
    }
}
