package v1ch06.interfaces;

import java.util.*;

/**
 * This program demonstrates the use of the Comparable interface.
 *
 * @author Cay Horstmann
 * @version 1.30 2004-02-27
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        // Arrays.sort()    static void sort(Object[] a)
        // 要求数组中的元素必须属于实现了 Comparable 接口的类
        // 并且元素之间必须是可以比较的
        Arrays.sort(staff);

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}
