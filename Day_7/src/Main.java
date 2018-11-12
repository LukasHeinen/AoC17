import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    private static Sorter sorter;

    public static void main(String args[]) throws Exception {
        sorter = new Sorter();
        HashMap<String,Program> programs;

        List<String> testInput = Files.readAllLines(Paths.get("src/input.txt"));
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
        //sorter.reduce();

        System.out.println("Master: " + sorter.masterName);
        System.out.println("ChangeValue: " + sorter.changeValue);
    }
}
