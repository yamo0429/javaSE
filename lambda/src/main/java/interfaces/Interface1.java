package interfaces;

@FunctionalInterface
public interface Interface1 {
    void test();
    String ddd = "aaa"; // 接口中变量，默认是静态的常量，默认有static
    default void say(){
        System.out.println("java8中，接口可以有带方法体的默认方法");
    }
}
