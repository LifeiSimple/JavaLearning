package JUC.syn;

// 创建资源类，定义属性和操作方法
class Ticket {

    // 票数
    private int number = 50;

    // 操作方法：卖票
    public synchronized void sale() {
        // 判断：是否有票
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + ": {卖出:" + number-- + "}, {剩下:" + number + "}");
        }
    }
}

// 3个售票员，30张票
public class ProducerAndConsumer {
    // 创建多个线程，调用资源类方法
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread thread_A =  new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用卖票方法
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "AA");
        Thread thread_B = new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用卖票方法
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "BB");
        Thread thread_C = new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用卖票方法
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "CC");

        thread_A.start();
        thread_B.start();
        thread_C.start();


    }

}
