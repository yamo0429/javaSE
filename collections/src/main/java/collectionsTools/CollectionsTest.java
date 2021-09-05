package collectionsTools;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ##五. Collections集合操作工具类
 * 1. sort:对List集合排序,自然顺序升序排列
 * <p>
 * 2. shuffle:对List集合元素,随机排列,每次执行方法,效果不同
 */
public class CollectionsTest {

    @Test
    public void test33(){
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,7,8,9,0); // 把可变参数放入集合，可变参数就是数组
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void shuffle() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        list.add(-100);
        list.add(2);
        list.add(8);
        list.add(-71);
        list.add(99);

        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

    }

    @Test
    public void ascii() {
        char c = '世';
        int i = c;
        System.out.println(i);

        char a = 'a';
        int j = a;
        System.out.println(j);

        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void sort2() {
        //按ASCII码的顺序
        ArrayList<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("cba");
        list.add("界");
        list.add("itheima");
        list.add("itbanma");
        list.add("american vedio");
        list.add("world");
        list.add("世");

        Collections.sort(list);
        for (String word : list) {
            System.out.println(word);
        }

    }

    @Test
    public void sort() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        list.add(-100);
        list.add(2);
        list.add(8);
        list.add(-71);
        list.add(99);

        System.out.println(list.toString());
        Collections.sort(list);
        System.out.println(list.toString());

    }
}
