import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        List<String> l = Files.readAllLines(Paths.get("src/input.txt"));
        List<String[]> al = new ArrayList<>();
        HashMap<String,Action> actions = new HashMap<>();
        int last = 0;
        for (int i=0;i<l.size();i++) {
            if (l.get(i).equals("")) {
                String[] tmp = new String[i-last-1];
                for (int j=1;j<tmp.length+1;j++) {
                    tmp[j-1] =l.get(i-tmp.length+j-1);
                }
                al.add(tmp);
                last = i;
            } if (i == l.size()-1) {
                i++;
                String[] tmp = new String[i-last-1];
                for (int j=1;j<tmp.length+1;j++) {
                    tmp[j-1] =l.get(i-tmp.length+j-1);
                }
                al.add(tmp);
            }
        }
        int count = Integer.parseInt(al.get(0)[0].split("Perform a diagnostic checksum after ")[1].split(" steps.")[0]);

        al.remove(0);
        al.forEach(a -> {
            Action tmp = new Action();

            String id = a[0].split("In state ")[1].substring(0,1);
            char[] a1 = new char[] {a[2].split("    - Write the value ")[1].charAt(0),a[3].split("    - Move one slot to the ")[1].charAt(0),a[4].split("    - Continue with state ")[1].charAt(0)};
            char[] a2 = new char[] {a[6].split("    - Write the value ")[1].charAt(0),a[7].split("    - Move one slot to the ")[1].charAt(0),a[8].split("    - Continue with state ")[1].charAt(0)};
            tmp.action.add(a1);
            tmp.action.add(a2);
            actions.put(id, tmp);
        });

        Compiler compiler = new Compiler(actions);
        for (int i=0;i<count;i++) {
            compiler.run();
        }
        System.out.println(compiler.calculateChecksum());
    }
}
