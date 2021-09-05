package clazz.encapsulation;

/**
 * 7. 动物联合声明案例
		步骤一 : 定义一个 `共性` 类.   行为: 联合声明 (decleration)
		步骤二 : 定义一个 `Dog` 类. 继承 `Animal` 类, 子类无条件拥有父类中所有可继承的 `属性和行为`.  (不可继承: 构造方法)
		步骤三 : Fox extends Animal    获取 decleration() 行为，重写了该方法。
		
		 继承的好处: Fox 可以不重写该方法, 可以直接继承.   
		继承的缺点: 继承后重写方法，打破了 `类` 的封装性.
		
		需求：又想被继承，又不能被重写！
		
	8. final 关键字 :
		final 关键字是用于修饰类,变量和方法,它有"这是无法改变的"或者"最终"的含义.
		特点 :
		1.	final 修饰的类不能被继承.即不能有子类.
		2.	final 修饰的方法不能被子类重写.老老实实继承,不允许做任何篡改.
		3.	final 修饰的变量(成员变量和局部变量)是常量,由于常量在运行期间不允许再发生改变,所以常量在声明时没有默认值, 这就要求程序在声明常量时必须指定该常量的值.
			1. 局部变量：因为在运行时才创建，所以可以先定义后初始化 
			2. 成员变量：因为在类加载时已经创建，所以必须声明时进行初始化（系统的方法 `静态代码块, 构造方法, 构造代码块`）
			3. 一个原则：final修饰的变量在被调用的时候必须有值
		注意：由于final修饰的变量是常量，我们开发中为了和变量名有区别，因此所有的被final修饰的变量名统一大写。
		
		总结：不可继承（类）、不可重写（方法）、不可修改（属性）
		
		final:常量池（缓存）    static ： 静态区
 *
 */
public class FinalTest {
	public static void main(String[] args) {
//		Dog dog = new Dog();
//		dog.name = "二哈";
//		dog.decleration();
		Animal fox = new Fox();
		fox.name = "狐狸";
		fox.decleration();
		
		
		new String("abc");
		
	}
}

/**
 *     核心：常量被调用必须有值
 *   初始化：
 *   		1. 成员属性 ：随着对象的创建而初始化
 *   		2. 局部变量：方法进栈初始化
 *	问题：如果能够保证成员属性在初始化的同时就赋值，那就可以了。(构造方法、构造代码块、静态代码块)
 */
class Someone{
	final static int I;
	static{
		I = 2;
	}
	{
//		I = 0;
	}
	public Someone(){
//		I = 1;
	}
	void speak(){
		final int J;
		J = 2;
		System.out.println(J);
	}
	static void show(){
//		I = 3;
		System.out.println(I);
	}
}


class Animal{
	String name = "";
	public final void decleration(){
		System.out.println(name + "说：我们动物是人类的好朋友！");
	}
}

class Dog extends Animal {
	
}

class Fox extends Animal {
//	@Override
//	public void decleration() {
//		System.out.println(name + "说：我们动物是人类的天敌！");
//	}
}




