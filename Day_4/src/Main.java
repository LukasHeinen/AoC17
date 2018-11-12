import java.nio.file.Paths;

public class Main {
    private static Validator validator;

    public static void main(String args[]) throws Exception {
        validator = new Validator();
        System.out.println("Result: " + validator.isValid(Paths.get("src/input.txt")));
    }
}
