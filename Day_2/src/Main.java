import java.nio.file.Paths;

public class Main {

    private static Calculator calculator;

    public static void main_1(String args[]) {
        calculator = new Calculator();
        if(calculator.readInputSequence(Paths.get("src/input_space.txt"))) {
            calculator.calculate();
            System.out.println("Sum: " + calculator.sum);
        }
    }

    public static void main(String args[]) {
        calculator = new Calculator();
        if(calculator.readInputSequence(Paths.get("src/input_space.txt"))) {
            calculator.calculateDivision();
            System.out.println("Sum: " + calculator.sum);
        }
    }
}
