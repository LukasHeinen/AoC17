public class Calculator2 {
    private long basewitdh;
    private long[] lastList;
    private long[] newList;
    public long result;

    public Calculator2() {
        basewitdh = 3;
        lastList = new long[] {1,2,4,5,10,11,23,25};
        result = 0;
    }

    public void calculateNextList(long checkpoint) {
        basewitdh = basewitdh + 2;
        int listLength = ((int)basewitdh-1)*4;
        newList = new long[listLength];

        boolean flag = false;
        int lastLength = lastList.length;
        for (int i=0;i<listLength;i++) {
            if (i==0) {
                newList[i] = lastList[0] + lastList[lastLength-1];
            } else if (i == 1) {
                newList[i] = lastList[0] + lastList[1] + lastList[lastLength - 1] + newList[0];

            } else if (i < (basewitdh-3)) {
                newList[i] = lastList[i-2] + lastList[i-1] + lastList[i] + newList[i-1];
            } else if (i == (basewitdh-3)) {
                newList[i] = lastList[i-2] + lastList[i-1] + newList[i-1];
            } else if (i == basewitdh-2) {
                newList[i] = lastList[i-2] + newList[i-1];
            } else if (i == basewitdh-1) {
                newList[i] = lastList[i-3] + lastList[i-2] + newList[i-1] + newList[i-2];

            } else if (i < (basewitdh-1)*2-2) {
                newList[i] = lastList[i-4] + lastList[i-3] + lastList[i-2] + newList[i-1];
            } else if (i == (basewitdh-1)*2-2) {
                newList[i] = lastList[i-4] + lastList[i-3] + newList[i-1];
            } else if (i == (basewitdh-1)*2-1) {
                newList[i] = lastList[i-4] + newList[i-1];
            } else if (i == (basewitdh-1)*2) {
                 newList[i] = lastList[i-5] + lastList[i-4] + newList[i-1] + newList[i-2];

            } else if (i < (basewitdh-1)*3-2) {
                newList[i] = lastList[i-6] + lastList[i-5] + lastList[i-4] + newList[i-1];
            } else if (i == (basewitdh-1)*3-2) {
                newList[i] = lastList[i-6] + lastList[i-5] + newList[i-1];
            } else if (i == (basewitdh-1)*3-1) {
                newList[i] = lastList[i-6] + newList[i-1];
            } else if (i == (basewitdh-1)*3) {
                newList[i] = lastList[i-7] + lastList[i-6] + newList[i-1] + newList[i-2];

            } else if (i < (basewitdh-1)*4-2) {
                newList[i] = lastList[i-8] + lastList[i-7] + lastList[i-6]+ newList[i-1];
            } else if (i == (basewitdh-1)*4-2) {
                newList[i] = lastList[i-8] + lastList[i-7] + newList[i-1] + newList[0];
            } else if (i == (basewitdh-1)*4-1) {
                newList[i] = lastList[i-8] + newList[i-1] + newList[0];
            } else {
                System.out.println("Oups--one missing");
            }

            if (newList[i] > checkpoint) {
                result = newList[i];
                break;
            }
        }
        lastList = newList;
    }

    public long getLast() {
        return lastList[lastList.length-1];
    }
}
