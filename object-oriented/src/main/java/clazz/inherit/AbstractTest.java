package clazz.inherit;

import org.junit.Test;

/**
 * 当定义一个类时,常常需要定义一些方法来描述该类的行为特征,但有时这些方法的实现方式是无法确定的.
 * 例如定义了一个 Animal 类, shout() 方法用于表示动物的叫声,但是针对不同的动物,叫声也是不同的.因此在 shout() 方法中无法准确描述动物的叫声.
 * 针对这一问题, Java允许在定义方法时不写方法体,不包含方法体的方法称为抽象方法.抽象方法必须使用 abstract 关键字来修饰.
 * 当一个类中包含了抽象方法,该类必须使用abstract关键字来修饰,使用abstract关键字修饰的类为抽象类
 */
class AbstractTest {
    @Test
    public void abstractTest() {
        Dog ddd = new Dog();
        ddd.shout();
        ddd.eat();

        Cat ccc = new Cat();
        ccc.shout();
        ccc.eat();

        // 1. 创建一个 Animal 类的对象
        // Animal a = new Animal(); 编译失败,不能实例化对象
        // a.shout();
    }
}


abstract class Animal {
    abstract void shout();

    abstract void eat();
}


class Dog extends Animal {
    void shout() {
        System.out.println("汪汪汪...");
    }

    void eat() {
        System.out.println("跟我混,有骨头吃...");
    }
}


class Cat extends Animal {
    void shout() {
        System.out.println("喵喵喵...");
    }

    void eat() {
        System.out.println("跟我混,有鱼吃...");
    }


}