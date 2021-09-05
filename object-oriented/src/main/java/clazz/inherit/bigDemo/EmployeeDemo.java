package clazz.inherit.bigDemo;

public class EmployeeDemo {
	public static void main(String[] args) {
		
		JavaEE javaEE = new JavaEE();
		javaEE.name = "javaEE worker";
		javaEE.id = 9527;
		javaEE.work();
		
		Android a = new Android("android worker", 22);
		a.work();
	}
}
