package lambda;

import bean.Person;
import interfaces.Interface2;
import interfaces.Interface5;
import interfaces.Interface6;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

/**
 * lambda方法引用
 * lambda方法引用语法：接口 接口名 = 方法的隶属者::方法名;  解释如下：
 * TODO =号后面的内容是=号前面接口抽象方法的实现（实质是一个被labmda表达式简化了的匿名内部类），被封装的方法的参数列表和返回值类型要与接口方法一致
 * TODO 注意：只要可以确定方法的调用者（如遍历或传入对象），又不需要参数，那么，就可以使用与引用静态方法相同的方式，即：接口 接口名 = 类名::方法名
 * 静态方法用类名引用、对象方法用对象引用、构造方法用类名引用、类的特殊方法（set/get）用类名引用（同静态方法引用方式）
 */
public class LambdaTest2 {

    public static <T, R> List<R> convert(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        list.forEach(t -> result.add(function.apply(t)));
        return result;
    }
    /**
     * 方法调用（注意不是lambda的方法引用，只是调用。引用是lambda对调用的简化）
     */
    @Test
    public void test2843() {
        // 原始形式
        Interface5 interface5 = a -> a * 2; //a*2 是原接口的方法体，a -> a*2 可看做被lambda表达式简化了的匿名内部类的简化版方法体
        System.out.println(interface5.test(7));

        // 方法调用：注意这不是函数引用，只是调用一个封装的方法而已。引用是对调用的简化
        // change方法就是原接口里test方法的方法体(封装了原始的a*2逻辑)，故调用test，就会执行change方法(接口回调)，change方法为静态或非静态均可
        Interface5 interface52 = a -> change(a);
        System.out.println(interface52.test(8));

    }

    private static int change(int a) { // 该方法的返回值类型、参数列表必须与接口中抽象方法一致
        return a * 2;
    }

    private static int change2(int a, int b) {
        return a * b;
    }

    /**
     * 引用类的静态方法：
     * 接口 接口名 = 类名::方法名：表示一个重写了接口方法的匿名内部类，故用接口接收
     * 被封装的方法的参数列表和返回值类型要与接口方法一致
     */
    @Test
    public void test28543() {
        // change方法就是原接口里test方法的方法体(封装了原始的a*2逻辑)，调用test，即会调用到change方法
        // lambda方法引用语法：方法的隶属者::方法名
        // TODO 理解：=号后面的内容表示一个重写了接口方法的匿名内部类，故用接口名接收
//        Interface5 interface5 = a -> change(a); // 原始方式：a -> change(a)表示一个实现接口（实质是重写了接口test方法）的匿名内部类
        Interface5 interface5 = LambdaTest2::change;  // 优化：静态方法引用：LambdaTest2::change是对a -> change(a)的简化，即优化了静态方法的调用而已，但都是一个匿名内部类
        System.out.println(interface5.test(9));
        Interface6 interface6 = LambdaTest2::change2;
        System.out.println(interface6.test(8, 9));

    }

    // 引用静态方法
    @Test
    public void test3s() {
        List<Integer> list = Arrays.asList(1000, 2000, 3000);

        // 原始：注意：lambda表达式就是一个实现Function接口(实质是重写了apply方法)的匿名内部类，方法体即toHexString方法
//        List<String> hexList = LambdaTest6.convert(list, i -> Integer.toHexString(i));

        // 优化：静态方法引用：注意：lambda表达式就是一个实现Function接口（实质是重写了apply方法）的匿名内部类，方法体即toHexString方法
        List<String> hexList = LambdaTest2.convert(list, Integer::toHexString); // Integer::toHexString是对i -> Integer.toHexString(i)的简化，但都是一个匿名内部类，前者优化了静态方法的调用而已
        System.out.println(hexList); // [3e8, 7d0, bb8]
    }

    /**
     * 引用类的非静态方法
     * 只要可以确定方法的调用者，就可以使用与引用静态方法相同的方式，即：接口 接口名 = 类名::方法名
     * 只要可以确定方法的调用者（如遍历或传入对象），又不需要参数，就可以使用与引用静态方法相同的方式，即：接口 接口名 = 类名::方法名
     */
    @Test
    public void test3282() {
        Person person1 = new Person("lili", 12, 175);
        Person person2 = new Person("cici", 13, 176);

//        PersonCreator3 personCreator3 = p -> p.getName(); // 原始形式

        // 简化了上一行的原始形式，作为接口中getPersonName方法的方法体，只要传入Person类对象，就可调用getName方法（TODO 传入对象说明确定了方法调用者，故可以用类名::方法名方式）
        PersonCreator3 personCreator3 = Person::getName;//Person::getName 实际就是getPersonName()方法的方法体
        System.out.println(personCreator3.getPersonName(person2));

//        PersonCreator4 personCreator4 = p -> p.setName("lili");  // 原始形式
        PersonCreator4 personCreator4 = Person::setName;//Person::setName就是set()方法的方法体
        personCreator4.set(person1, "lili");
    }

    @FunctionalInterface
    interface PersonCreator3 {
        String getPersonName(Person person);
    }

    @FunctionalInterface
    interface PersonCreator4 {
        void set(Person person, String name);
    }

    @Test
    public void tes2t3s() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
//        List<String> upperList = LambdaTest6.convert(list, s -> s.toUpperCase());
        List<String> upperList = LambdaTest2.convert(list, String::toUpperCase);
        System.out.println(upperList);
    }

    /**
     * 引用对象的非静态方法：接口 接口名 = 对象::方法名
     * 如果可以确定方法的调用者（如遍历或传入对象），又不需要参数，那么，就可以使用与引用静态方法相同的方式(接口 接口名 = 类名::方法名)，
     * 否则用对象::方法名(本例就是)
     */
    @Test
    public void test243() {
        Interface6 interface6 = new LambdaTest2()::change3; // 无法确定方法调用者，故只能手动生成一个对象，故用对象::方法名
        System.out.println(interface6.test(8, 9));
    }

    private int change3(int a, int b) {
        return a - b;
    }


    @FunctionalInterface
    interface PersonCreator {
        Person getPerson();
    }

    @FunctionalInterface
    interface PersonCreator2 {
        Person getPerson2(String name, int age, int height);
    }
    /**
     * 引用构造方法（无论有参还是无参。在调用时确定参数列表即可）：接口 接口名 = 类名::new
     * TODO 先去Person里吧注释放开
     */
    @Test
    public void test2853() {

        PersonCreator creator = () -> new Person(); // 原始形式。 参见：lambda的基础语法简化形式：Interface4和Interface6
        creator.getPerson();
        PersonCreator creator1 = Person::new; // Person::new ：其实是一个实现了PersonCreator接口里getPerson方法的匿名内部类的简写形式，故下面可以调用该方法
        creator1.getPerson();
        PersonCreator2 creator2 = Person::new; // 调用有参构造，注意每个接口只能有一个抽象方法，故必须新建一个接口
        creator2.getPerson2("lili", 25, 175);
    }
    Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    Logger logger2 = Logger.getLogger(String.valueOf(LambdaTest2.class));
    @Test
    public void test3222() {

        logger.info("-----------------------");
        logger.info("-----------------------");
        logger.warning("==================");

    }


}
