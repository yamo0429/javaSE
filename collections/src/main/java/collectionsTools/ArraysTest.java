package collectionsTools;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 数组和集合互转的几种形式
 * 可变参数就是数组
 */
public class ArraysTest {

    @Test
    public void test33() {
        String[] array = {"aaa","bbb"};
        List<String> list = Arrays.asList(array);
        Object[] objects = list.toArray();
        System.out.println(list.toString());
    }

    @Test
    public void test313() {
        List<String> list = Arrays.asList("aaa","bbb");
        Object[] objects = list.toArray();
        System.out.println(list.toString());
    }
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1,2,3,4);
        Object[] objects = list.toArray();
        System.out.println(list.toString());
    }

    @Test
    public void test(){

    }


}
