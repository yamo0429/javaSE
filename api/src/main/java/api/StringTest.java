package jdk.api;

import org.junit.Test;

/**
 * 测试String类：构造、判断、获取、转化、去空格、分割
 */
public class StringTest {
    /**
     * String类的构造方法 ===============================================================================================
     */
    @Test
    public void test1() {
        //方式1
        //String(String original):把字符串数据封装成字符串对象
        String s1 = new String("hello");
        System.out.println("---------s1:" + s1);

        //方式2
        //String(char[] value):把字符数组的数据封装成字符串对象
        char[] chs = {'h', 'e', 'l', 'l', 'o'};
        String s2 = new String(chs);
        System.out.println("---------s2:" + s2);

        //方式3
        //String(char[] value, int index, int count):把字符数组中的一部分数据封装成字符串对象
        //String s3 = new String(chs,0,chs.length);
        String s3 = new String(chs, 1, 3);
        System.out.println("---------s3:" + s3);

        //方式4
        String s4 = "hello";
        System.out.println("---------s4:" + s4);
    }

    /**
     * 通过构造方法创建的字符串对象和直接赋值方式创建的字符串对象有什么区别呢?
     * 通过构造方法创建字符串对象是在堆内存。
     * 直接赋值方式创建对象是在方法区的常量池。
     * <p>
     * ==:
     * 基本数据类型：比较的是基本数据类型的值是否相同
     * 引用数据类型：比较的是引用数据类型的地址值是否相同
     */
    @Test
    public void test0() {
        String s1 = new String("hello");
        String s2 = "hello";

        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);

        System.out.println("s1==s2:" + (s1 == s2)); //false

        String s3 = "hello";
        System.out.println("s1==s3:" + (s1 == s3)); //false
        System.out.println("s2==s3:" + (s2 == s3)); //true
    }

    /**
     * String类的判断方法================================================================================================
     */
    @Test
    public void test2() {
        //创建字符串对象
        String s1 = "hello";
        String s2 = "hello";

        //是否包含
        System.out.println(s1.contains("el"));
        //equals(Object obj):比较字符串的内容是否相同（==：比较引用类型的地址值、比较基本类型的值）
        System.out.println(s1.equals(s2));
        //boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));
        //boolean startsWith(String str):判断字符串对象是否以指定的str开头
        System.out.println(s1.startsWith("he"));
        //boolean startsWith(String str):判断字符串对象是否以指定的str结尾
        System.out.println(s1.endsWith("ll")); //判空
        if(s2==null||s2.isEmpty()){

        }
    }

    /**
     * String类的获取方法================================================================================================
     */
    @Test
    public void test3() {
        String s = "heelloworld";

        System.out.println(s.length());//获取字符串的长度，其实也就是字符个数
        System.out.println(s.charAt(0));//获取指定索引处的字符
        System.out.println(s.indexOf("e"));//获取str在字符串对象中第一次出现的索引
        System.out.println(s.lastIndexOf("e"));//获取str在字符串对象中最后一次出现的索引

        System.out.println(s.substring(5));//从start开始截取字符串
        System.out.println(s.substring(0, s.length()));//从start开始，到end结束截取字符串
        System.out.println(s.substring(3, 8));
    }

    /**
     * 案例： 统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数
     * 字符可以直接进行比较：
     * 大写：ch>='A' && ch<='Z'
     * 小写：ch>='a' && ch<='z'
     * 数字：ch>='0' && ch<='9'
     */
    @Test
    public void test4() {
        String s = "lakj8975lfjLKJLAiouyFJLLIL2313546ERLKJljlaa82222";

        //定义三个统计变量，初始化值都是0
        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;

        //遍历字符串，得到每一个字符
        for (int x = 0; x < s.length(); x++) {
            char ch = s.charAt(x);
            //拿字符进行判断
            if (ch >= 'A' && ch <= 'Z') {
                bigCount++;
            } else if (ch >= 'a' && ch <= 'z') {
                smallCount++;
            } else if (ch >= '0' && ch <= '9') {
                numberCount++;
            } else {
                System.out.println("该字符" + ch + "非法");
            }
        }

        //输出结果
        System.out.println("大写字符：" + bigCount + "个");
        System.out.println("小写字符：" + smallCount + "个");
        System.out.println("数字字符：" + numberCount + "个");
    }

    /**
     * String类的3个转换方法 ===============================================================================================
     */
    @Test
    public void test5() {
        String s = "abcde"; //创建字符串对象
        char[] chs = s.toCharArray();                 //char[] toCharArray():把字符串转换为字符数组
        for (int x = 0; x < chs.length; x++) {
            System.out.println(chs[x]);
        }
        System.out.println("HelloWorld".toLowerCase());//String toLowerCase():把字符串转换为小写字符串
        System.out.println("HelloWorld".toUpperCase());//String toUpperCase():把字符串转换为大写字符串
    }

    /**
     * 案例：录入一个字符串，把该字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符)
     * 分析：
     * A:键盘录入一个字符串
     * B:截取首字母
     * C:截取除了首字母以外的字符串
     * D:B转大写+C转小写
     * E:输出即可
     */
    @Test
    public void test() {

        //键盘录入一个字符串
        String s = "abcde";

        //截取首字母
        String s1 = s.substring(0, 1);

        //截取除了首字母以外的字符串
        String s2 = s.substring(1);

        //B转大写+C转小写
        String s3 = s1.toUpperCase() + s2.toLowerCase(); //TODO 这样其实非常耗内存，可用StringBuilder

        //输出即可
        System.out.println("s3:" + s3);
    }

    /**
     * String类的其他方法：trim、split、replace/replaceAll===============================================================
     */
    @Test
    public void test6() {
        //创建字符串对象
        String s1 = "helloworld";
        String s2 = "  helloworld  ";
        String s3 = "  hello  world  ";
        System.out.println("---" + s1 + "---");
        System.out.println("---" + s1.trim() + "---");
        System.out.println("---" + s2 + "---");
        System.out.println("---" + s2.trim() + "---");
        System.out.println("---" + s3 + "---");
        System.out.println("---" + s3.trim() + "---");
    }

    /**
     * 案例：把数组中的数据按照指定个格式拼接成一个字符串
     * 举例：int[] arr = {1,2,3};
     * 输出结果：[1, 2, 3]
     * <p>
     * 分析：
     * A:定义一个int类型的数组
     * B:写方法实现把数组中的元素按照指定的格式拼接成一个字符串
     * C:调用方法
     * D:输出结果
     */
    @Test
    public void test7() {

        //定义一个int类型的数组
        int[] arr = {1, 2, 3};

        //写方法实现把数组中的元素按照指定的格式拼接成一个字符串

        //调用方法
        String s = arrayToString(arr);

        //输出结果
        System.out.println("s:" + s);
    }

    /*
     * 两个明确：
     * 		返回值类型：String
     * 		参数列表：int[] arr
     */
    public static String arrayToString(int[] arr) {
        String s = "";

        //[1, 2, 3]
        s += "[";
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                s += arr[x];
            } else {
                s += arr[x];
                s += ", ";
            }
        }
        s += "]";

        return s;
    }

    /**
     * 案例：字符串反转
     * 举例：键盘录入”abc”
     * 输出结果：”cba”
     * <p>
     * 分析：
     * A:键盘录入一个字符串
     * B:写方法实现字符串的反转
     * a:把字符串倒着遍历，得到的每一个字符拼接成字符串
     * b:把字符串转换为字符数组，然后对字符数组进行反转，最后在把字符数组转换为字符串
     * C:调用方法
     * D:输出结果
     */
    @Test
    public void test8() {
        //键盘录入一个字符串。。main方法可以演示键盘录入，test不行
        String s = "abcdefg";

        //写方法实现字符串的反转

        //调用方法
        String result1 = reverse1(s);
        String result2 = reverse2(s);

        //输出结果
        System.out.println("result:" + result1);
        System.out.println("result:" + result2);

    }

    //方法1：把字符串倒着遍历，得到的每一个字符拼接成字符串
    public static String reverse2(String s) {
        String ss = "";

        for (int x = s.length() - 1; x >= 0; x--) {
            ss += s.charAt(x);
        }

        return ss;
    }

    //方法2：把字符串转换为字符数组，然后对字符数组进行反转，最后在把字符数组转换为字符串
    public static String reverse1(String s) {
        //把字符串转换为字符数组
        char[] chs = s.toCharArray();

        //对字符数组进行反转
        for (int start = 0, end = chs.length - 1; start <= end; start++, end--) {
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
        }

        //最后在把字符数组转换为字符串
        String ss = new String(chs);
        return ss;
    }


    @Test
    public void test9() {
        String old = "abade";
        String replace = old.replace('a', 'k');
        System.out.println(replace);

        String old2 = "aacaad";
        String a = old2.replaceAll("aa","bb");
        System.out.println(a);

    }

    // 转义
    @Test
    public void test59() {
        String bbb = "aba|de";
        String[] split2 = bbb.split("\\|");
        for (String s : split2) {
            System.out.println(s);
        }
    }


    // 转义
    @Test
    public void test539() {
        char ddd = ' ';
        boolean whitespace = Character.isWhitespace(ddd);

    }



}
