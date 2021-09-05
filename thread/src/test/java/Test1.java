import org.junit.Test;

public class Test1 {
    @Test
    public void test(){
        System.out.println(Apple.age);
        Apple apple = new Apple();
        Apple.age--;
        Apple apple2 = new Apple();
        Apple.age--;
        Apple apple3 = new Apple();
        Apple.age--;

        System.out.println(Apple.age);
    }
}
