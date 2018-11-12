import java.util.ArrayList;
import java.util.List;

public class Follower {
    public String[] hor;
    public String[] vert;
    private int dir;        // 0 = right, 1 = down, 2 = left, 3 = up
    private char current;
    private int x = 0;
    private int y = 0;
    String output = "";
    boolean done = false;
    int count = 0;

    public String run() {

        findStart();
        boolean b = true;
        while(b) {
            b = goOn();
        }
        return output;
    }

    private void findStart() {
        for (int i=0;i<hor[0].length();i++) {
            if (hor[0].charAt(i) == '|') {
                x = i;
                dir = 1;
                current = '|';
                break;
            }
        }
    }

    private boolean goOn() {
        switch (dir) {
            case 0: {
                String route = hor[y];
                for (int i = x;i<hor[y].length();i++) {
                    char c = route.charAt(i);
                    if (c == 32) {
                        done = true;
                        return false;
                    }
                    count++;
                    if (!addLetter(c)) {
                        x = i;
                        findNext();
                        break;
                    }
                }
                break;
            }
            case 1: {
                String route = vert[x];
                for (int i = y;i<vert[x].length();i++) {
                    char c = route.charAt(i);
                    if (c == 32) {
                        done = true;
                        return false;
                    }
                    count++;
                    if (!addLetter(c)) {
                        y = i;
                        findNext();
                        break;
                    }
                }
                break;
            }
            case 2: {
                String route = hor[y];
                for (int i = x;i>=0;i--) {
                    char c = route.charAt(i);
                    if (c == 32) {
                        done = true;
                        return false;
                    }
                    count++;
                    if (!addLetter(c)) {
                        x = i;
                        findNext();
                        break;
                    }
                }
                break;
            }
            case 3: {
                String route = vert[x];
                for (int i = y;i>=0;i--) {
                    char c = route.charAt(i);
                    if (c == 32) {
                        done = true;
                        return false;
                    }
                    count++;
                    if (!addLetter(c)) {
                        y = i;
                        findNext();
                        break;
                    }
                }
                break;
            }
        }
        return true;
    }

    private boolean addLetter(char c) {
        if (c != '-' && c != '|' && c != '+' && c != 32) {
            output += "" + c;
            return true;
        } else return !(c == '+');
    }

    private void findNext() {
        List<int[]> options = new ArrayList<>();
        for (int i = -1;i<2;i++) {
            for (int j=-1 ;j<2;j++) {
                try {
                    if (i != j && (i + x) >= 0 && (i + x) < hor[y + j].length() && (j + y) >= 0 && (j + y) < vert[x + i].length()) {
                        options.add(new int[]{x + i, y + j});
                    }
                } catch (Exception e) {

                }
            }
        }
        for(int i=0;i<options.size();i++) {
            int tmpx = options.get(i)[0];
            int tmpy = options.get(i)[1];
            String tmps =hor[tmpy];
            char tmp = tmps.charAt(tmpx);

            if (tmp != current && tmp != 32) {
                if (options.get(i)[0] > x) {
                    dir =0;
                    current = '-';
                    x += 1;
                    break;
                }
                else if (options.get(i)[0] < x) {
                    dir =2;
                    current = '-';
                    x -= 1;
                    break;
                }
                else if (options.get(i)[1] > y) {
                    dir =1;
                    current = '|';
                    y += 1;
                    break;
                }
                else if (options.get(i)[1] < y) {
                    dir =3;
                    current = '|';
                    y -= 1;
                    break;
                }
            }
        }
    }
}
