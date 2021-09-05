package exception;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 7. 异常的分类
 * 1. 编译异常:（必须处理）
 * 1. 调用了一个抛出异常的方法,调用者不处理,编译失败
 * 2. 应用：IO异常
 * 2. 运行异常:（设计者希望不要处理，修改代码） 但是，在开发者有很多与用户交互的内容，不可控，还是要处理
 * 1. 方法中,抛出的异常是RuntimeException类,或者是他的子类叫做运行异常
 * 2. 方法中,抛出的是运行时异常,方法的声明上,不需要使用throws标识，调用者也不需要处理这个异常
 * 3. 应用：调用者传递参数,传入不合法的数据导致后面所有的计算,没有必要执行了，那么该方法就会抛出运行异常。运行时期异常不能处理,一旦发生,必须停下程序,修改源代码
 */
public class ExceptionTypesTest{

    @Test
    public void FileNotFoundExceptionTest() {
        try {
            new FileReader("a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ClassCastExceptionTest() {
        //java.lang.ClassCastException : 类转换异常
//		Person p = new Student();
//		Teacher t = (Teacher) p;

    }

    @Test
    public void ArithmeticException() {
        //java.lang.ArithmeticException : 算术异常
//		int i = 1/0;
//		System.out.println(i);
    }

    @Test
    public void NullPointerExceptionTest() {
        //java.lang.NullPointerException : 空指针异常
        String s = null;
//		s.toString();

        //java.lang.ArrayIndexOutOfBoundsException: 数组越界异常
//		int[] array = new int[0];
//		int i = array[1];

        //因为文件找不到，io读写（由第三方完成，是否异常的结果是不可控，还是要继续处理）

    }

    @Test
    public void test() {
        /**
         * 问题：边长为负数，比较毫无意义！
         */
        int a = -7;
        int b = 6;
        int areaA = getArea(a);
        int areaB = getArea(b);
        if (areaA >= areaB) {
            System.out.println("A正方形的面积比较大");
        } else {
            System.out.println("B正方形的面积比较大");
        }
    }

    //求正方形的面积
    private static int getArea(int i) {
        if (i <= 0) {
//			Exception e = new Exception("边长为负，面积无意义");
//			return e;
//			throw new Exception("边长为负，面积无意义");
            throw new RuntimeException("边长为负，面积无意义");
        }
        return i * i;
    }
}

class Person8 {
}

class Student extends Person8 {
}

class Teacher extends Person8 {
}
