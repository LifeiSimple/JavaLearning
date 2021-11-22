package v1ch04;

import java.util.*;

/**
 * This program demonstrates object construction.
 *
 * @author Cay Horstmann
 * @version 1.02 2018-04-10
 */
public class ConstructorTest2 {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
    }
}

class Employee {
    private static int nextId;

    private int id;
    private String name = ""; // instance field initialization
    private double salary;

    // static initialization block


    // object initialization block
    {
        System.out.println("object initialization block");
        System.out.println("id_before:" + id);
        id = nextId;
        nextId++;
        System.out.println("id_after:" + id);
        System.out.println("nextId:" + nextId);
        System.out.println("name:" + name);
        System.out.println("salary:" + salary);
    }

    static {
        System.out.println("static initialization block");

        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);

        System.out.println("nextId:" + nextId);

    }

    // three overloaded constructors
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        // calls the Employee(String, double) constructor
        this("Employee #" + nextId, s);
    }

    // the default constructor
    public Employee() {
        // name initialized to ""--see above
        // salary not explicitly set--initialized to 0
        // id initialized in initialization block
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
