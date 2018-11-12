import javafx.collections.transformation.SortedList;

import java.util.*;

public class Dance {
    List<String> pos;
    List<Character> pos4;
    Set<String> set;

    String[] pos2;
    char[] pos3;
    int size;

    private String r;
    int flag;

    Dance(int size) {
        flag = 0;

        r = "";
        pos = new ArrayList<>();
        pos4 = new ArrayList<>();
        set = new HashSet<>();
        for (int i=0;i<size;i++) {
            char a = (char) ('a' + i);
            pos.add( "" +  a);
            pos4.add(a);
        }
        pos2 = new String[pos.size()];
        pos.toArray(pos2);

        pos3 = new char[pos.size()];
        for (int i =0;i<pos4.size();i++) {
            pos3[i] = pos4.get(i);
        }
        this.size = pos3.length;
    }

    public void exeMove(Move move) {
        //switch (move.type) {
            //case 0: { // s
        int type = move.type;
        if (type == 0) {
                //if (flag == 0 || flag == 3) {
                    char[] tmp = new char[size];
                    int x = move.x;
                    for (int i = 0; i < size; i++) {
                        tmp[i] = pos3[(size - x + i) % size];
                    }
                    pos3 = tmp;
                //}
                //break;
            }
            else if (type == 1) {
            //case 1: { // x
               // if (flag == 1 || flag == 3) {
                    char a = pos3[(move.x)];
                    char b = pos3[(move.y)];

                    pos3[move.x] = b;
                    pos3[move.y] = a;
                //}
                //break;
            } else {
            //case 2: { // p
               // if (flag == 2 || flag == 3) {
                    char a = move.a;
                    char b = move.b;
                    int x = -1;
                    int y = -1;
                    for (int i = 0; i < size; i++) {
                        if (x < 0 && pos3[i] == a) {
                            x = i;
                            if(y>0) {
                                break;
                            }
                        } else if (y < 0 && pos3[i] == b) {
                            y = i;
                            if(x>0) {
                                break;
                            }
                        }
                    }
                    pos3[x] = b;
                    pos3[y] = a;
              //      break;
                //}
            }
    }

    public void exeMove2(Move move) {
        switch (move.type) {
            case 0: { // s
                //if (flag == 0 || flag == 3) {
                    int size = pos2.length;
                    String[] tmp = new String[size];
                    int x = move.x;
                    for (int i = 0; i < size; i++) {
                        tmp[i] = pos2[(size-x+i)%size];
                    }
                    pos2 = tmp;
                //}
                break;
            }
            case 1: { // x
                //if (flag == 1 || flag == 3) {
                    String a = pos2[(move.x)];
                    String b = pos2[(move.y)];

                    pos2[move.x] = b;
                    pos2[move.y] = a;
                //}
                break;
            }
            case 2: { // p
                //if (flag == 2 || flag == 3) {
                    String a = move.a + "";
                    String b = move.b+ "";
                    int x = -1;
                    int y = -1;
                    for (int i=0;i<pos2.length;i++) {
                        if (x < 0 && pos2[i].equals(a)) {
                            x = i;
                        } else if(y < 0 && pos2[i].equals(b)) {
                            y = i;
                        }
                        if (x >0 && y > 0) {
                            break;
                        }
                    }
                    pos2[x] = b;
                    pos2[y] = a;
                //}
                break;
            }
        }

    }

    public void exeMove1(Move move) {
        switch (move.type) {
            case 0: { // s
                if (flag == 0 || flag == 3) {
                    int size = pos.size();
                    String[] tmp = new String[size];
                /*
                String[] tmp2 = new String[size];
                pos.toArray(tmp2);
                for (int i=0;i<pos.size();i++) {
                    tmp[i] = tmp2[((size-move.x+i)%size)];
                }
                */
                    for (int i = 0; i < size; i++) {
                        tmp[i] = pos.get((size - move.x + i) % size);
                    }
                    pos = Arrays.asList(tmp);
                }
                break;
            }
            case 1: { // x
                if (flag == 1 || flag == 3) {
                    String a = pos.get(move.x);
                    String b = pos.get(move.y);

                    pos.set(move.x, b);
                    pos.set(move.y, a);
                }
                break;
            }
            case 2: { // p
                if (flag == 2 || flag == 3) {
                    int x = pos.indexOf(move.a);
                    int y = pos.indexOf(move.b);

                    pos.set(x, move.b + "");
                    pos.set(y, move.a + "");
                }
                break;
            }
        }
    }

    public String getResult1() {
        pos.forEach(a -> r += a);
        return r;
    }

    public String getResult2() {
        for(String p : pos2) {
            r+= p +"";
        }
        return r;
    }

    public String getResult() {
        for(Character p : pos3) {
            r+= p +"";
        }
        return r;
    }
}
