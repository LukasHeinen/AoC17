import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main1(String args[]) throws Exception {
        Runner runner = new Runner();

        List<String> strings = Files.readAllLines(Paths.get("src/input"));
        List<int[]> tmp = new ArrayList<>();

        strings.forEach(a -> {
            String[] s = a.split(": ");
            int[] i = new int[2];
            i[0] = Integer.parseInt(s[0]);
            i[1] = Integer.parseInt(s[1]);
            tmp.add(i);
        });

        runner.set(tmp);
        boolean valid = true;
        while(valid) {
            valid = runner.move();
        }
        long r = runner.calcRisk();
        System.out.print(r);
    }

    public static void main(String args[]) throws Exception {
        Runner runner = new Runner();

        List<String> strings = Files.readAllLines(Paths.get("src/input"));
        List<int[]> tmp = new ArrayList<>();

        strings.forEach(a -> {
            String[] s = a.split(": ");
            int[] i = new int[2];
            i[0] = Integer.parseInt(s[0]);
            i[1] = Integer.parseInt(s[1]);
            tmp.add(i);
        });

        runner.set(tmp);
        long c = runner.calcMin();
        System.out.print(c);
    }

}
