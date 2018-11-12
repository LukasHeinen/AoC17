import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception{
        List<Action> list = new ArrayList<>();
        List<String> input = Files.readAllLines(Paths.get("src/input.txt"));
        input.forEach(a -> {
            String[] items = a.split(" ");
            Action action = new Action();
            action.id = items[0];
            action.key = items[1];
            try {
                action.value = items[2];
            } catch (Exception e) {

            }
            list.add(action);
        });
        Action[] array = new Action[list.size()];
        list.toArray(array);

        Assembler a1 = new Assembler(array,0);
        Assembler a2 = new Assembler(array,1);

        boolean running = true;
        List<Long> input1 = new ArrayList<>();
        List<Long> input2;
        while (running) {
            input2 = a1.run(input1);
            input1 = a2.run(input2);
            if (input1.isEmpty() && input2.isEmpty()) {
                running = false;
            }
        }

        System.out.print(a2.getCounter());
    }
}
