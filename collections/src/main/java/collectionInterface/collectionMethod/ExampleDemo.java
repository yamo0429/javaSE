package collection;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * 数组和集合的区别： 1. 数组是定长的，既可以存放基本类型又可以存放引用类型 2. 集合长度是可变的,只能存放引用类型(基本类型，泛型是包装类，自动装箱)
 *
 */
public class ExampleDemo {

	@Test
	public void test() throws IOException {

		// 对象数组
		Father p1 = new Father();
		p1.age = 18;
		Father p2 = new Father();
		Father p3 = new Father();

		Father[] array = { p1, p2, p3 };
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].age);
		}

		// 集合
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); // 自动装箱
		System.out.println(list);
	}
}

class Father {
	int age;
}