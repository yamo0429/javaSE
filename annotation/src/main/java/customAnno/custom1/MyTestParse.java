package customAnno.custom1;

import java.lang.reflect.Method;

/**
 * 框架：通用性
 *
 */
public class MyTestParse {
	
	public static void run(String clazzName) throws Exception {
		
		Class<?> clazz = Class.forName(clazzName);
		Object obj = clazz.newInstance();
		//TODO 获取Class对象中所有public方法，包括无参和带参的，注意还包括编译器追加上去的
		Method[] methods = clazz.getMethods();

        //以下遍历获取的是无参的方法
		for (Method method : methods) {
			if(method.isAnnotationPresent(MyTest.class)){
                //TODO 无参的用于MyTestUse里mytest2和mytest3，带参的用于mytest1
//				method.invoke(obj);
				method.invoke(obj,"ggg");
			}
		}
	}
	public static void main(String[] args) throws Exception {
		run("anno.customAnno.custom1.MyTestUse");
		
	}
}
