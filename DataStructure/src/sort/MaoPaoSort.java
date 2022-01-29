package sort;

import java.util.Arrays;

public class MaoPaoSort {
    public static void maopaoSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    flag = false;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if (flag) break;

            for (int aa : a) {
                System.out.print(aa+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[] a = {5, 4, 7, 3, 8, 2, 1, 6};
        System.out.println(Arrays.toString(a));
        maopaoSort(a);
        System.out.println(Arrays.toString(a));
    }
}
