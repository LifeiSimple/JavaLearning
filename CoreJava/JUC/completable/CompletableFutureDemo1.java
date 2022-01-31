package JUC.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 异步调用，没有返回值
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "completableFuture1");
        });

        try {
            completableFuture1.get(5, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        // 异步调用，有返回值
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "completableFuture2");
//            int i = 1/0;
            return 1024;
        });
        completableFuture2.whenComplete((t,u)->{
            System.out.println("----t="+t); // 返回值
            System.out.println("----u="+u); // 异常
        }).get();

    }
}
