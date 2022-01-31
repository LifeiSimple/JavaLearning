package v1ch06.innerClass;

import java.awt.*;
import java.awt.event.*;
import java.time.*;

import javax.swing.*;

/**
 * This program demonstrates the use of inner classes.
 *
 * @author Cay Horstmann
 * @version 1.11 2017-12-14
 * @author Cay Horstmann
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        // keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock {
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     *
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start() {
        TimePrinter listener = new TimePrinter();
//        ActionListener listener = this.new TimePrinter();
//        TalkingClock.TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is "
                    + Instant.ofEpochMilli(event.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
//            if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * 局部内部类写法，将 TimePrinter 类声明在 start 方法中
     */
//    public void start()
//    {
//        class TimePrinter implements ActionListener
//        {
//            public void actionPerformed(ActionEvent event)
//            {
//                System.out.println("At the tone, the time is "
//                        + Instant.ofEpochMilli(event.getWhen()));
//                if (beep) Toolkit.getDefaultToolkit().beep();
//            }
//        }
//        TimePrinter listener = new TimePrinter();
//        Timer timer = new Timer(interval, listener);
//        timer.start();
//    }
    /**
     * 局部内部类写法，将 TimePrinter 类声明在 start 方法中
     * 局部内部类访问局部变量
     */
//    public void start(int interval,boolean beep)
//    {
//        class TimePrinter implements ActionListener
//        {
//            public void actionPerformed(ActionEvent event)
//            {
//                System.out.println("At the tone, the time is "
//                        + Instant.ofEpochMilli(event.getWhen()));
//                if (beep) Toolkit.getDefaultToolkit().beep();
//            }
//        }
//        TimePrinter listener = new TimePrinter();
//        Timer timer = new Timer(interval, listener);
//        timer.start();
//    }
}