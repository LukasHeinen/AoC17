import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Runner {

    private int pos;
    private List<int[]> setting;
    private List<Integer> firewall;
    private List<Integer> walls;
    private int max;
    private long risk;

    Runner() {
        pos = -1;
        risk = 0;
        setting = new ArrayList<>();
        firewall = new ArrayList<>();
        walls = new ArrayList<>();
    }
    public void set(List<int[]> setting) {
        this.setting = setting;
        max = setting.get(setting.size()-1)[0];
        for (int i=0;i<=max;i++) {
            firewall.add(0);
        }
        setting.forEach(a ->  {
            walls.add(a[0]);
        });
    }

    public long calcRisk() {
        long tmp = risk;
        risk = 0;
        pos = -1;
        risk = 0;
        firewall = new ArrayList<>();
        walls = new ArrayList<>();
        max = setting.get(setting.size()-1)[0];
        for (int i=0;i<=max;i++) {
            firewall.add(0);
        }
        setting.forEach(a ->  {
            walls.add(a[0]);
        });
        return tmp;
    }

    public void setPause(int pause) {
        pos = -pause-1;
    }

    public boolean move() {
        pos++;
        if (walls.contains(pos) && firewall.get(pos) == 0) {
            risk += pos*setting.get(walls.indexOf(pos))[1];
            if (risk == 0) {
                risk = 1;
            }
        }

        for (int i=0;i<firewall.size();i++) {
            if (!walls.contains(i)) {
                 firewall.set(i,firewall.get(i) + 1);
            } else {
                int ind = walls.indexOf(i);
                int mod = setting.get(ind)[1]*2-2;
                int tmp = (firewall.get(i)+1)%mod;
                firewall.set(i,tmp);
            }
        }

        if (pos == max) {
            return false;
        }
        return true;
    }

    public long calcMin() {
        int count =1;
        boolean found = false;
        while (!found) {
            found = true;
            inner:
            for (int i=0;i<setting.size();i++) {
                int mod = setting.get(i)[1]*2-2;
                if ((count + setting.get(i)[0]) % mod == 0) {
                    count++;
                    found = false;
                    break inner;
                }
            }
        }
        return count;
    }
}
