import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Engine engine;
    @BeforeEach
    public void ini() {
        engine = new Engine(256);
    }

    @Test
    void example_flqrgnkx() {
        String test = "flqrgnkx";
        String[] array  =new String[128];
        long sum = 0;
        for(int i=0;i<128;i++) {
            long count = 0;
            String tmp = test + "-" + i;
            String output = engine.run(tmp);
            engine.reset();
            String t = "";
            for (int j=0;j<output.length();j++) {
                int dec = Integer.parseInt(output.charAt(j) + "", 16);
                String bin = Integer.toBinaryString(dec);
                while(bin.length()<4) {
                    bin = "0" + bin;
                }
                t += bin;
            }
            array[i] = t;
            //String t = new BigInteger(output, 16).toString(2);
            for (char c : t.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            sum += count;
        }
    assertTrue(sum == 8108);
    }

    @Test
    void example_2_flqrgnkx() {
        String test = "flqrgnkx";
        String[] array  =new String[128];
        long sum = 0;
        for(int i=0;i<128;i++) {
            long count = 0;
            String tmp = test + "-" + i;
            String output = engine.run(tmp);
            engine.reset();
            String t = "";
            for (int j=0;j<output.length();j++) {
                int dec = Integer.parseInt(output.charAt(j) + "", 16);
                String bin = Integer.toBinaryString(dec);
                while(bin.length()<4) {
                    bin = "0" + bin;
                }
                t += bin;
            }
            array[i] = t;
        }
        engine.calcAreas(array);
        assertTrue(engine.result == 1242);
    }
}
