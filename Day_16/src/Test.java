import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    static String stepsFile;
    static long[] positions;
    static String[] tasks;
    public static void main(String args[]) throws Exception {
        positions = new long[5];
        stepsFile = new String(Files.readAllBytes(Paths.get("input_test.txt"))).replace("\n","");
        tasks = stepsFile.split(",");
        for (int i=0;i<5;i++) {
            positions[i] = i;
        }
        for (int i=0;i<tasks.length;i++) {
            executeMove(tasks[i]);
        }
        for (int i=0;i<positions.length;i++) {
            for (int j=0;j<positions.length;j++) {
                if (positions[j]==i) {
                    System.out.print(String.valueOf((char)(j + 96+1)));
                }
            }
        }
    }

    public static void executeMove(String move) {
        switch (move.charAt(0)) {
            case 's': {
                for(int i =0;i<5;i++) {
                    positions[i] = (positions[i] + Integer.parseInt(move.substring(1))) % positions.length;
                }
                break;
            }
            case 'p': {
                long tmp = positions[(int) move.charAt(1) - 96-1];
                positions[(int) move.charAt(1) - 96-1] = positions[(int) move.charAt(3) - 96-1];
                positions[(int) move.charAt(3) - 96-1] = tmp;
                break;
            }
            case 'x': {
                int pos1=0;
                int pos2=0;
                for(int i=0;i<positions.length;i++) {
                    if(positions[i] == pos(move)[0]) {
                        pos1 = i;
                    } else if(positions[i] == pos(move)[1]) {
                        pos2 = i;
                    }
                }
                positions[pos1]= pos(move)[1];
                positions[pos2]= pos(move)[0];
                break;
            }
        }
    }

    public static int[] pos(String s) {
        String[] tmp = s.split("/");
        int[] output = new int[2];
        output[0] = Integer.parseInt(tmp[0].substring(1));
        output[1] = Integer.parseInt(tmp[1]);
        return output;
    }
}
