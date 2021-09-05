package lambda;

import bean.Address;
import bean.Star;
import bean.User;
import com.mysql.jdbc.StringUtils;
import org.junit.Test;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class LambdaTest6 {
    static List<Star> aaa = null;
    static {
        aaa = Arrays.asList(
                new Star("type1", "big0"), new Star("type2", "big9"),
                new Star("type3", "big8"), new Star("type1", "big7"),
                new Star("type3", "big6"));
    }

    @Test
    public void tes1t(){
    }
    @Test
    public void tes10t(){
        Optional<String> aaa = Optional.of("aaaa");
        Optional<Object> ddd = Optional.ofNullable(null);//of方法，传入参数为null时，会报错
        Optional<Object> fff = Optional.ofNullable(null);
        if (fff.isPresent()) { // TODO fff.isPresent().if  会自动提示if
            System.out.println(fff.get());
        }

    }
    @Test
    public void tes2t(){
        //orElseThrow与orElse方法类似。但会抛出lambda表达式或方法生成的异常
        try {
            Optional.ofNullable(null).orElseThrow(Exception::new);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void te3st(){//获取数字的个数、最值总和、平均值
        List<Integer> aaa = Arrays.asList(100, 300, 300, 400);
        System.out.println(aaa.stream().map(bbb -> bbb + .12 * bbb).reduce(Double::sum).get());
        System.out.println(aaa.stream().map(bbb -> bbb + .12 * bbb).reduce(Double::min).get());

        System.out.println(IntStream.of(0, 20, 30).max().getAsInt());
        System.out.println(IntStream.of(1, 20, 30).sum());

        List<Integer> ggg = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics ttt = ggg.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(ttt.getAverage());
        System.out.println(ttt.getCount());
        System.out.println(ttt.getMax());
        System.out.println(ttt.getSum());

        //ifPresent方法接收lambda作为参数
        Optional<String> rrr = Optional.of("aaaa");
        rrr.ifPresent(value -> System.out.println(value.length()));

        //如果值不为null，orElse方法返回Optional实例的值，如果为null，返回传入的消息
        Optional<String> ddd = Optional.ofNullable(null);
        Optional<String> xxx = Optional.of("jjjjjj");
        System.out.println(ddd.orElse("qqqqq"));
        System.out.println(xxx.orElse("rrrrr"));

        //orElseGet与orElse方法类似，区别在于orElse传入的是默认值，而orElseGet可接收一个lambda生成默认值
        System.out.println(Optional.ofNullable(null).orElseGet(() -> "aaaaaaaa"));
        System.out.println(Optional.of("yyyyy").orElseGet(() -> "hhhhhhhhh"));

    }
    @Test
    public void t4est(){//Optional示例
        List<Star> aaa = Arrays.asList(new Star("ddd", "aaa"), new Star("ddd", ""));
        Optional<List<Star>> bbb = Optional.ofNullable(aaa);//包装秤Optional类
        Optional<Stream<Star>> ccc = Optional.ofNullable(aaa).map(List::stream);//泛型映射成stream
        Stream<Star> ccc2 = Optional.ofNullable(aaa).map(List::stream).get();
        Stream<Star> ddd = Optional.ofNullable(aaa).map(List::stream).orElse(Stream.empty());//不为空就默认get返回，否则使用后面的值
        Optional<Star> hhh = Optional.ofNullable(aaa).map(List::stream).orElse(Stream.empty()).filter(ggg -> StringUtils.isNullOrEmpty(ggg.getSize())).findFirst();
        Star star = Optional.ofNullable(aaa).map(List::stream).orElse(Stream.empty()).filter(ggg -> StringUtils.isNullOrEmpty(ggg.getSize())).findFirst().orElse(null);
        System.out.println(star);
    }
    @Test
    public void t5est(){//mapToObj
        int[] ids = {1,6,3,5,3,4};
        List<String> sss = IntStream.of(ids).mapToObj(Integer::toString).collect(Collectors.toList());
        System.out.println(sss);
    }
    @Test
    public void tes6t(){//flatMap
        List<Integer> aaa = Arrays.asList(1, 2, 3);
        List<String> bbb = Arrays.asList("aa","bb","cc");
        List<String> ccc = Arrays.asList("a","b","c");
        List<Address> qqq = Arrays.asList(new Address(1, "aaa"), new Address(2, "AAA"));
        List<Address> www = Arrays.asList(new Address(1, "bbb"), new Address(2, "BBB"));
        List<Address> ttt = Arrays.asList(new Address(1, "ccc"), new Address(2, "CCC"));
        List<Address> rrr = Arrays.asList(new Address(1, "ddd"), new Address(2, "DDD"));
        List<User> ddd = Arrays.asList(new User(1, "小红a", qqq), new User(2, "小明b", www));
        List<User> eee = Arrays.asList(new User(3, "小红A", ttt), new User(4, "小明B", rrr));
        //将不同类型的3个list合为一个
        List<? extends Serializable> fff = Stream.of(aaa, bbb, ccc).flatMap(everyList -> everyList.stream()).collect(Collectors.toList());
        //将同类型的2个list合为一个
        List<? extends Serializable> ggg = Stream.of(bbb, ccc).flatMap(everyList -> everyList.stream()).collect(Collectors.toList());
        //获取多个list<User>中所有name属性
        List<String> hhh = Stream.of(ddd, eee).flatMap(everyList -> everyList.stream().map(User::getName)).collect(Collectors.toList());
        //获取一个list<User>中二级list
        List<Address> iii = ddd.stream().flatMap(user -> user.getAddressList().stream()).collect(Collectors.toList());//类似上二合一
        //获取多个list<User>中所有二级list
        List<List<Address>> mmm = Stream.of(ddd, eee).flatMap(everyList -> everyList.stream().map(User::getAddressList)).collect(Collectors.toList());
        //获取多个list<User>中所有你list里的对象
        ArrayList<Address> kkk = new ArrayList<>();
        mmm.forEach(yyy ->{
            kkk.addAll(yyy);
        });
        System.out.println(fff);
        System.out.println(ggg);
        System.out.println(hhh);
        System.out.println(iii);

    }
    @Test
    public void tes7t(){//排序
        List<Star> bbb = aaa.stream().sorted(Comparator.comparing(sss -> sss.getSize())).collect(Collectors.toList());
        System.out.println(bbb);

        List<Integer> ccc = Arrays.asList(3, 2, 3, 2, 7, 5);
        System.out.println(ccc);
        ccc.sort(Comparator.comparing(ddd -> ddd));
        System.out.println(ccc);
    }
    @Test
    public void te8st(){//groupingBy、toSet、toMap、joining
        Map<String, List<Star>> www = aaa.stream().collect(Collectors.groupingBy(Star::getType));
        System.out.println(www);

        List<Integer> fff = Arrays.asList(3, 2, 3, 2, 7, 5);
        Set<Integer> bbb = fff.stream().collect(Collectors.toSet());//去重
        System.out.println(bbb);

        Map<String, String> ddd = aaa.stream().collect(Collectors.toMap(Star::getSize, Star::getType));
        Map<String, Star> ccc = aaa.stream().collect(Collectors.toMap(Star::getSize, item -> item));
        System.out.println(ddd);
        System.out.println(ccc);

        List<String> ttt = Arrays.asList("USA", "Japan", "France", "Germany");
        System.out.println(ttt.stream().collect(Collectors.joining(",")));

    }
    @Test
    public void te9st(){//map、peek

        List<Integer> ppp = Arrays.asList(2, 2, 3, 1, 7, 5).stream().map(num -> num * 10).collect(Collectors.toList());//普通->普通
        List<Object> ddd = aaa.stream().map(ele -> ddd(ele)).collect(Collectors.toList());//对象->对象
        List<String> sss = aaa.stream().map(yyy -> yyy.getType()).collect(Collectors.toList());//对象->字段1
        List<String> sss2 = aaa.stream().map(Star::getType).collect(Collectors.toList());//对象->字段2
        System.out.println(ppp);
        System.out.println(ddd);
        System.out.println(sss);

        //peek同map，但若参数与返回值类型一致时，可省略return语句
        List<Star> vvv = aaa.stream().peek(iii -> iii.setType("type4")).collect(Collectors.toList());
    }

    private Star ddd(Star ele) {
        ele.setType("type4");
        return ele;
    }
}
