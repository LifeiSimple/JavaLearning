package v1ch12.threads;

/**
 * @author Cay Horstmann
 * @version 1.30 2004-08-01
 */
public class ThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(4, 100000); // 初始化4个账户，每个账户金额100000
        Runnable task1 = () ->
        {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
            }
        };

        Runnable task2 = () ->
        {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
            }
        };

        Thread thread1 = new Thread(task1);
        thread1.setName("线程1");
        thread1.start();
        Thread thread2 = new Thread(task2);
        thread2.setName("线程2");
        thread2.start();


    }
}
