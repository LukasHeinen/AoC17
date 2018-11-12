import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String sequence;
    public long result;
    public long result2;

    Calculator() {
        result = 0;
        result2 = 0;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public void run() {
        removeByBang();
        removeInnerBrackets();
        calculateResult();
    }

    private void calculateResult() {
        result = 0;
        List<Integer> count = new ArrayList<>();
        char[] cArray = sequence.toCharArray();

        int depth = 0;
        for (char c : cArray) {
            if (c == '{') {
                if (count.size()>depth) {
                    count.set(depth,count.get(depth)+1);
                } else {
                    count.add(1);
                }
                depth++;
            } else if(c == '}') {
                depth--;
            }
        }
        for(int i=0;i<count.size();i++) {
            result += (i+1)*count.get(i);
        }

        //String sub = sequence.substring(1,sequence.length()-1);
        //String[] subs = sub.split(",");


        //System.out.println();
    }

    private void removeByBang() {
        char[] cArray = sequence.toCharArray();
        List<Character> tmp = new ArrayList<>();

        for (int i=0;i<cArray.length;i++) {
            if (cArray[i] != '!') {
                tmp.add(cArray[i]);
            } else {
                i+=1;
            }
        }
        Character[] t = new Character[tmp.size()];
        tmp.toArray(t);
        sequence = "";
        for (Character c : t)
            sequence += c.toString();
    }

    private void removeInnerBrackets() {
        char[] cArray = sequence.toCharArray();
        List<Character> tmp = new ArrayList<>();

        for (int i=0;i<cArray.length;i++) {
            if (cArray[i] != '<') {
                tmp.add(cArray[i]);
            } else {
                do {
                    result2++;
                    i++;
                }while (cArray[i] != '>');
                result2--;
            }
        }
        Character[] t = new Character[tmp.size()];
        tmp.toArray(t);
        sequence = "";
        for (Character c : t)
            sequence += c.toString();
    }
}
