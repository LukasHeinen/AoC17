import java.nio.ByteBuffer;

public class Generator {
    private long initialValue;
    private long multiplier;
    private long divider;
    private long mod;
    public long currentValue;


    Generator(long initialValue,long multiplier,long divider, long mod) {
        this.initialValue = initialValue;
        this.currentValue = initialValue;
        this.multiplier = multiplier;
        this.divider = divider;
        this.mod = mod;
    }

    public void gen() {
        long temp = currentValue * multiplier;
        temp = temp % divider;
        currentValue = temp;
    }

    public void gen2() {
        long temp = 3;
        while(temp % mod != 0) {
            temp = currentValue * multiplier;
            temp = temp % divider;
            currentValue = temp;
        }
    }

    public byte[] returnLastBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(currentValue);
        byte[] b = buffer.array();
        return new byte[] {b[b.length-1],b[b.length-2]};
    }

    public static boolean CompareTwoByteArrays(byte[] a, byte[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
