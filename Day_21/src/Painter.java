import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Painter {
    HashMap<String, String> patterns;
    private int count;
    private int div;
    private List<String> complete;
    private List<String> current2;
    private List<String> current3;

    Painter() {
        complete = new ArrayList<>();
        current2 = new ArrayList<>();
        current3 = new ArrayList<>();

        complete.add(".#.");
        complete.add("..#");
        complete.add("###");
        count = 0;
    }


    void paint() {
        separate();
        complete.clear();
        if (current2.size() >0 ) {
            for (int i=0;i<current2.size();i++) {
                process2(current2.get(i),i);
            }
            current2.clear();
        } else {
            for (int i=0;i<current3.size();i++) {
                process3(current3.get(i),i);
            }
            current3.clear();
        }
    }

    private void separate() {
        if ((complete.get(0).length() % 2 == 0)) {
            div = complete.get(0).length() / 2;
            for (int i=0;i<div;i++) {
                for (int j=0;j<div;j++) {
                    current2.add(String.valueOf(complete.get(i*2).charAt(j*2)) + String.valueOf(complete.get(i*2).charAt(j*2+1)) + "/" +
                            String.valueOf(complete.get(i*2+1).charAt(j*2)) + String.valueOf(complete.get(i*2+1).charAt(j*2+1)));
                }
            }
        } else {
            div = complete.get(0).length() / 3;
            for (int i=0;i<div;i++) {
                for (int j=0;j<div;j++) {
                    current3.add(String.valueOf(complete.get(i*3).charAt(j*3)) + String.valueOf(complete.get(i*3).charAt(j*3+1)) + String.valueOf(complete.get(i*3).charAt(j*3+2)) + "/" +
                            String.valueOf(complete.get(i*3+1).charAt(j*3)) + String.valueOf(complete.get(i*3+1).charAt(j*3+1)) + String.valueOf(complete.get(i*3+1).charAt(j*3+2))+ "/" +
                            String.valueOf(complete.get(i*3+2).charAt(j*3)) + String.valueOf(complete.get(i*3+2).charAt(j*3+1)) + String.valueOf(complete.get(i*3+2).charAt(j*3+2)));
                }
            }
        }
    }

    private void process3(String pattern, int index) {
        String tmp = pattern;
        int pos[] = new int[] {(index / div)*4, index % div};
        int count = 0;
        while (!patterns.containsKey(tmp)) {
            count++;
                String[] rows = tmp.split("/");
                String r1 = String.valueOf(rows[2].charAt(0)) + String.valueOf(rows[1].charAt(0)) + String.valueOf(rows[0].charAt(0));
                String r2 = String.valueOf(rows[2].charAt(1)) + String.valueOf(rows[1].charAt(1)) + String.valueOf(rows[0].charAt(1));
                String r3 = String.valueOf(rows[2].charAt(2)) + String.valueOf(rows[1].charAt(2)) + String.valueOf(rows[0].charAt(2));
                tmp = r1 + "/" + r2 + "/" + r3;
            if (count==4) {
                rows = tmp.split("/");
                r1 = String.valueOf(rows[0].charAt(2)) + String.valueOf(rows[0].charAt(1)) + String.valueOf(rows[0].charAt(0));
                r2 = String.valueOf(rows[1].charAt(2)) + String.valueOf(rows[1].charAt(1)) + String.valueOf(rows[1].charAt(0));
                r3 = String.valueOf(rows[2].charAt(2)) + String.valueOf(rows[2].charAt(1)) + String.valueOf(rows[2].charAt(0));
                tmp = r1 + "/" + r2 + "/" + r3;
            }
        }
        String match = patterns.get(tmp);
        String[] s = match.split("/");
        while (complete.size()<pos[0]+4) {
            complete.add("");
        }
        String r1 = complete.get(pos[0]) + s[0];
        String r2 = complete.get(pos[0]+1) + s[1];
        String r3 = complete.get(pos[0]+2) + s[2];
        String r4 = complete.get(pos[0]+3) + s[3];

        complete.set(pos[0],r1);
        complete.set(pos[0]+1,r2);
        complete.set(pos[0]+2,r3);
        complete.set(pos[0]+3,r4);
    }

    private void process2(String pattern, int index) {
        String tmp = pattern;
        int pos[] = new int[] {(index / div)*3, index % div};

        while (!patterns.containsKey(tmp)) {
            String[] rows = tmp.split("/");
            String r1 = String.valueOf(rows[1].charAt(0)) + String.valueOf(rows[0].charAt(0));
            String r2 = String.valueOf(rows[1].charAt(1)) + String.valueOf(rows[0].charAt(1));
            tmp = r1 + "/" + r2;
        }
        String result =patterns.get(tmp);
        String[] s = result.split("/");
        while (complete.size()<pos[0]+3) {
            complete.add("");
        }
        String r1 = complete.get(pos[0]) + s[0];
        String r2 = complete.get(pos[0]+1) + s[1];
        String r3 = complete.get(pos[0]+2) + s[2];

        complete.set(pos[0],r1);
        complete.set(pos[0]+1,r2);
        complete.set(pos[0]+2,r3);
    }

    int count() {
        complete.forEach( a-> {
            for (int i=0;i<a.length();i++) {
                if (a.charAt(i) != '.') {
                    count++;
                }
            }
        });
        return count;
    }
}
