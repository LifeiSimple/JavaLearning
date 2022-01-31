package JUC.syn;


// 1.创建资源类，定义属性和操作方法
class Share {
    // 初始值
    private int number = 0;

    // +1 的方法
    public synchronized void incr() throws InterruptedException {
        // 2.判断、干活、通知
        while (number != 0) {
            this.wait();
        }

        Thread.sleep(1000);

        number++;
        System.out.println(Thread.currentThread().getName() + "::" + number);

        // 通知其他线程
        this.notifyAll();
    }

    // -1 的方法
    public synchronized void decr() throws InterruptedException {
        // 2.判断、干活、通知
        while (number != 1) {
            this.wait();
        }

        Thread.sleep(1000);

        number--;
        System.out.println(Thread.currentThread().getName() + "::" + number);

        // 通知其他线程
        this.notifyAll();
    }
}

public class ThreadDemo1 {
    // 3.创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        Share share = new Share();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr(); // +1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-1-incr").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr(); // -1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-2-decr").start();
    }
}
