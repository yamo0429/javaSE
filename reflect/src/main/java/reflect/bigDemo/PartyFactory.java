package reflect.bigDemo;


import java.util.Properties;

/**
 *1.  工厂设计模式：主要是为创建对象提供过渡接口，以便将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。
 *
 *	工厂类:生产商品，对外提供对象（静态方法）
 *		1. 反射 : 提高代码通用性
 *		2. property 配置文件
 *		
 *  实际工厂   -》 抽象工厂
 *  只跟抽象商品，无需关注实际商品
 *  因为多态特性，就解耦（高内聚，低耦合）
 *  	
 *
 */
public class PartyFactory {

	static Properties properties;
	static{

		properties = new Properties();
		try {
//			properties.load(new FileInputStream("src/main/party.properties")); //TODO 为何找不到文件？试一下全路径应该可以
			properties.load(PartyFactory.class.getClassLoader().getResourceAsStream("party.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//**********************************************
	}
	public static Singer getSinger() throws Exception{
		String className = properties.getProperty("singer");
		Class<?> singerClazz = Class.forName(className);
		Singer singer = (Singer) singerClazz.newInstance();
		return singer;
	}
	public static Dancer getDancer() throws Exception{
		String className = properties.getProperty("dancer");
		Class<?> dancerClazz = Class.forName(className);
		Dancer dancer = (Dancer) dancerClazz.newInstance();
		return dancer;
	}
	public static Player getPlayer() throws Exception{
		String className = properties.getProperty("player");
		Class<?> playerClazz = Class.forName(className);
		Player player = (Player) playerClazz.newInstance();
		return player;
	}
}
