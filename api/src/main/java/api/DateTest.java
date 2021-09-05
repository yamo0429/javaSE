package api;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    @Test
    public void test(){

        long time2 = new Date().getTime();
        Date date = new Date(1520100000000L);

    }
    @Test
    public void te3st() throws ParseException {

        // compareTo比较date大小
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2020-04-04 23:42:21");
        Date date2 = sdf.parse("2020-04-05 23:42:11");
        int iii = date1.compareTo(date2);
        System.out.println(iii);
    }

}
