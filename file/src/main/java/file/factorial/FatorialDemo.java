package file.factorial;

import org.junit.Test;

import java.io.IOException;

/**
 * ##3.递归(recursion)
 * 1. 需求:求5的阶乘(factorial) 。。。。分析：只能用递减的思路去做
 * /**
 * 递归
 * 5! = 5 * 4!
 * 4! = 4 * 3!
 * 3!= 3 * 2!
 * 2! = 2 * 1!
 * 1! = 1
 * 1. 何时结束递归?         getFatorial(n)   n = 1
 * <p>
 * 2. 怎么进行方法递归?      n * getFatorial(n-1)
 */

public class FatorialDemo {

    @Test
    public void test5() {
        System.out.println(five(5));
    }

    private int five(int i) {
        if (i == 1) {
            return 1;
        }
        return i * five(--i);
    }


    /**
     * //栈溢出演示
     */
    @Test
    public void test() throws IOException {
        getFatorial2(5);
    }

    private static int getFatorial2(int i) {
        /**
         * 1. 没有结束条件!错误！！
         * 2. 递归的次数不能太多
         */
        //java.lang.StackOverflowError
        return i * getFatorial2(i - 1);

    }

    @Test
    public void test2() throws IOException {
        System.out.println(getFatorial(1000));
    }

    private static double getFatorial(double i) {
        if (i == 1) {
            return 1;
        } else {
            return i * getFatorial(i - 1);
        }
    }

    @Test
    public void te333st() throws IOException {
        int fatorial2333 = getFatorial2333(5);
        System.out.println(fatorial2333);
    }

    private int getFatorial2333(int i) {
        if (i==1){
            return 1;
        }else {
            return i*getFatorial2333(--i);
        }

    }
}
