package clazz.inherit.super_key;

import org.junit.Test;

class SuperTest3 {
    @Test
    public void superTest3() {
        Student stu = new Student("张三", 38, '男', "1024");
        stu.introduce();
    }
}

class Person {
    String name;
    int age;
    char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
    }
}

class Student extends Person {
    String stuNumber;

    public Student(String name, int age, char gender, String stuNumber) {

//        标准写法
        super(name, age, gender);
        this.stuNumber = stuNumber;

//        次等方法：
//        super.name = name;
//        super.age = age;
//        super.gender = gender;

//        末等方法
//        this.name = name;
//        this.age = age;
//        this.gender = gender;	this.stuNumber = stuNumber;

    }

    void introduce() {
        System.out.println("大家好, 我叫" + name + ", 我今年" + age + "岁了. " + gender);
        System.out.println("我的学号是: " + stuNumber);
    }
}