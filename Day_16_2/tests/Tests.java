import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Dance d;

    @BeforeEach
    public void ini() {
        d = new Dance(5);
    }

    @Test
    void example() throws  Exception {
        List<Move> m = new ArrayList<>();
        List<String> list = Files.readAllLines(Paths.get("tests/test.txt"));
        String moves = list.get(0);
        String[] split = moves.split(",");
        for (String s : split) {
            Move tmp = new Move(s);
            m.add(tmp);
        }
        m.forEach(a -> d.exeMove(a));
        String r = d.getResult();
        assertTrue(r.equals("baedc"));
    }

}
