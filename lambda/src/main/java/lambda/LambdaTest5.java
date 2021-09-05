package lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * 内置函数式接口
 */
public class LambdaTest5 {


    /**
     * Function
     */
    @Test
    public void test3222() {
        // Function表示任何有参数和返回值的接口
//        Function interfaceww5 = a -> change3(a);
        Function interfaceww5 = LambdaTest5::change3;
        Object apply = interfaceww5.apply(2);
        System.out.println(apply);
    }
    private static int change3(Object a) {
        return (int)a * 2;
    }

    /**
     * Predicate：谓词复用 TODO======================
     */
    @Test
    public void t222() {


    }
    /**
     * lambda表达式实例化线程，这里以Thead为例
     * 实际是实现了Runable接口的抽象类run方法，故可以用lambda表达式（相当于一个匿名内部类）
     */
    @Test
    public void test3212() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });
        thread.start();
    }


}
