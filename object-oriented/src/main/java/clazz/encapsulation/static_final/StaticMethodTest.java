package clazz.encapsulation.static_final;

/**
 * 1. static引入（计算器需求）：
		1）创建一个Calculator计算器类，并在Calculator类中定义两个属性 price和color。
		2）在Calculator类中定义一个方法, getSum(); 求和功能.
		对比计算器类的 getSum() 求和方法和之前学生类的 introduce() 方法内部有什么区别 ?
 *2. static修饰方法(静态方法):
		1. 在方法前面加关键字static
		2. 调用：类名.方法名()、 对象.方法名()
		3. 静态方法无法访问非静态属性,静态方法不存在重写
		4. 应用：如果方法无需访问'成员变量'，那么该方法就应该被设计成静态方法。
 */
public class StaticMethodTest {
	
	public static void main(String[] args) {
//		Calculator c = new Calculator();
//		c.color = "pink";
//		c.price = 100;
//		int sum = c.getSum(1, 2);
//		int sum = Calculator.getSum(1, 4);
//		System.out.println(sum);
		
		/**
		 * 本质上：不是重写方法（只不过恰巧在子类中定义了和父类一样的方法）
		 * static与对象无关，不关注*** 这个引用，以及引用在堆区中的实际对象
		 * 只与类有关：是什么类调用，就是属于什么类的静态方法
		 */
		Calculator c = new CaclSon();
		int sum = c.getSum(1, 2);
		
	}
}
class Calculator{
	String color;
	int price;
	
	static int getSum(int x,int y){
		System.out.println("这是父类的方法");
		return x + y;
	}
	void introduce(){
		System.out.println("我的颜色是：" + color + ",价格是：" + price);
	}
}
class CaclSon extends Calculator{
	/**
	 * 形式上：可以重写
	 */
	static int getSum(int x,int y){
		System.out.println("这是子类的方法");
		return x + y;
	}
}