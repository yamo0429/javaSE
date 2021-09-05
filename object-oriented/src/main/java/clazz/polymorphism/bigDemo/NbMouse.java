package clazz.polymorphism.bigDemo;

public class NbMouse implements USB {

	@Override
	public void open(String name) {
		System.out.println(name + "  is opening NbMouse...");

	}

	@Override
	public void close(String name) {
		System.out.println(name + "  is closing NbMouse...");

	}
	
	public void bling(){
		System.out.println("NbMouse is bling bling....");
	}

}
