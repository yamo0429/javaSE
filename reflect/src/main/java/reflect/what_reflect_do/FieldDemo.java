package reflect.what_reflect_do;

import java.lang.reflect.Field;

import org.junit.Test;

public class FieldDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("zs");
        s.setAge(18);
    }

    /**
     * 获取公开属性对象
     */
    @Test
    public void filed1() throws Exception {

        Class<?> clazz = Class.forName("reflect.what_reflect_do.Student");
        Object obj = clazz.newInstance();//调用无参构造方法创建对象实例
        Field field = clazz.getField("id"); //通过属性名：获取属性对象

        field.set(obj, 11);
        int id = (int) field.get(obj);//通过属性对象，访问该对象的属性
        System.out.println(id);
    }
    /**
     * 获取私有属性对象
     */
    @Test
    public void filed2() throws Exception {
        Class<?> clazz = Class.forName("reflect.what_reflect_do.Student");
        Object obj = clazz.newInstance();

        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj, "·纪伯伦");

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj, 18);

        System.out.println(obj);
    }


}