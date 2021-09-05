package xml.beanUtil;

public class Demo {
	/**
	 * 类加载先加载所有的属性和方法
	 * 类加载static的顺序
	 * 		1. 先检测到谁就是谁
	 */
	static int i = 2;
	static{
		i = 3;
	}
	public static void main(String[] args) {
		System.out.println(i);
	}
}
