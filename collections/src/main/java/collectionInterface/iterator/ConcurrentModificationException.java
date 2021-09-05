package iterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 * 7. 并发修改异常
		1. java.util.ConcurrentModificationException
		2. 注意：不能在迭代的过程中,使用集合的方法,修改长度（增减元素）
 *
 */
public class ConcurrentModificationException {
	@Test
	public void test() throws IOException{
		Collection<String> coll = new ArrayList<String>();
		coll.add("java");
		coll.add("php");
		coll.add("ios");
		coll.add("ui");

		Iterator<String> it = coll.iterator();
		while (it.hasNext()) {
			String name = it.next();
			// java.util.ConcurrentModificationException
			// 原因：在集合开始遍历的时候，迭代器就记录的当前集合的大小，如果在遍历过程中修改集合长度，就会发生并发修改异常
			if ("java".equals(name)) {
				coll.add("oracle");
			}
		}
	}
}
