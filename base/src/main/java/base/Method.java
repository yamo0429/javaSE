package base;

import org.junit.Test;

import java.util.Scanner;

public class Method {
    /**
     * 方法格式：
     * 修饰符 返回值类型 方法名(参数类型 参数名1，参数类型 参数名2…) {
     *   函数体;
     *   return 返回值;
     * }
     *
     * 方法格式解释：
     * 修饰符：目前记住 public static
     * 返回值类型：用于限定返回值的数据类型
     * 方法名：一个名字，为了方便我们调用方法
     * 参数列表：参数类型（用于接收调用方法时传入的数据的类型）、参数名（用于接收调用方法时传入的数据的变量）、参数数量
     * 方法体：完成功能的代码
     * return：结束方法，把返回值带给调用者
     */

    /**
     * 返回两个数中的较大值
     */
    public static int getMax(int a, int b) {
        if (a>b) {
            return a;
        } else {
            return b;
        }
    }
    @Test
    public void test32132(){
        //创建对象
        Scanner sc = new Scanner(System.in);

        //接收数据
        System.out.println("请输入第一个数据：");
        int x = sc.nextInt();

        System.out.println("请输入第二个数据：");
        int y = sc.nextInt();

        //调用方法
        int max = getMax(x,y);
        System.out.println("max:"+max);

    }


    /**
     * 需求：比较两个数据是否相等。参数类型分别为两个byte类型，两个short类型，两个int类型，两个long类型
     */
    @Test
    public void test31212(){
        int a = 10;
        int b = 20;

        // 求和
        int result = sum(a, b);
        System.out.println("result:" + result);

        int c = 30;
        // 求和
        //int result2 = sum2(a,b,c);
        //System.out.println("result2:"+result2);
        result = sum(a,b,c);
        System.out.println("result:"+result);
    }


    //两个float类型的数据求和
    public static float sum(float a,float b) {
        return a + b;
    }

    // 三个整数的求和
    public static int sum(int a,int b,int c) {
        return a + b + c;
    }

	/*
	public static int sum2(int a, int b, int c) {
		return a + b + c;
	}
	*/

    // 两个整数的求和
    public static int sum(int a, int b) {
        return a + b;
    }

    /**
     * 形参为基本数据类型
     */
    @Test
    public void test32112(){
        // 定义变量
        int a = 10;//实参
        int b = 20;
        System.out.println("a:" + a + ",b:" + b);// a:10,b:20
        change(a, b);
        System.out.println("a:" + a + ",b:" + b);// a:10,b:20
    }

    public static void change(int a, int b) { // a=10,b=20
        System.out.println("a:" + a + ",b:" + b);// a:10,b:20
        a = b; // a=20;
        b = a + b;// b=40;
        System.out.println("a:" + a + ",b:" + b);// a:20,b:40
    }

    /**
     * 形参为引用数据类型
     */
    @Test
    public void test32122(){
        // 定义数组
        int[] arr = { 1, 2, 3, 4, 5 };
        // 遍历数组
        for (int x = 0; x<arr.length; x++) {
            System.out.println(arr[x]);
        }
        System.out.println("----------------");
        change(arr);
        for (int x = 0; x<arr.length; x++) {
            System.out.println(arr[x]);
        }
    }

    public static void change(int[] arr) {
        for (int x = 0; x<arr.length; x++) {
            // 如果元素是偶数，值就变为以前的2倍
            if (arr[x] % 2 == 0) {
                arr[x] *= 2;
            }
        }
    }

    @Test
    public void test3212(){
    }



}
