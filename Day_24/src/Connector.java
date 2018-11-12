import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Connector {
    private List<Option> options;
    private List<Option> finalList;
    int max = Integer.MIN_VALUE;
    int length = 0;

    Connector(List<int[]> ini) {
        finalList = new ArrayList<>();
        options = new ArrayList<>();
        HashMap<String,int[]> max = new HashMap<>();
        for (int i=0;i<ini.size();i++) {
            max.put("" + i, ini.get(i));
        }

        for (int i=0;i<ini.size();i++) {
            if (ini.get(i)[0] == 0) {
                HashMap<String,int[]> tmp = new HashMap<>();
                tmp.putAll(max);
                tmp.remove(""+i);
                options.add(new Option(ini.get(i)[1],tmp));
            } else if (ini.get(i)[1] == 0) {
                HashMap<String,int[]> tmp = new HashMap<>();
                tmp.putAll(max);
                tmp.remove(""+i);
                options.add(new Option(ini.get(i)[0],tmp));
            }
        }
    }

    boolean iterate() {
        List<Option> deleteList = new ArrayList<>();
        List<Option> addList = new ArrayList<>();
        options.forEach(a -> {
            if (!a.hasNext()) {
                finalList.add(a);
            } else {
                addList.addAll(a.next());
            }
            deleteList.add(a);
        });
        options.removeAll(deleteList);
        options.addAll(addList);
        if(options.isEmpty()) {
            return false;
        }
        return true;
    }

    int getMax() {
        finalList.forEach(a -> {
            if (a.sum > max) {
                max = a.sum;
            }
        });
        return max;
    }

    int getLongMax() {
        finalList.forEach(a -> {
            if (a.length > length) {
                max = a.sum;
            } else {
                if (a.length == length) {
                    if (a.sum > max) {
                        max = a.sum;
                        length = a.length;
                    }
                }
            }
        });
        return max;
    }
}
