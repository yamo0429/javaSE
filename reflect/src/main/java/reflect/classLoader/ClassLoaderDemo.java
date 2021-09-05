package reflect.classLoader;



import org.junit.Test;
import sun.net.spi.nameservice.dns.DNSNameService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 1. 类加载器
 * 		1. 引导类加载器         C、C++  Bootstrap            jre\lib\rt.jar
 *      2. 扩展类加载器         java  ext：extension         lib\ext
 *      3. 应用类加载器            java  application    自定义，自己编写，第三方框架  jar包
 *   总结：不同的类加载器加载不同的类
 * 2. Class对象：我们只能获取，不能创建（JVM创建）    	
 * 3. 因为这样可以保证类的对象只被创建一次！
 * 		1. 如果应用类加载器接收到加载类的请求，不会马上加载，会先问扩展类加载器   ，扩展类加载器    先问
 * 			引导类加载器  ，引导类说可以加载，他就加载，其他两个加载器啥都不干
 * 		2. 引导类加载器说不加载，扩展类加载器看看自己能否能做，以此类推
 * 		（双亲委托机制）
 *
 */
public class ClassLoaderDemo {
    /**
     * 引导类加载器
     */
	@Test
	public void test3() throws IOException {
		ClassLoader app = ClassLoaderDemo.class.getClassLoader();

	/*	InputStream stream = ClassLoaderDemo.class.getClassLoader().getResourceAsStream("party.properties");
        final Properties properties = new Properties();
        properties.load(stream);
        final String singer = properties.getProperty("singer");
        System.out.println(singer);*/

		ClassLoader ext = app.getParent();
		System.out.println(ext);

		ClassLoader boot = ext.getParent();
		System.out.println(boot);
	}

    /**
     * 扩展类加载器
     */
	@Test
	public void test2(){
		ClassLoader classLoader =  DNSNameService.class.getClassLoader();
		//sun.misc.Launcher$ExtClassLoader
		System.out.println(classLoader);
	}

    /**
     * 应用类加载器
     */
	@Test
	public void test1(){
		ClassLoader classLoader = String.class.getClassLoader();
		System.out.println(classLoader);
	}
	
	
	
	
	
}
