import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception{
        Follower f = new Follower();
        List<String> t = Files.readAllLines(Paths.get("src/input.txt"));
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
        System.out.println(f.output);
        System.out.println(f.count -1 );
    }
}
