import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public long result;

    private long[] banks;
    private int banksLength;
    private Set<String> previousBanks;

    public void setBanks(long[] banks) {
        result = 0;
        this.banks = banks;
        banksLength = banks.length;
        previousBanks = new HashSet<>();
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
        if (max > banksLength-1) {
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
            banks[pos]=0;
            while (max!= 0) {
                pos++;
                banks[pos%banksLength] += 1;
                max--;
            }
        }

        return previousBanks.add(Arrays.toString(banks));
    }
}

