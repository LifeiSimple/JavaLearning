package v1ch04;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

public class InstanceAndClass {
    public static void main(String[] args) {
        Date dayetime = new Date();
        String s = dayetime.toString();
        System.out.println(dayetime);
        System.out.println(s);

        LocalDate newYearsEve = LocalDate.of(1999, 12, 31);
        System.out.println(newYearsEve);
        newYearsEve = LocalDate.now();
        System.out.println(newYearsEve);
        System.out.println(newYearsEve.getDayOfWeek());
        System.out.println(newYearsEve.minusDays(-4));

    }
}
