import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class Jumper {
    long result;
    private long[] actions;
    private int currentPos;

    public void initialize(Path path) throws Exception {
        currentPos = 0;
        result = 0;
        List<String> lines = Files.readAllLines(path);
        actions = new long[lines.size()];
        int length = lines.size();
        for(int i=0;i<length;i++) {
            actions[i] = Long.parseLong(lines.get(i));
        }
    }

    public void setActions(long[] actions) {
        currentPos = 0;
        result = 0;
        this.actions = actions;
    }

    public void run() {
        boolean done = false;
        while (!done) {
            done = !jump();
        }
    }

    private boolean jump() {
        result++;
        if(currentPos + actions[currentPos]>actions.length-1 || currentPos + actions[currentPos]<0) {
            return false;
        } else {
            if(actions[currentPos]>=3) {
                actions[currentPos] -=1;
                currentPos += actions[currentPos] + 1;
            } else {
                actions[currentPos] += 1;
                currentPos += actions[currentPos] - 1;
            }
            return true;
        }
    }
}
