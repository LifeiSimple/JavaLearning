package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) return;

        int k = arr[start];
        int low = start;
        int high = end;

        while (low < high) {
            while (low < high && k <= arr[high]) high--;
            arr[low] = arr[high];
            while (low < high && k >= arr[low]) low++;
            arr[high] = arr[low];
        }
        arr[low] = k;

        //输出每一轮排序过程
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        quickSort(arr, start, low - 1);
        quickSort(arr, high + 1, end);

    }

//    // 输出每一轮排序过程
//            for (int a : arr) {
//        System.out.print(a + " ");
//    }
//            System.out.println();

    public static void main(String[] args) {
        int[] arr = {10, 9, 5, 3, 4, 7, 8, 2, 1, 6};
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("开始排序");
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序结束");
        System.out.println();
        System.out.println("排序之后");
        System.out.println(Arrays.toString(arr));
    }
}
