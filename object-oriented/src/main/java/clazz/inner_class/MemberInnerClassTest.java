package clazz.inner_class;

/**
 * 下面每一句注释都是要点
 */
public class MemberInnerClassTest {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.introduce();
        //外部类访问成员内部类方式：格式: 外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
        Outer.Inner in = new Outer().new Inner();
        in.show();
    }
}

class Outer {
    private String name = "外部类的name属性";
    private Inner inner;  //外部类将内部类声明成自己的成员属性用以访问内部类（常为私有）

    class Inner {  //定义了一个内部类,在成员属性的位置上. (成员内部类)
        //成员内部类不可以声明静态变量,静态方法.因为成员变量是属于对象的,静态与对象无关
        //另见笔记：成员内部类编译特点：OuterClass$InnerClass 表示：InnerClass是属于OuterClass的成员
        public void show() {
            System.out.println("我是成员内部类的show方法.");
            System.out.println("在内部类中访问外部类的成员属性:" + name);
            introduce();  //在成员内部类方法中可访问外部类所有方法和属性（包括静态的成员）
            name = "aaa";
        }
    }

    public void introduce() {
        System.out.println("大家好,我是外部类的introduce方法.");
        //在外部类方法中创建内部类对象,并调用内部类的方法，实际在new前可加this关键字，见上外部类访问成员内部类方式
//       Inner in = new Outer().new Inner();
//       Inner in = this.new Inner();
        inner = new Inner(); //这里可以声明也可以不声明，若不声明，则名字要相同
//        in.show();
    }
}
