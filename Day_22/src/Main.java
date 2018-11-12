import org.omg.IOP.ExceptionDetailMessage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static Virus virus;
    private static Virus2 virus2;

    public static void main1(String args[]) throws Exception{
        virus = new Virus(2600);

        List<String> input = Files.readAllLines(Paths.get("src/input.txt"));

        boolean[][] ini = new boolean[input.size()][input.size()];
        for (int i=0;i<input.size();i++) {
            for (int j=0;j<input.size();j++) {
                ini[i][j] = input.get(i).charAt(j) == '#';
            }
        }
        virus.setInitialState(ini);
        for (int i=0;i<10000;i++) {
            virus.move();
        }
        int count = virus.getCount();
        //int dir = virus.getDir();
        System.out.print(count);
    }

    public static void main(String args[]) throws Exception{
        int length = 40000;
        virus2 = new Virus2(length);

        List<String> input = Files.readAllLines(Paths.get("src/input.txt"));

        char[][] ini = new char[input.size()][input.size()];

        for (int i=0;i<input.size();i++) {
            for (int j=0;j<input.size();j++) {
                ini[i][j] = input.get(i).charAt(j);
            }
        }
        virus2.setInitialState(ini);
        for (int i=0;i<10000000;i++) {
            try {
                virus2.move();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int count = virus2.getCount();
        //int dir = virus.getDir();
        System.out.print(count);
    }
}
