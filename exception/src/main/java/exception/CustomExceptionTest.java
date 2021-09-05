package exception;

/**
 * ##三.自定义异常
	1. JDK不能把所有的异常全部定义出来,当程序员需要一些特殊的异常时，需要自定义
	2. 案例：定义一个Person，当age属性非法时，抛出自定义的NoAgeException
		1. 自定义异常: 入伙  继承 Exception或者继承RuntimeException
 *
 */
public class CustomExceptionTest {
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(-18);
	}
}

class NoAgeException extends RuntimeException{//如果是继承Exception，则需要进行catch或是throws声明
	public NoAgeException(String message){
		super(message);
	}
}

class Person{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0 || age > 200){
//			throw new RuntimeException("年龄不合法！");
			throw new NoAgeException("年龄不合法！");
		}
		this.age = age;
	}
	
}