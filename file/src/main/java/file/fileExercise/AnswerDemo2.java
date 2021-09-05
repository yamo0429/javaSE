package io.file.fileDemo;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

/**
 * 键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数
	注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
		用个数作为value,放入到map集合中,并用两种方式遍历map集合
		例如：
		doc 的类型的文件有  3 个
		java 的类型的文件有  5 个
		txt 的类型的文件有  7 个
		
	分析:
		最终: map  key(后缀名)  value(个数)
		1. key:如何获取后缀名
			1. 判断是否是文件,是文件,通过分割文件名获取后缀
			2. 如果不是文件,继续递归
		2. value:如何获取个数
			1. 判断map集合中是否有key,如果没有,put(key,1)
			2. 如果有,put(key,map.get(key) + 1)
 */
public class AnswerDemo2 {
	public static void main(String[] args) {
		File srcfile = new File("f:/test_io\\filedoc");
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		
		method(srcfile, map);
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Integer value = map.get(key);
			System.out.println(key + ":" + value);
		}
	}

	private static void method(File srcfile, HashMap<String, Integer> map) {
		File[] listFiles = srcfile.listFiles();
		for (File file : listFiles) {
			if(file.isDirectory()){
				method(file,map);
			}else{
				String name = file.getName();
				int suffixIndex = name.lastIndexOf(".") + 1;
				String suffix = name.substring(suffixIndex);
				
//				System.out.println(suffix);
				boolean result = map.containsKey(suffix);
				if(result){
					//原来的个数   + 1
					Integer i = map.get(suffix) + 1;
					map.put(suffix, i);
				}else{
					map.put(suffix, 1);
				}
			}
		}
	}

}
