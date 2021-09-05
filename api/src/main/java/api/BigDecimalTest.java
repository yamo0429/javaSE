package api;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

public class BigDecimalTest {

    /**
     * 构造方法
     */
    @Test
    public void test1() {
        String string = " 12346 ";
        BigDecimal bigDecimal = new BigDecimal(string.trim());
        BigDecimal bigDecimal2 = new BigDecimal(100);
        int i = bigDecimal2.intValue();
    }

    /**
     * 加减乘除
     */
    @Test
    public void test8() {

        BigDecimal bigDecimal = new BigDecimal(100);
        BigDecimal add = bigDecimal.add(new BigDecimal(2));
        System.out.println(add);//102
        BigDecimal subtract = bigDecimal.subtract(new BigDecimal(1));
        System.out.println(subtract);//99

        BigDecimal divide = new BigDecimal(100).multiply(new BigDecimal(2)).divide(new BigDecimal(100), 2, 1);
        BigDecimal divide1 = new BigDecimal(100).multiply(new BigDecimal(2)).divide(new BigDecimal(100));
        System.out.println(divide);
        System.out.println(divide1);
    }

    /**
     * 舍入策略、divide方法
     * public static final int ROUND_UP = 0;
     * public static final int ROUND_DOWN = 1;
     * public static final int ROUND_CEILING = 2;
     * public static final int ROUND_FLOOR = 3;
     * public static final int ROUND_HALF_UP = 4;
     * public static final int ROUND_HALF_DOWN = 5;
     * public static final int ROUND_HALF_EVEN = 6;
     * public static final int ROUND_UNNECESSARY = 7;
     */
    @Test
    public void test3() {
        BigDecimal money = new BigDecimal(12322);
        BigDecimal aa = new BigDecimal(12322).divide(new BigDecimal(100), 2);//直接舍去小数，2即ROUND_CEILING
        BigDecimal bb = new BigDecimal(12322).divide(new BigDecimal(100), 1, 2);//保留一位小数，之后的直接舍去
        BigDecimal prodPrice2 = new BigDecimal("12300.00 ".trim()).divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);//四舍五入，保留两位小数
        System.out.println(bb);

    }



    // 保留三位小数
    @Test
    public void test5() {
        BigDecimal minPrice = new BigDecimal("100").setScale(3);
        System.out.println(minPrice); // 100.000


    }

    /***
     * 比较大小：1（大于）、0（等于）、-1（小于）
     */
    @Test
    public void test4() {
        int vv = new BigDecimal(100).compareTo(new BigDecimal(122));
        System.out.println(vv);
    }

    /**
     * 格式化与解析
     */
    @Test
    public void test7() throws ParseException {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.00");
        BigDecimal bigDecimal = new BigDecimal(1234567890);
        String s = decimalFormat.format(bigDecimal).toString();
        System.out.println(s);//1,234,567,890.00

        Number parse = decimalFormat.parse("1,234,567,890.00");
        System.out.println(parse);//1234567890

    }

    /**
     * String、int、BigDecimal三者互转：
     */
    @Test
    public void test9() {
        //String——int
        int iii = Integer.parseInt("100");
        String s1 = String.valueOf(100);
        String s2 = "" + 1;

        //BigDecimal——String
        BigDecimal bigDecimal = new BigDecimal(" 12346 ".trim());
        String s = bigDecimal.toString();

        //int——BigDecimal
        BigDecimal bigDecimal2 = BigDecimal.valueOf(1234567890);
        BigDecimal bigDecimal1 = new BigDecimal(1234567890);
        int i = Integer.parseInt(bigDecimal2.toString());
        int i2 = bigDecimal2.intValue();

    }

}
