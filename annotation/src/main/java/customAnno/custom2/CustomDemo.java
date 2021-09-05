package customAnno.custom2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnno("在类上面")
public class CustomDemo {
	@MyAnno("在属性上面") //当注解类里只有一个属性，且名为value()的时候，使用时可以省略名称
	private int age;
	@MyAnno("在方法上面")
	public void speak(){
		
	}
	public static void main(String[] args) throws Exception, SecurityException {
		
		//1.判断类上是否有这个注解，如果有，则读取该注解的属性值。注意注解设置了不同的作用范围
		Class<?> clazz = CustomDemo.class;
		if(clazz.isAnnotationPresent(MyAnno.class)){
			MyAnno anno = clazz.getAnnotation(MyAnno.class);
			String value = anno.value();//如果有多个属性值呢？
			System.out.println(value);
		}
		//2.判断方法上
		Method method = clazz.getMethod("speak");
		if(method.isAnnotationPresent(MyAnno.class)){
			MyAnno anno2 = method.getAnnotation(MyAnno.class);
			System.out.println(anno2.value());
		}
		//3.判断属性上
		Field field = clazz.getDeclaredField("age");
		if(field.isAnnotationPresent(MyAnno.class)){
			MyAnno anno3 = field.getAnnotation(MyAnno.class);
			System.out.println(anno3.value());
		}
		
	}
}
