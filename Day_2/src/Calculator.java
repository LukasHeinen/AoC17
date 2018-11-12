import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public long sum;
    private List<int[]> lines;

    public Calculator() {
        lines = new ArrayList<>();
        sum = 0;
    }

    public boolean readInputSequence(Path filePath) {
        try {
            List<String> fileLines = Files.readAllLines(filePath);
            for (int i = 0; i < fileLines.size(); i++) {
                String[] values = fileLines.get(i).split(" ");
                int[] array = new int[values.length];
                for (int j = 0; j < values.length; j++) {
                    array[j] = Integer.parseInt(values[j]);
                }
                lines.add(array);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void calculate() {
        for(int[] line : lines) {
            int length = line.length;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i=0;i<length;i++) {
                if (line[i] < min) {
                    min = line[i];
                }
                if (line[i]> max) {
                    max = line[i];
                }
            }
            sum += max-min;
        }
    }

    public void calculateDivision() {
        for(int[] line : lines) {
            int length = line.length;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i=0;i<length;i++) {
                if (line[i] < min) {
                    min = line[i];
                }
                if (line[i]> max) {
                    max = line[i];
                }
            }
            for(int i=0;i<length;i++) {
                int tmp = 0;
                if (line[i] != max) {
                    tmp = line[i];
                    outerLoop:
                    for (int j=0;j<length;j++) {
                        if (line[j] != tmp) {
                            if (line[j]%tmp ==0) {
                                sum += line[j]/tmp;
                                break outerLoop;
                            }
                        }
                    }
                }
            }
        }
    }
}
