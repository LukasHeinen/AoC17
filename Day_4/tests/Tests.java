import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Validator validator;

    @BeforeEach
    public void initialize() {
        validator = new Validator();
    }

    @Test
    public void example_abcde() {
        boolean valid = validator.isValid("aa bb cc dd ee");
        assertTrue(valid);
    }

    @Test
    public void example_abcda() {
        boolean valid = validator.isValid("aa bb cc dd aa");
        assertTrue(!valid);
    }

    @Test
    public void example_abcdaa() {
        boolean valid = validator.isValid("aa bb cc dd aaa");
        assertTrue(valid);
    }
}
