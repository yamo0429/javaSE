package jdk.api;

import org.junit.Test;

/**
 * Java推出了8个基本类型的包装类：基本类型——String——包装类之间的转换，共3对（包括自动装箱和拆箱），以下以Integer为例
 * Byte(byte)、Short(short)、Integer(int)、Long(long)、Float(float)、Double(double)、Character(char)、Boolean(boolean)
 */
public class WrapperTest {
    /**
     * String、int、Integer三者互转：
     */
    @Test
    public void test1() {

        //String——int
        int iii = Integer.parseInt("100");
        String s1 = String.valueOf(100);
        String s2 = "" + 1;

        //String——Integer
        Integer integer = Integer.valueOf("100");
        String s3 = integer.toString();

        //int——Integer
        Integer integer2 = Integer.valueOf(100);
        Integer integer4 = new Integer(100);
        Integer integer3 = 100;                     //自动装箱：基本类型变成对象
        int aa = new Integer("100");             //自动拆箱：对象变成基本类型

    }


    @Test
    public void test2() {
        Integer i1 = new Integer(200);
        Integer i2 = new Integer(200);

        System.out.println(i1 == i2); // false
        System.out.println(i1.equals(i2)); //true，因为Integer重写了equals方法

        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(200 == i4); //false,自动装箱
        System.out.println(i3.equals(i4));//true

        Integer i5 = 100;
        Integer i6 = 100;

        /**
         * 1. 如果int的取值在byte范围（-128 ~ 127），会先去缓存中取，如果有则直接返回，如果没有就创建
         * 2. 如果int的取值不在此范围，直接创建对象
         */
        System.out.println(i5 == i6); //true
        System.out.println(i5.equals(i6));//true
    }

    @Test
    public void test3(){

    }


}
