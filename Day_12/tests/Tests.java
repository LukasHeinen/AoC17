import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Calculator calc;

    @Test
    void example() throws Exception{
        calc = new Calculator();

        List<String> list = Files.readAllLines(Paths.get("tests/input.txt"));
        list.forEach(a -> calc.add(a));
        calc.getGroupSize(0);
        long num = calc.num;
        assertTrue(num == 6);
    }

    @Test
    void example2() throws Exception{
        calc = new Calculator();

        List<String> list = Files.readAllLines(Paths.get("tests/input.txt"));
        List<Item> l = new ArrayList<>();


        list.forEach(a -> {
            String[] t = a.split(" <-> ");
            Integer key = Integer.parseInt(t[0]);
            List<Integer> tmp = new ArrayList<>();
            String[] s1 = t[1].split(", ");
            for (String s2 : s1) {
                tmp.add(Integer.parseInt(s2));
            }
            Item item = new Item();
            item.key = key;
            item.neibours = tmp;

            l.add(item);
        });
        calc.add(l);
        calc.getGroupSize(0);
        long num = calc.num;
        assertTrue(num == 6);
    }
}
