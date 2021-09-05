package customAnno.custom2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 如果只有一个属性，且属性名定义为value，则在赋值的时候可以省略此变量
 * 同一个注解类，通过设置范围参数@Target以实现在不同的地方使用，类似不同的注解用在不同的地方，如下
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	String value();
}
