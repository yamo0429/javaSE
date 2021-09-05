package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 	3. Map遍历方式
		1. 第一种：键找值, keySet方式
		 	1. Map集合的方法keySet,所有的键存储到Set集合中
			2. 迭代器遍历Set集合
		 	3. 遍历过程中取出Set集合的元素,就是Map中的键
		 	4. Map集合的方法get,通过键获取到值
		2. 第二种：通过键值对，entrySet方式
			1. 内部接口
				1. 定义在接口内部的接口
				2. 实现类,可以直接实现外部接口,无需同时实现内部接口
				3. 实现类,可以直接实现内部接口(外接口名.内接口)
				4. 实现类也可同时实现外部和内部接口
			2. entrySet遍历
				1. Map集合方法entrySet(),取出键值对的对应关系对象 (Entry接口实现类对象)存储到Set集合
	  			2. 迭代器遍历Set集合
				3. 遍历Set中,取出的是Entry接口实现类的对象
				4. 通过实现类对象,调用方法 getKey,getValue获取键值对
 *
 */
public class LoopDemo {
	
	public static void main(String[] args) {
		
		keyFindValue();
//		entrySet();
	}

	private static void entrySet() {
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		
		//1.取出map中   ‘键值对’  的  集合
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		//2. 遍历集合，每个元素包含   键   和   值
		Iterator<Entry<Integer, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<Integer, String> entry = it.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		
		
//		for (Entry<Integer, String> entry : entrySet) {
//			Integer key = entry.getKey();
//			String value = entry.getValue();
//			System.out.println(key + ":" + value);
//			
//		}
	}

	private static void keyFindValue() {
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		
		//键找值
		//1. 首先获取map中所有键的集合
		Set<Integer> keySet = map.keySet();
		
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()){
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}
//		for (Integer key : keySet) {
//			//2. 通过键在map中找到相应的值
//			String value = map.get(key);
//			System.out.println(key + ":" + value);
//		}
		
	}
}
