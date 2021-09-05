package lambda;

import bean.Person;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * 排序、遍历
 */
public class LambdaTest3 {
    /**
     * List
     * lambda综合案例1：集合排序：list等（注意未去重）--- 还可以在将list转化成stream后进行排序（见LambdaTest2）
     * sort（ArrayList、Collections、Arrays均有sort（Comparator）方法，这里暂演示list的）
     */

    static ArrayList<Person> list = new ArrayList<>();

    static {
        list.add(new Person("eee", 444, 175));
        list.add(new Person("ccc", 333, 177));
        list.add(new Person("ddd", 333, 175));
    }



    /**
     * 排序1
     */
    @Test
    public void test283() {
        // 原始形式
/*        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/

        // 演示lambda各排序方式
//        list.sort((o1, o2) -> o1.getAge() - o2.getAge()); // 形式1。如果降序，则减数与被减数调换位置（相当于改变了符号）
//        list.sort(Comparator.comparingInt(o -> o.getAge())); // 形式2。如果倒序，则加个负号：-o.getAge()
        list.sort(Comparator.comparingInt(Person::getAge)); // 形式3。对类的特殊方法的引用。相比于封装方法，虽不灵活但高效，各有所长
        list.sort(Comparator.comparing(Person::getAge)); // TODO 也可以用comparing，似乎没区别
//        list.sort(Comparator.comparingInt(Person::getAge).reversed()); // 形式3补充：如果倒序，追加reversed方法

//        list.sort(Comparator.comparingInt(Person::getAge).thenComparingInt(Person::getHeight)); // 形式4,在第一个排序基础上追加后续排序规则
//        list.sort(Comparator.comparingInt(Person::getAge).reversed().thenComparingInt(Person::getHeight)).reversed()); // 形式4补充：灵活添加reversed方法
    }

    /**
     * 排序2
     * Collections
     */
    @Test
    public void testee() {
        Collections.sort(list, ((o1, o2) -> o1.getAge() - o2.getAge())); // 原始形式
        Collections.sort(list, Comparator.comparing(Person::getAge)); // 优化
    }
    /**
     * 排序3
     * TreeSet
     * 将集合中的每个元素都带入到compare方法中
     */
    @Test
    public void test222() {
        // 原始形式
        TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        // lambda形式
        TreeSet<Person> set1 = new TreeSet<>((o1, o2) -> o2.age - o1.age);

        // 上面的TreeSet的lambda形式的缺点是：age重复的数据相减结果等于0故会被合并，故需要自定义排序规则
        TreeSet<Person> set = new TreeSet<>((o1, o2) -> {
            if (o2.getAge() <= o1.getAge()) {
                return -1;
            } else {
                return 1;
            }
        });

        set.add(new Person("eee", 444, 175));
        set.add(new Person("aaa", 111, 175));
        set.add(new Person("ccc", 333, 175));
        set.add(new Person("bbb", 222, 175));
        set.add(new Person("ddd", 333, 175));
        System.out.println(set);
    }

    /**
     * 遍历1
     * 将集合中的每个元素都带入到accept方法中，实现自定义处理
     * 遍历的几种方式：for角标、增强for循环、迭代器、forEach
     * forEach：点进去查看该方法，发现有Consumer参数，点进Consumer，发现accept方法
     */
    @Test
    public void test32() {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0); // 把可变参数放入集合
        // 原始形式
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        // lambda表达式形式，实际就是实现了Compatator接口里的accept抽象方法，注意forEach参数是一个匿名内部类
        list.forEach(ele -> {
            if (ele % 2 == 0) {
                System.out.println(ele);
            }
        });
        list.forEach(System.out::println);
    }


    /**
     * 遍历2+过滤，过滤另见filter
     * 过程中的其他方法，以removeIf为例
     * 需求：删除集合中年龄> 222的元素
     */
    @Test
    public void test322() {
        ArrayList<Person> peopleList = new ArrayList<>();
        peopleList.add(new Person("eee", 444, 175));
        peopleList.add(new Person("ccc", 333, 175));
        peopleList.add(new Person("bbb", 222, 175));
        peopleList.add(new Person("ddd", 333, 175));

        ListIterator<Person> iterator = peopleList.listIterator(); // 原始方式
        while (iterator.hasNext()){
            Person person = iterator.next();
            if (person.age > 222){
                iterator.remove();
            }
        }
        peopleList.removeIf(ele -> ele.age > 222); // lambda方式

        System.out.println(peopleList);
    }


}
