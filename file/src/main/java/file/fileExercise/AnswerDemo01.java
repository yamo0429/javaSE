package io.file.fileDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @author spy
 *
 */
public class AnswerDemo01 {
	
	@Test
	public void test3() throws IOException{
		String ss = "abcdef.xml";
		int i = ss.lastIndexOf(".")+1;
//		int of = ss.indexOf(".");
		System.out.println(i);
		String substring = ss.substring(i);
		System.out.println(substring);
	}

	
	

	@Test
	public void test1() throws IOException{
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "a");
		map.put(3, "a");
		
		boolean containsKey = map.containsKey(2);
		System.out.println(containsKey);
		String str = null;
		System.out.println(str + "yyy");
		System.err.println(null + "xxx");
	}


	
	@Test
	public void test() throws IOException{
	Map<String,Integer> hm = new HashMap<String, Integer>();
	hm.put("张三", 3);
	hm.put("李四", 4);
	hm.put("王五", 5);
	hm.put("赵六", 6);
	hm.put("孙七", 7);
	hm.put("田七", 7);
	hm.put("周八", 5);
	
	Collection<Integer> hmValues = hm.values();
	HashSet<Integer> cfValuesTest = new HashSet<Integer>();
	ArrayList<Integer> cfValues = new ArrayList<Integer>();
	for (Integer hmValue : hmValues) {
	boolean add = cfValuesTest.add(hmValue);
	if (!add) {
		cfValues.add(hmValue);
	}
	}
	for (Integer integer : cfValues) {
		System.out.println(integer);
		
	}
	ArrayList<String> cfKeys = new ArrayList<String>();
	
	Set<String> keySet = hm.keySet();
	for (String key : keySet) {
		Integer value = hm.get(key);
		if (cfValues.contains(value)) {
			cfKeys.add(key);
		}
	}
	
	for (String cfKey : cfKeys) {
		hm.remove(cfKey);
	}

	System.out.println(hm);
	
	
	

	}

}
