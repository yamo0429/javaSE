package set;

import java.io.IOException;
import java.util.LinkedHashSet;

import org.junit.Test;

/**
 * 	9. LinkedHashSet特点
		1. LinkedHashSet 继承 HashSet,实现Set接口
 		2. LinkedHashSet集合的自身特点:
			1. 底层数据结构 哈希表,双向链表
		 	2. 有序的Set集合,存储和取出的顺序一致
		 	3. 线程不安全的集合,运行速度快
 *
 */
public class LinkedHashSetTest {
	@Test
	public void test() throws IOException{

		
		LinkedHashSet<String> set = new LinkedHashSet<String>();
//		ArrayList<String> set = new ArrayList<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		for (String word : set) {
			System.out.println(word);
		}
	}
}
