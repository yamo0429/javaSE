package set;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * ##三. 集合Collection接口的子接口：Set集合
 * 1. Set集合特点
 * 1. 不包含重复元素,不保证集合中的元素顺序
 * 2. 无索引
 * 3. Set接口的方法和Collection父接口中一样
 * 2. HashSet实现类演示set特点
 * 1. 遍历集合：迭代器和增强for循环遍历，结果是去重而有序的
 * 2. 添加元素：相同元素不能重复添加（add方法返回false）
 * 3. Hashset本质上是HashMap
 */
public class HashSetTest {

    @Test
    public void test1() throws IOException {
        ArrayList<Object> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        System.out.println("===list长度：" + list.size());

        Set<String> set = new HashSet<String>();
        for (Object str : list) {
            set.add((String) str);
        }
        System.out.println("===set长度：" + set.size());

        for (String word : set) {
            System.out.println(word);
        }

    }

    //元素去重
    @Test
    public void test0429() {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        list.add("aa");
        list.add("aa");
        list.add("bb");
        //去重前
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("======去重前======");
        //去重后
        set.addAll(list);
        for (String strings : set) {
            System.out.println(strings);
        }
        System.out.println("======去重后======");

        list.clear();
        list.addAll(set);
        for (String s : list) {
            System.out.println(s);
        }

    }

}
