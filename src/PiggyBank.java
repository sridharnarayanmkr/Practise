import java.util.*;

public class PiggyBank {
    public static Scanner in;

    public static void main(String [] args) {
        run();
    }

    private static void run() {
        in = new Scanner (System.in);
        int testCase;
        int n, weight;
        int [] max = new int [10000];
        int [] v = new int [500];
        int [] W = new int [500];

        testCase = in.nextInt();
        while (testCase > 0) {
            weight = -(in.nextInt() - in.nextInt());
            Arrays.fill(max, -1);
            max[0] = 0;
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                v[i] = in.nextInt();
                W[i] = in.nextInt();
            }
            for (int i = 0; i < weight; i++) {
                if (max[i] != -1) {
                    for (int j = 0; j < n; j++) {
                        int tmpw = W[j] + i;
                        int tmpv = v[j] + max[i];
                        if (tmpw <= weight && (max[tmpw] == -1 || max[tmpw] > tmpv)) {
                            max[tmpw] = tmpv;
                        }
                    }
                }
            }
            if (max[weight] == -1) {
                System.out.println("This is impossible.");
            } else {
                System.out.println("The minimum amount of money in the piggy-bank is " + max[weight] + ".");
            }
            testCase--;
        }
    }
}