package io.serializaton_deserialization;

import java.io.Serializable;

/**
 * 1. java.io.NotSerializableException：javabean想要能够序列化,必须实现 Serializable 接口。Serializable 接口没有任何方法和属性,这种接口称之为   '标识接口'
 * 2. java.io.InvalidClassException：如果这个类没有id可以唯一标识,那么修改这个类,序列化流无法找到对应信息
 */
public class Student implements Serializable {

    /**
     * 根据该类的所有信息生成的唯一ID，以后再修改该类信息，则该ID不会改变，相当于一张身份证
     */
    private static final long serialVersionUID = 6648253977470508548L;
    private String name;
    // @transient : 瞬间\瞬态，特点:不能被序列化，忽略该字段
    private transient int age;

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public void speak() {

    }

    public void show() {

    }

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

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

}
