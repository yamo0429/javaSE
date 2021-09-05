package io.byteStream.exercise;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 *1. 接口回调(多态)
	1. 学会使用API
	2. 看懂源码: 代码的执行过程
	3. 体会设计思想(提高代码扩展性)
2. 什么是代码扩展性? 当需求变化的时候,代码改的越少,扩展性就越强

3. 小案例
		1. 需求:一组字符串添加到集合中,集合中的每个字符串都需要添加后缀 .txt,遍历集合打印所有字符串
		2. 需求变更: 集合中的字符串添加后缀名改为 .jpg,遍历集合打印所有字符串
		3. 需求再变: 集合中的字符串需要添加前缀   "超人"
		4. 需求再变: 集合中的字符串需要添加中间缀    "真可爱"
		5. 需求再变
			1. 烦死了!!!!!!! 得重载多少个方法才能结束
			2. 调用者其实都是在修改字符串!!!!!!!!
				1. 那我就将字符串返回给调用者,让调用者直接处理
 *	
 * 优化:
 * 	1. 通过封装方法的形式提高代码扩展性
 *  2. 通过接口回调的方式:
 *  	1. 暴露相应的参数,给调用者去处理
 *  	2. 但是不影响框架封装的业务完善
 */
public class DuotaiDemo {
	public static void main(String[] args) {
		
//		method("超人","真可爱",".jpg");
		method(new NameHandler() {
			
			@Override
			public String giveYouName(String name) {
				String finalName = "超人" + name + "真可爱.jpg";
				return finalName;
			}
		});
		
	}
	interface NameHandler{
		String giveYouName(String name);
	}
	private static void method(NameHandler handler) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			
//			String name = prefix + i + middle + suffix;
			String name = handler.giveYouName(i + "");
			/**
			 * 不能直接return name,因为直接return之后,后面还有业务无法封装处理,给调用者处理!!!!
			 */
			list.add(name);
		}
		for (String name : list) {
			System.out.println(name);
		}
	}
	
	private static void method(String prefix,String middle,String suffix) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			String name = prefix + i + middle + suffix;
			/**
			 * 不能直接return name,因为直接return之后,后面还有业务无法封装处理,给调用者处理!!!!
			 */
			list.add(name);
		}
		for (String name : list) {
			System.out.println(name);
		}
	}
	
	private static void method(String prefix,String suffix) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			String name = prefix + i + suffix;
			list.add(name);
		}
		for (String name : list) {
			System.out.println(name);
		}
	}
	private static void method(String suffix) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			String name = i + suffix;
			list.add(name);
		}
		for (String name : list) {
			System.out.println(name);
		}
	}

	private static void filter() {
		File file = new File("C:/test/filedoc");
		File[] listFiles = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		for (File file2 : listFiles) {
			System.out.println(file2.getName());
		}
	}
}
