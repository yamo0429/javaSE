package base;

import org.junit.Test;

/**
 * 运算符：对常量和变量进行操作的符号称为运算符
 * 表达式：用运算符把常量或者变量连接起来符合java语法的式子就可以称为表达式。不同运算符连接的式子体现的是不同类型的表达式。定义两个int类型的变量a,b，做加法(a + b)
 */
public class OperationSymbol {

    /**
     * 算数运算符
     * 1 数据精度问题
     * 取余和除这两种计算，整数和小数各有不同：
     * 整数取余/相除，只能得到整数，要想得到小数，就必须有浮点数参与运算。TODO 浮点数运算时，由于进制转换，经常导致损失精度，这是计算所无法避免的问题，务必注意
     */
    @Test
    public void test11(){
        float aa = 10.3F;
        float cc = aa%3;
        System.out.println(cc); // 1.3000002，原因是计算时无法避免的精度问题，是计算机计算时常见现象

        float aaa =10.4F;
        System.out.println(aaa/3); // 3.4666665
        System.out.println(3.4666665*3); // 10.3999995
    }

    /**
     * 2 字符和字符串参与加法操作
     * 字符参与运算：其实是拿该字符对应的数值来操作
     * 字符串参与运算：这里其实做的不是加法运算，而是字符串拼接。字符串和其他类型的数据做拼接，结果是字符串类型的
     */
    @Test
    public void test112(){
        int a = 10;
        // 字符参与加法操作
        char c = '0';
        char c2 = 'a';
        System.out.println((char) 98);
        System.out.println(a + c);
        System.out.println(a + c2);

        System.out.println(c + "hello");
    }

    /**
     * ++ 和 --
     * 单独使用的时候，++或者--无论是放在变量的前面还是后面，结果是一样的
     * 参与操作的时候：
     * 如果++或者--在变量的后面，先拿变量参与操作，后变量做++或者--
     * 如果++或者--在变量的前面，先变量做++或者--，后拿变量参与操作
     */
    @Test
    public void test1912(){
        int aa = 10;
        int bb = 20;
        int cc = 30;
        int dd = 40;
        System.out.println(aa++);  // 10
        System.out.println(aa);  // 11

        System.out.println(bb--);  // 20
        System.out.println(bb); // 19

        System.out.println(cc);  // 30
        System.out.println(++cc);  // 31

        System.out.println(dd);  // 40
        System.out.println(--dd);  // 39

    }

    /**
     * 位移运算符
     * 所谓位移，指的是该十进制数的二进制形式向左或右移动（即乘以/除以2），溢出部分都被舍弃
     * 注意：
     *  1 byte和short属于低精度整型，不适合做无符号右移（>>>）
     *  2 右移运算对正数和负数的两种不同处理方式：
     *   负数右移：高位补1（表示符号负），保证还是负数。溢出部分舍弃
     *   正数右移：高位补0（表示符号正），保证还是正数。溢出部分舍弃
     */
    @Test
    public void test13(){
        int aa = 10,bb = 1;
        aa >>= bb;
        System.out.println(aa); // 5
    }

    @Test
    public void test81(){
        int aa = 10;
        System.out.println(aa >>> 1); // 将原数的二进制数向右移移两位（即除以两个2），并舍去非整余数
        System.out.println(aa << 1); // 将原数的二进制数向左移移一位（即乘以一个2）
    }

    // byte和short属于低精度整型，不适合做无符号右移（>>>）
    @Test
    public void test12(){
        byte aa = (byte)(-32 >>> 1);
        System.out.println(aa); // -16
        short bb = (short)(-128 >>> 4);
        System.out.println(bb); // -8

    }
    /**
     * 逻辑运算符：用于连接关系表达式。
     * &,|,^,!
     * &&,||
     *
     * 与：&	有false则false
     * 或：|	有true则true
     * 异或：^ 相同则false,不同则true。(男女朋友)
     * 非：!	true则false,false则true
     */
    @Test
    public void test1712(){
        int a = 10;
        int b = 20;
        int c = 30;

        System.out.println((a>b) & (a>c));// false & false
        System.out.println((a<b) & (a>c)); // true & false
        System.out.println((a>b) & (a<c)); // false & true
        System.out.println((a<b) & (a<c)); // true & true
        System.out.println("---------------");
        System.out.println((a>b) | (a>c));// false | false
        System.out.println((a<b) | (a>c)); // true | false
        System.out.println((a>b) | (a<c)); // false | true
        System.out.println((a<b) | (a<c)); // true | true
        System.out.println("---------------");
        System.out.println((a>b) ^ (a>c));// false ^ false
        System.out.println((a<b) ^ (a>c)); // true ^ false
        System.out.println((a>b) ^ (a<c)); // false ^ true
        System.out.println((a<b) ^ (a<c)); // true ^ true
        System.out.println("---------------");
        System.out.println((a>b)); // false
        System.out.println(!(a>b)); // !false
        System.out.println(!!(a>b)); // !!false
    }

    /**
     * &&和&的区别?	最终结果一样。&&具有短路效果。左边是false，右边不执行。&是无论左边是false还是true,右边都会执行
     * ||和|的区别?	最终结果一样。||具有短路效果.左边是true,右边不执行，|是无论左边是false还是true,右边都会执行
     */
    @Test
    public void test142(){
        int a = 10;
        int b = 20;
        int c = 30;

        System.out.println((a>b) && (a>c));// false && false
        System.out.println((a<b) && (a>c)); // true && false
        System.out.println((a>b) && (a<c)); // false && true
        System.out.println((a<b) && (a<c)); // true && true
        System.out.println("---------------");
        System.out.println((a>b) || (a>c));// false || false
        System.out.println((a<b) || (a>c)); // true || false
        System.out.println((a>b) || (a<c)); // false || true
        System.out.println((a<b) || (a<c)); // true || true
        System.out.println("---------------");

        int x = 3;
        int y = 4;
        // System.out.println((x++ > 4) & (y++ > 5)); // false & false
        System.out.println((x++ > 4) && (y++ > 5)); // false && false
        System.out.println("x:" + x);
        System.out.println("y:" + y);
    }

    /**
     * 三元运算符
     * (关系表达式)?表达式1：表达式2；
     * 如果条件为true，运算后的结果是表达式1；
     * 如果条件为false，运算后的结果是表达式2；
     */
    @Test
    public void test11352(){
        int a = 10;
        int b = 20;

        boolean flag = (a == b) ? true : false;
    }
    @Test
    public void test11452(){
        int a = 10;
        int b = 30;
        int c = 20;

        // 先比较两个整数的大值
        int temp = ((a>b) ? a : b);
        int max = ((temp>c) ? temp : c);
    }



    @Test
    public void test17152(){

    }
    @Test
    public void test1152(){

    }


}
