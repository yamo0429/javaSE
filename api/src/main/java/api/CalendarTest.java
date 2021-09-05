package api;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 西方星期的开始为周日，中国为周一。
 * 在Calendar类中，月份的表示是以0-11代表1-12月
 */
public class CalendarTest {

    @Test
    public void test1() throws ParseException {

        Calendar calendar1 = Calendar.getInstance();
        // 日历对象转日期对象
         Date time1 = calendar1.getTime();
        // 指定时间
        Date parse = new SimpleDateFormat().parse("2020-10-04 15:20:00");
        calendar1.setTime(parse);

        // 设置偏移量，正加负减
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1); // 增加一年
        calendar.add(Calendar.MONTH, -2); // 减少两个月
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        calendar.add(Calendar.HOUR, -10);
        calendar.add(Calendar.MINUTE, -10);
        calendar.add(Calendar.SECOND, -10);

        // set方法。如设置时间为2020年5月20日
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 4);
        calendar.set(Calendar.DATE, 20);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

        // get方法
        int i0 = calendar.get(Calendar.YEAR);//2019
        int i1 = calendar.get(Calendar.MONTH) + 1;      //0基的
        int i2 = calendar.get(Calendar.DAY_OF_MONTH);
        int i3 = calendar.get(Calendar.DAY_OF_YEAR);
        int i4 = calendar.get(Calendar.DAY_OF_WEEK);


    }


    /**
     * 测试你活了多少天。。。只能用main方法测试键盘录入，注意Scanner只能用在main方法中！不能用在test方法中
     */

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的生日，按照格式（2017-09-20）");
        String birthString = sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(birthString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("格式错误!");
        }
        long birthTime = date.getTime();

        long currentTime = System.currentTimeMillis();

        long day = (currentTime - birthTime) / 3600 / 24 / 1000;
        System.out.println("恭喜你，活了" + day + "天！");
    }

    /**
     * compareTo 比较大小
     */
    @Test
    public void test22() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2020-04-04 23:42:11");
        Date date2 = sdf.parse("2020-04-05 23:42:11");
        int iii = date1.compareTo(date2);
        System.out.println(iii);
    }




}
