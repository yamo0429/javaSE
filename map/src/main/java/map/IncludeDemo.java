package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ##四. 集合的嵌套
	1. List嵌套List: ArrayList <ArrayList<String>>    苹果   在每个城市    都有     多家专卖店
	2. List嵌套Map:ArrayList <Map<String,String>>  java     21期      class1
	3. Map嵌套List:Map <String, ArrayList<String>>
	4. Map嵌套Map:Map <String, Map<String,String> >

	5. 案例:百度  Map<学科，班级Map<学号，姓名>>
		JavaSE
			1 号        杨幂
			2 号       赵丽颖
	    JavaEE
	    	3 号         紫霞
	    	4 号         蓬莱
 */
public class IncludeDemo {
	public static void main(String[] args) {
		//外层:百度
		HashMap<String, Map<String, String>> baidu = new HashMap<String, Map<String,String>>();
		
		//内层：班级
		HashMap<String, String> javaSE = new HashMap<String, String>();
		javaSE.put("1号", "杨幂");
		javaSE.put("2号", "张三");
		
		HashMap<String, String> javaEE = new HashMap<String, String>();
		javaEE.put("3号", "紫霞");
		javaEE.put("4号", "亚伟");
		
		baidu.put("javaSE", javaSE);
		baidu.put("javaEE", javaEE);
		
//		keySet(baidu);
		entrySet(baidu);
	}

	private static void entrySet(HashMap<String, Map<String, String>> baidu) {
		Set<Entry<String, Map<String, String>>> baiduEntrySet = baidu.entrySet();
		
		for (Entry<String, Map<String, String>> baiduEntry : baiduEntrySet) {
			String clazzNameKey = baiduEntry.getKey();
			System.out.println(clazzNameKey + ":");
			Map<String, String> clazz = baiduEntry.getValue();
			
			Set<Entry<String, String>> studentSet = clazz.entrySet();
			for (Entry<String, String> student : studentSet) {
				String num = student.getKey();
				String name = student.getValue();
				System.out.println("  " + num + ":" + name);
			}
			
		}
	}

	private static void keySet(HashMap<String, Map<String, String>> baidu) {
		//外层剥离
		Set<String> clazzKeySet = baidu.keySet();
		Iterator<String> it = clazzKeySet.iterator();
		while(it.hasNext()){
			String clazzKey = it.next();
			System.out.println(clazzKey + ":");
			//内层剥离
			Map<String, String> clazz = baidu.get(clazzKey);
			Set<String> numKeySet = clazz.keySet();
			Iterator<String> it2 = numKeySet.iterator();
			while(it2.hasNext()){
				String numKey = it2.next();
				String nameValue = clazz.get(numKey);
				System.out.println("    " + numKey + ":" + nameValue);
			}
		}
	}
}
