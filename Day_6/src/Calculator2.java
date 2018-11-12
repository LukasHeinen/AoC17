import java.util.Arrays;
import java.util.HashMap;


public class Calculator2 {
    public long result;

    private long[] banks;
    private int banksLength;
    private HashMap<String,Long> previousBanks;

    public void setBanks(long[] banks) {
        result = 0;
        this.banks = banks;
        banksLength = banks.length;
        previousBanks = new HashMap<>();
    }

    public void run() {
        boolean done = false;
        while (!done) {
            done = !recalculate();
        }
    }

    private boolean recalculate() {
        result++;
        long max = Integer.MIN_VALUE;
        int pos = 0;
        long share;
        long res;

        for (int i = 0; i < banksLength; i++) {
            if (banks[i] > max) {
                max = banks[i];
                pos = i;
            }
        }
        if (max > banksLength - 1) {
            share = (max - max % (banksLength - 1)) / (banksLength - 1);
            res = max % (banksLength - 1);
            for (int i = 0; i < banksLength; i++) {
                if (i == pos) {
                    banks[i] = res;
                } else {
                    banks[i] += share;
                }
            }
        } else {
            banks[pos] = 0;
            while (max != 0) {
                pos++;
                banks[pos % banksLength] += 1;
                max--;
            }
        }

        if (!previousBanks.containsKey(Arrays.toString(banks))) {
            previousBanks.put(Arrays.toString(banks), result);
            return true;
        } else {
            result = result - previousBanks.get(Arrays.toString(banks));
            return false;
        }
    }
}

