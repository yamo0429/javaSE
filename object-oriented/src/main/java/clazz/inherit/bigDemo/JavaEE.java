package clazz.inherit.bigDemo;

public class JavaEE extends Development {
	
	public JavaEE() {
		super();
	}

	public JavaEE(String name, int id) {
		super(name, id);
	}


	@Override
	void work() {
		System.out.println(name + "JavaEE is doing");
	}
	
}
