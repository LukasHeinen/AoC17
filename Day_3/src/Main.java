public class Main {
    private static Calculator calculator;
    private static Calculator2 calculator2;

    public static void main1(String args[]) {
        calculator = new Calculator();
        calculator.calculate(347991);
        System.out.println("Result: " + calculator.result);
    }

    public static void main(String args[]) {
        calculator2 = new Calculator2();
        do {
            calculator2.calculateNextList(347991);
            if (calculator2.getLast()>347991) {
                break;
            }
        } while (calculator2.result == 0);
        System.out.println("Result: " + calculator2.result);


    }
}
