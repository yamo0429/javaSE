package clazz.inner_class;

/**
 * 方法内部类
 * 这里三种方式实现笔记本案例，匿名内部类另见其本类演示。另见静态内部类中演示的方法内部类
 */
public class MethodInnerClassTest {
    static int aaa = 999;

    public static void main(String[] args) {
        Computer c = new Computer();

        //1.面向对象方式
        Mouse m = new Mouse();
        c.useUSB(m);

        //2.方法内部类方式：在外部类的成员方法里新建一个类，称为方法内部类。只能访问外部类的静态成员
        class KeyBoard implements USB {
            @Override
            public void open() {
                System.out.println("keyboard is open...");
            }

            @Override
            public void close() {
                System.out.println("keyboard is close...");
            }
        }
        USB k = new KeyBoard();
        int bbb = aaa;
        c.useUSB(k);

        //3.匿名内部类：有2种方式：匿名对象和有名对象
        // 匿名对象：没有名字的对象  有名对象：有赋值的对象
        // 语法： new 接口/父类（）{实现接口方法}   ——这就表示创建了一个子类对象，而且是匿名的
        // 优劣：匿名内部类简化代码，无需定义类。缺点：不知道类的名字

        //匿名内部类的有名对象：这里也属于用父类接收子类对象（只要带大括号就是一个子类）
        USB usb = new USB() {
            @Override
            public void open() {
                System.out.println("video is open...");
            }
            @Override
            public void close() {
                System.out.println("video is close...");
            }
        };
        c.useUSB(usb);

        //匿名内部类的匿名对象
        c.useUSB(new USB() {
            @Override
            public void open() {
                System.out.println("camera is open...");
            }
            @Override
            public void close() {
                System.out.println("camera is close...");
            }
        });
    }
}

interface USB {
    void open();
    void close();
}
class Computer {
    void powerOn() {
    }
    void powerOff() {
    }
    //扩展
    //接口回调方法
    void useUSB(USB usb) {
        usb.open();
        usb.close();
    }
}

class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("mouse is open...");
    }
    @Override
    public void close() {
        System.out.println("mouse is close...");
    }
}




