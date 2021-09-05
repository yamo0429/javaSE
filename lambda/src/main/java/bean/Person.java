package bean;

public class Person {
    public String name;
    public int age;
    public int height;

    public Person() {
        //        System.out.println("Person无参构造执行了");
    }

    public Person(String name, int age, int height) {
        //        System.out.println("Person有参构造执行了");
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {

        return age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

}
