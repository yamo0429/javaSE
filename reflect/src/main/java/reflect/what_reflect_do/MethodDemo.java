package reflect.what_reflect_do;

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodDemo {

    public static void main(String[] args) {
        Student s = new Student();
        s.show("xxx");
    }

    /**
     * 获取公开方法对象
     */
    @Test
    public void method1() throws Exception {
        //1.获取Class对象,调用默认空参构造获取对象实例，注意：newInstance不是默认空参构造器，只是被空参构造所调用
        Class<?> clazz = Student.class;
        Object obj = clazz.newInstance();
        //2.通过clazz获取方法
        Method method = clazz.getMethod("show", String.class);
        //3.通过方法对象，访问该对象的方法
        method.invoke(obj, "我来自于反射");//TODO 关于获取方法对象以及传参的特殊情况，见笔记搜520，有3+1处

        String name = method.getName(); // TODO 使用反射获取方法对象的各种参数
        Class<?> returnType = method.getReturnType();
    }

    /**
     * 获取私有方法对象
     */
    @Test
    public void method2() throws Exception {
        Class<?> clazz = Student.class;
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("speak", String.class);
        method.setAccessible(true);
        method.invoke(obj, "我来自暴力反射");
    }

    /**
     * 参数是数组的情形（严重）
     * 获取静态方法对象
     */
    @Test
    public void method3() throws Exception {
        Class<?> clazz = Student.class;
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("main", String[].class);
        /**
         * TODO 参数类型是数组的情形==================
         * 非法的参数异常：wrong number of args(参数的数量不对)
         * 因为底层会直接遍历这个数组String[]，得到多个参数，而人家本来只要一个参数，故要手动转为object类型
         *
         */
//		method.invoke(null, new String[]{"hello","world"}); //错误的
        //方案1：
//		Object arg = new String[]{"hello","world"};
//		method.invoke(null, arg);
        //方案2：
        method.invoke(null, (Object) new String[]{"hello", "world"}); // null不可以省略
        //方案3：
//		method.invoke(null, new Object[]{new String[]{"hello","world"}});
    }


}
