package clazz.inherit.super_key;

import org.junit.Test;

/**
 * super用法2：super()隐式调用父类空参构造——即子类实例化过程
 * 一旦构造方法重载，系统就不再提供默认的无参构造，这导致子类无法实例化
 *      解案一：在子类中手动显式调用父类存在的构造方法
 *      方案二：父类中定义一个无参的构造方法,方便子类的创建与调用
 */


class SuperTest2 {
    @Test
    public void superTest1() {
        Son son = new Son();
    }
}

class Father {
    String name;

    //方案二：父类中定义一个无参的构造方法,方便子类的创建与调用
  /*  public Father() {
        System.out.println("Father 构造方法被调用 ...");
    }*/

    public Father(String name) {
        this.name = name;
        System.out.println("name=" + name);
    }

}

class Son extends Father {

    public Son() {
        //方案：在子类中手动显式调用父类存在的构造方法
        super("浅仓南");
        System.out.println("Son 构造方法被调用 ...");
    }

}