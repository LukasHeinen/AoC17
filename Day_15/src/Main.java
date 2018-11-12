public class Main {
    public static void main1(String args[]) {
        Generator gen1 = new Generator(703,16807,2147483647,4);
        Generator gen2 = new Generator(516,48271,2147483647,8);
        int count = 0;
        for (int i=0;i<40000000;i++) {
            gen1.gen();
            gen2.gen();
            if (Generator.CompareTwoByteArrays(gen1.returnLastBytes(), gen2.returnLastBytes())) {
                count++;
            }
        }
        System.out.print(count);
    }
    public static void main(String args[]) {
        Generator gen1 = new Generator(703, 16807, 2147483647, 4);
        Generator gen2 = new Generator(516, 48271, 2147483647, 8);
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            gen1.gen2();
            gen2.gen2();
            if (Generator.CompareTwoByteArrays(gen1.returnLastBytes(), gen2.returnLastBytes())) {
                count++;
            }
        }
        System.out.print(count);
    }
}
