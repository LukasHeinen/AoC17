import java.util.HashMap;
import java.util.LinkedList;

public class Compiler {
    HashMap<String, Action> actions;
    LinkedList<Integer> list;
    String current;
    int currentPos;
    int result;

    Compiler(HashMap<String, Action> actions) {
        this.actions = new HashMap<>();
        this.actions.putAll(actions);
        this.list = new LinkedList<>();
        this.list.add(0);
        this.currentPos = 0;
        this.current = "A";
        this.result = 0;
    }

    void run() {
        Action action = actions.get(current);
        char[] tmp = null;

        switch (list.get(currentPos)) {
            case 0: {
                tmp  = action.action.get(0);
                break;
            }
            case 1: {
                tmp  = action.action.get(1);
                break;
            }
        }
        list.add(currentPos, Integer.parseInt("" + tmp[0]));
        list.remove(currentPos+1);
        if (tmp[1] == 'r') {
            currentPos++;
        } else {
            currentPos--;
        }
        if (currentPos<0) {
            list.addFirst(0);
            currentPos = 0;
        }
        if (currentPos==list.size()) {
            list.addLast(0);
        }
        current = tmp[2] + "";
    }

    int calculateChecksum() {
        list.forEach(a -> result += a);
        return result;
    }
}
