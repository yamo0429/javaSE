package jdk.api;

import org.junit.Test;

import java.util.Random;

/**
 * ##五.Math类
 * 1. java.lang.Math类是数学计算工具，构造也是私有
 * 2. 常见静态方法：
 * 1. abs：返回参数的绝对值
 * 2. ceil：返回大于或者等于参数的最小整数（向上取整）：用于分页显示
 * 3. floor：向下取整
 * 4. round：四舍五入取整数
 * 5. pow：幂运算: a的b次幂
 * 6. random：返回随机数,范围是0.0-1.0之间的伪随机数；结果可能是0.0,不会到达1.0
 * 1. 计算机中的随机数都是由确定算法计算出来的，不是真正意义上的随机数
 * 2. 同样是返回随机数 new Random().nextInt(params)用的更多
 */
public class MathTest {

    @Test
    public void test1() {
        for (int i = 0; i < 5; i++) {
            double random = Math.random();
            System.out.println(random);
        }
        //指定范围,故只是伪随机数，而不是真正的随机数
        int nextInt = new Random().nextInt(10);
        System.out.println(nextInt);
    }

    @Test
    public void test2() {
        //abs方法,返回绝对值，结果都为正数
        double d1 = Math.abs(-5); // d1的值为5
        double d2 = Math.abs(5); // d2的值为5
//ceil方法，结果为比参数值大的最小整数的double值
        double d31 = Math.ceil(3.3); //d1的值为 4.0
        double d22 = Math.ceil(-3.3); //d2的值为 -3.0
        double d3 = Math.ceil(5.1); // d3的值为 6.0
//floor方法，结果为比参数值小的最大整数的double值
        double d51 = Math.floor(3.3); //d1的值为3.0
        double d42 = Math.floor(-3.3); //d2的值为-4.0
        double d83 = Math.floor(5.1); //d3的值为 5.0
//max方法，返回两个参数值中较大的值
        double d571 = Math.max(3.3, 5.5); //d1的值为5.5
        double d52 = Math.max(-3.3, -5.5); //d2的值为-3.3
//min方法，返回两个参数值中较小/大的值
        double d17 = Math.min(3.3, 5.5); //d1的值为3.3
        double d25 = Math.max(-3.3, -5.5); //d2的值为-5.5
//pow方法，返回第一个参数的第二个参数次幂的值
        double d187 = Math.pow(2.0, 3.0); //d1的值为 8.0
        double d462 = Math.pow(3.0, 3.0); //d2的值为27.0
//round方法，返回参数值四舍五入的结果
        double d189 = Math.round(5.5); //d1的值为6.0
        double d62 = Math.round(5.4); //d2的值为5.0
//random方法，产生一个大于等于0.0且小于1.0的double小数
        double d137 = Math.random();
    }


}
