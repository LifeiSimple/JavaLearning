package JUC.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 1.创建资源类，定义属性和操作方法
class Share {
    private int number = 0;

    // 创建 Lock
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void incr() {
        lock.lock();
        try {
            // 判断
            while (number != 0) {
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            // 通知
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    public void decr() {
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            // 通知
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
}

public class ThreadDemo2 {
    // 3.创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        Share share = new Share();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                share.incr(); // +1
            }
        }, "thread-1-incr").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                share.decr(); // -1
            }
        }, "thread-2-decr").start();
    }
}
