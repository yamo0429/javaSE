package jdk.api;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ##七.正则表达式
 * 1. Regex：正则表达式是用字符串写成的一种规则
 * 2. String类的方法matches匹配规则
 * 1.  案例：检查QQ号码是否合法,规则: 必须全数字,不能0开头,最低5位,最高12位
 * 2.  案例：检查手机号码是否合法,规则：必须1开头,第二位: 34578，全数字,总共11位
 * 3. String类的方法split
 * 1. 案例：切割字符串，返回数组
 * 2. 案例：切割网络ip
 */
public class RegexTest {
    @Test
    public void test1() {
        //案例：检查QQ号码是否合法,规则: 必须全数字,不能0开头,最低5位,最高12位
        String s = "112500000000";
        boolean matches = s.matches("[1-9][0-9]{4,11}");
        System.out.println(matches);
    }

    @Test
    public void test2() {
        // 案例：检查手机号码是否合法,规则：必须1开头,第二位: 34578，全数字,总共11位
        String phone = "13800138000";
        boolean matches = phone.matches("[1][34578][0-9]{9}");
        System.out.println(matches);
    }

    @Test
    public void test3() {
        String[] split = "ab,cd,,,ef,,,,,gh".split(",+");//表示一个或多个，号
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

    @Test
    public void test4() {
        String ip = "192.168.0.1";
        //\\转义字符：就是将字符原有含义，给取消掉，将.号变成普通字符，防止编译器编译
        String[] split = ip.split("\\.");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }


    @Test
    public void test6() {
        Pattern p = Pattern.compile("[acb]", Pattern.CASE_INSENSITIVE);//常量表示不区分大小写，不加则表示完全匹配
//        Matcher mm = p.matcher("A");
        Matcher mm = p.matcher("a");
        System.out.println(mm.matches());


        Pattern compile = Pattern.compile("\\w{2}");
        Matcher matcher = compile.matcher("252465");
        System.out.println(matcher.matches());
    }

}
