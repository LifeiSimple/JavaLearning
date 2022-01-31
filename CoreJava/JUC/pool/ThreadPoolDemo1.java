package JUC.pool;

import java.util.concurrent.*;

// 演示线程池三种常用分类
public class ThreadPoolDemo1 {

    public static void main(String[] args) {
        // 一 池 五 线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(3);

        // 一 池 一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        // 一 池 可扩容
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            // 10 个任务
            for (int i = 0; i < 50; i++) {
                int finalI = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 正在执行任务:" + finalI);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }
}
