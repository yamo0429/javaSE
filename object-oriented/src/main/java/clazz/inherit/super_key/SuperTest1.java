package clazz.inherit.super_key;

import org.junit.Test;

/**
 * super用法1：用于访问父类的成员
 */
class SuperTest1 {
    @Test
    public void superTest1() {
        Janpnese janpnese = new Janpnese();
        janpnese.name = "苍老师";
        janpnese.sayHi();
    }
}


class Man {
    String name = "Man";

    public void sayHi() {
        System.out.println(name + "说:大家好！");
    }

    public void walk() {
        System.out.println("walk walk");
    }
}


class Janpnese extends Man {
    String name;

    @Override
    public void sayHi() {
        String name = "局部张三"; //如果定类义了局部name，且name前没有this关键字，就会调用局部name，而不会调用成员name （就近原则），如果有this，即调用成员 （this表示本类）
        System.out.println("Janpnese类中" + this.name + "说:偶嗨哟！");

        //以下演示子类调用父类成员
        System.out.println("Janpnese类中" + super.name + "说:偶嗨哟！");
        super.walk();
    }
}









