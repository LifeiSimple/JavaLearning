package JUC.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer> {

    // 拆分差值不能超过 10
    private static final Integer VALUE = 10;

    private int begin; // 拆分开始值
    private int end; // 拆分结束值
    private int result; // 返回结果

    // 创建有参数构造
    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    // 拆分和合并过程
    @Override
    protected Integer compute() {
        // 判断相加两个数是否大于10
        if ((end - begin) <= VALUE) {
            // 相加操作
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
            System.out.println("当前线程:"+Thread.currentThread().getName()+" 相加操作::范围(" + begin + ":" + end + ")");
        } else {
            // 进一步拆分
            // 获取中间值
            int middle = (begin + end) / 2;
            // 拆分左边
            MyTask task01 = new MyTask(begin, middle);
            // 拆分右边
            MyTask task02 = new MyTask(middle + 1, end);
            task01.fork();
            task02.fork();

            result = task01.join() + task02.join();
        }

        return result;
    }
}

public class ForkJoinDemo1 {

    public static void main(String[] args) {
        // 创建 MyTask 对象
        MyTask myTask = new MyTask(0, 100);
        // 创建分支合并池对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);

        // 获取最终合并之后的结果
        Integer result = null;
        try {
            result = forkJoinTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        // 关闭池对象
        forkJoinPool.shutdown();
    }
}
