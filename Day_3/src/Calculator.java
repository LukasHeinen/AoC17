public class Calculator {
    private long[] centerPoints;
    private long baseWidth = 1;

    long result = 0;

    public Calculator() {
        centerPoints = new long[4];
    }

    public void calculate(long point) {

        while(baseWidth*baseWidth < point) {
            baseWidth +=2;
        }
        long area = baseWidth*baseWidth;

        long min = Integer.MAX_VALUE;
        for (int i=0;i<4;i++) {
            centerPoints[i] = area - (baseWidth-1)/2 - i*(baseWidth-1);
            if (Math.abs(centerPoints[i]-point) < min) {
                min = Math.abs(centerPoints[i]-point);
            }
        }

        result = (baseWidth-1)/2+min;
    }
}
