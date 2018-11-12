import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Locator {
    private long x;
    private long y;
    private long max;

    Locator() {
        x = 0;
        y = 0;
        max = Integer.MIN_VALUE;
    }

    public static void main(String args[]) throws Exception {
        Locator locator = new Locator();
        List<String> list = Files.readAllLines(Paths.get("src/input.txt"));
        String[] dirs = list.get(0).split(",");
        for(String s : dirs) {
            locator.move(s);
        }
        System.out.println(locator.calculateResult());
        System.out.println(locator.getMaxDist());

    }

    public void move(String dir) {
        switch (dir) {
            case "n" : {
                y += 2;
                break;
            }
            case "ne" : {
                x += 2;
                y += 1;
                break;
            }
            case "nw" : {
                x -= 2;
                y += 1;
                break;
            }
            case "s" : {
                y -= 2;
                break;
            }
            case "se" : {
                x += 2;
                y -= 1;
                break;
            }
            case "sw" : {
                x -= 2;
                y -= 1;
                break;
            }
        }

        long tmp = calculateResult();
        if (tmp > max) {
            max = tmp;
        }
    }

    public long calculateResult() {
        long x1 = Math.abs(x);
        long y1 = Math.abs(y);

        y1 -= x1/2;
        return  x1/2 + y1/2;
    }

    public long getMaxDist() {
        return max;
    }
}
