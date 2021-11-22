package v1ch03;

import static java.lang.Math.*;

public class Welcome {
    public static void main(String[] args) {
        String greeting2 = "v1ch03.Welcome to Core Java!\u2122";
        System.out.println(greeting2);
        for (int i = 0; i < greeting2.length(); i++)
            System.out.print("=");
        System.out.println();
        double a = -1.2;
        a = a / 0;
        System.out.println(a);
        a = 9;
        System.out.println(sqrt(a));

        System.out.println("==================");

        String greeting = "Hello";
        int n = greeting.length();
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);
        int index = greeting.offsetByCodePoints(0, 4);
        int cp = greeting.codePointAt(index);
        System.out.println(cp);

        System.out.println("==================");

        int[] codePoints = greeting.codePoints().toArray();
        for (int i = 0; i < codePoints.length; i++)
            System.out.println(Integer.toHexString(codePoints[i]));

        System.out.println("==================");

        StringBuilder buider = new StringBuilder();
        buider.append("Hello");
        buider.append("World");
        String hw = buider.toString();
        System.out.println(hw);

        System.out.println("==================");

    }
}