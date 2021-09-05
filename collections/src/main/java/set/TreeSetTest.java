package set;

import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {


    // 元素az排序
    @Test
    public void test() throws IOException {

        // 二叉树算法：自然顺序
        Set<String> set = new TreeSet<String>();
        // 根据内部的哈希算法，固定排序
        set.add("b");
        set.add("a");
        set.add("c");
        boolean add = set.add("a");
        // 因为不包含重复元素，故存入重复元素，失败
        System.out.println(add);

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String word = it.next();
            System.out.println(word);
        }
    }



}
