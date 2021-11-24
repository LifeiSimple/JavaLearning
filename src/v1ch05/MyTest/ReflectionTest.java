package v1ch05.MyTest;

import java.lang.reflect.*;
import java.util.Random;

public class ReflectionTest {
    public static void main(String[] args) {
        Test t = new Test("test");

        // 第一种方法获得类对应的 Class 类型的实例
        Class cl = t.getClass();

        System.out.println(cl);
        System.out.println(t);
        System.out.println(t.toString());
        System.out.println(t.getClass());
        System.out.println(t.getClass().getName());

        // 第二种方法获得类对应的 Class 类型的实例
        // 静态方法 forName 获得类名对应的 Class 对象
        String className = "v1ch05.MyTest.Test";
        String className2 = "java.util.Random";
//        Class cl2 = Class.forName(className2);
//        System.out.println(cl2);

        // 第三种方法获得类对应的 Class 类型的实例
        /*
         * 如果 T 是任意类型的 Java 类型（或 void 关键字），T.class 将代表匹配的类对象。
         * 一个 Class 对象实际上表示的是一个类型，这可能是类，也可能不是类。
         * 如下：int 不是类，但 int.class 是一个 Class 类型的对象。
         * */
        Class[] cl3 = {Random.class, int.class, Double[].class, Test.class};
        for (Class c : cl3) {
            System.out.println(c.getName());
        }


    }
}
