import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Interpreter {
    private HashMap<String,Long> reg;
    private List<Action> actions;
    public long result;
    public long everResult;

    Interpreter() {
        reg = new HashMap<>();
        actions = new ArrayList<>();
    }

    public void setReg(List<String> names, List<Action> actions) {
        names.forEach(a-> reg.put(a,(long) 0));
        this.actions = actions;
    }

    public void run() {
        result = Integer.MIN_VALUE;
        everResult = Integer.MIN_VALUE;

        actions.forEach(a-> {
            if (isTrue(a.condition)) {
                doAction(a);
            }
        });


        reg.values().forEach(a-> {
            if (a > result) {
                result = a;
            }
        });
        
    }

    private void doAction(Action a) {
        Long regValue = reg.get(a.key);
        switch (a.operation) {
            case "inc": {
                regValue += a.value;
                break;
            }
            case "dec": {
                regValue -= a.value;
                break;
            }
        }
        if (regValue > everResult) {
            everResult = regValue;
        }
        reg.put(a.key, regValue);
    }

    private boolean isTrue(Condition condition) {
        switch (condition.operator) {
            case ">": {
                if (reg.get(condition.key) > condition.value) {
                    return true;
                }
                break;
            }
            case "<": {
                if (reg.get(condition.key) < condition.value) {
                    return true;
                }
                break;
            }
            case ">=": {
                if (reg.get(condition.key) >= condition.value) {
                    return true;
                }
                break;
            }
            case "<=": {
                if (reg.get(condition.key) <= condition.value) {
                    return true;
                }
                break;
            }
            case "!=": {
                if (reg.get(condition.key) != condition.value) {
                    return true;
                }
                break;
            }
            case "==": {
                if (reg.get(condition.key) == condition.value) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
