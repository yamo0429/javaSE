package jdk.api;

import org.junit.Test;

import java.util.Date;
import java.util.Properties;

/**
 * ##四.System类
 * 1. System类是final修饰，可是不能实例化，因为构造方法私有
 * 2. 常见静态方法：
 * 1. currentTimeMillis()：获取系统当前时间
 * 2. exit(0)：终止当前正在运行的 Java 虚拟机，0表示正常中止
 * 3. gc() ：运行垃圾回收器     garbage collection
 * 4. getProperty():确定当前的系统属性
 * 3. 关于arrayCopy方法复制数组：String 和 StringBuilder
 * 1. StringBuilder的封装char[]没有用final修饰，可重新赋值
 */
public class SystemTest {
    @Test
    public void test1() {

        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 0};

        System.arraycopy(src, 1, dest, 0, 3);//src的第二个起，共三个元素，从dest里第一个起开始替换

        for (int i = 0; i < dest.length; i++) {
            System.out.println(dest[i]);
        }
    }

    @Test
    public void test2() {
        String path = System.getProperty("java.home");
        System.out.println(path);
        Properties properties = System.getProperties();
        String property = properties.getProperty("java.home");
        System.out.println(property);
    }

    @Test
    public void test3() {
        try {
            System.out.println("啊哈哈");
            System.exit(1);//用来结束正在运行的JVM。参数传入一个数字即可。通常传入0记为正常状态，其他为异常状态
        } catch (Exception e) {

        } finally {
            System.out.println("我一定执行");
        }
    }

    @Test
    public void test4() {
        long time = new Date().getTime();
        long ct = System.currentTimeMillis();
        System.out.println(time + "=====" + ct);
    }

}
