package exception;

public class FinallyTest{
	public static void main(String[] args) {
//		boolean result = method();
//		System.out.println(result); //true
//		int i = method2();
//		System.out.println(i);  // 1
		
		Person6 p =  method3();
		System.out.println(p.age);
	}

	private static Person6 method3() {
		Person6 p = new Person6();
		try {
			p.age = 1;
			return p;  // p 地址值(传值不传址)
		} catch (Exception e) {
			p.age = 2;
		}finally{
//			p = new Person();
			p.age = 3; //该地址值里面的属性
		}
		return p;
	}

	private static int method2() {
		int a;
		try {
			a = 1;
			return a; // return记录的是 值而不是变量
		} catch (Exception e) {
			a = 2;
		}finally{
			a = 3; //赋值成功
			System.out.println(a);
		}
		return a;
	}

	private static boolean method() {
		try {
			//直接返回
			return false;  // 生效了，但是碰到finally，将会将当前的返回值记录下来，等待finally执行完毕之后再返回
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			//必须执行
			System.out.println("哈哈执行");
			return true;
		}
//		return true;
	}
}

class Person6{
	int age;
}