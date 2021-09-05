package xml.beanUtil;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 2. BeanUtils
	1. 导包
	2. BeanUtils方法
		1. populate(Object bean, Map<K,V> map)   	
			1. 将Map数据封装到指定Javabean中，一般用于将表单的所有数据封装到javabean
		2. setProperty(Object obj,String name,Object value)	设置属性值
		3. getProperty(Object obj,String name)	获得属性值
		* 底层原理是反射
 *
 */
public class BeanUtilsDemo {
	
	@SuppressWarnings("null")
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, Exception {
		//获取前端的数据
		Map<String, Object> parameterMap = Request.getParameterMap();
		
		Student s = new Student();
		BeanUtils.populate(s, parameterMap);
		
		System.out.println(s);
	}

	private static void method2() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		Student s = new Student("超人2号", 20, 9528);
		
		String name = BeanUtils.getProperty(s, "name");
		String age = BeanUtils.getProperty(s, "age");
		String id = BeanUtils.getProperty(s, "id");
		System.out.println(name + ":" + age + ":" + id);
	}

	private static void method() throws IllegalAccessException,
			InvocationTargetException {
		Student s = new Student();
		
		/**
		 * bean: 被赋值的对象
		 * name: 被赋值的属性名（元数据）
		 * value: 此元数据对应的值
		 */
		BeanUtils.setProperty(s, "name", "超人1号");
		BeanUtils.setProperty(s, "age", "18");
		BeanUtils.setProperty(s, "id", "9527");
		
//		Class<?> cls = null;
//		Object obj = cls.newInstance();
//		Method method = cls.getMethod("methodname", String.class);
//		method.invoke(bean, "超人1号")
		
		System.out.println(s);
	}
}

class Request{
	/**
	 * 前端（网页） 向服务器发起请求，在服务器获取到request请求对象，
	 * 可以获取一个parameterMap（参数集合）
	 */
	public static Map<String,Object> getParameterMap(){
		//前端讲用户输入的内容封装到请求体中
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("name", "超人3号");
		hm.put("age", "21");
		hm.put("id", "110");
		
		return hm;
	}
}
