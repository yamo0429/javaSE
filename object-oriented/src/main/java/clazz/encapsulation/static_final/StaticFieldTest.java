package clazz.encapsulation.static_final;

/**
 * 3. static修饰成员变量(静态变量) :
	1. 使用 static 关键字来修饰成员变量.
	2. 调用：类名.变量名、对象.变量名
	3. 特点：该变量被称作静态变量,被所有实例共享。静态变量在内存中独一份，一旦修改，其他对象的该变量值一并被修改。
	4. 应用：当类中的变量为所有对象所共有，就应该定义为静态变量。

	需求 : 例如某个学校所有学生共享同一个学校名称.
	            此时完全不必在每个学生对象所占用的内存空间中都定义一个变量来表示学校名称.
		  而可以使用 static 关键字在静态区定义一个表示学校名称的变量让所有对象来共享.
 *
 */
public class StaticFieldTest {
	
	public static void main(String[] args) {
		
		Student s1 = new Student();
		Student s2 = new Student();
		s1.schoolName = "交大黑马";
		s2.schoolName = "交大白马";
		Student.schoolName = "交大斑马";
		System.out.println(s1.schoolName);
		System.out.println(s2.schoolName);
	}
}
class Student{
	static String schoolName;
}