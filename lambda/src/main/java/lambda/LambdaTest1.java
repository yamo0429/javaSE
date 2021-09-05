package lambda;

import interfaces.*;
import org.junit.Test;

/**
 * lambda表达式作用: 通过简化匿名内部类，从而简化接口实现
 * 这里演示基础语法、进阶（基本语法简化）
 * @FunctionalInterface：表示该接口为函数式接口，即只能有一个抽象方法，方便使用lambda表达式
 */
public class LambdaTest1 {

    /**
     * lambda表达式引入
     */
    @Test
    public void test(){

        MyCompatator compatator1 = new MyCompatator(); // 方式一：实现类方式

        Compatator compatator2 = new Compatator() {    // 方式二：匿名内部类方式
            @Override
            public int compate(int a, int b) {
                return a - b;
            }
        };
        Compatator compatator3 = (a, b) -> a - b;      // 方式三：lambda表达式（是对方式二中匿名内部类的简化 ）

        System.out.println("比较结果：" + compatator1.compate(2, 1));
        System.out.println("比较结果：" + compatator2.compate(2, 1));
        System.out.println("比较结果：" + compatator3.compate(2, 1));
    }
    // 实现类方式只用于方式一
    class MyCompatator implements Compatator{
        @Override
        public int compate(int a, int b) {
            return a - b;
        }
    }
    // 提供一个接口。@FunctionalInterface：表示接口式编程，即只能有一个抽象方法
    @FunctionalInterface
    interface Compatator{
        int compate(int a, int b);
    }

    /**
     * lambda的基础语法
     * lambda两个特征：接口内只有一个抽象方法、本质是个匿名函数
     * 根据以上两个特征，一般函数的四个要素（返回值类型，方法名，参数列表，方法体）在lambda这里就只需考虑后两个，这决定了lambda的基础语法
     * ()：描述参数列表
     * {}：描述方法体，相当于一个匿名内部类，方法体表示重写了接口唯一的抽象方法
     * ->：lambda运算符，读作：goes to
     */
    @Test
    public void test2(){
        // 无返回值
        Interface1 interface1 = () -> { System.out.println("无参数，无返回值"); };
        interface1.test();
        Interface2 interface2 = (int a) -> { System.out.println("一个参数，无返回值：" + a); };
        interface2.test(2);
        Interface3 interface3 = (int a, int b) -> { System.out.println("多个参数，无返回值：" + (a + b)); };
        interface3.test(2, 3);
        // 有返回值
        Interface4 interface4 = () -> { System.out.println("无参数，有返回值"); return 100;};
        System.out.println("返回值：" + interface4.test());
        Interface5 interface5 = (int a) -> { System.out.println("一个参数，有返回值"); return a*2;};
        System.out.println("返回值：" + interface5.test(6));
        Interface6 interface6 = (int a, int b) -> { System.out.println("多个参数，有返回值"); return a+b;};
        System.out.println("返回值：" + interface6.test(6, 7));

    }

    /**
     * lambda的基础语法简化形式
     */
    @Test
    public void test228(){
        Interface3 interface3 = (a,b) -> { System.out.println("可直接省略参数类型（不管几个参数）：" + (a + b)); };
        interface3.test(2, 3);
        Interface2 interface2 = a -> { System.out.println("只有一个参数时，可以省略小括号：" + a); };
        interface2.test(2);

        Interface1 interface1 = () -> System.out.println("方法体只有一条语句时，大括号可以省略");
        interface1.test();
        Interface6 interface6 = (a,b) -> a + b;
        System.out.println("方法体只有一条return语句时，大括号和return均可省略：" + interface6.test(1, 2));
    }

    @Test
    public void test324(){

    }

}
