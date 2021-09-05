package io.file.fileDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 需求:在map中去掉重复的值(删除key)
 * 	1. 找到重复的值元素
 *  2. 从值中找到相应key
 *  3. 遍历cfkey集合,在map中移除
 */
public class AnswerDemo02 {
	@Test
	public void test1() throws IOException{
		// 1.创建HashMap集合key存放姓名,value存放年龄
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("张三", 3);
		hm.put("李四", 4);
		hm.put("王五", 5);
		hm.put("赵六", 6);
		hm.put("孙七", 7);
		hm.put("田七", 7);
		hm.put("周八", 5);
		
		Collection<Integer> values = hm.values();
		//判断重复值
		HashSet<Integer> valueSet = new HashSet<Integer>();
		//存重复值
		ArrayList<Integer> cfValue = new ArrayList<Integer>();
		for (Integer value : values) {
			boolean add = valueSet.add(value);
			if(!add){
				cfValue.add(value);
			}
		}
		
		Set<String> keySet = hm.keySet();
		ArrayList<String> cfKey = new ArrayList<String>();
		
		for (String key : keySet) {
			//map中的值
			Integer value = hm.get(key);
			if(cfValue.contains(value)){
				cfKey.add(key);
			}
		}
		
		for (String key : cfKey) {
			hm.remove(key);
		}
		System.out.println(hm);

	}
}
