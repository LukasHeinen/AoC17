public class Virus {

    private int x;
    private int y;
    private int dir;
    private int count;

    private boolean[][] fields;

    Virus(int size) {
        fields = new boolean[size][size];
        x = (size-1)/2;
        y = (size-1)/2;
        dir = 3;
        count = 0;
    }

    public void setInitialState(boolean[][] input) {
        int size = input.length;

        int fieldLength = fields.length;
        int ini = (fieldLength-1)/2 - (size-1)/2;

        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                fields[ini+i][ini+j] = input[i][j];
            }
        }
    }

    public void move() {
        if (!fields[y][x]) {
            turnLeft();
            count++;
        }
        else {
            turnRight();
        }
        fields[y][x] = !fields[y][x];
        proceed();
    }

    private void turnRight() {
        dir = (dir+1) % 4;
    }

    private void turnLeft() {
        if (dir>0) {
            dir--;
        } else {
            dir = 3;
        }
    }

    private void proceed() {
        switch (dir) {
            case 0: {
                x++;
                break;
            }
            case 1: {
                y++;
                break;
            }
            case 2: {
                x--;
                break;
            }
            case 3: {
                y--;
                break;
            }
        }
    }

    public int getCount() {
        return count;
    }

    public int getDir() {
        return dir;
    }
}
