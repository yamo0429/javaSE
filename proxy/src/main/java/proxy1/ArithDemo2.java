package proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 若匿名内部类访问外部的局部变量，则该局部变量需要final修饰，作用：1. 为了保证局部变量和 内部类中复制品 的数据一致性
 * 2. 生命周期(栈中的变量移动到方法区的常量池，生命周期变长)
 * 优化：jdk8.0之后优化了这个问题，无需添加，详见lambda表达式处也有这点
 */
public class ArithDemo2 {

    public static void main(String[] args1) {

        //1.创建房东
        final ArithImpl ai = new ArithImpl(); //局部方法被匿名内部类调用时，用final修饰，jdk8.0之后优化了这个问题
        //2.根据房东的特点创建中介
        ClassLoader loader = ai.getClass().getClassLoader();
        Class<?>[] interfaces = ai.getClass().getInterfaces();
        ArithInt proxy1 = (ArithInt) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName(); // 使用反射获取方法对象的各种参数，中间可以加入判断或新逻辑，进而对原方法增强
                Class<?> returnType = method.getReturnType();

                System.out.println("这里对方法进行增强，比如开启事务，或者加日志");
                Object obj = method.invoke(ai, args);  // 拦截想拦截的方法，对其进行增强。由于匿名内部类用到外部的局部变量，故该变量要final
                return obj;                            //是否有返回值，取决于原接口的方法是否有返回值
            }
        });
        ArithInt proxy2 = (ArithInt) Proxy.newProxyInstance(loader, interfaces, (proxy, method, args) -> {
            System.out.println("这里对方法进行增强");
            Object obj = method.invoke(ai, args);
            return obj;
        });
        //3.顾客调用中介/代理类的方法（代理类通过房东所实现的接口，从而获取了全部房东的方法）
        int iii = proxy1.sum2(2, 2);
        System.out.println(iii);


    }
}