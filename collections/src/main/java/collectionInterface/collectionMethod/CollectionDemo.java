package collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

/**
 * 	2. collection常用方法
		1. add
			1. 添加元素，返回值boolean，成功为true
			2. list中元素可重复，故恒为true。set中元素不可重复，有可能为false
		2. clear
			1. 清空集合中的所有元素。集合容器本身不会改变,继续使用
		3. remove
			1. 移除集合中的单个实例（参数obj），移除成功返回true
		4. toArray
			1. 集合中的元素,变成数组。集合存储的数据类型不确定,返回的数组的类型是Object
		5. contains 包含某个元素，如果有返回true,区分大小写
		6. size：获取大小	
 */
public class CollectionDemo {


	@Test
	public void size() throws IOException{
		Collection<String> coll = new ArrayList<String>();
		coll.add("悟空");
		coll.add("八戒");
		coll.add("沙沙");

		for (int i = 0; i < coll.size(); i++) {
			// 问题：collection接口没有get方法，如何进行遍历？增强for循环和迭代器.
		}

		for (String string : coll) {
			System.out.println(string);
		}

	}

	@Test
	public void contains() throws IOException{
		Collection<String> coll = new ArrayList<String>();
		coll.add("悟空");
		coll.add("八戒");
		coll.add("沙沙");
		coll.add("IOS");
		// 是否包含该元素
//		boolean contains = coll.contains("ios");
//		System.out.println(contains);

		String ss = "kkkkll";
		final boolean l = ss.contains("l");
		System.out.println(l);

	}
	@Test
	public void toArray() throws IOException{
		Collection<String> coll = new ArrayList<String>();
		coll.add("悟空");
		coll.add("八戒");
		coll.add("沙沙");
		System.out.println(coll);

		Object[] array = coll.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	@Test
	public void remove() throws IOException{
		Collection<String> coll = new ArrayList<String>();
		coll.add("悟空");
		coll.add("八戒");
		coll.add("沙沙");
		coll.add("八戒");

		// 移除第一个八戒
		boolean remove = coll.remove("八戒");
		System.out.println(remove);
		System.out.println(coll);
	}

	@Test
	public void clear() throws IOException{
		Collection<String> coll = new ArrayList<String>();
		coll.add("悟空");
		coll.add("八戒");
		coll.add("沙沙");

		// 清空集合中所有元素，返回[]
		coll.clear();
		// 置空,返回null
		coll = null;
		System.out.println(coll);
	}

	@Test
	public void add() throws IOException{
		Collection<String> coll = new ArrayList<String>();
		coll.add("悟空");
		coll.add("八戒");
		// 返回值：添加此元素是否成功（在list中恒为true，存放的元素允许重复， Set不允许重复，添加重复元素返回false）
		boolean add = coll.add("沙沙");
		System.out.println(add);
		System.out.println(coll);
	}
}
