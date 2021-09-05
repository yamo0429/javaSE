package io.file.factorial;

import org.junit.Test;

import java.util.HashMap;

/**
 * 4. 小练习(年龄递推)
 * 有5个人坐在一起,问第5个人多少岁 ? 他说比第4个人大两岁.
 * 问第4个人多少岁 ? 他说比第三个人大两岁,
 * 问第三个人,又说比第二个人大两岁,
 * 问第二个人, 说比第一个人大两岁,
 * 最后问第一个人, 他说是10岁,请问第5个人多大 ?
 *
 * 分析：只能用递减的思路去做
 */
public class AgeDemo {

    public static void main(String[] args) {

        /**
         * 1. 何时结束递归?
         * 2. 如何进行递归调用?(业务)
         *
         * index = 5   when   = 1 is over  return 10
         *             else    method(index -1) + 2;
         */
        System.out.println(getAge(5));
    }

    private static int getAge(int i) {
        if (i == 1) {
            return 10;
        } else {
            return getAge(--i) + 2;
        }
    }



}
