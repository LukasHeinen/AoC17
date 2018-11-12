public class Main {
    private static long[] banks = new long[] {14,0,15,12,11,11,3,5,1,6,8,4,9,1,8,4};
    public static void main1(String args[]) {
        Calculator calculator;
        calculator = new Calculator();
        calculator.setBanks(banks);
        calculator.run();
        System.out.println("Result: " + calculator.result);
    }

    public static void main(String args[]) {
        Calculator2 calculator2;
        calculator2 = new Calculator2();
        calculator2.setBanks(banks);
        calculator2.run();
        System.out.println("Result: " + calculator2.result);
    }
}
