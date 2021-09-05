package jdk.api;

import org.junit.Test;

import java.util.Scanner;

public class StringBuilderTest {
    /**
     * StringBuilder:是一个可变的字符串。字符串缓冲区类
     * <p>
     * String和StringBuilder的区别：
     * String的内容是固定的。
     * StringBuilder的内容是可变的。
     * <p>
     * 构造方法：
     * StringBuilder()
     * <p>
     * 成员方法：
     * public int capacity():返回当前容量
     * public int length():返回长度（字符数）
     * <p>
     * 容量：理论值
     * 长度：实际值
     */
    @Test
    public void test1() {
        //创建对象
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb);
        System.out.println("sb.capacity():" + sb.capacity());
        System.out.println("sb.length():" + sb.length());
    }

    /**
     * 添加功能
     * public StringBuilder append(任意类型):添加数据，并返回自身对象
     * 反转功能
     * public StringBuilder reverse()
     */
    @Test
    public void test2() {
        //创建对象
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = sb.append("aaa");
        System.out.println("sb:" + sb + "=====" + "sb2:" + sb2 + "====sb是否等于sb2：" + (sb == sb2));

        sb.append("bbb");
        sb.append("ccc");
        sb.append(true);//任意类型均可
        sb.append(100);

        //以上步骤可以简化为链式编程
        sb.append("ddd").append("eee").append(true).append(100);
        System.out.println("sb:" + sb);


    }

    /**
     * 反转方法
     */
    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        sb.append(111).append("aaa").append(false);

        System.out.println("sb:" + sb);
        sb.reverse();
        System.out.println("sb:" + sb);
    }

    /**
     * StringBuilder -- String 互转：
     * toString()、new StringBuilder(String str)
     */

    @Test
    public void test3() {
        //StringBuilder -- String
        StringBuilder sb = new StringBuilder();
        sb.append("hello").append("world");
        String s = sb.toString();
        System.out.println(s);

        //String -- StringBuilder
        String ss = "helloworld";
        StringBuilder sb2 = new StringBuilder(ss);
        System.out.println(sb2);
    }

    /**
     * 案例：把数组拼接成一个字符串
     * 举例：
     * int[] arr = {1,2,3};
     * 结果：
     * [1, 2, 3]
     */

    @Test
    public void test5() {
        int[] arr = {1, 2, 3};

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
        StringBuilder sb = new StringBuilder();
        //[1, 2, 3]
        sb.append("[");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                sb.append(arr[x]);
            } else {
                sb.append(arr[x]).append(", ");
            }
        }
        sb.append("]");
        String result = sb.toString();
        return result;
    }

    /**
     * 案例：把字符串反转
     * <p>
     * 分析：
     * A:键盘录入一个字符串
     * B:写方法实现反转
     * String -- StringBuilder -- reverse() -- String
     * C:调用方法
     * D:输出结果
     */
    @Test
    public void test6() {
        String s = "abc";

        //调用方法
        String result = myReverse(s);

        //输出结果
        System.out.println("result:" + result);
    }

    /*
     * 两个明确：
     * 		返回值类型：String
     * 		参数列表：String
     */
    public static String myReverse(String s) {
        //String -- StringBuilder -- reverse() -- String
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String result = sb.toString();
        return result;
    }

    /**
     * 案例：判断一个字符串是否是对称字符串
     * 例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串
     * <p>
     * 分析：
     * A:键盘录入一个字符串
     * B:写方法实现判断一个字符串是否是对称字符串
     * 把字符串反转，和反转前的字符串进行比较，如果内容相同，就说明是对称字符串
     * C:调用方法
     * D:输出结果
     */
    @Test
    public void test7() {
        String s = "abc";

        //调用方法
        boolean b = isSymmetry(s);

        //输出结果
        System.out.println("b:" + b);
    }

    /*
     * 两个明确：
     * 		返回值类型：boolean
     * 		参数列表：String s
     */
    public static boolean isSymmetry(String s) {
        //把字符串反转，和反转前的字符串进行比较，如果内容相同，就说明是对称字符串
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String result = sb.toString();
        return result.equals(s);
    }

    // 转义
    @Test
    public void test459() {
        StringBuilder stringBuilder = new StringBuilder();
        String volType = "aaa";
        stringBuilder.append("volType:\"" + volType + "\"");
        System.out.println(stringBuilder.toString());

    }
}
