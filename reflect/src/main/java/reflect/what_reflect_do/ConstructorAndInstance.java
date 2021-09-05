package reflect.what_reflect_do;

import java.io.Closeable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;

import org.junit.Test;
import sun.invoke.empty.Empty;

public class ConstructorAndInstance {
    /**
     * 通过公开的空参构造获取构造器（即getConstructor()）对象，进而获取类对象
     */
    @Test
    public void method1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //通过调用默认的空参构造创建类的对象
        Class<?> clazz = Class.forName("reflect.what_reflect_do.Student");
        Constructor<?> constructor = clazz.getConstructor();
        Object object1 = constructor.newInstance();

// 由于是调用默认的无参构造创建类对象，故以上两句相当于 clazz.newInstance();这一句
    }

    /**
     * 2.通过公开的有参构造获取构造器对象，进而获取类对象
     */
    @Test
    public void method2() throws Exception {
        //1. 获取Class对象
        Class<?> clazz = Class.forName("reflect.what_reflect_do.Student");
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        //3.通过构造器对象创建实例
        Object object = constructor.newInstance("哪吒", 3);

        System.out.println(object);

    }

    /**
     * 3.通过私有的有参构造、私有的无参构造获取构造器对象，进而获取类对象
     */
    @Test
    public void method3() throws Exception {
        //1. 获取Class对象
        Class<?> clazz = Class.forName("reflect.what_reflect_do.Student");
        //2.获取有参构造器对象(无论是否私有，但参数列表要一致) TODO 能否遍历所有构造器？
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, int.class);
        //获取无参构造器对象（无论是否私有）
        Constructor<?> constructor2 = clazz.getDeclaredConstructor();//Student 22行
        //3. 设置暴力访问（让它开放权限）
        constructor.setAccessible(true);

        //4.通过构造器创建实例
        Object object2 = constructor.newInstance("蓝星", 19, 9527);//对应上面的有参构造器对象30行
        Object object1 = constructor2.newInstance();// 调用默认空参构造时，还可以直接用clazz.newInstance()创建对象
        System.out.println(object2);
        System.out.println(object1);
    }


}
