package enumTest;

import bean.Color1;
import bean.Color2;
import org.junit.Test;

/**
 * 枚举类除了这里所有演示的之外，还可以作为静态内部类，注意不是下面的对外的静态方法
 * 枚举实例之间注意是逗号隔开，不是分号！！！！！
 */
public class EnumStartTest {
    /**
     * 测试只有枚举实例，而不带属性值的枚举类
     */
    @Test
    public void color1Test() {

        Color1 color1 = Color1.Red;
        switch (color1) {
            case Red:
                //放入代码块中也是可以的
            {
                System.out.println("Red");
                break;
            }
            case Yellow:
                //不放入代码块也可以。也可以再次调用某个方法
                System.out.println("Yellow");
                break;
            default:
                break;
        }
    }

    /**
     * 测试带属性的枚举类
     * 构造器的作用（本类中的枚举实例在声明的时候，就会调用该构造器初始化自己的属性）
     * 通过get方法获取枚举对象里的属性
     */
    @Test
    public void color2Test() {
        //在Color2.Red的时候，调用了构造器初始化了两个属性(参数是Red后面的具体属性值)，然后调用自定义的用于获取枚举属性的get***方法获取
        String color = Color2.Red.getColor();
        int no = Color2.Red.getNo();
        System.out.println(color + "===" + no);
    }

    /**
     * 测试枚举类的对外的静态方法
     */
    @Test
    public void outerMethodTest() {
        Color2 color2 = Color2.outerMethod(3); //枚举类自定义方法使用static修饰后，可以直接类名访问
        System.out.println(color2);
    }
}



