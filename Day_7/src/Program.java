import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {
    String name;
    String parent;
    int number;
    int depth = 1000;

    long sum = 0;
    Set<String> subProgramNames;
    Set<Program> subPrograms;

    Program() {
        subProgramNames = new HashSet<>();
        subPrograms = new HashSet<>();
    }
}
