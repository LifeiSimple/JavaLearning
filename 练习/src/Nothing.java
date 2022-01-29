import Implement.MITest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Nothing implements Person, Named {
    public static void main(String[] args) {

        MITest test = new MITest("wangjiaxiang");

        System.out.println(test.testString("2333"));
        BigDecimal x = new BigDecimal("1.0");
        BigDecimal y = new BigDecimal("1.00");
        System.out.println(x.equals(y));
        System.out.println(x.compareTo(y));
        Nothing nt = new Nothing();
        System.out.println(nt.getName());
        String[] a = {"sfsf", "fsdfsdf", "afdq", "sdqwd"};
        Arrays.sort(a, new LengthComparator());
        System.out.println(Arrays.toString(a));
        Object o = new Object();

        String aa = "wangjiaxiang";
        System.out.println(aa.hashCode());
        aa = "wangjiaxiangd";
        System.out.println(aa.hashCode());
    }

    @Override
    public String getName() {
        return Named.super.getName();
    }
}

interface Person {
    default String getName() {
        return "";
    }
}

interface Named {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}

class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

class jisuan {
    public static void main(String[] args) {
        double a = 1;
        Scanner sin = new Scanner(System.in);
        double year = sin.nextDouble();

        while (year-- > 0) {
            a = a + a * 0.05;
        }
        System.out.println(a);

    }
}