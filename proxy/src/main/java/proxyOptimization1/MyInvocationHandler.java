package proxyOptimization1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//之后想要修改其他增强的话可以再定义一个类实现InvocationHandler，然后更换到动态代理中即可
public class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object invoke = null;
        if (method.getName().equals("teleplay")) {
            System.out.println("插播广告：" + args[0] + ",就是这么自信");
            invoke = method.invoke(new ActorImpl(), args);
        }

        if (method.getName().equals("movie")) {
            System.out.println("插播广告：" + args[0] + ",好酒");
            invoke = method.invoke(new ActorImpl(), args);
        }
        return invoke; //原方法并无返回值，故此可为null
    }

}
