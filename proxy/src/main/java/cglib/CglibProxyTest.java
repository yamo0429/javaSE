package cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTest {
    @Test
    public void demo() {
        final Director director = new Director();
        /**
         *  第三方基于子类的动态代理：cglib
         * 	要求：被代理对象不是最终类，即不能被final修饰
         * 	涉及到的类：Enhancer
         * 	涉及到的方法：create
         * 	方法中需要2个参数：
         * 		一：被代理对象的Class
         * 		二：回调函数，它和InvocationHanlder的作用和用法是一样的
         */
        Director directorProxy = (Director) Enhancer.create(director.getClass(), new MethodInterceptor() {
            /**
             * 前3个参数和InvocationHanlder中的一致
             * 第4个参数：当前执行方法的代理对象
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args,
                                    MethodProxy methodProxy) throws Throwable {
                Object invoke = null;
                if (method.getName().equals("movie")) {
                    System.out.println("插播广告：" + args[0] + ",就是这么自信");
                    invoke = method.invoke(director, args);
                }

                if (method.getName().equals("teleplay")) {
                    System.out.println("插播广告：" + args[0] + ",好酒");
                    invoke = method.invoke(director, args);
                }
                return invoke;
            }

        });

        directorProxy.movie("飘柔");
        directorProxy.teleplay("茅台");
    }
}