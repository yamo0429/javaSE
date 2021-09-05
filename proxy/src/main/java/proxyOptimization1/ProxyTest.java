package proxyOptimization1;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 *  优化解耦1：自定义类实现 InvocationHandler
 */
public class ProxyTest {

    @Test
    public void proxyOptimization1() {
        Actor actor = new ActorImpl();
        Actor actorProxy = (Actor) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new MyInvocationHandler());
        actorProxy.movie("茅台");
        actorProxy.teleplay("飘柔");
    }

}
