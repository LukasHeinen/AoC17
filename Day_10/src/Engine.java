import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Engine {
    private int currentPos;
    private int[] array;
    private int length;
    private long step;
    public long result;
    public String resultString;

    Engine(int length) {
        currentPos = 0;
        step = 0;
        resultString = "";
        this.length = length;
        array = new int[length];
        for (int i=0;i<length;i++) {
            array[i] = i;
        }
    }

    public static void main1(String args[]) throws Exception {
        Engine engine = new Engine(256);
        List<String> list= Files.readAllLines(Paths.get("src/input.txt"));
        String[] s = list.get(0).split(",");
        for(String a : s) {
            engine.run(Integer.parseInt(a));
        }
        System.out.println("Result: " + engine.result);
    }
    public static void main(String args[]) throws Exception {
        Engine engine = new Engine(256);
        List<String> list= Files.readAllLines(Paths.get("src/input.txt"));
        char[] s = list.get(0).toCharArray();
        for (int i=0;i<64;i++) {
            for (char c : s) {
                engine.run((int) c);
            }
            engine.run(17);
            engine.run(31);
            engine.run(73);
            engine.run(47);
            engine.run(23);
        }
        engine.calculateResultString();
        System.out.println("Result: " + engine.result);
        System.out.println("Result: " + engine.resultString);
    }

    public void run(int dist) {
        int[] tmp = getArray(currentPos,dist);
        tmp = reverseArray(tmp);
        setArray(tmp);
        result = array[0]*array[1];
    }

    private int[] getArray(int ini, int dist) {
        int[] tmp = new int[dist];
        for (int i=0;i<dist;i++) {
            tmp[i] = array[(currentPos+i)%length];
        }
        return tmp;
    }

    private int[] reverseArray(int[] input) {
        int l = input.length;
        int[] tmp = new int[l];
        for (int i=0;i<l;i++) {
            tmp[i] = input[l-1-i];
        }
        return tmp;
    }

    private void setArray(int[] input) {
        int l = input.length;
        for (int i=0;i<l;i++) {
            array[(currentPos+i)%length] = input[i];
        }
        currentPos += l + step;
        currentPos = currentPos%length;
        step++;
    }

    public void calculateResultString() {
        int count = 0;
        int tmp = 0;
        // List<Integer> tmpList = new ArrayList<>();
        for (int i=0;i<length;i++) {
            if (i != 0 && i%16 == 0) {
                String x = Integer.toHexString(tmp);
                if (x.length() == 1) {
                    x = "0" + x;
                }
                resultString += x;
                tmp = 0;

            }
            tmp ^= array[i];

            /*
            int tmp =0;
            for (int j =count;j%17<16;j++) {
                tmp ^= array[j];
                count++;
            }
            //tmpList.add(tmp);

            */
            //resultString += Integer.toHexString(tmp);
        }
        String x = Integer.toHexString(tmp);
        if (x.length() == 1) {
            x = "0" + x;
        }
        resultString += x;
    }
}
