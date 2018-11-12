import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Engine engine;

    @BeforeEach
    public void ini() {
        engine = new Engine(5);
    }

    @Test
    void example_1() {
        engine.run(3);
        engine.run(4);
        engine.run(1);
        engine.run(5);
        assertTrue(engine.result == 12);
    }

    @Test
    void example_2_1() {
        engine = new Engine(256);
        String s1 = "";
        char[] s = s1.toCharArray();
        for (int i=0;i<64;i++) {
            for (char c : s) {
                engine.run((int) c);
            }
            engine.run(17);
            engine.run(31);
            engine.run(73);
            engine.run(47);
            engine.run(23);
        }
        engine.calculateResultString();
        assertTrue(engine.resultString.equals("a2582a3a0e66e6e86e3812dcb672a272"));
    }

    @Test
    void example_2_2() {
        engine = new Engine(256);
        String s1 = "AoC 2017";
        char[] s = s1.toCharArray();
        for (int i=0;i<64;i++) {
            for (char c : s) {
                engine.run((int) c);
            }
            engine.run(17);
            engine.run(31);
            engine.run(73);
            engine.run(47);
            engine.run(23);
        }
        engine.calculateResultString();
        assertTrue(engine.resultString.equals("33efeb34ea91902bb2f59c9920caa6cd"));
    }
}
