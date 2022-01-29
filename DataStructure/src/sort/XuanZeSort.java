package sort;

import java.util.Arrays;

public class XuanZeSort {
    public static void xuanzeSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int pos = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j]<min) {
                    min = a[j];
                    pos = j;
                }
            }

            int temp = a[i];
            a[i]=a[pos];
            a[pos]=temp;

            // 输出每一轮排序过程
            for (int aa : a) {
                System.out.print(aa + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[] a = {10, 5, 3, 4, 7, 8, 2, 1, 6};
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(a));
        System.out.println();
        System.out.println("开始排序");
        xuanzeSort(a);
        System.out.println("排序结束");
        System.out.println();
        System.out.println("排序之后");
        System.out.println(Arrays.toString(a));
    }
}
