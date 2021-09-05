package set;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

/**
 * 1.HashSet的存储过程原理：
 * 		1). 先用hashcode()方法判断元素是否一致，如果不一致直接存hash表；
 * 		2). 如果hash值一致，再用equals()方法判断，如果不一致存，就存 **链表**，若一致，则不存。
 * 2.HashSet数据结构，是数组和链表的组合
 * 3.给HashSet中存储JavaAPI中提供的类型元素时，不需要重写元素的hashCode和equals方法，
 *   因为这两个方法，在Java API的每个类中已经重写完毕，如String类、Integer类等。
 *   
 *   遗留问题：
		为什么hashSet底层既是数组结构也是链表结构！
		hashCode重复，且equals不重复的也可以存，说明每个hash码值位置上可以添加多个元素！
 */
public class SetSaveDemo {
	/**
	 *
	 * s1和s2不可以共存，因为hashCode方法比较结果一样，equals方法比较结果也一样
	 * s3和s4可以存，虽然hash值一样，但equals比较结果不同
	 * 
	 * hashCode同、equals同：不存（如字符串：aa、aa）
	 * hashCode同、equals异：可存（如字符串：重地、通话）
	 * hashCode异、equals同：不存（如学生对象）
	 * hashCode异、equals异：可存
	 * 总结：只要equals方法结果相同，就不存，反之就存
	 */
	@Test
	public void test1() throws IOException{
		HashSet<String> set = new HashSet<String>();
		//hashCode和equals结果均相同时，不存
		String s1 = new String("abc");
		String s2 = new String("abc");
		set.add(s1);
		boolean add = set.add(s2);
		System.out.println(add);
		System.out.println(set);

		String s3 = "重地";
		String s4 = "通话";
		System.out.println(s3.hashCode());//1179395、1179395。。 hashCode算法非常简单，可以用字符串演示其生成过程，见拓展索引
		System.out.println(s4.hashCode());
		set.add(s4);
		set.add(s3);
		System.out.println(set);
		
		//这里用ArrayList对比上面，说明list是存取有序的，而set是存取无序的（因为生成的hash值是无序的）
		ArrayList<String> list = new ArrayList<String>();
		list.add(s3);
		list.add(s4);
		System.out.println(list);
		
	}
	
	/**
	 * 虽然两个超人，hash值不同，但是equals结果相同，因此无法存入
	 * 
	 * hashCode同、equals同：不存（如字符串：aa、aa）
	 * hashCode同、equals异：可存（如字符串：重地、通话）
	 * hashCode异、equals同：不存（如学生对象）
	 * hashCode异、equals异：可存
	 * 总结：只要equals方法结果相同，就不存；反之就存。。。。简称equals同不存
	 */
	@Test
	public void test2() throws IOException{
		HashSet<Person3> set = new HashSet<Person3>();
		set.add(new Person3("超人",18));
		set.add(new Person3("超人",18));
		set.add(new Person3("超人2号",19));
		
		for (Person3 p : set) {
			System.out.println(p);
		}
	}
}
class Person3{
	String name;
	int age;
	public Person3(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person3 other = (Person3) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
