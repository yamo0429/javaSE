package dateTimeAPI;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateTimeAPITest {

    @Test
    public void te11st() {
    }

    @Test
    public void te11s2t() {//TODO 其他：Instant、Clock、until方法
    }

    @Test
    public void te111st() {//ZonedDateTime是带有时区的日期时间，存储纳秒、时差、时区
        System.out.println(ZonedDateTime.now());//2020-12-02T22:28:00.570+08:00[Asia/Shanghai]
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Paris")));//2020-12-02T15:28:00.570+01:00[Europe/Paris]
        System.out.println(ZonedDateTime.parse("2020-12-02T15:28:00.570+01:00[Europe/Paris]"));
    }

    @Test
    public void te1121st() {//获取间隔-Period：只用于日期
        LocalDate aaa = LocalDate.now();
        LocalDate bbb = LocalDate.of(2020, 12, 12);
        Period ccc = Period.between(aaa, bbb);
        System.out.println(ccc);
        System.out.printf("年龄：%d 年 %d 月 %d 天", ccc.getYears(), ccc.getMonths(), ccc.getDays());
        System.out.println(ccc.isNegative());
    }

    @Test
    public void te1221st() {//获取间隔-Duration：日期时间、日期、时间均可。注意：Duration无年月间隔API
        LocalDateTime aaa = LocalDateTime.of(2020, 12, 1, 20, 33, 2, 999);
        LocalDateTime bbb = LocalDateTime.of(2020, 12, 1, 20, 33, 22, 999);
        System.out.println(Duration.between(aaa, bbb).toDays());
        System.out.println(Duration.between(aaa, bbb).toHours());
        System.out.println(Duration.between(aaa, bbb).getSeconds());

        LocalDate ccc = LocalDate.of(1993, 11, 20);
        LocalDate ddd = LocalDate.of(2020, 11, 20);
        System.out.println(Duration.between(ccc, ddd).toHours());

        LocalTime eee = LocalTime.of(10, 10, 10);
        LocalTime fff = LocalTime.of(12, 10, 10);
        System.out.println(Duration.between(eee, fff).toHours());
        System.out.println(Duration.between(aaa, bbb).getSeconds());
    }

    @Test
    public void te2st() {//获取间隔-ChronoUnit：日期时间、日期、时间均可
        LocalDateTime aaa = LocalDateTime.of(2020, 11, 1, 20, 33, 12, 999);
        LocalDateTime bbb = LocalDateTime.of(2021, 12, 1, 20, 33, 12, 999);
        System.out.println(ChronoUnit.YEARS.between(aaa, bbb));
        System.out.println(ChronoUnit.MONTHS.between(aaa, bbb));
        System.out.println(ChronoUnit.DAYS.between(aaa, bbb));
        System.out.println(ChronoUnit.SECONDS.between(aaa, bbb));
        LocalDate ccc = LocalDate.of(1993, 11, 20);
        LocalDate ddd = LocalDate.of(2020, 11, 20);
        System.out.println(ChronoUnit.YEARS.between(ccc, ddd));
        LocalTime eee = LocalTime.of(10, 10, 10);
        LocalTime fff = LocalTime.of(12, 10, 10);
        System.out.println(ChronoUnit.SECONDS.between(eee, fff));
    }

    @Test
    public void t3est() {//新旧日期类转换
        Instant aaa = new Date().toInstant();
        //旧->新：方法1
        LocalDateTime bbb = LocalDateTime.ofInstant(aaa, ZoneId.systemDefault());
        System.out.println(bbb);
        System.out.println(bbb.toLocalDate());
        System.out.println(bbb.toLocalTime());
        //旧->新：方法2
        System.out.println(ZonedDateTime.ofInstant(aaa, ZoneId.systemDefault()).toLocalDateTime());
        System.out.println(ZonedDateTime.ofInstant(aaa, ZoneId.systemDefault()).toLocalDate());
        System.out.println(ZonedDateTime.ofInstant(aaa, ZoneId.systemDefault()).toLocalTime());
        //新->旧
        ZonedDateTime ccc = LocalDateTime.now().atZone(ZoneId.systemDefault());
        System.out.println(Date.from(ccc.toInstant()));
        ZonedDateTime ddd = LocalDate.now().atStartOfDay(ZoneId.systemDefault());
        System.out.println(Date.from(ddd.toInstant()));
        //注意无LocalTime->Date，因为无日期信息
    }

    @Test
    public void t5est() {//parse
        //TODO 注意不同类型的日期或时间，必须用对应的解析类的parse方法
        System.out.println(LocalDateTime.parse("2020-12-02 10:20:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDate.parse("2020-12-02 10:20:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalTime.parse("2020-12-02 10:20:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDate.parse("2020/12/02", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        System.out.println(LocalTime.parse("112233", DateTimeFormatter.ofPattern("HHmmss")));
        System.out.println(LocalDateTime.parse("2020-12-02T22:22:22.999"));//999纳秒可以不加
    }

    @Test
    public void tes3t() {//format
        LocalDateTime aaa = LocalDateTime.now();
        System.out.println(aaa.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));//2020-12-02 21:27:06
        System.out.println(aaa.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(aaa.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(aaa.format(DateTimeFormatter.ISO_LOCAL_DATE));//2020-12-02 二者相同
        System.out.println(aaa.format(DateTimeFormatter.ISO_DATE));//2020-12-02
        System.out.println(aaa.format(DateTimeFormatter.ISO_TIME));//21:27:06.776
        System.out.println(aaa.format(DateTimeFormatter.ISO_DATE_TIME));//2020-12-02T21:27:06.776
        System.out.println(aaa.format(DateTimeFormatter.ISO_ORDINAL_DATE));//2020-337
        System.out.println(aaa.format(DateTimeFormatter.ISO_WEEK_DATE));//2020-W49-3
        System.out.println(aaa.format(DateTimeFormatter.BASIC_ISO_DATE));//20201202
    }

    @Test
    public void te112st() {//with：单独重置年月日时分秒
        LocalDateTime bbb = LocalDateTime.now();
        System.out.println(bbb.withMinute(20));

        LocalDate aaa = LocalDate.now();
        System.out.println(aaa.withMonth(2));

        LocalTime ccc = LocalTime.now();
        System.out.println(ccc.withSecond(30));
    }

    @Test
    public void te1st() {//比较大小
        System.out.println(LocalTime.now().isBefore(LocalTime.of(22, 22, 22)));
        System.out.println(LocalDate.now().isAfter(LocalDate.of(2020, 12, 12)));
        System.out.println(LocalDateTime.now().isEqual(LocalDateTime.of(2020, 12, 12, 10, 11, 20, 999)));
    }

    @Test
    public void t2est() {//日期时间增减
        LocalDateTime aaa = LocalDateTime.now();
        System.out.println(aaa);
        System.out.println(aaa.minusDays(1));//昨日当前时刻
        System.out.println(aaa.minusMonths(2));//-2月
        System.out.println(aaa.plusYears(2));//+2年
        System.out.println(aaa.plusWeeks(3));//+3周
        System.out.println(aaa.plus(1, IsoFields.QUARTER_YEARS));
    }

    @Test
    public void te3st() {//获取1970以来毫秒值的几种方式
        long bbb = Calendar.getInstance().getTimeInMillis();
        long ccc = System.currentTimeMillis();
        long ddd = Clock.systemDefaultZone().millis();

    }

    @Test
    public void te4st() {//LocalTime
        LocalTime aaa = LocalTime.now();
        System.out.println(aaa);
        LocalTime bbb = LocalTime.of(12, 13, 14, 999);
        System.out.println(bbb);
        System.out.println(LocalTime.now().toSecondOfDay());//时间转成秒数，int类型
        System.out.println(LocalTime.ofSecondOfDay(10000));//秒数转成时间
    }

    @Test
    public void tes5t() {//LocalDate
        LocalDate aaa = LocalDate.now();
        System.out.println(LocalDate.now(ZoneId.of("Asia/Kolkata")));
        LocalDate bbb = LocalDate.of(2020, Month.APRIL, 1);
        LocalDate ccc = LocalDate.of(2020, 4, 1);
        System.out.println(LocalDate.of(aaa.getYear(), aaa.getMonth(), 2));//指定本月第二天
        System.out.println(LocalDate.of(aaa.getYear() + 1, aaa.getMonth(), 5));//明年本月第五天
        System.out.println(LocalDate.ofYearDay(2020, 100));//2020第100天的日期
        System.out.println(LocalDate.of(2020, 11, 11).getDayOfMonth());//某日是一年/月/周的第几天
        System.out.println(aaa.with(TemporalAdjusters.lastDayOfMonth()));//本月最后一天
        System.out.println(aaa.with(TemporalAdjusters.lastDayOfYear()));//本年最后一天

    }

    @Test
    public void t6est() {//LocalDateTime
        LocalDateTime aaa = LocalDateTime.now();
        LocalDateTime bbb = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        LocalDateTime ccc = LocalDateTime.of(2020, Month.DECEMBER, 2, 20, 33, 12, 999);
        LocalDateTime ddd = LocalDateTime.of(2020, 12, 2, 20, 33, 12, 999);
        LocalDateTime eee = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(aaa.getYear());
        System.out.println(aaa.getMonth());//DECEMBER
        System.out.println(aaa.getMonthValue());//12
        System.out.println(aaa.getDayOfMonth());
        System.out.println(aaa.getDayOfYear());
        System.out.println(aaa.getMinute());
        System.out.println(aaa.getSecond());

        LocalDate localDate = aaa.toLocalDate();
        LocalTime localTime = aaa.toLocalTime();



    }
}
