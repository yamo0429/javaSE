package clazz.inherit.bigDemo;

public class HardWare extends Mantainer {
	
	public HardWare(String name, int id) {
		super(name, id);
	}

	@Override
	void work() {
		System.out.println(name + "HardWare is doing");
	}

}
