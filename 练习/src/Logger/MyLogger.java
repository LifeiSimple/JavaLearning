package Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
    private int number_a;
    private int number_b;

    MyLogger(int a, int b) {
        number_a = a;
        number_b = b;
    }

    public int IntSum() {
        Logger.getGlobal().info("2");
        Thread.dumpStack();
        return number_a + number_b;
    }

    public static void main(String[] args) {
//        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("1");
        System.out.println("这是字符串输出");
        MyLogger ml = new MyLogger(1,2);
        System.out.println(ml.IntSum());
//        Logger.getLogger()
        Logger myLogger = Logger.getLogger("logger1");
        myLogger.setLevel(Level.FINE);
    }
}

