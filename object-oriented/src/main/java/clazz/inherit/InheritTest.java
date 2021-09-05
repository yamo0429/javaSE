package clazz.inherit;


import org.junit.Test;

/**
 * 继承三要素：
 * 1.子类继承父类，拥有并且可以访问父类中所有可继承的属性和方法（构造方法除外，私有），对于私有属性，可通过set方法访问
 * 2.子类可以对父类方法进行重写:方法名、参数列表、返回值类型相同，只有方法体不同
 * 3.子类可通过super封关键字访问父类成员

 * 方法重写：如果子类没有重写方法，那么就调用父类中的方法，否则就调用子类中的方法。。通过@override注解检验。
 */

class InheritTest {
    @Test
    public void sayHiTest() {
        Chinese chinese = new Chinese();
        chinese.name = "中国人";
        chinese.sayHi();
        chinese.walk();

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

class Chinese extends Man {
    //Chinese 直接继承父类方法，没有重写
}


class Janpnese extends Man {
    String name;

    @Override
    public void sayHi() {
        String  name = "局部张三"; //如果定类义了局部name，且name前没有this关键字，就会调用局部name，而不会调用成员name （就近原则），如果有this，即调用成员 （this表示本类）
        System.out.println("Janpnese类中" + this.name + "说:偶嗨哟！");

        //以下演示子类调用父类成员
        System.out.println("Janpnese类中" + super.name + "说:偶嗨哟！");
        super.walk();
    }
}









