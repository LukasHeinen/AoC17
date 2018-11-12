import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main (String args[]) throws Exception{
        Painter painter = new Painter();
        HashMap<String,String> p = new HashMap<>();
        List<String> s = Files.readAllLines(Paths.get("src/input.txt"));
        s.forEach(a -> {
            String[] tmp = a.split(" => ");
            p.put(tmp[0],tmp[1]);
        });
        painter.patterns = p;

        for(int i=0;i<18;i++) {
            painter.paint();
        }

        System.out.print(painter.count());
    }
}
