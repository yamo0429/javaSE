package exception;

/**
 * 	1. 异常的继承体系
		1. 异常的介绍：也是一个类（java面向对象），java.lang.Throwable 是java中所有异常和错误的父类，有两个子类	
			1. Error（错误）：所有错误的父类，非常严重，不修改源代码，不能执行（只能避开）
				1. 人：癌症、艾滋
			2. Exception（异常）：Exception类表示程序可以处理的异常，可以捕获且可能恢复。

		2. 因为Error是无法处理只能修改源码（虚拟机相关的问题：系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢），所以开发中主要是Exception
 *
 */
public class ExceptionSystem {
	public static void main(String[] args) {
		Person9 p = new Person9();
		p.speak();
		
		String s = null;
		//java.lang.NullPointerException  空指针异常
		s.toString();
	}
}

class Person9{
	void speak(){
		//java.lang.StackOverflowError 栈溢出错误（虚拟机错误）
		//完美      编译   -》 运行   虚拟的内存空间不是无限大
		//我们没办法解决，只能避开
//		speak();  //递归
	}
}
