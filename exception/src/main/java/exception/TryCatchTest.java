package exception;

import org.junit.Test;

/**
 * 3. 异常的处理
 * 1. 捕获处理，将异常获取，使用try/catch做分支处理：数组越界异常
 * <p>
 * 2. 原理：JVM检测到异常，抛出，被try抓到扔给catch处理
 * <p>
 * 3. 语法：
 * try {
 * //尝试运行代码（有可能出现异常的代码）
 * <p>
 * } catch (Exception e) {
 * // 如果出现异常，程序会捕获到异常，在这里处理
 * <p>
 * }
 * System.out.println("程序继续运行");
 */
public class TryCatchTest {

    @Test
    public void test1() {

        boolean result = false;
        // 转账
        try {
            System.out.println("你转出10000块");
            int i = 1 / 0;
            System.out.println("你女朋友进账10000块");
            result = true;
        } catch (Exception e) {
            // 处理异常，当务之急，给你退钱，并进行安抚
            System.out.println("抱歉，服务器正在维护,给你退回10000块");
        }
        //判断结果
        if (result) {
            System.out.println("转账成功！");
        } else {
            System.out.println("转账失败！");
            //给你女朋友一个解释
            System.out.println("给你女朋友的提示：你男朋友已经转了，但是余额不足！");
        }

    }


    @Test
    public void test2() {
        int[] array = {1, 2};
        int i;
        try {
            //有可能出现异常的代码
            i = array[3];
            System.out.println(i);
        } catch (RuntimeException e) {
            // 如果出现异常，程序会捕获到异常，在这里处理
            System.out.println("异常被捕获了！");
            throw new RuntimeException("异常信息：" + e);
        }
        System.out.println("如果上面没有throw异常，那么程序继续运行");
    }
}
