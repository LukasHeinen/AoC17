import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Engine {
    private int currentPos;
    private int[] array;
    private int length;
    private long step;
    private Point[][] points;
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

    public static void main(String args[]) {
        Engine engine = new Engine(256);
        String test = "wenycdww";
        String[] array  =new String[128];
        long sum = 0;
        for(int i=0;i<128;i++) {
            long count = 0;
            String tmp = test + "-" + i;
            String output = engine.run(tmp);
            engine.reset();
            String t = "";
            for (int j=0;j<output.length();j++) {
                int dec = Integer.parseInt(output.charAt(j) + "", 16);
                String bin = Integer.toBinaryString(dec);
                while(bin.length()<4) {
                    bin = "0" + bin;
                }
                t += bin;
            }
            array[i] = t;
        }
        engine.calcAreas(array);
        System.out.print(engine.result);
    }

    public static void main1(String args[]) throws Exception {
        Engine engine = new Engine(256);
        String test = "wenycdww";
        String[] array  =new String[128];
        long sum = 0;
        for(int i=0;i<128;i++) {
            long count = 0;
            String tmp = test + "-" + i;
            String output = engine.run(tmp);
            engine.reset();
            String t = "";
            for (int j=0;j<output.length();j++) {
                int dec = Integer.parseInt(output.charAt(j) + "", 16);
                String bin = Integer.toBinaryString(dec);
                while(bin.length()<4) {
                    bin = "0" + bin;
                }
                t += bin;
            }
            array[i] = t;
            //String t = new BigInteger(output, 16).toString(2);
            for (char c : t.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            sum += count;
        }
        System.out.print(sum);
    }

    public String run(String input) {
        char[] s = input.toCharArray();
        for (int i=0;i<64;i++) {
            for (char c : s) {
                run((int) c);
            }
            run(17);
            run(31);
            run(73);
            run(47);
            run(23);
        }
        calculateResultString();
        String tmp = resultString;
        //String t = new BigInteger(tmp, 16).toString(2);
        return tmp;
    }

    public void reset() {
        currentPos = 0;
        step = 0;
        resultString = "";
        array = new int[length];
        for (int i=0;i<length;i++) {
            array[i] = i;
        }
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

    public void calcAreas(String[] input) {
        currentPos = 1;
        int height = input.length;
        int width = input[0].length();
        points = new Point[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                points[i][j] = new Point(j,i);
                try {
                    if (input[i].charAt(j) == '1') {

                        points[i][j].marked = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (points[i][j].marked && points[i][j].region == 0) {
                    points[i][j].region = currentPos;
                    currentPos++;
                    List<Point> tmp = new ArrayList<>();
                    tmp.add(points[i][j]);
                    while (tmp != null) {
                        tmp  = markNext(tmp);
                    }
                }
            }
        }

        result = currentPos-1;
    }

    private List<Point> markNext(List<Point> input) {
        List<Point> nextList = new ArrayList<>();
        for (Point a : input) {
            List<Point> n = getValidNeibours(a.x,a.y);
            n.forEach(b -> {
                if(b.marked && b.region == 0) {
                    b.region = input.get(0).region;
                    nextList.add(b);
                }
            });
        }
        if (nextList.size()>0) {
            return nextList;
        }
        return null;
    }

    private List<Point> getValidNeibours(int x, int y) {
        List<Point> list = new ArrayList<>();

        for (int i=-1;i<2;i++) {
            for (int j=-1;j<2;j++) {
                int tmpx = x+i;
                int tmpy = y+j;
                if ((i == 0 || j == 0) && (i!=j)) {
                    if (tmpx >= 0 && tmpx < 128 && tmpy >= 0 && tmpy < 128) {
                        list.add(points[tmpy][tmpx]);
                    }
                }
            }
        }
        return list;
    }
}

class Point {
    boolean marked;
    int region;
    int x;
    int y;

    Point(int x,int y) {
        this.x = x;
        this.y = y;
        marked = false;
        region = 0;
    }
}
