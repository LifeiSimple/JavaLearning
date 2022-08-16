package lambda_learn;

import java.util.function.IntConsumer;

public class Lambda01 {

    public static void main(String[] args) {

        foreachArr(System.out::println);

    }

    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }

}
