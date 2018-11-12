import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Interpreter interpreter;

    @BeforeEach
    void ini() {
        interpreter = new Interpreter();
    }

    @Test
    void example() throws Exception {
        List<String> names = new ArrayList<>();
        List<Action> actions = new ArrayList<>();

        List<String> fileLines = Files.readAllLines(Paths.get("tests/test_input.txt"));
        fileLines.forEach(a-> {
            String[] s = a.split(" ");
            String name = s[0];
            names.add(name);
            Action action = new Action();
            action.key = name;
            action.operation = s[1];
            action.value = Long.parseLong(s[2]);
            Condition con = new Condition();
            con.key = s[4];
            con.operator = s[5];
            con.value = Long.parseLong(s[6]);
            action.condition = con;
            actions.add(action);
        });

        interpreter.setReg(names,actions);

        interpreter.run();

        assertTrue(interpreter.result == 1);
    }
}
