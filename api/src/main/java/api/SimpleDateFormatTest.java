package api;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    @Test
    public void test() throws ParseException {

        // long - date
        long time2 = new Date().getTime();
        Date date = new Date(1520100000000L);

        // string - date
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Date parseDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-10-04 15:20:00");

    }

}
