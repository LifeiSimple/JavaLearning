package v1ch03;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = new int[100];
        System.out.println(a.length);
        for (int var : a) {
            System.out.print(var);
        }
        System.out.println();
        System.out.println("=================");
        int[] b = {2, 5, 4, 3, 1};
        for (int var : b) {
            System.out.print(var);
        }
        System.out.println();
        b = new int[]{1, 2, 3, 4, 52, 3, 4, 52, 3, 4, 5};
        for (int var : b) {
            System.out.print(var);
        }
        System.out.println();
        System.out.println(Arrays.toString(b));
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        int[] t = new int[7];
        System.out.println(Arrays.toString(t));
        int setLocation = Arrays.binarySearch(t,9);
        System.out.println(setLocation);
        System.out.println(Arrays.toString(t));
    }
}
