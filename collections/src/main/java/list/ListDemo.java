package list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * 一、List的特点
 * 1. 有序的集合：元素存储的顺序和取出的顺序相同
 * 2. 具有整数索引,就是下标
 * 3. 允许重复元素
 * 二、List的方法（带索引）
 * 1. add(int index, E element) ：往索引位置添加一个元素
 * 2. get(int index)：获取指定索引的元素
 * 3. remove(int index):移除指定索引的元素，返回被删除的元素
 *    remove(Object o):删除指定的元素，返回删除是否成功
 * 4. set(int index, E element) ：修改指定索引的元素值，返回被修改的元素
 * 5. subList(int fromIndex, int toIndex) ：返回集合的一部分(左包右不包)
 *
 * 三、Java中的 三个越界异常
 * 1. IndexOutOfBoundsException  集合
 * 2. ArrayIndexOutOfBoundsException  数组
 * 3. StringIndexOutOfBoundsException 字符串越界
 * 四、Java中常见的4大异常：
 * NullPointerException、IndexOutOfBoundsException、ClassCastException、IllegalArgumentException
 */
public class ListDemo {

    @Test
    public void set() throws IOException {

    }
    @Test
    public void remove() throws IOException {

    }

    //位移运算符
    @Test
    public void test() throws IOException {

        double i = 4 >> 1;//2.0 **********************************************************!!!!!!!!!!!!!!!!
        System.out.println(i);
    }

    @Test
    public void subList() throws IOException {

        List<String> list = new ArrayList<String>();
        list.add("天宫1号");
        list.add("天宫2号");
        list.add("天宫3号");
        list.add("天宫4号");

        //包左不包右
        List<String> subList = list.subList(1, 3);
        for (String string : subList) {
            System.out.println(string);
        }

    }

    @Test
    public void get() throws IOException {

        List<String> list = new ArrayList<String>();
        list.add("天宫1号");
        list.add("天宫2号");
        list.add("天宫3号");
        list.add("天宫4号");
        //在已有的基础上修改
        list.set(2, "天宫333号");

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            System.out.println(name);
        }
    }


    @Test
    public void add() throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("天宫1号");
        list.add("天宫2号");
        list.add("天宫3号");
        list.add("天宫4号");

        //java.lang.StringIndexOutOfBoundsException
        String s = "abc";
        s.charAt(4);

        //java.lang.ArrayIndexOutOfBoundsException
        String[] array = {};
        System.out.println(array[0]);

        //java.lang.IndexOutOfBoundsException : 集合索引越界异常
        list.add(5, "天宫5号");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);
        }

    }
}
