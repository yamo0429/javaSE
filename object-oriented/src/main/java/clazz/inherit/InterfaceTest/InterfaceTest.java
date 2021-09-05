package clazz.inherit.InterfaceTest;

import org.junit.Test;

/**
 * * 需求：猫和狗都会导盲，但是狼不会    解决：接口interface （为了弥补java类的单继承的不足）
 * 1. 接口的实现： class A extends B implements C（接口）、2. 类实现接口，就拥有接口所有的属性和方法
 * 2. 接口名、常量和抽象方法
 * 3. 接口中的属性都是常量，默认用public final static修饰(常量名要大写，规范)
 * 4. 接口中的方法都是抽象方法，默认用public abtract修饰
 * 5. 类只能继承一个父类
 *    类可以实现多个接口：一个类可实现多个接口，这些接口之间可以存在相同的方法和属性
 *    接口可以继承多个接口：interface GoodBabySitter extends BabySitter,Singable{...}
 */
public class InterfaceTest {
    @Test
    public void interfaceTest() {
        Dog dog = new Dog();

        dog.name = "哮天犬";
        dog.eat();
        dog.shout();
        dog.run();

        dog.drugDetection();
        dog.blingGuiding();
    }
}

interface Guidable {
    int YEARS = 2;

    void blingGuiding();
}

interface DrugDetecatable {
    int YEARS = 3;

    void drugDetection();
}

abstract class Animal {
    String name;

    abstract void shout();

    abstract void eat();

    void run() {
        System.out.println(name + "正在狂奔！");
    }
}

class Dog extends Animal implements Guidable, DrugDetecatable {

    @Override
    public void drugDetection() {
        System.out.println(name + "正在缉毒！");
    }

    @Override
    public void blingGuiding() {
        System.out.println(name + "经过" + Guidable.YEARS + "年的训练 ，学会了导盲！");
        System.out.println(name + "经过" + DrugDetecatable.YEARS + "年的训练 ，学会了缉毒！");
    }

    @Override
    void shout() {
        System.out.println(name + "正在汪汪叫！");
    }

    @Override
    void eat() {
        System.out.println(name + "正在狂吃骨头！");
    }

}

class Cat extends Animal implements Guidable {

    @Override
    public void blingGuiding() {
    }

    @Override
    void shout() {
    }

    @Override
    void eat() {
    }

}

class Wolf extends Animal implements DrugDetecatable {

    @Override
    public void drugDetection() {
    }

    @Override
    void shout() {
    }

    @Override
    void eat() {
    }

}










