import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Connector connector;

    public static void main(String args[]) throws Exception{
        List<String> input = Files.readAllLines(Paths.get("src/input.txt"));
        List<int[]> iinput = new ArrayList<>();
        for (int i=0;i<input.size();i++) {
            iinput.add(new int[] {Integer.parseInt(input.get(i).split("/")[0]),Integer.parseInt(input.get(i).split("/")[1])});
        }
        connector = new Connector(iinput);
        boolean running = true;
        while (running) {
            running = connector.iterate();
        }
        System.out.print(connector.getLongMax());
    }
}
