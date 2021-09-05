package iterator;

import java.io.IOException;
import java.util.*;

import org.junit.Test;

/**
 * 迭代器思想
 * 	1. 设计者   封装：迭代器是集合的内部类（隐藏内部实现细节）
 *  2. 学习者    无需关注集合内部实现细节，只管调用接口方法（规范），大大降低学习成本
 *  注意：在进行集合元素取出时，如果集合中已经没有元素了，还继续使用迭代器的next方法，将会发生 java.util.NoSuchElementException 没有集合元素的错误。
 */
public class InteratorDemo {



	@Test
	public void test2() throws IOException{

		Collection<String> coll = new LinkedList<String>();
		coll.add("黛玉");
		coll.add("黛玉2号");
		coll.add("黛玉18号");

//		Iterator<String> it = coll.iterator();
//		while (it.hasNext()) {
//			String name = it.next();
//			System.out.println(name);
//		}

		// 迭代器生命周期在for循环内部，循环结束，对象就销毁，节省内存
		for (Iterator<String> it2 = coll.iterator(); it2.hasNext();) {
			String name = it2.next();
			System.out.println(name);
		}

	}

	@Test
	public void test1() throws IOException{

//		 Collection<String> coll = new ArrayList<String>(); //存取顺序相同
//		 LinkedList<String> coll = new LinkedList<String>(); //存取顺序相同
//		 Collection<String> coll = new HashSet<String>(); //可去重复元素
		Collection<String> coll = new TreeSet<String>(); //存入时自动排序

		coll.add("黛玉");
		coll.add("黛玉2号");
		coll.add("黛玉08号");
		coll.add("黛玉88号");

		Iterator<String> it = coll.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
	}

	@Test
	public void test() throws IOException{

		Collection<String> coll = new ArrayList<String>();
		coll.add("黛玉");
		coll.add("黛玉2号");
		coll.add("黛玉18号");

		/**
		 * 向下转型：可以，但是不具备通用性 另外：collection 接口没有get方法，如何进行遍历？增强for循环和迭代器.
		 */
		// ArrayList<String> array = (ArrayList<String>)coll;
		// for (int i = 0; i < coll.size(); i++) {
		// String name = array.get(i);
		// System.out.println(name);
		// }

		Iterator<String> it = coll.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
