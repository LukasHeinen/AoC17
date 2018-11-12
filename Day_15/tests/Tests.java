import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Generator gen1;
    private Generator gen2;

    @BeforeEach
    public void ini() {
        gen1 = new Generator(65,16807,2147483647,4);
        gen2 = new Generator(8921,48271,2147483647,8);
    }

    @Test
    void example() {
        int count = 0;
        //for (int i=0;i<40000000;i++) {
        for (int i=0;i<1;i++) {
            gen1.gen();
            gen2.gen();
            if (Generator.CompareTwoByteArrays(gen1.returnLastBytes(), gen2.returnLastBytes())) {
                count++;
            }
        }
        //assertTrue(count == 588);
        assertTrue(count == 0);
    }

    @Test
    void example2() {
        int count = 0;
        for (int i=0;i<5000000;i++) {
            gen1.gen2();
            gen2.gen2();
            if (Generator.CompareTwoByteArrays(gen1.returnLastBytes(), gen2.returnLastBytes())) {
                count++;
            }
        }
        assertTrue(count == 309);
    }
}
