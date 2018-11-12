import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception{
        List<String> s = Files.readAllLines(Paths.get("src/input.txt"));
        String s1 = s.get(0);
        Calculator c = new Calculator();
        c.setSequence(s1);
        c.run();
        System.out.println("Result: " + c.result);
        System.out.println("Result2: " + c.result2);
    }
}
