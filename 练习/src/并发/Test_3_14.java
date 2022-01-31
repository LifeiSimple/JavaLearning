package 并发;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test_3_14 {
    public static void main(String[] args) {
        // 第一种方式，继承 Thread 类
        MyThreadTest myThread = new MyThreadTest();


        // 第二种方式，实现 Runnable 接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是 Runnable 接口中的run");
            }
        };
        Thread runnablethread = new Thread(runnable);
        runnablethread.start();

        // 第三种方式，实现 Callable 接口
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "我是 Callable 的返回结果";
            }
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread callablethread = new Thread(futureTask);
        callablethread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("我是MyThread中run方法");
    }
}
