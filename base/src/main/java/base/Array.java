package base;

import org.junit.Test;

public class Array {


    /**
     * 数组
     * 两种初始化方式
     * 方式1：动态初始化：只指定数组长度，由系统为数组分配初始值
     * 格式：数据类型[] 数组名 = new 数据类型[数组长度];
     * 举例：int[] arr = new int[3];
     *
     *
     * 方式2：静态初始化：初始化时指定每个数组元素的初始值，由系统决定数组长度
     * 格式：数据类型[] 数组名 = new 数据类型[]{元素1,元素2,...};
     * int[] arr = new int[]{1,2,3};

     * 简化格式：
     * 数据类型[] 数组名 = {元素1,元素2,...};
     * int[] arr = {1,2,3};
     */
    @Test
    public void test171(){

        int[] arr1 = new int[3];  // 动态初始化

        // 静态初始化
        int[] arr = {1,2,3};//这种使用局部代码块创建数组的方式，实际还是在堆内存里new int[],因此，其元素初始值一开始为零，不过很快被赋予了新值。

    }

    /**
     * 数组元素的访问
     * 用数组名和编号的配合我们就可以获取数组中的指定编号的元素，这个编号的专业叫法：索引
     * 格式：数组名[编号] -- 数组名[索引]
     */
    @Test
    public void test1712(){
        int[] arr = {1,2,3};

        //输出数组名和元素
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }

    /**
     * 数组遍历
     */
    @Test
    public void test187312(){
// 定义数组
        int[] arr = { 11, 22, 33, 44, 55 };
        // 原始做法
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println("--------------------");

        // 用for循环改进
        for (int x = 0; x <5; x++) {
            System.out.println(arr[x]);
        }
        System.out.println("--------------------");

        //为了解决我们去数数组中元素个数的问题，数组就提供了一个属性：length
        //用于获取数组的长度
        //格式：数组名.length
        System.out.println("数组共有："+arr.length+"个");
        System.out.println("--------------------");

        for(int x=0; x<arr.length; x++) {
            System.out.println(arr[x]);
        }
    }

    @Test
    public void test187152(){
        //定义数组
        int[] arr = {12,98,45,73,60};

        //定义参照物
        int max = arr[0];

        //遍历数组，获取除了0以外的所有元素，进行比较
        for(int x=1; x<arr.length; x++) {
            if(arr[x] > max) {
                max = arr[x];
            }
        }
        System.out.println("数组中的最大值是："+max);
    }

    /**
     * 需求：数组获取最值(获取数组中的最大值最小值)
     */
    @Test
    public void test18712(){
        //定义数组
        int[] arr = {12,98,45,73,60};

        //定义参照物
        int max = arr[0];

        //遍历数组，获取除了0以外的所有元素，进行比较
        for(int x=1; x<arr.length; x++) {
            if(arr[x] > max) {
                max = arr[x];
            }
        }
        System.out.println("数组中的最大值是："+max);
    }


    /**
     * 数组 ============================================================================================================
     * 两个常见问题：
     * A:java.lang.ArrayIndexOutOfBoundsException
     * 数组索引越界异常：访问了不存在的索引元素
     * B:java.lang.NullPointerException
     * 空指针异常：引用已经不指向堆内存的数据了，你还使用它调用方法
     */
    @Test
    public void test5() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[2]);
        arr = null;
        System.out.println(arr[1]);
    }

    @Test
    public void test6() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }

        System.out.println(max);
    }

    @Test
    public void test7() {
        int[] arr = {5, 7, 3, 2, 5};

        int ii = 5;
        for (int i = 0; i < arr.length; i++) {
            if (ii == arr[i]) {
                System.out.println(i);
                return;
            }
        }

    }

    @Test
    public void test1812(){

    }








}
