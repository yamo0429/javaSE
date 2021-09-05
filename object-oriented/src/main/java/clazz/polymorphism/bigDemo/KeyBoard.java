package clazz.polymorphism.bigDemo;

public class KeyBoard implements USB {

	@Override
	public void open(String name) {
		System.out.println(name + "  is opening keyBoard...");
	}

	@Override
	public void close(String name) {
		System.out.println(name + "  is closing keyBoard...");

	}

}
