import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Assembler {

    private HashMap<String,Long> list;
    private long counter;
    private List<Long> sendList;
    private List<Long> recList;
    private Action[] actions;
    private int currentPos;
    private boolean terminated = false;

    Assembler(Action[] actions, long id) {
        list = new HashMap<>();
        list.put("p",id);
        sendList = new ArrayList<>();
        counter = 0;
        this.actions = actions;
        currentPos = 0;
    }

    public List<Long> run (List<Long> recList) {
        this.recList = recList;
        boolean running = true;
        while(running) {
            running = doAction();
        }
        return sendList;
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
                case "mod": {
                    mod(actions[currentPos].key, actions[currentPos].value);
                    break;
                }
                case "jgz": {
                    jgz(actions[currentPos].key, actions[currentPos].value);
                    break;
                }
                case "snd": {
                    snd(actions[currentPos].key);
                    break;
                }
                case "rcv": {
                    if (!rcv(actions[currentPos].key)) {
                        return false;
                    }
                    break;
                }
                case "add": {
                    add(actions[currentPos].key, actions[currentPos].value);
                    break;
                }
            }
            return true;
        } else {
            sendList = null;
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

    private void add(String key, String value) {
        if (list.containsKey(value)) {
            list.put(key,list.get(key) + list.get(value));
        } else {
            list.put(key,list.get(key) + Long.parseLong(value));
        }
        currentPos += 1;
    }


    private void mul(String key, String value) {
        if (list.containsKey(key)) {
            if (list.containsKey(value)) {
                list.put(key, list.get(key) * list.get(value));
            } else {
                list.put(key, list.get(key) * Long.parseLong(value));
            }
        } else {
            list.put(key,Long.parseLong("0"));
        }
        currentPos += 1;
    }

    private void mod(String key, String value) {
        if (list.containsKey(key)) {
            if (list.containsKey(value)) {
                list.put(key, list.get(key) % list.get(value));
            } else {
                list.put(key, list.get(key) % Long.parseLong(value));
            }
        }
        else {
            list.put(key,Long.parseLong("0"));
        }
        currentPos += 1;
    }

    private void jgz(String key, String value) {
        if (list.containsKey(key) && list.get(key) > 0 ) {
            if (list.containsKey(value)) {
                currentPos += list.get(value);
            } else {
                currentPos += Integer.parseInt(value);
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

    private void snd(String key) {
        counter++;
        if (list.containsKey(key)) {
            sendList.add(list.get(key));
        } else {
            sendList.add(Long.parseLong(key));
        }
        currentPos += 1;
    }

    private boolean rcv(String key) {
        if(!recList.isEmpty()) {
            list.put(key,recList.get(0));
            recList.remove(0);
            currentPos += 1;
            return true;
        } else {
            return false;
        }
    }

    public long getCounter() {
        return counter;
    }
}
