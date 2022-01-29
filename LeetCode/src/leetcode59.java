import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class leetcode59 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int count = 0;


        return matrix;
    }

    public static void printMatrix(int[][] matrix) {

    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }

        // 顺时针打印出来
        printMatrix(matrix);
    }
}
