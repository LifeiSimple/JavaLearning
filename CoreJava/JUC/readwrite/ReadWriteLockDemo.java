package JUC.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 资源类
class MyCache {

    // 创建 map 集合
    private volatile Map<String, Object> map = new HashMap<>();

    // 创建读写锁对象
    private ReadWriteLock rwlock = new ReentrantReadWriteLock();


    // 放数据
    public void put(String key, Object value) {

        // 添加写锁
        rwlock.writeLock().lock();

        // 暂停一会
        try {
            System.out.println(Thread.currentThread().getName() + " 正在写操作" + key);

            TimeUnit.MILLISECONDS.sleep(300);

            // 放数据
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写完了" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }


    }

    // 取数据
    public Object get(String key) {
        // 添加读锁
        rwlock.readLock().lock();
        Object result = null;

        try {

            System.out.println(Thread.currentThread().getName() + " 正在读取操作" + key);
            // 暂停一会
            TimeUnit.MILLISECONDS.sleep(300);

            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "取完了" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }

        return result;
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        // 创建线程放数据
        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> {
                myCache.put(num + "", num + "");
            }, String.valueOf(i)).start();

        }

        // 创建线程取数据
        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> {
                myCache.get(num + "");
            }, String.valueOf(i)).start();

        }
    }

}