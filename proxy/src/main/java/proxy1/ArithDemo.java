package proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理常用的有两种方式：
 * 基于接口的动态代理：JDK官方的Proxy类
 * 基于子类的动态代理：第三方CGLib，如果报asmxxxx异常，需要导入asm.jar

 * jdk动态代理：必须要有接口
 * 核心： 接口 + 实现类 + 测试类【包含实现类对象 + 代理类（三大参数及反射方法时需要用到实现类对象） + 调用方法（传参）+ 注意final】+ 优化（见spring 里的动态代理）
 */
public class ArithDemo {
    public static void main(String[] args) {
        //原始形式
        //method();

        final ArithImpl ai = new ArithImpl();   //局部变量在匿名内部类里要定义成final（因为在main方法里所以是局部变量）
        ClassLoader loader = ai.getClass().getClassLoader();         // 运行时新创建的类, 需要被加载到内存, 只有类加载器负责将类加载到内存
        Class<?>[] interfaces = ai.getClass().getInterfaces();        //获取这个类实现的所有接口
        InvocationHandler invocationHandler = new InvocationHandler() {  // 动态代理具体处理的实现代码
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable {  // proxy是代理类本身，几乎不用
                System.out.println("这里对方法进行增强");
                method.invoke(ai, args);  // 调用真正房东的真正方法(反射)
                System.out.println("这里对方法进行增强");
                return null; // 是否返回值，取决于原方法
            }
        };
        ArithInt proxy = (ArithInt) Proxy.newProxyInstance(loader, interfaces, invocationHandler);

        // 租客：直接找中介，无需找房东
        proxy.sum(1, 1);
        proxy.minus(3, 2);
        proxy.multiply(-1, 2);
        proxy.divide(-4, -2);
    }


    /**
     * 原始调用形式
     */
    private static void method() {
        ArithImpl ai = new ArithImpl();

        ai.sum(1, 1);
        ai.minus(3, 2);
        ai.multiply(-1, 2);
        ai.divide(-4, -2);
    }
}
