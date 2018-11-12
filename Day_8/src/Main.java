import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Interpreter interpreter;

    public static void main(String args[]) throws Exception{
        interpreter = new Interpreter();
        List<String> names = new ArrayList<>();
        List<Action> actions = new ArrayList<>();

        List<String> fileLines = Files.readAllLines(Paths.get("src/input.txt"));
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
        System.out.println("Result: " + interpreter.result);
        System.out.println("EverResult: " + interpreter.everResult);
    }
}
