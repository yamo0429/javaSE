package proxyOptimization2;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 *  优化解耦2：反射+资源文件
 */
public class ProxyTest {
    @Test
    public void proxyOptimization2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("myInvocationHandlerFile"); // 获取资源文件
        String inuse = resourceBundle.getString("inuse");

        Actor actor = new ActorImpl();
        Actor actorProxy = (Actor) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(),
                (InvocationHandler) Class.forName(inuse).newInstance());
        actorProxy.movie("梦之蓝");
        actorProxy.teleplay("胸藏万壑");
    }

}
