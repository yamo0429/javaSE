package list;

import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * ##三. List实现类:LinkedList特点
 * 1. 底层数据结构链表,双向链表
 * 2. 查询速度慢,增删快
 * 3. 线程不安全集合,运行速度快
 * <p>
 * 4. 特有方法（不能使用多态,即接口接收子类对象）
 * 1. addFirst 元素添加在链表开头
 * 2. addLast（add相同） 元素添加在链表结尾
 * <p>
 * 3. getFirst 获取链表开头
 * 4. getLast  获取链表结尾
 * <p>
 * 5. removeFirst 移除并返回链表开头
 * 6. removeLast 移除并返回链表结尾
 * <p>
 * 7. push 将元素推入此列表所表示的堆栈（元素存储到集合顶部,addFirst）
 * 8. pop 从此列表所表示的堆栈处弹出一个元素（最顶部元素弹出,removeFirstt）
 */
public class LinkedListTest {

    @Test
    public void linkedListTest() throws IOException {

//		 Collection<String> coll = new ArrayList<String>(); //存取顺序相同
        LinkedList<String> coll = new LinkedList<String>(); //存取顺序相同
//		 Collection<String> coll = new HashSet<String>(); //可去重复元素
//        Collection<String> coll = new TreeSet<String>(); //存入时自动排序

        coll.add("黛玉");
        coll.add("黛玉2号");
        coll.add("黛玉08号");
        coll.add("黛玉88号");

        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);
        }
    }

    @Test
    public void push() throws IOException {

        LinkedList<String> ll = new LinkedList<String>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");

        ll.push("e");
        String pop = ll.pop();
        System.out.println(pop);
        System.out.println(ll);
    }

    @Test
    public void getFirst() throws IOException {

        LinkedList<String> ll = new LinkedList<String>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");

        //不修改集合
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll);
        //从集合中移除
        String removeFirst = ll.removeFirst();
        String removeLast = ll.removeLast();
        System.out.println(ll);

    }

    @Test
    public void addFirst() throws IOException {

        LinkedList<String> ll = new LinkedList<String>();

        ll.add("a");
        ll.add("b");
        ll.add("c");
        ll.add("d");

        ll.addFirst("e");
        ll.addLast("f");

        for (String word : ll) {
            System.out.println(word);
        }
    }
}
