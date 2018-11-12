import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    static String uri ="src/input_sequence.txt";
    static Calculator calculator;

    public static void main(String args[]) throws Exception{
        calculator = new Calculator();
        calculator.loadFileInput(Paths.get(uri));
        //calculator.calculateResult();
        calculator.calculateResultHalfwayRound();
        System.out.println("Result:" + calculator.sum);
    }
}
