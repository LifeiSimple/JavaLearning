package JUC.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 1. 创建资源类
class ShareResource {
    // 标志位
    // AA:1 BB:2 CC:3
    private int flag = 1;

    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    // 打印 5 次，参数第几轮
    public void print5(int loop) {
        lock.lock();

        try {
            // 判断
            while (flag != 1) {
                c1.await();
            }
            // 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + ":轮数" + loop);
            }
            // 通知
            flag = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 打印 10 次，参数第几轮
    public void print10(int loop) {
        lock.lock();

        try {
            // 判断
            while (flag != 2) {
                c2.await();
            }
            // 干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + ":轮数" + loop);
            }
            // 通知
            flag = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 打印 15 次，参数第几轮
    public void print15(int loop) {
        lock.lock();

        try {
            // 判断
            while (flag != 3) {
                c3.await();
            }
            // 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + ":轮数" + loop);
            }
            // 通知
            flag = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class ThreadDemo3 {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5(i);
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10(i);
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15(i);
            }
        }, "CC").start();
    }

}
