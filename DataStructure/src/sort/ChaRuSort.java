package sort;

import java.util.Arrays;

public class ChaRuSort {
    public static void charuSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && temp < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;

            // 输出每一轮排序过程
            for (int aa : a) {
                System.out.print(aa + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[] a = {50, 10, 5, -9, 43, 4, 7, 3, 8, 2, 1, 6};
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(a));
        System.out.println();
        System.out.println("开始排序");
        charuSort(a);
        System.out.println("排序结束");
        System.out.println();
        System.out.println("排序之后");
        System.out.println(Arrays.toString(a));
    }
}
