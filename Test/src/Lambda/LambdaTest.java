package Lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class LambdaTest {
    public static void main(String[] args) {

        Timer timer = new Timer(1000, event -> {
            System.out.println("At the tone, the time is " +
                    Instant.ofEpochMilli(event.getWhen()));
            Toolkit.getDefaultToolkit().beep();
        });

        timer.start();

        // keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/* 不用lambda表达式的代码如下：

public class TimerTest {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();

        // construct a timer that calls the listener
        // once every second
        Timer timer = new Timer(1000, listener);
        timer.start();

        // keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
*/