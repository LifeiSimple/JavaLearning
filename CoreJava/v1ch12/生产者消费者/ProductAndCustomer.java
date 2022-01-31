package v1ch12.生产者消费者;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductAndCustomer {
    private static final List<Object> list = new ArrayList<>();

    private static void add() {
        while (true) {
            try {
                Thread.sleep(3000);
                synchronized (list) {
                    list.add(new Object());
                    System.out.println(new Date() + Thread.currentThread().getName() + " 添加了新的Object ");
                    list.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static void take() {
        while (true) {
            try {
                synchronized (list) {
                    while (list.isEmpty()) list.wait();
                    list.remove(0);
                    System.out.println(new Date() + Thread.currentThread().getName() + " 拿走了Object ");
                }
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 通过多线程编程，
        // 来模拟一个餐厅的2个厨师和3个顾客，
        // 假设厨师炒出一个菜的时间为3秒，顾客吃掉菜品的时间为4秒。

        Thread c1 = new Thread(ProductAndCustomer::add);
        c1.setName("厨师1厨师");
        Thread c2 = new Thread(ProductAndCustomer::add);
        c2.setName("厨师2厨师");
        c1.start();
        c2.start();

        Thread s1 = new Thread(ProductAndCustomer::take);
        s1.setName("顾客1");
        Thread s2 = new Thread(ProductAndCustomer::take);
        s2.setName("顾客2");
        Thread s3 = new Thread(ProductAndCustomer::take);
        s3.setName("顾客3");
        s1.start();
        s2.start();
        s3.start();

    }
}
