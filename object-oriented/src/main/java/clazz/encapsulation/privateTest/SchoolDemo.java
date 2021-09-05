package clazz.encapsulation.privateTest;

/**
 * 父类的私有属性也被子类加载进堆区，但是子类不能直接调用，但是可以间接调用
 *
 */
public class SchoolDemo {
	
	public static void main(String[] args) {
		SchoolMaster master = new SchoolMaster();
		master.setId(9527);
		System.out.println(master.getId());
	}
}

class Person{
	String name;
	int age;
	char gender;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

class SchoolMaster extends Person {
	int workingYears;
	public void introduce(){
		System.out.println("我叫"+name + ",年龄：" + age + ",性别：" +gender);
		System.out.println("我已经工作" + workingYears + "年了！");
	}
}

class Student extends Person {
	int number;
}

/*class Teacher extends Person {
	String teachingField;
}*/


