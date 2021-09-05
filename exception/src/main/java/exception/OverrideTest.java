package exception;

import org.junit.Test;

/**
 * 	1. 子类重写父类方法的异常问题
		1. 如果父类的方法抛出了异常，子类重写后,可以不抛出异常,也可以抛出异常。但是,子类抛出的异常不能大于父类抛出的异常
		2. 如果父类方法没有抛出异常，子类重写后,方法也不能抛出异常(运行时异常可以,无需编译)。如果子类的方法遇到了异常,只能try...catch处理
		3. 原因：多态
 *
 */
public class OverrideTest{

	@Test
	public void OverrideTest() {
		
		Person7 p = new Student7();
		//编译看左边，运行看右边：父类接收的话，调用的方法在父类中必须存在编译才能通过，而运行时则执行子类重写的方法
		try {
			p.speak();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Person7{
	void speak(){ }
}

class Student7 extends Person7{
	@Override
	void speak() throws RuntimeException {
		
	}
}