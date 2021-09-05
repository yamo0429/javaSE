package clazz.polymorphism;

import org.junit.Test;

/**
 * 多态：父类引用指向子类对象，父类引用调用方法，执行的是子类重写的方法
 * 多态三要素
 * 1. 继承
 * 2. 方法重写
 * 3. 向上转型
 */
public class DowncastTest {
    @Test
    public void downcastTest() {

        //这里使用子类进行接收，但是在方法声明处使用了父类发生了向上转型，跟这里使用父类接收，然后调用子类方法，效果一样，区别在于前者封装了一个静态方法
        BarberMan b = new BarberMan();
        b.name = "tony";
        cut(b);

        DoctorMan d = new DoctorMan();
        d.name = "五大三粗的医生";
        cut(d);


    }

    /**
     * 3. 向下转型
     */
    //扩展方法，具备通用性
    private static void cut(Man p) { //多态
        p.doSomething();//此时执行的是子类方法，如果想要执行子类方法，下面要向下转型
        /**
         * 需求：每个子类有其特有方法
         * 问题：但是父类引用，不能调用子类特有方法（编译看左边）
         * 解决：
         * 		向下转型：父类引用转成子类类型（强制类型转换）
         * 		语法：子类类型  b = (子类类型) 父类引用;
         *      弊端：ClassCastException（安全隐患，类转换异常）Doctor cannot cast to Barber
         *      解决： 双元运算符 instanceof
         */
        //判断变量p是否是 BarberMan 类的实例，如果是则为true
        if (p instanceof BarberMan) {
            BarberMan b = (BarberMan) p;
            b.chasingGirl();
        }
        if (p instanceof DoctorMan) {
            DoctorMan d = (DoctorMan) p;
            d.temptationOfUniform();
        }

    }
}

class Man {
    String name;

    void doSomething() {
        System.out.println(name + "正在不可描述！");
    }
}

class BarberMan extends Man {
    @Override
    void doSomething() {
        System.out.println(name + "给你理发！");
    }

    void chasingGirl() {
        System.out.println("窈窕淑女，君子好逑！");
    }

}

class DoctorMan extends Man {
    @Override
    void doSomething() {
        System.out.println(name + "给你搭桥！");
    }

    void temptationOfUniform() {
        System.out.println(name + "正在手术台上表演制服诱惑！");
    }

}

