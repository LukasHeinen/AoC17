import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    @Test
    public void example() {
        Painter painter = new Painter();
        HashMap<String,String> p = new HashMap<>();
        List<String> s;
        try {
            s = Files.readAllLines(Paths.get("tests/input.txt"));
        } catch (Exception e) {
            s = new ArrayList<>();
        }

        s.forEach(a -> {
            String[] tmp = a.split(" => ");
            p.put(tmp[0],tmp[1]);
        });
        painter.patterns = p;

        for(int i=0;i<2;i++) {
            painter.paint();
        }

        int count =painter.count();

        assertTrue(count == 12);
    }
}
