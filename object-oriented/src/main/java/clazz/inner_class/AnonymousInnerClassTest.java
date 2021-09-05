package clazz.inner_class;

/**
 * 匿名内部类（实际是方法内部类的特殊形式）：位置、格式、匿名对象、有名对象。另见方法内部类演示里的匿名内部类
 *  new Object() { }：表示Object的一个匿名子类的一个对象，该对象尚未赋值，因此也是匿名的
 *  匿名内部类常用于lambda表达式中
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        //匿名内部类(Object的子类)的匿名对象
        new Object() {
            void show() {
                System.out.println("哈哈，我是匿名obj");
            }
        }.show();

        //匿名内部类(Object的子类)的有名对象
        Object obj = new Object() {
            void show() {
                System.out.println("哈哈，我是obj1");
            }
        };

//		obj.show(); //父类引用不能调用子类特有方法，因为匿名内部类虽然是子类，但没有名字，无法强转向下转型
    }
}
