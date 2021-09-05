package annoGrammar;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解= 定义 + 使用 + 解析，本类是定义
 * 注释和注解
 * 		1. 注释：给程序员看的（关于代码的含义）
 * 		2. 注解：给程序看的（也有特定含义）
 * 注解：JDK5.0出现，是和   类、接口、枚举是同一等级的。
 * 
 * 自定义注解类：
 * 		1. 关键字 @interface
 * 		2. 注解只有属性没有方法
 * 
 * 元注解：注解的注解(元注解是对注解进行描述的)，就像元数据是数据的数据
 *
 *	如果注解中有一个名称value()的属性，那么使用注解时可以省略value=部分：String value(), String[] value();
 */


//TODO 在生成文档的时候，文档会自动生成相应的注解说明，何意？
@Documented  
//如果子类继承有这个注解的父类，子类也有此注解
@Inherited 
//作用范围（将此注解放在那里？ 类、方法、属性、参数，等等）
@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
//生命周期（保留策略）：通常保留到运行时期
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationDefinition{
	//属性的格式：属性类型 属性名();
	String desc() ;
	int age() default 18;
	String author();

//	Date date();//报错原因如下
	/**
	 * Invalid type Date for the annotation attribute Description.date;
	 *  only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional arrays thereof
	 *  原始类型：8大基本类型、String、Class 、Anno、Enum   = 12种        以及一维数组
	 */

}
