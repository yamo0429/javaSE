package iterator;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * #三. 增强for循环
	1. JDK1.5特性：只要实现(继承)Iterable接口，允许对象成为“foreach”语句的目标
	2. 集合Collection（List、Set）和数组都可以使用增强for循环
	3. 语法
		for（数据类型  变量名：集合或数组）{

		}
	4. 增强for循环的原理是Iterator,本质是变量被循环赋值
	4. 优劣
		1. 好处：代码简单，适合遍历
		2. 弊端：不能获取元素的索引
		3. 总结：眼看手勿动
	5. 遍历数组
		1. 基本类型 int，可以运算
		2. 引用类型 String，可以调用方法
	6. 遍历集合
		1. String和自定义类型
 *
 */
public class ForeachDemo {

	@Test
	public void test() throws IOException{
		String[] array = { "a", "bd", "c" };

		for (String s : array) {
			System.out.println(s.length());
		}
	}

	@Test
	public void test1() throws IOException{
		int[] array = { 1, 2, 3 };
		for (int i : array) {
			System.out.println(i);
		}
	}

	@Test
	public void test2() throws IOException{
		ArrayList<String> coll = new ArrayList<String>();
		coll.add("赛亚人1号");
		coll.add("赛亚人2号");
		coll.add("赛亚人3号");
		
		String name;
		for (int i = 0; i < coll.size(); i++) {
			name = coll.get(i);
			coll.set(i, "supergirl");
			System.out.println(name);
		}

		//没有索引，不能修改集合中的元素 本质：name变量被循环赋值的过程
		for (String name2 : coll) {
			System.out.println(name2 + "3");
		}
	}
}
