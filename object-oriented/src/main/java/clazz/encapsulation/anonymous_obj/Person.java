package clazz.encapsulation.anonymous_obj;

/**
 * 类的格式与成员：成员变量 + 成员方法
 *      修饰符	class{
 *          成员变量；
 *          构造方法；
 *          set和get方法；
 *          其他一般方法；
 *      }
 */
class Person {
    //在类中，属性使用成员变量表示；为了数据安全，所以使用private关键字修饰成员变量
    private String name;
    private int age;

    //有参和无参的构造方法
    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //因为成员变量都已经私有化，为了外界可以访问，所以需要提供公开的get和set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //在Java的类中，使用方法表示事物的行为；所以接下来要定义两个方法表示吃饭和说话这两个行为
    public void eat() {
        System.out.println("吃饭");
    }

    public void say() {
        System.out.println("我叫" + name + "，今年" + age + "岁");
    }

    public void walk() {
        System.out.println("walk 方法执行");
    }
}