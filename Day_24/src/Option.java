import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Option {
    private int connector;
    int sum;
    int length;
    HashMap<String,int[]> optionList;
    private HashMap<String,int[]> next;

    Option(int connector, HashMap<String,int[]> optionList) {
        this.connector = connector;
        this.optionList = optionList;
        this.sum = connector;
        this.length = 0;
        this.next = new HashMap<>();
    }

    Option(Option option, String key) {
        this.connector = option.connector;
        this.sum = option.sum;
        this.length = option.length +1;
        this.optionList = new HashMap<>();
        this.optionList.putAll(option.optionList);
        this.next = new HashMap<>();

        int[] tmp = this.optionList.get(key);
        if (tmp[0] == connector) {
            this.connector = tmp[1];
        } else {
            this.connector = tmp[0];
        }
        this.sum += tmp[0];
        this.sum += tmp[1];
        this.optionList.remove(key);
    }

    boolean hasNext() {
        int size = optionList.keySet().size();
        String[] keySet = new String[size];
        optionList.keySet().toArray(keySet);

        for (int i=0;i<size;i++) {
            if (optionList.get(keySet[i])[0] == connector || optionList.get(keySet[i])[1] == connector) {
                next.put(keySet[i], optionList.get(keySet[i]));
            }
        }
        return (next.size() > 0);
    }

    List<Option> next() {
        int size = next.keySet().size();
        List<Option> result = new ArrayList<>();

        String[] keySet = new String[size];
        next.keySet().toArray(keySet);

        for (int i=0;i<size;i++) {
            Option tmp = new Option(this, keySet[i]);
            result.add(tmp);
        }
        return result;
    }
}
