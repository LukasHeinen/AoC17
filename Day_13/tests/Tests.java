import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Tests {
    @Test
    void example() throws Exception{
        Runner runner = new Runner();

        List<String> strings = Files.readAllLines(Paths.get("tests/input"));
        List<int[]> tmp = new ArrayList<>();

        strings.forEach(a -> {
            String[] s = a.split(": ");
            int[] i = new int[2];
            i[0] = Integer.parseInt(s[0]);
            i[1] = Integer.parseInt(s[1]);
            tmp.add(i);
        });

        runner.set(tmp);
        boolean valid = true;
        while(valid) {
            valid = runner.move();
        }
        long r = runner.calcRisk();
        assertTrue(r == 25);
    }

    @Test
    void example2() throws Exception{
        Runner runner = new Runner();

        List<String> strings = Files.readAllLines(Paths.get("tests/input"));
        List<int[]> tmp = new ArrayList<>();

        strings.forEach(a -> {
            String[] s = a.split(": ");
            int[] i = new int[2];
            i[0] = Integer.parseInt(s[0]);
            i[1] = Integer.parseInt(s[1]);
            tmp.add(i);
        });

        runner.set(tmp);
        /*
        boolean valid = true;
        long r = 1;
        int c = -1;
        while(r!=0) {
            c++;
            runner.setPause(c);
            valid = true;
            while (valid) {
                valid = runner.move();
            }
            r = runner.calcRisk();
        }
        */
        long c = runner.calcMin();
        assertTrue(c == 10);
    }
}
