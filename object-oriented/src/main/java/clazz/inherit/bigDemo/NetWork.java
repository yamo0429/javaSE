package clazz.inherit.bigDemo;

public class NetWork extends Mantainer {

    public NetWork(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println(name + "NetWork is doing");
    }

}
