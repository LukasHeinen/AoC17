import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Processor {

    private HashMap<String,Long> list;
    private long counter;
    private Action[] actions;
    private int currentPos;
    private boolean terminated = false;

    Processor(Action[] actions) {
        list = new HashMap<>();
        counter = 0;
        this.actions = actions;
        currentPos = 0;
        list.put("a",(long) 1);
        list.put("b",(long) 0);
        list.put("c",(long) 0);
        list.put("d",(long) 0);
        list.put("e",(long) 0);
        list.put("f",(long) 0);
        list.put("g",(long) 0);
        list.put("h",(long) 0);
    }

    public boolean run () {
        boolean running = true;
        while(running) {
            running = doAction();
        }
        return false;
    }

    private boolean doAction() {
        if (!(currentPos < 0 || currentPos > actions.length-1|| terminated)) {
            switch (actions[currentPos].id) {
                case "set": {
                    set(actions[currentPos].key, actions[currentPos].value);
                    break;
                }
                case "mul": {
                    mul(actions[currentPos].key, actions[currentPos].value);
                    break;
                }
                case "jnz": {
                    jnz(actions[currentPos].key, actions[currentPos].value);
                    break;
                }
                case "sub": {
                    sub(actions[currentPos].key, actions[currentPos].value);
                    break;
                }
            }
            return true;
        } else {
            terminated = true;
            return false;
        }
    }

    private void set(String key, String value) {
        if (list.containsKey(value)) {
            list.put(key,list.get(value));
        } else {
            list.put(key,Long.parseLong(value));
        }
        currentPos += 1;
    }

    private void sub(String key, String value) {
        if (list.containsKey(value)) {
            list.put(key,list.get(key) - list.get(value));
        } else {
            list.put(key,list.get(key) - Long.parseLong(value));
        }
        currentPos += 1;
    }


    private void mul(String key, String value) {
        counter++;
        if (list.containsKey(value)) {
            list.put(key, list.get(key) * list.get(value));
        } else {
            list.put(key, list.get(key) * Long.parseLong(value));
        }
        currentPos += 1;
    }

    private void jnz(String key, String value) {
        if (list.containsKey(key)) {
            if (list.get(key) != 0) {
                if (list.containsKey(value)) {
                    currentPos += list.get(value);
                } else {
                    currentPos += Integer.parseInt(value);
                }
            } else {
                currentPos++;
            }
        } else {
            try {if (Integer.parseInt(key)>0) {
                currentPos += Integer.parseInt(value);
            } else {
                currentPos += 1;
            }
            } catch (Exception e) {
                currentPos++;
            }
        }
    }

    public long getCounter() {
        return list.get("h");
    }
}
