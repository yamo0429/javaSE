package clazz.encapsulation.anonymous_obj;

import org.junit.Test;

/**
 * 匿名对象：没有名字的对象
 * 1. 简化了格式，无须定义变量名
 * 2. 弊端：只能一次使用
 * 3. 作用：传参方便
 */
public class Anonymous_obj {

    @Test
    public void test1() {


        //new 执行一次，就创建一个对象（堆内存中开辟一块空间）
        new Person().setName("柳岩");
        String name = new Person().getName();
        System.out.println(name);//打印null

        Person p = new Person("马六", 21);
        walk(p);

        walk(new Person("马六", 21));
//		new BufferedReader(new FileReader(file))
        Person p2 = getPerson();
        p2.walk();
    }


    private static Person getPerson() {
        return new Person("赵七", 22);
    }


    private static void walk(Person person) {
        person.walk();
    }


    @Test
    public void test2() {

        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.walk();

        Person p2 = new Person("李四", 19);
        p2.walk();

        Person p3 = new Person();
        p3.walk();

    }
}
