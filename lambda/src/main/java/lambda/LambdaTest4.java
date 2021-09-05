package lambda;

import bean.Person;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * lambda表达式的流式编程
 * 1 list、set、array、file与管道流互转1
 * 2 管道流方法介绍
 */
public class LambdaTest4 {

    static ArrayList<Person> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static ArrayList<String> list3 = new ArrayList<>();
    static {
        Collections.addAll(list,new Person("eee", 444, 175),new Person("ccc", 333, 177));
        Collections.addAll(set,9,2,5,3,4);
        Collections.addAll(list3,"ddddd","c","aa");
    }

    /**
     * 方法介绍1
     */
    @Test
    public void test(){
        set.stream()
                .map(ele -> ele*10) // map表示对每个元素进行映射处理
                .filter(ele -> ele>20) // 过滤
                .sorted() // 首字母排序，括号里可传递排序规则
                .sorted((ele1,ele2) -> ele1 - ele2) // 数值排序
                .sorted(Comparator.comparingInt(ele -> ele)) // 数值排序简化，comparingInt可以用comparing代替
                .distinct() //  去重
                .forEach(ele -> System.out.println(ele)); // 遍历
    //         .forEach(System.out::println); // 或者这样输出也可
    }

    /**
     * 方法介绍2
     */
    @Test
    public void te2st(){
        list3.stream()
                .map(String::toUpperCase) // 可以明确调用者的，就可以用该方法引用格式
                .collect(Collectors.toList()); // 把流转成list。如果不是最后一步终操作，则不会最终改变原集合

        System.out.println(list3);
    }
    /**
     * 方法介绍3
     */
    @Test
    public void te23st(){
        list3.stream()
                .mapToInt(String::length) // map还有多种扩展用法
        .forEach(System.out::println);

        System.out.println(list3);
    }
    /**
     * 方法介绍4：peek（如果参数和返回值是同种类型，则可以用peek替换map，并舍去return语句）  TODO======================
     */
    @Test
    public void te223st(){

    }

    /**
     * flatMap：用于for循环嵌套情形，待深入整理
     */
    @Test
    public void te2323st(){
        List<String> words = Arrays.asList("htlle","world");
        words.stream()
                .map(w -> Arrays.stream(w.split("")))  // Arrays.stream是把数组转换成流，可以不要
                .forEach(System.out::println);

        words.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .forEach(System.out::println);
    }
    /**
     * 将一个或多个字符串数组（经split生成），转换成一个管道流
     */
    @Test
    public void te2423st(){
        Stream<String> stream = Arrays.stream("sa,df".split(","));

    }

    /**
     * 数组转流
     */
    @Test
    public void tes23ts(){
        Stream<String> stream = Stream.of("ddd", "aaa");
        List<String> list = stream
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 文件转流
     * 把文件的每一行转换成字符串数组的元素：[aaaaaaaa, aaaaaaaa]
     */
    @Test
    public void tes23t3s() {
        try {
            Stream<String> stream = Files.lines(Paths.get("aaa.txt"));
            List<String> collect = stream.collect(Collectors.toList());
            System.out.println(collect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * reduce：规约，注意有返回值，故跟forEach互斥
     */
    @Test
    public void test22(){
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,5,2,5,3,4);

        Optional<Integer> optional = list.stream()
                .map(ele -> ele * 10)
                .filter(ele -> ele > 30) // 过滤
                .sorted((num1, num2) -> num1 - num2) // 排序。p1 - p2：顺序排序，反之倒序
                .distinct() //  去重
                .reduce((ele1, ele2) -> ele1 + ele2); // 规约

        Integer integer = optional.get(); // get方法可以得到集合中的那个元素
        System.out.println(integer);
    }

    /**
     * 如何流式处理对象
     * collect
     */
    @Test
    public void test25(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("eee", 444, 175));
        list.add(new Person("ccc", 333, 176));
        list.add(new Person("bbb", 222, 177));
        list.add(new Person("ddd", 333, 175));

        List<Person> collect = list.stream()
                .filter(person -> person.getAge() > 222)    // 过滤
                .collect(Collectors.toList());              // 将结果收集起来，即从流——>集合，此外还可以toMap、toSet
        System.out.println(collect);
    }


    /**
     * 部分过滤方法
     */
    @Test
    public void test4235(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("eee", 444, 175));
        list.add(new Person("ccc", 333, 176));
        list.add(new Person("bbb", 222, 177));
        list.add(new Person("ddd", 333, 175));

        boolean b = list.stream()
//                .anyMatch(person -> person.getAge()>333)       // 只要有一个满足即可
                .allMatch(person -> person.getAge() > 222);      // 所有都满足某个条件
        System.out.println(b);
    }

    /**
     * count：统计个数
     */
    @Test
    public void test42435(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("eee", 444, 175));
        list.add(new Person("ccc", 333, 176));
        list.add(new Person("bbb", 222, 177));
        list.add(new Person("ddd", 333, 175));

        long b = list.stream()
                .count();      // 统计个数，注意中间不能加过程，只能是对流进行统计
        System.out.println(b);
    }
    /**
     * findFirst
     */
    @Test
    public void test4245(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("eee", 444, 175));
        list.add(new Person("ccc", 333, 176));
        list.add(new Person("bbb", 222, 177));
        list.add(new Person("ddd", 333, 175));

        Optional<Person> b = list.stream()
                .sorted((p1,p2)-> p1.getAge() - p2.getAge())
                .findFirst();      // 拿到上一步操作后的第一个
        System.out.println(b);
    }
    /**
     * min、max 获取最值方式1 —— 重要，先排序，才能获取最值
     * get方法
     */
    @Test
    public void test425(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("eee", 444, 175));
        list.add(new Person("ccc", 333, 176));
        list.add(new Person("bbb", 222, 177));
        list.add(new Person("ddd", 333, 175));

        Person personMin = list.stream()
                .min(Comparator.comparing(person -> person.getAge())).get();
        Person personMax = list.stream()
                .max(Comparator.comparing(person -> person.getAge())).get();

        // 对象方法引用形式——对上面person -> person.getAge()的简化，见LambdaTest2
        Person personMin2 = list.stream()
                .min(Comparator.comparing(Person::getAge)).get();
        Person personMax2 = list.stream()
                .max(Comparator.comparing(Person::getAge)).get();

//        Optional<Person> min = list.stream().min(Comparator.comparing(Person::getAge));
//        Person person = min.get();

        System.out.println(personMin.getAge() + "-" + personMax.getAge()); // 222-444
        System.out.println(personMin2.getAge() + "-" + personMax2.getAge());
    }

    /**
     * min、max 获取最值方式2 —— 重要
     */
    @Test
    public void test4257(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("eee", 444, 175));
        list.add(new Person("ccc", 333, 176));
        list.add(new Person("bbb", 222, 177));
        list.add(new Person("ddd", 333, 175));

        OptionalInt optionalIntMin = list.stream().flatMapToInt(ele -> IntStream.of(ele.getAge())).min();
        OptionalInt optionalIntMax = list.stream().flatMapToInt(ele -> IntStream.of(ele.getAge())).max();
        System.out.println(optionalIntMin.getAsInt() + "-" + optionalIntMax.getAsInt());

/*        Stream<String> stringStream = list.stream()
                .flatMap(ele -> Stream.of(ele.getName()));
        stringStream.forEach(ele -> System.out.println(ele));*/
    }


    @Test
    public void test2(){

    }

    // 函数式接口只能有一个抽象方法
    // lambda函数式编程，将方法进行传递（本地只是简化了的匿名内部类）
    // 在函数式编程里调用外部局部变量，建议加上final（默认为final，加上更友好）

    // 函数式接口特性：
    // 一般加上注解：@FunctionalInterface，不加也对，加上更友好
    // java8中，接口可以有带方法体的默认方法，可以直接调用
    // 接口中变量，默认是静态的常量，默认有static


    // new了一个类，你又不调用它的方法，那你new它干什么！


    // 熟练度、创造性

    // lambda表达式的写法 = new该接口的匿名内部类 = new该接口的实现类

    // lambda内置的函数式接口，百度下（严重），尤其是带一个参数、两个参数的同类接口

    // stream：流式编程：所有集合都可以变成流，中间可以有若干处理步骤，最后返回。直接处理集合不方便，故先转换成流，便于操作

/*    default void add1(int a){ // java8 允许接口里有default修饰的默认方法
        System.out.println("===");
    };*/

}
