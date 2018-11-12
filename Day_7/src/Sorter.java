import java.util.*;

public class Sorter {
    public long changeValue;
    private Program master;
    public String masterName;
    private Program wrongChild;
    private int correctValue;
    private int maxDepth;
    private HashMap<String,Program> programs;

    public void setPrograms(HashMap<String, Program> programs) {
        this.programs = programs;
        maxDepth = Integer.MIN_VALUE;
    }

    public void setParents() {
        Program[] programArray = new Program[programs.values().size()];
        programs.values().toArray(programArray);
        for (Program p : programArray) {
            if (p.subProgramNames.size() > 0) {
                p.subProgramNames.forEach(s -> {
                    Program tmp = programs.get(s);
                    tmp.parent = p.name;
                    p.subPrograms.add(tmp);
                    programs.put(tmp.name, tmp);
                });
            }
        }

        for (Program p : programArray) {
            if (p.parent == null) {
                masterName = p.name;
                p.depth = 0;
                programs.put(p.name,p);
                break;
            }
        }
    }

    public void tree() {
        master = new Program();
        master = programs.get(master);
        Program[] array = new Program[programs.values().size()];
        programs.values().toArray(array);

        while (!allSet()) {
            for (Program p : array) {
                if (p.depth != 1000) {
                    p.subPrograms.forEach(a-> {
                        a.depth = p.depth + 1;
                        if (a.depth > maxDepth) {
                            maxDepth = a.depth;
                        }
                        programs.put(a.name,a);
                    });

                }
            }
        }

        loop:
        for (int i =maxDepth-1;i>-1;i--) {
            for (Program p : array) {
                if (p.depth == i && p.subPrograms.size() > 0) {
                    if (validChildren(p)) {
                        p.subPrograms.forEach(a -> p.number += a.number);
                    } else {
                        getWrongChild(p);
                        changeValue = correctValue - wrongChild.subPrograms.size()*wrongChild.subPrograms.iterator().next().number;
                        break loop;
                    }
                }
            }
        }
    }

    private void getWrongChild(Program p) {
        int a[] = new int[] {0,0} ;
        int b[] = new int[] {0,0} ;

        for (Program c : p.subPrograms) {
            if (a[0] == 0) {
                a[0] = c.number;
                a[1] = 1;
            } else if (a[0] == c.number) {
                a[1]++;
            } else {
                b[0] = c.number;
                b[1]++;
            }
        }
        int tmp;
        if (a[1]<b[1]) {
            tmp = a[0];
            correctValue =b[0];
        } else {
            tmp = b[0];
            correctValue =a[0];
        }

        for (Program c : p.subPrograms) {
            if (c.number == tmp) {
                wrongChild = c;
            }
        }
    }

    private boolean validChildren(Program p) {
        Set<Integer> tmp = new HashSet<>();
        p.subPrograms.forEach(a->tmp.add(a.number));
        if (tmp.size() == 1) {
            return true;
        }
        return false;
    }

    private boolean allSet() {
        Program[] array = new Program[programs.values().size()];
        programs.values().toArray(array);
        for (Program p : array) {
            if (p.depth == 1000) {
                return false;
            }
        }
        return true;
    }
}
