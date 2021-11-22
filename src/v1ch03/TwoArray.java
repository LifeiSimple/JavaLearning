package v1ch03;

import java.util.Arrays;

public class TwoArray {
    public static void main(String[] args) {
        double[][] balances;
//        balances = new double[10][10];
        balances = new double[][]{
                {1, 2, 3},
                {4, 5, 6, 7, 8},
                {9, 8, 7, 6}
        };
        for (double[] var : balances) {
            for (double t : var) {
                System.out.print(t);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(balances));

    }
}
