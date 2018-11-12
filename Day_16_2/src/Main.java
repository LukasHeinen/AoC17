import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Dance d;
    public static void main(String args[]) throws Exception{
        d = new Dance(16);
        List<Move> m = new ArrayList<>();
        List<String> list = Files.readAllLines(Paths.get("src/input.txt"));
        String moves = list.get(0);
        String[] split = moves.split(",");
        for (String s : split) {
            Move tmp = new Move(s);
            m.add(tmp);
        }
        Move[] moves1 = new Move[m.size()];
        m.toArray(moves1);
        int size = moves1.length;
        long t1 = System.nanoTime();
        for(int i=0;i<100;i++) {
            for (int j=0;j<size;j++) {
                d.exeMove(moves1[j]);
            }
            //m.forEach(a -> d.exeMove(a));
        }
        long t2 = System.nanoTime();
        System.out.println("Time: " + (t2-t1)/1000000000);
        String r = d.getResult();
        System.out.print(r);
    }
}
