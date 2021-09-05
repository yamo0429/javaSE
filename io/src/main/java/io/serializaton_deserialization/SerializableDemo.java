package io.serializaton_deserialization;

import java.io.*;

/**
 * 需求：将一个自定义对象存储到文件中(序列化), 并读取出来（反序列化）
 */
public class SerializableDemo {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        Student student = new Student("张太极", 18);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f:/test_io/stu.txt"));
        oos.writeObject(student);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:/test_io/stu.txt"));
        Student readObject = (Student) ois.readObject();
        System.out.println(readObject);
    }


}
