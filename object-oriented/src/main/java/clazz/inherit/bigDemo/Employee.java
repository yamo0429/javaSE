package clazz.inherit.bigDemo;

public abstract class Employee {
	String name;
	int id;
	
	public Employee() {
		super();
	}
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	abstract void work();
}
