package clazz.encapsulation.modifier;

public class ProtectedTest {
	public static void main(String[] args) {
		Student s = new Student();
		s.name = "zs";
		// s.age = 100;
	}
}

class Student extends Master {

	void speak() {
		System.out.println(age);
	}
}

class Master {
	public String name;
	String id;

	// protected只能在子类内部调用，不能外部使用
	protected int age;
}
