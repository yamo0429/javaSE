package customAnno.custom1;

import org.junit.Test;

/**
 * 自定义MyTest
 * 		1. 自定义注解MyTest
 * 			1. 不需要属性，target = method，retention = runtime
 *		2. 解析注解，获取有注解的方法，嵌入main方法执行
 *
 */
public class MyTestUse {
	
	@Test
	public void demo(){
		System.out.println("测试方法被执行了。。。");
	}
	
	@MyTest
	public void mytest1(String dd){
		System.out.println("自定义注解的方法走你啦 mytest1："+dd);
	}

//	@MyTest
	public void mytest3(){
		System.out.println("自定义注解的方法走你啦 mytest3");
	}
//	@MyTest
	public void mytest2(){
		System.out.println("自定义注解的方法走你啦 mytest2");
	}
}
