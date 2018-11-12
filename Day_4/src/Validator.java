import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Validator {

    private int validCodes;

    public Validator() {
        validCodes = 0;
    }
    public int isValid(Path path) throws Exception {
        List<String> passCodeList = Files.readAllLines(path);

        for (String passCode : passCodeList) {
            if (isValid(passCode)) {
                validCodes++;
            }
        }
        return validCodes;
    }

    public boolean isValid(String passCode) {
        Set<String> tmpSet = new HashSet<>();
        String[] passCodeSplit = passCode.split(" ");

        for (int i=0;i<passCodeSplit.length;i++) {
            char[] ar = passCodeSplit[i].toCharArray();
            Arrays.sort(ar);
            passCodeSplit[i] = String.valueOf(ar);
        }
        tmpSet.addAll(Arrays.asList(passCodeSplit));
        if (tmpSet.size() == passCodeSplit.length) {
            return true;
        }
        return false;
    }
}
