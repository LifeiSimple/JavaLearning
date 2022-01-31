package JUC.juc;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// 6 辆汽车，停 3 个车位
public class SemaphoreDemo1 {
    public static void main(String[] args) {
        // 创建 Semaphore，设置信号量
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {

            new Thread(() -> {

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到了车位");

                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));

                    System.out.println(Thread.currentThread().getName() + " --- 离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }, String.valueOf(i+1)).start();

        }

    }
}
