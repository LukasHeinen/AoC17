import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Sorter sorter;

    @BeforeEach
    public void initialize() {
        sorter = new Sorter();
    }

    @Test
    public void example() throws Exception {
        HashMap<String, Program> programs;

        List<String> testInput = Files.readAllLines(Paths.get("tests/test_input.txt"));
        programs = new HashMap<>();

        for (String string : testInput) {
            String[] subStrings = string.split(" -> ");
            String core = subStrings[0];
            String[] coreSubString = core.split(" ");
            Program tmp = new Program();
            tmp.subProgramNames = new HashSet<>();
            tmp.name = coreSubString[0];
            tmp.number = Integer.parseInt(coreSubString[1].substring(1, (coreSubString[1].length() - 1)));
            if (subStrings.length > 1) {
                String[] subPrograms = subStrings[1].split(", ");
                tmp.subProgramNames.addAll(Arrays.asList(subPrograms));
            }
            programs.put(tmp.name, tmp);
        }

        sorter.setPrograms(programs);
        sorter.setParents();

        assertTrue(sorter.masterName.equals("tknk"));

    }

    @Test
    public void example2() throws Exception {
        HashMap<String, Program> programs;

        List<String> testInput = Files.readAllLines(Paths.get("tests/test_input.txt"));
        programs = new HashMap<>();

        for (String string : testInput) {
            String[] subStrings = string.split(" -> ");
            String core = subStrings[0];
            String[] coreSubString = core.split(" ");
            Program tmp = new Program();
            tmp.subProgramNames = new HashSet<>();
            tmp.name = coreSubString[0];
            tmp.number = Integer.parseInt(coreSubString[1].substring(1, (coreSubString[1].length() - 1)));
            if (subStrings.length > 1) {
                String[] subPrograms = subStrings[1].split(", ");
                tmp.subProgramNames.addAll(Arrays.asList(subPrograms));
            }
            programs.put(tmp.name, tmp);
        }
        sorter.setPrograms(programs);
        sorter.setParents();
        sorter.tree();

        assertTrue(sorter.changeValue == 60);
    }
}
