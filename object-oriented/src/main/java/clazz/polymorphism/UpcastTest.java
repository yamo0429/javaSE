package clazz.polymorphism;
/**
 * 提高代码扩展性、复用性
 * 多态： 父类/接口的引用指向子类对象(发生了向上转型，即隐形的类型转换)，父类引用调用方法，执行的是子类重写的方法
 * 多态发生在两个地方：1 父类引用接收子类对象处 2 方法形参处
 */

import org.junit.Test;

public class UpcastTest {
    @Test
    public void upcastTest() {

        Person b = new Barber(); // TODO 多态1：子类对象使用父类接收
        b.name = "tony";
        cut(b);
    }


    //有人喊Cut，不同的职业有不同的行为
    private static void cut(Person p) { // TODO 多态2：方法形参使用父类接收
        p.doSomething();
    }
}

/**
 * 医生、理发师、演员     共性行为    dosomething()
 */
abstract class Person {  //这里使用 抽象类/接口都可以
    String name;

    //防止编译出错，编译看左边
    abstract void doSomething();
}

class Doctor extends Person {

    @Override
    void doSomething() {
        System.out.println(name + "给你开膛破肚！");
    }

}

class Barber extends Person {

    @Override
    void doSomething() {
        System.out.println(name + "给你理发！");
    }

}

class Actor extends Person {

    @Override
    void doSomething() {
        System.out.println(name + "停止表演！");
    }

}