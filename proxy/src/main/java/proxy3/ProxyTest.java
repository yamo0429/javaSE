package proxy3;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理常用有两种：jdk动态代理、cglib动态代理，本工程下proxy指的是jdk方式的代理
 */
public class ProxyTest {

    @Test
    public void proxyTest() {

        //1.提供实现类对象
        final Actor actor = new ActorImpl();

        //2.创建代理类
        Actor actorProxy = (Actor) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                Object invoke = null;
                if (method.getName().equals("teleplay")) {
                    System.out.println("插播广告：" + args[0] + ",就是这么自信");
                    invoke = method.invoke(actor, args);
                }

                if (method.getName().equals("movie")) {
                    System.out.println("插播广告：" + args[0] + ",好酒");
                    invoke = method.invoke(actor, args);
                }
                return invoke; //原方法并无返回值，故此应为null
            }
        });

        //3.代理类调用
        actorProxy.movie("茅台");
        actorProxy.teleplay("飘柔");
    }

}
