package v1ch05.MyTest;

import v1ch05.equals.Employee;

import java.util.ArrayList;
import java.util.Arrays;

public class Nothing {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("wangjiaxiang", 2500, 2021, 12, 15));
        staff.add(new Employee("qwerttyuyuii", 4500, 2023, 6, 15));
        System.out.println(staff.size());
        staff.ensureCapacity(100);
        System.out.println(staff.size());
        for (Employee e : staff) {
            System.out.println(e);
        }
        Integer t = new Integer(121);
        Byte b = new Byte((byte) 1);
        int tt = Integer.valueOf("2323");
        System.out.println("tt:" + tt);

        double[] d = {3.1, 32, 34, 0, 7, -76.5, 32.3, -100.143};
        System.out.println(min(3.1, 32, 34, 0, 7, -76.5));
        System.out.println(min(d));

        Size s = Size.SMALL;
        System.out.println(s.ordinal());
        Size[] values = Size.values();
        System.out.println(Arrays.toString(values));
        Size ss = Enum.valueOf(Size.class, "EXTRA_LARGE");
        System.out.println(ss.ordinal());
        Class cl = ss.getClass();
        System.out.println(cl.getName());

    }

    public static double min(double... value) {
        double largest = Double.POSITIVE_INFINITY;
        System.out.println("Double.NEGATIVE_INFINITY=" + largest);
        for (double v : value) {
            if (v < largest) largest = v;
        }
        return largest;
    }

}

enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};