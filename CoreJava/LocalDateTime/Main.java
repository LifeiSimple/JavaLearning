package LocalDateTime;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
//        LocalDate d = LocalDate.now(); // 当前日期
//        LocalTime t = LocalTime.now(); // 当前时间
//        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
//        System.out.println(d); // 严格按照ISO 8601格式打印
//        System.out.println(t); // 严格按照ISO 8601格式打印
//        System.out.println(dt); // 严格按照ISO 8601格式打印

//        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
//        LocalDate d = dt.toLocalDate(); // 转换到当前日期
//        LocalTime t = dt.toLocalTime(); // 转换到当前时间


        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm ZZZZ");
        System.out.println(formatter.format(zdt));

        DateTimeFormatter zhFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm", Locale.CHINA);
        System.out.println(zhFormatter.format(zdt));

        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern("E, MMMM/dd/yyyy HH:mm", Locale.US);
        System.out.println(usFormatter.format(zdt));
    }
}
