import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> list;
    static List<Particle> particles;

    public static void main(String args[]) throws Exception {
        list = Files.readAllLines(Paths.get("src/input.txt"));
        particles = new ArrayList<>();
        list.forEach(a-> {
            Particle p = new Particle();


            String[] s = a.split(", a=<");
            String sub1 = s[1];
            sub1 = sub1.substring(0,sub1.length()-1);
            String[] s1 = sub1.split(",");
            p.accX = Integer.parseInt(s1[0]);
            p.accY = Integer.parseInt(s1[1]);
            p.accZ = Integer.parseInt(s1[2]);
            p.acc = Math.abs(p.accX) + Math.abs(p.accY) + Math.abs(p.accZ);

            String[] v = s[0].split(", v=<");
            String sub2 = v[1];
            sub2 = sub2.substring(0,sub2.length()-1);
            String[] s2 = sub2.split(",");
            p.velX = Integer.parseInt(s2[0]);
            p.velY = Integer.parseInt(s2[1]);
            p.velZ = Integer.parseInt(s2[2]);

            String sub3 = v[0];
            sub3 = sub3.substring(3,sub3.length()-1);
            String[] s3 = sub3.split(",");
            p.posX = Integer.parseInt(s3[0]);
            p.posY = Integer.parseInt(s3[1]);
            p.posZ = Integer.parseInt(s3[2]);
            p.pos = "" + p.posX + p.posY + p.posZ;

            particles.add(p);
        });
        Calculator c = new Calculator();
        c.particles = particles;
        System.out.print(c.collide());
        //System.out.print(c.min());

    }
}
