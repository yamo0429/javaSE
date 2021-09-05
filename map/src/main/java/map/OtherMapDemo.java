package map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * 	2. LinkedHashMap
		1.  底层结构哈希表,双向链表
		2.  元素有序
		3. Lru算法   least recently used 最近最少使用原则
			1. android   阉割版的linux 内核     上层  java - 》  dvm  
			2. 内存回收  GC自动管理（堆区对象和数组）
			3. 缓存：手动自动，内存（Lru算法）：  20M
			
	3. HashTable
		 1. 开始于JDK1.0,从1.2开始实现Map接口
		 2. 底层数据结构哈希表
		 3. 线程安全的集合,不允许存储null值,null键
		 4. 效率低,被更先进的HashMap取代
		 
		 5. 但是Hashtable有个子类 Properties(重要),Properties可以和IO流对象结合使用,实现数据的持久存储
 */
public class OtherMapDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		method();
		
		//可以结合IO流的map
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/a.properties"));
		
		String name = properties.getProperty("name");
		String age = properties.getProperty("age");
		System.out.println(name + ":" + age);
	}

	private static void method() {
		LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
		map.put("1", "a");
		map.put("3", "a");
		map.put("2", "a");
		map.put("4", "a");
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" + value);
		}
	}
}
