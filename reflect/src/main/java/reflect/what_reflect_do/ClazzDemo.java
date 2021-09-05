package reflect.what_reflect_do;


import org.junit.Test;

/**
 * Class对象获取方式:
 *  1. Class.forName('全限定名') 全路径名 ： 包名 + 类名 。应用场景：加载配置文件
 *  2. 类名.class。应用场景：在反射中指定参数类型
 *  3. 对象名.getClass()。应用场景：方法（参数向上转型） 内部判定 对象 类型
 *
 */
public class ClazzDemo {

	@Test
	public void method() throws ClassNotFoundException {
		Class<?> forName = Class.forName("reflect.what_reflect_do.Student");
		System.out.println(forName);
	}

	@Test
	public void method2() throws ClassNotFoundException {
		Class<?> clazz = Student.class;
		System.out.println(clazz);
		
		Class<?> forName = Class.forName("reflect.what_reflect_do.Student");
		System.out.println(clazz == forName);
	}

	@Test
	public void method3() {
		Student s = new Student();
		Class<?> clazz = s.getClass();
//		System.out.println(clazz);
		show(s);
	}

	// 向上转型，参见equals方法和拓展索引
	private void show(Object obj) {
		if(obj instanceof Student){
			System.out.println(obj.getClass());// 打印Object还是 Student类名？Student
		}
	}


}
