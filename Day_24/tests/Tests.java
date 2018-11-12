import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Connector connector;
    @BeforeEach
    public void init() {
        //
    }

    @Test
    void example() throws Exception{
        List<String> input = Files.readAllLines(Paths.get("tests/input.txt"));
        List<int[]> iinput = new ArrayList<>();
        for (int i=0;i<input.size();i++) {
            iinput.add(new int[] {Integer.parseInt(input.get(i).split("/")[0]),Integer.parseInt(input.get(i).split("/")[1])});
        }
        connector = new Connector(iinput);
        boolean running = true;
        while (running) {
            running = connector.iterate();
        }
        int count = connector.getMax();
        int longCount = connector.getLongMax();
        assertTrue(count == 31);
        assertTrue(longCount == 19);
    }
}
