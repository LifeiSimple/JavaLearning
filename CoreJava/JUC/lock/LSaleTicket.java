package JUC.lock;

import java.util.concurrent.locks.ReentrantLock;

class LTicket {

    private int number = 60;

    // 创建可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    public void sale() {
        // 上锁
        lock.lock();

        try {
            // 方法
            if (number > 30) {
                System.out.println(Thread.currentThread().getName() + ": {卖出:" + number + "}, {剩下:" + number + "}");
                number--;
            }
        } finally {
            // 解锁
            lock.unlock();
        }

    }

}

public class LSaleTicket {
    public static void main(String[] args) {
        LTicket ticket = new LTicket();

        Thread thread_A = new Thread(() -> {
            // 调用卖票方法
            for (int i = 0; i < 30; i++) {
                ticket.sale();

            }
        }, "AA");
        Thread thread_B = new Thread(() -> {
            // 调用卖票方法
            for (int i = 0; i < 30; i++) {
                ticket.sale();

            }
        }, "BB");
        Thread thread_C = new Thread(() -> {
            // 调用卖票方法
            for (int i = 0; i < 30; i++) {
                ticket.sale();

            }
        }, "CC");

        thread_A.start();
        thread_B.start();
        thread_C.start();
    }

}
