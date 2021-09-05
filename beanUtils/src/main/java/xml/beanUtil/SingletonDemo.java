package xml.beanUtil;

/**
 * 单例：保证该类只有一个实例
 * 特点
 * 		1. 私有构造方法
 * 		2. 内部对外提供一个公开获取实例的方法  用static修饰   方法名getInstance
 * 		3. 本类属性私有化  private static修饰
 */
public class SingletonDemo {
	
	public static void main(String[] args) {
		
		Person p = Person.getInstance();
		Person p2 = Person.getInstance();
		Person p3 = Person.getInstance();
		
		System.out.println(p);
		System.out.println(p2);
		System.out.println(p3);
		Person.show();
	}
}

/**
 * 饿汉式单例    hungry
 * 		1. 当类加载的时候就创建这个类的实例，无论调用方法getInstance与否
 *		2. 对内存不是很讲究，线程安全的
 */
class Person{
	int money = 1000;
	private static Person p = new Person();
	private Person(){
	}
	
	public static Person getInstance(){
		return p;
	}
	public static void show(){
		
	}
}

/**
 * 懒汉式单例: lazy
 * 		1. 只有在调用方法getInstance的时候，如果没有该实例才创建
 *		2. 对内存讲究，但是线程不安全
 */
//class Person{
//	
//	int money = 1000;
//	private static Person p;
//	private Person(){
//	}
//	
//	public static Person getInstance(){
//		if(p == null){
//			p = new Person();
//		}
//		return p;
//	}
//	public static void show(){
//		
//	}
//}
//class Person{
//	
//	int money = 1000;
//	public final static Person p = new Person();
//	private Person(){
//		
//	}
//}