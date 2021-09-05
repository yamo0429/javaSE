package api;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Java8DateAPI {

    @Test
    public void test(){
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.getZone());

        LocalDate localDate = LocalDate.now(); // 自行点看看LocalDate里的方法
        System.out.println(localDate);

        LocalDate localDate2 = LocalDate.now(ZoneId.of("America/Panama")); // 百度以下各时区
        System.out.println(localDate2);

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Panama"));
        System.out.println(localDateTime); // 2020-09-14T08:45:20.744


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(dateTimeFormatter));
    }
    @Test
    public void test1(){

    }




}
