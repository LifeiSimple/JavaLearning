package JUC;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("我是一个线程");
        });

        thread.start();
    }
}
