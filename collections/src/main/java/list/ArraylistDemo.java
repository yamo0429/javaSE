package list;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * 	3. List实现类: ArrayList 特点
		1. 底层数据结构是数组，自动复制扩容
			1. 添加元素时，判断集合长度是否足够，如果不够，就扩容成原来的1.5f(默认初始10)
			2. StringBuilder 如果不够，扩容成原来的2f + 2;（默认初始16）
		2. 查询快，增删慢
		3. 不是同步的，线程不安全，运行速度快
	4. List实现类:Vector特点
		1. List属于集合框架中的接口,开始于JDK1.2版本.Vector开始于JDK1.0版本,从1.2开始改为实现接口List
		2. 底层数据结构也是数组,和ArrayList相同
		3. Vector是线程安全的集合,运行速度慢,在开发中被ArrayList取代
 *
 */
public class ArraylistDemo {
	
	@Test
	public void test() throws IOException{

		ArrayList<String> list = new ArrayList<String>();
		list.add("bb");
		list.add("aa");
		boolean contains = list.contains("aa");
		System.out.println(contains);
		
		StringBuilder sb = new StringBuilder();
//		sb.append(b)
		
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("file.separator"));
	}
	@Test
	public void test1() throws IOException{

		Integer integer = new Integer("5");
		int i = integer.intValue();
		System.out.println(i+1);
	}



	/**
	 * list.add(int1,int2)方法：在集合某个位置添加元素，原来的编号顺延
	 */
	@Test
	public void test2() {
		ArrayList list = new ArrayList<>();
		list.add(1);
		list.add(100);
		list.add(200);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "：" + list.get(i));
		}

		list.add(1, 300);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "：" + list.get(i));
		}

	}
}
