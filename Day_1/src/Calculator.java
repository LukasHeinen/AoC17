import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Calculator {
    private int[] inputSequence;
    public long sum;
    private int fullway=0;
    private int halfway=0;

    public void loadFileInput(Path inputPath) throws Exception {
        List<String> file = Files.readAllLines(inputPath);
        String sequence = file.get(0);
        inputSequence = new int[sequence.length()];
        for(int i=0;i<sequence.length();i++) {
            inputSequence[i] = (int) sequence.charAt(i) - '0';
        }
        fullway = inputSequence.length;
        halfway = fullway / 2;
    }

    public void setInputSequence(int[] sequence) {
        inputSequence = sequence;
        fullway = inputSequence.length;
        halfway = fullway / 2;
    }

    public void calculateResultHalfwayRound() {
        sum = 0;

        for(int i=0;i<fullway;i++) {
            if (i<fullway-1) {
                if (inputSequence[i] == inputSequence[(halfway + i)%fullway]) {
                    sum += inputSequence[i];
                }
            } else {
                if (inputSequence[halfway-1] == inputSequence[i]) {
                    sum += inputSequence[i];
                }
            }
        }
    }

    public void calculateResult() {
        sum = 0;
        for(int i=0;i<inputSequence.length;i++) {
            if (i<inputSequence.length-1) {
                if (inputSequence[i] == inputSequence[i + 1]) {
                    sum += inputSequence[i];
                }
            } else {
                if (inputSequence[0] == inputSequence[i]) {
                    sum += inputSequence[0];
                }
            }
        }
    }
}
