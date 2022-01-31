package v1ch09.shuffle;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 *
 * @author Cay Horstmann
 * @version 1.12 2018-04-10
 */

/**
 * 程序用 1~49 之间的 49 个 Integer 对象填充数组。
 * 然后，随机地打乱列表，并从打乱后的列表中选前 6 个值。
 * 最后再将选择的数值进行排序并打印。
 */
public class ShuffleTest {
    public static void main(String[] args) {
        int count = 5;
        while (count-- >0) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int i = 1; i <= 49; i++)
                numbers.add(i);
            Collections.shuffle(numbers);
            List<Integer> winningCombination = numbers.subList(0, 6);
            Collections.sort(winningCombination);
            System.out.println(winningCombination);
        }
    }
}
