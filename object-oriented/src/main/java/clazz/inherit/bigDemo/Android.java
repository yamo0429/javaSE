package clazz.inherit.bigDemo;

public class Android extends Development {

    public Android(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println(name + "Android is doing");
    }

}
