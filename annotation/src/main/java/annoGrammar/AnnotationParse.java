package annoGrammar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解的解析
 * 	 1. 注解的解析离不开反射技术：获取类或者其方法、属性的对象，然后判断和获取类或其方法属性上存在的注解对象，见2
 * 	 2. AnnotatedElement
			所有已知实现类： 	Class, Constructor, Field, Method
	 3. 方法
	 	1. 获取注解信息
	 	2. 判断是否存在此注解
 */
public class AnnotationParse {
	
	public static void main(String[] args) throws Exception {
		
		Class<?> clazz = AnnotationUse.class;

        // 获取类上的注解
        if(clazz.isAnnotationPresent(AnnotationDefinition.class)){
            AnnotationDefinition anno = clazz.getAnnotation(AnnotationDefinition.class);
            String value = anno.author();
            System.out.println("类上的注解信息为 : "+ value);
        }

		// 获取属性上的注解
        Field field = clazz.getDeclaredField("xxx");
        field.setAccessible(true);
        if(field.isAnnotationPresent(AnnotationDefinition.class)){
            AnnotationDefinition anno = field.getAnnotation(AnnotationDefinition.class);
            String value = anno.desc();
            System.out.println("属性上的注解信息为 : "+ value);
        }

		// 获取方法上的注解
		Method method = clazz.getDeclaredMethod("speak");//该方法无需参数类型
		Method method2 = clazz.getDeclaredMethod("say",String.class);//该方法需参数类型，如果是数组类型，参见 TODO 参数类型是数组的情形

//		判断方法上该注解类是否存在
		boolean result = method.isAnnotationPresent(AnnotationDefinition.class);
		if(result){
			//获取注解上的信息
			AnnotationDefinition anno = method.getAnnotation(AnnotationDefinition.class);
			int age = anno.age();
			String desc = anno.desc();
			String author = anno.author();
			System.out.println("desc:" + desc + "---author:" + author + ";age:" + age);
		}

        boolean result2 = method2.isAnnotationPresent(AnnotationDefinition.class);
        if(result2){
            //获取注解上的信息
            AnnotationDefinition anno = method2.getAnnotation(AnnotationDefinition.class);
            int age = anno.age();
            String desc = anno.desc();
            String author = anno.author();
            System.out.println("desc:" + desc + "---author:" + author + ";age:" + age);
        }


	}
}



