package collectionInterface.generic;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/**
	通配符？表示任意类型的泛型
	特殊格式
		1. <? extends Person>：表示可以传递Person及其子类（上限）。。arraylist addAll方法
		2. <? super Person>：表示可以传递Person及其父类（下限）
 */
public class GenericSymbol {

	// 理解：装西瓜的篮子，装苹果的篮子，两个集合本身没有继承关系，但是元素之间有
	// 向上转型：装西瓜的篮子也可以装苹果,两个集合里的泛型没有继承关系
	@Test
	public void test2() throws IOException {
		ArrayList<Human> aa = new ArrayList<Human>();
		ArrayList<Student> bb = new ArrayList<Student>();
		bb.add(new Student(2));
		aa.add(new Student(1));
		aa.addAll(bb);// TODO 学生继承了人类，因此里面的泛型也是子父关系，可以按住ctrl，然后鼠标悬停在addAll方法上
		Object[] array = aa.toArray();
		for (Object object : array) {
			System.out.println(object);
		}
	}

	class Human { }

	class Student extends Human {
		int age;
		public Student(int age){}
	}
	
	/**
	 *  * public ArrayList(Collection<? extends E> c)
	 *    为了便于通配符?的理解,我们将以上方法重写为public ArrayList(ArrayList<? extends E> c)
	 *  * 该方法的意思:创建集合对象A时,给于另外一个集合对象B作为参数,则创建好的集合A中包含了集合B中的所有元素
	 *
	 */
	@Test
	public void test3() throws IOException{
		//定义集合b,包含3个元素
		ArrayList<String> listSon = new ArrayList<String>();
        listSon.add("Jack");
        listSon.add("Rose");
        listSon.add("Trump");
		
		//使用集合b创建集合a
		ArrayList<Object> listDad = new ArrayList<Object>(listSon);
		// 相当于下面两行
//		ArrayList<Object> listDad = new ArrayList<Object>();
//		listDad.add(listB);
        listDad.add("Obama");

		System.out.println(listDad);
	}


}