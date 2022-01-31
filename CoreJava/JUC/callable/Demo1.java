package JUC.callable;

import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 实现 Runnable 接口
class MyThread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread-Runnable...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 实现 Callable 接口
class MyThread2 implements Callable {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }

        return sum;
    }
}


public class Demo1 {
    public static void main(String[] args) {

        // Runnable 接口
        Thread thread1 = new Thread(new MyThread1(), "Runnable-Thread1");
        thread1.start();

        // Callable 接口
        FutureTask<Integer> callableThread = new FutureTask<Integer>(new MyThread2());

        Thread thread2 = new Thread(callableThread, "Callable-Thread2");
        thread2.start();

        try {
            System.out.println("Callable-Result" + ":" + callableThread.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
