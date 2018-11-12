import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private Virus virus;

    @BeforeEach
    public void ini() {
        virus = new Virus(11);
    }

    @Test
    void moveCleanStartTurnLeftInfect() {
        boolean[][] input = new boolean[3][3];
        virus.setInitialState(input);
        virus.move();
        int count = virus.getCount();
        int dir = virus.getDir();

        assertTrue(count == 1);
        assertTrue(dir == 2);
    }

    @Test
    void moveInfectedStartTurnRightClean() {
        boolean[][] input = new boolean[3][3];
        input[1][1] = true;
        virus.setInitialState(input);
        virus.move();
        int count = virus.getCount();
        int dir = virus.getDir();

        assertTrue(count == 0);
        assertTrue(dir == 0);
    }

    @Test
    void example() {
        boolean[][] input = new boolean[3][3];
        input[0][2] = true;
        input[1][0] = true;
        virus.setInitialState(input);
        for (int i=0;i<70;i++) {
            virus.move();
        }
        int count = virus.getCount();
        int dir = virus.getDir();

        assertTrue(count == 41);
        assertTrue(dir == 3);
    }
}
