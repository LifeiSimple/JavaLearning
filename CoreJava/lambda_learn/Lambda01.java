package lambda_learn;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class Lambda01 {

    public static void main(String[] args) {

        /*
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是匿名内部类的写法");
                }
            }).start();

            new Thread(() -> System.out.println("我是 lambda 表达式的写法")).start();
         */

        /*
        int i = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println(i);
        */

        /*
        printNum(value -> value % 2 == 0);
        */



    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }

    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }


}
