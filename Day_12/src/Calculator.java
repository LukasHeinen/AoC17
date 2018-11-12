import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Calculator {
    private List<Set<Integer>> list;
    private HashMap<Integer,Integer> dict;
    private List<List<Integer>> links;
    public long num;

    Calculator() {
        list = new ArrayList<>();
        dict = new HashMap<>();
        links = new ArrayList<>();

        num = 0;
    }

    public static void main1(String args[]) throws Exception {
        Calculator calc = new Calculator();

        List<String> list = Files.readAllLines(Paths.get("src/input.txt"));
        list.forEach(a -> calc.add(a));
        calc.getGroupSize(0);
        System.out.print(calc.num);
    }

    public static void main(String args[] ) throws Exception {
        List<Item> l = new ArrayList<>();
        Calculator calc = new Calculator();

        List<String> strings = Files.readAllLines(Paths.get("src/input.txt"));

        strings.forEach(a -> {
            String[] t = a.split(" <-> ");
            Integer key = Integer.parseInt(t[0]);
            List<Integer> tmp = new ArrayList<>();
            String[] s1 = t[1].split(", ");
            for (String s2 : s1) {
                tmp.add(Integer.parseInt(s2));
            }
            Item item = new Item();
            item.key = key;
            item.neibours = tmp;

            l.add(item);
        });
        calc.add(l);
        while (l.size()>0) {
            calc.list.get(calc.list.size()-1).forEach(a-> {
                for (Item i : l) {
                    if (i.key == a) {
                        l.remove(i);
                        break;
                    }
                }
            });
            //l.removeAll(calc.list.get(calc.list.size()-1));
            if (l.size()>0) {
                calc.add(l);
            }
        }

        calc.getGroupSize(0);
        System.out.println(calc.num);
        System.out.println(calc.list.size());
    }
    public void add(String s) {
        String[] a = s.split(" <-> ");
        Integer key = Integer.parseInt(a[0]);
        List<Integer> tmp = new ArrayList<>();
        String[] s1 = a[1].split(", ");
        for (String s2 : s1) {
            tmp.add(Integer.parseInt(s2));
        }

        if(!addToList(key,tmp)) {
            list.add(new HashSet<Integer>());
            list.get(list.size()-1).add(key);
            dict.put(key,list.size()-1);
            addRest(key,tmp);
        }
    }

    public void add(List<Item> s) {
        int size = s.size();
        Set<Integer> tmp = new HashSet<>();
        tmp.add(s.get(0).key);
        for(int i=0;i<s.size();i++) {
            for (int j=0;j<size;j++){
                int test = j;
                for(int n : s.get(j).neibours) {
                    if (tmp.contains(n)) {
                        tmp.add(s.get(test).key);
                        tmp.addAll(s.get(test).neibours);
                    }
                }
            }
        }
        list.add(tmp);
    }

    private boolean addToList(Integer key, List<Integer> tmp) {
        int tmpL = tmp.size();
        int listL = list.size();

        for (int i = 0; i < tmpL; i++) {
            List<Integer> link = new ArrayList<>();
            for (int j = 0; j < listL; j++) {
                if (list.get(j).contains(tmp.get(i))) {
                    link.add(j);
                }
            }
            if (link.size()> 1) {
                list.get(link.get(0)).add(key);
                dict.put(key, link.get(0));
                addRest(key, tmp);
                links.add(link);
                return true;
            }
        }
        return false;
    }

    private void addRest(Integer key,List<Integer> tmp) {
        tmp.forEach(a-> {
            list.get(dict.get(key)).add(a);
        });
    }

    public void getGroupSize(Integer l) {
        int listL = list.size();
        Set<Integer> tmp = new HashSet<>();
        for (int i=0;i<listL;i++) {
            if (list.get(i).contains(l)) {
                tmp.add(i);
                break;
            }
        }
        while(true) {
            int t = tmp.size();
            Set<Integer> copy = new HashSet<>();
            tmp.forEach(a -> {
                links.forEach(b-> {
                    if (b.contains(a)) {
                        copy.addAll(b);
                    }
                });
            });
            tmp.addAll(copy);
            if (t == tmp.size()) {
                break;
            }
        }
        tmp.forEach(a -> num += list.get(a).size());
    }
}
