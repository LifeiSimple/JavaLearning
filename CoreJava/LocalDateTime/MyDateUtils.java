package LocalDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyDateUtils {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.of(2022, 7, 22, 1, 24, 45);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Date myDate = Date.from(zonedDateTime.toInstant());

//        System.out.println("测试选择的时刻：" + localDateTime);
//
//        System.out.println("测试选择的年份：" + localDateTime.getYear());
//
//        System.out.println("测试选择的月份：" + localDateTime.getMonth());
//
//        System.out.println("测试选择的日份：" + localDateTime.getDayOfMonth());
//
//        System.out.println("测试选择的时：" + localDateTime.getHour());
//
//        System.out.println("测试选择的分：" + localDateTime.getMinute());
//
//        System.out.println("测试选择的秒：" + localDateTime.getSecond());
//
//        System.out.println(compareDate(localDateTime));

        System.out.println(compareNowAndInRoomTime(myDate));

    }

    public static String compareDate(LocalDateTime beginDateTime) {
        LocalDateTime nowDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN); // 当前日期和时间
        String dateTimeString = "";
        Duration duration = Duration.between(nowDateTime, beginDateTime);

        if (duration.toDays() == 0) dateTimeString = "今日";
        else if (duration.toDays() == -1 ) dateTimeString = "昨日";
        else if (duration.toDays() == 1) dateTimeString = "明日";
        else dateTimeString = DateTimeFormatter.ofPattern("yyyy年M月d日").format(beginDateTime);

        System.out.println("========================================================");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("LocalDateTime_now:\t\t" + dateTimeFormatter.format(nowDateTime));
        System.out.println("LocalDateTime_begin:\t" + dateTimeFormatter.format(beginDateTime));
        System.out.println("========================================================");


        return beginDateTime.getHour() + ":" + beginDateTime.getMinute() + "/" + dateTimeString;
    }

    /**
     * 赛事列表返回前端时间格式转换
     *
     * 9:08/今日
     *
     * @param beginTime 赛事开始时间
     * @return
     */
    public static String compareNowAndBegin(Date beginTime) {
        LocalDateTime nowDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN); // 当前日期和时间
        String dateTimeString = "";
        LocalDateTime beginDateTime = LocalDateTime.ofInstant(beginTime.toInstant(), ZoneId.systemDefault());
        Duration duration = Duration.between(nowDateTime, beginDateTime);
        Period period = Period.between(nowDateTime.toLocalDate(), beginDateTime.toLocalDate());
        if (period.getYears()==0) {
            if (duration.toDays() == 0) dateTimeString = "今日";
            else if (duration.toDays() == -1 ) dateTimeString = "昨日";
            else if (duration.toDays() == 1) dateTimeString = "明日";
            else dateTimeString = DateTimeFormatter.ofPattern("M月d日").format(beginDateTime);
        } else dateTimeString = DateTimeFormatter.ofPattern("yyyy年M月d日").format(beginDateTime);

        String timeString = DateTimeFormatter.ofPattern("HH:mm").format(beginDateTime);

//        System.out.println("========================================================");
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println("LocalDateTime_now:\t\t" + dateTimeFormatter.format(nowDateTime));
//        System.out.println("LocalDateTime_begin:\t" + dateTimeFormatter.format(beginDateTime));
//        System.out.println("========================================================");


        return timeString + "/" + dateTimeString;
    };

    /**
     * 赛事详情 —— 开赛时间
     *
     * @param begindate 赛事开始时间
     * @return
     */
    public static String matchDetailBeginDate(Date begindate) {
        LocalDateTime beginDateTime = LocalDateTime.ofInstant(begindate.toInstant(), ZoneId.systemDefault());
        LocalDateTime nowDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN); // 当前日期和时间
        Duration duration = Duration.between(nowDateTime, beginDateTime);
        Period period = Period.between(nowDateTime.toLocalDate(), beginDateTime.toLocalDate());
        String dateTimeString = "";
        if (period.getYears()==0) {
            if (duration.toDays() == 0) dateTimeString = "今日";
            else if (duration.toDays() == -1 ) dateTimeString = "昨日";
            else if (duration.toDays() == 1) dateTimeString = "明日";
            else dateTimeString = DateTimeFormatter.ofPattern("M月d日").format(beginDateTime);
        } else dateTimeString = DateTimeFormatter.ofPattern("yyyy年M月d日").format(beginDateTime);
        return dateTimeString;
    }

    /**
     * 赛事详情 —— 进度状态
     *
     * @param statime 比赛开始时间
     * @param signupTime 报名时间
     * @param inroomTime 进入房间时间
     * @return
     */
    public static int progressSta(Date statime, Date signupTime, Date inroomTime) {

        // 状态 0 [-,开始报名] 1 [开始报名,进入房间] 2 [进入房间,比赛开始] 3 [比赛开始,-]
        int sta = 0;
        // 比赛开始时间
        LocalDateTime staDateTime = LocalDateTime.ofInstant(statime.toInstant(), ZoneId.systemDefault());
        // 报名时间
        LocalDateTime signupDateTime = LocalDateTime.ofInstant(signupTime.toInstant(), ZoneId.systemDefault());
        // 进入房间时间
        LocalDateTime inroomDateTime = LocalDateTime.ofInstant(inroomTime.toInstant(), ZoneId.systemDefault());
        // 当前系统时间
        LocalDateTime nowDateTime = LocalDateTime.now();


        if (nowDateTime.compareTo(signupDateTime)>=0 && nowDateTime.compareTo(inroomDateTime)<0) return 1;
        if (nowDateTime.compareTo(inroomDateTime) >=0 && nowDateTime.compareTo(staDateTime)<0) return 2;
        if (nowDateTime.compareTo(staDateTime)>=0) return 3;

        return sta;
    }

    /**
     * 转换时间，获取日期中的时间
     * 12:30
     *
     * @param date 待转换的时间
     * @return
     */
    public static String getHHmm(Date date) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return dateTimeFormatter.format(dateTime);
    }

    /**
     * 组队报名成功页面
     * 进入房间时间
     *
     * 今日/明日/7月20日/2023年7月2日
     *
     * @param inRoomTime 进入房间时间
     * @return
     */
    public static String compareNowAndInRoomTime(Date inRoomTime) {
        LocalDateTime nowDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN); // 当前日期和时间
        String dateTimeString = "";
        LocalDateTime beginDateTime = LocalDateTime.ofInstant(inRoomTime.toInstant(), ZoneId.systemDefault());
        Duration duration = Duration.between(nowDateTime, beginDateTime);
        Period period = Period.between(nowDateTime.toLocalDate(), beginDateTime.toLocalDate());
        if (period.getYears() == 0) {
            if (duration.toDays() == 0) dateTimeString = "今日";
            else if (duration.toDays() == -1 ) dateTimeString = "昨日";
            else if (duration.toDays() == 1) dateTimeString = "明日";
            else dateTimeString = DateTimeFormatter.ofPattern("M月d日").format(beginDateTime);
        } else dateTimeString = DateTimeFormatter.ofPattern("yyyy年M月d日").format(beginDateTime);

        String timeString = DateTimeFormatter.ofPattern("HH:mm").format(beginDateTime);
        return dateTimeString+timeString;
    }

}
