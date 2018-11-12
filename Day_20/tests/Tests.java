import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    private Calculator calculator;

    @BeforeEach
    public void ini() {
        calculator = new Calculator();
    }

    @Test
    void merge_3to1() {
        Particle p1 = new Particle();
        p1.pos = "-1-2-3";
        Particle p2 = new Particle();
        p2.pos = "-1-2-3";
        Particle p3 = new Particle();
        p3.pos = "-2-2-3";
        List<Particle> tmp = new ArrayList<>();
        tmp.add(p1);
        tmp.add(p2);
        tmp.add(p3);
        calculator.particles = tmp;
        calculator.merge();
        assertTrue(calculator.particles.size() == 1);
    }

    @Test
    void merge_3to0() {
        Particle p1 = new Particle();
        p1.pos = "-1-2-3";
        Particle p2 = new Particle();
        p2.pos = "-1-2-3";
        Particle p3 = new Particle();
        p3.pos = "-1-2-3";
        List<Particle> tmp = new ArrayList<>();
        tmp.add(p1);
        tmp.add(p2);
        tmp.add(p3);
        calculator.particles = tmp;
        calculator.merge();
        assertTrue(calculator.particles.size() == 0);
    }
    @Test
    void merge_3to3() {
        Particle p1 = new Particle();
        p1.pos = "-1-2-3";
        Particle p2 = new Particle();
        p2.pos = "-2-2-3";
        Particle p3 = new Particle();
        p3.pos = "-3-2-3";
        List<Particle> tmp = new ArrayList<>();
        tmp.add(p1);
        tmp.add(p2);
        tmp.add(p3);
        calculator.particles = tmp;
        calculator.merge();
        assertTrue(calculator.particles.size() == 3);
    }
}
