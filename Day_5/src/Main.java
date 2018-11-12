import java.nio.file.Paths;

public class Main {
    private static Jumper jumper;

    public static void main(String args[]) throws Exception{
        jumper = new Jumper();
        jumper.initialize(Paths.get("src/input.txt"));
        jumper.run();
        System.out.println("Result: " + jumper.result);
    }
}
