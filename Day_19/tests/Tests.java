import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.FileHandler;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    @Test
    public void t() throws  Exception{
        Follower f = new Follower();
        List<String> t = Files.readAllLines(Paths.get("tests/input.txt"));
        int max = Integer.MIN_VALUE;
        for (int i=0;i<t.size();i++) {
            if (t.get(i).length()> max) {
                max = t.get(i).length();
            }
        }

        for (int i=0;i<t.size();i++) {
            while (t.get(i).length()<max) {
                t.set(i, t.get(i) + " ");
            }
        }

        String[] hor = new String[t.size()];
        t.toArray(hor);

        String[] vert = new String[t.get(0).length()];
        for(int i =0;i< vert.length;i++) {
            vert[i] = "";
        }

        for (int i=0;i<t.size();i++) {
            for(int j=0;j<t.get(0).length();j++) {
                vert[j] += hor[i].charAt(j);
            }
        }

        f.hor = hor;
        f.vert = vert;

        f.run();

        assertTrue(f.output.equals("ABCDEF"));
        assertTrue(f.count==38);
    }
}
