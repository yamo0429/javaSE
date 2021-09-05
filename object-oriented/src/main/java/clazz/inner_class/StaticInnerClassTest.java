package clazz.inner_class;

/**
 * 虽然本类主讲静态内部类，但这里还有成员内部类、方法内部类做对比，只差一个匿名内部类
 */
public class StaticInnerClassTest {
    int kk;
    static int ggg;
    static void vvv(){

    }

    public static void main(String[] args) {

        OuterClass oc = new OuterClass();
        oc.outerField = 1;

        //外部类访问成员内部类：MemberInner innerClass = new OuterClass().new MemberInner();
        OuterClass.MemberInner memberInner = oc.new MemberInner();

        //外部类访问静态内部类
        OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
        //外部类可以访问静态内部类所有成员：静态/非静态属性、静态/非静态方法
        System.out.println(sic.innerField);
        System.out.println(OuterClass.StaticInnerClass.staticInnerField);

        /**
         * 方法内部类
         * 方法内部类是指在成员方法中定义的类,它只能在当前方法中存在和被调用，可访问外部类的静态成员
         */
        class MethodInnerClass {
            int iii;
            void show() {
                //方法内部类只能调用外部类静态成员（属性和方法）,main方法除外
                System.out.println(ggg);
                vvv();
//                System.out.println(kk);
            }
        }
        //方法内部类只能在当前方法中存在和和调用
        MethodInnerClass mc = new MethodInnerClass();
        mc.iii = 3;
        mc.show();

    }
}

class OuterClass {
    int outerField;
    static String name;
    MemberInner memberInner; //将成员内部类声明成外部类的属性（常为私有），静态内部类无需声明

    void outerMethod() {  //外部类自己的非静态成员方法
        System.out.println(outerField);
        MemberInner memberInner = new MemberInner(); //这里将声明MemberInner去掉也是可以的，因为成员位置已经声明过了
    }
    static void outerStaticMethod(){ //外部类自己的静态成员方法
        System.out.println("static Method");
    }
    /**
     * 成员内部类
     */
    class MemberInner {
        void innerMethod() {
            //成员内部类访问外部类的所有方法和变量
            outerMethod();
            System.out.println(OuterClass.name);
            System.out.println(outerField);
        }
    }

    /**
     * 静态内部类
     */
    static class StaticInnerClass {
        static int staticInnerField =1; //在静态内部类中可以定义静态成员和非静态成员,而在成员内部类中不允许定义静态成员
        int innerField;
        void dosth(){
            outerStaticMethod();//在静态内部类方法中只能访问外部类的静态成员，无法访问外部类的对象方法和非静态属性
            name = "lll";
        }
    }
}





