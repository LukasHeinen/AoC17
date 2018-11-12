import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main1(String args[]) throws Exception{
        List<Action> list = new ArrayList<>();
        List<String> input = Files.readAllLines(Paths.get("src/input.txt"));
        input.forEach(a -> {
            String[] items = a.split(" ");
            Action action = new Action();
            action.id = items[0];
            action.key = items[1];
            try {
                action.value = items[2];
            } catch (Exception e) {

            }
            list.add(action);
        });
        Action[] array = new Action[list.size()];
        list.toArray(array);
        Processor a1 = new Processor(array);
        a1.run();

        System.out.print(a1.getCounter());
    }

    public static void main(String args[]) throws Exception{
        long a = 1;
        long b = 84;
        long c = b;
        b = b * 100;
        b += 100000;
        c = b;
        c += 17000;
        long f;
        long d;
        long e;
        long g;
        long h = 0;
        while (true) {
            f = 1;
            d = 2;
            do {
                e = 2;
                if ( b % d == 0)
                    f = 0;
                d -= -1;
                g = d;
                g -= b;
            } while (g != 0);
            if (f == 0) {
                h -= -1;
            }
            g = b;
            g -= c;
            if (g == 0) {
                break;
            } else {
                b -= -17;
            }
        }
        System.out.print(h);
    }
}
