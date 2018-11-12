import java.util.*;

public class Calculator {
    List<Particle> particles;
    private HashMap<String,Particle> positions;
    private int min;
    private int pos;
    Calculator(){
        particles = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public int min() {
        for (int i= 0;i<particles.size();i++) {
            if (Math.abs(particles.get(i).accX) + Math.abs(particles.get(i).accY) + Math.abs(particles.get(i).accZ) < min) {
                min = Math.abs(particles.get(i).accX) + Math.abs(particles.get(i).accY) + Math.abs(particles.get(i).accZ);
                pos = i;
            }
        }
        return pos;
    }

    public int collide() {
        while(!validate()) {
            jump();
            merge();
        }
        return particles.size();
    }

    public boolean validate() {

        for (int i=0;i<particles.size();i++) {
            if (!particles.get(i).flag) {
                return false;
            }
        }

        List<Particle> dist = new ArrayList<>();
        List<Particle> acc = new ArrayList<>();

        dist.addAll(particles);
        acc.addAll(particles);

        //dist.sort( new Comparator<Particle>() {
        Collections.sort(dist,new Comparator<Particle>() {
            @Override
            public int compare(Particle o1, Particle o2) {
                if (o1.dist > o2.dist) {
                    return 1;
                } else if (o1.dist < o2.dist) {
                    return -1;
                }
                if (o1.dist == o2.dist) {
                    return Integer.compare(o1.acc, o2.acc);
                }
                return 0;
            }
        });

        acc.sort(new Comparator<Particle>() {
            @Override
            public int compare(Particle o1, Particle o2) {
                if (o1.acc > o2.acc) {
                    return 1;
                } else if (o1.acc < o2.acc) {
                    return -1;
                }
                if (o1.acc == o2.acc) {
                    return Integer.compare(o1.dist, o2.dist);
                }
                return 0;
            }
        });

        for (int i=0;i<dist.size();i++) {
            if (!(dist.get(i).pos.equals(acc.get(i).pos))) {
                return false;
            }
        }
        return true;
    }

    public void jump() {
        particles.forEach(a-> {
            a.velX += a.accX;
            a.velY += a.accY;
            a.velZ += a.accZ;
            a.posX += a.velX;
            a.posY += a.velY;
            a.posZ += a.velZ;
            int tmp = Math.abs(a.posX) + Math.abs(a.posY) + Math.abs(a.posZ);
            if (tmp > a.dist) {
                a.flag = true;
            }
            a.dist = tmp;
            a.pos = "" + a.posX + a.posY + a.posZ;
        });
    }

    public void merge() {
        positions = new HashMap<>();
        List<Particle> toDelete = new ArrayList<>();

        particles.forEach(a-> {
            if (positions.containsKey(a.pos)) {
                toDelete.add(a);
                toDelete.add(positions.get(a.pos));
            } else {
                positions.put(a.pos,a);
            }
        });
        particles.removeAll(toDelete);
    }

}
