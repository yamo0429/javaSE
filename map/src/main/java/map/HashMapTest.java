package map;

import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

/**
 * 1. HashMap特点(重要)
 * 1. Map接口实现类HashMap,底层数据结构,哈希表
 * 2. 无序的集合,存储到HashMap集合中的键对象,必须重写方法hashCode,equals
 * 3. 线程不安全集合,运行速度快
 * 4. 允许存储null值,null键
 * <p>
 * 5. 案例:HashMap存储自定义对象
 * 1. HashMap存储自定义对象,作为值使用
 * 2. HashMap存储自定义对象,作为键使用
 */
public class HashMapTest {
    @Test
    public void test1() {

        HashMap<Person, String> map = new HashMap<Person, String>();
        /**
         * 因为默认调用Object的hashcode（根据内存地址值的哈希算法）
         * 需求：如果name和age相同，则判定为同一个人
         * 解决：重写自定义类的hashcode和equals方法
         *
         */
        map.put(new Person("天宫1号", 18), "1");
        map.put(new Person("天宫1号", 19), "2");
        map.put(new Person("天宫2号", 18), "3");
        map.put(new Person("天宫1号", 18), "4");

        Set<Person> keySet = map.keySet();
        for (Person key : keySet) {
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
    }

    @Test
    public void test2() {
        HashMap<String, Person> map = new HashMap<String, Person>();
        map.put("1", new Person("天宫1号", 18));
        map.put("2", new Person("天宫1号", 18));
        map.put("3", new Person("天宫1号", 18));
        map.put("4", new Person("天宫1号", 18));

        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Person p = map.get(key);
            System.out.println(key + ":" + p);
        }
    }

    @Test
    public void test3() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "a");
        map.put("3", "a");
        map.put("4", "a");
//		map.put(null, null);

//		Hashtable<String, String> table = new Hashtable<String, String>();
//		table.put(key, value)


        Set<Entry<String, String>> entrySet = map.entrySet();
        for (Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

    //containsKey和containsValue 用法
    @Test
    public void test5(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("name",111);
        map.put("age",222);
        boolean name = map.containsKey("name");
        boolean b = map.containsValue(222);
        System.out.println(name);
        System.out.println(b);
    }

    // map-for-containsKey-容器(map/list/set/StringBuilder/aray)===== hashMap经典用法========
    // 容器可用一下几种情形
    Map<String, List<Member>> map1 = new HashMap<>(); // 对象中一定有两个字段形成key-value格式
    Map<String, List<Map<String,String>>> map2 = new HashMap<>();
    Map<String, Map<String, StringBuilder>> map3 = new HashMap<>();
    Map<String, Map<String, List<String>>> map4 = new HashMap<>();

    @Test
    public void test55(){
        Member member = new Member();
        member.setGroup("fist");         member.setName("lili");
        Member member2 = new Member();
        member2.setGroup("fist");         member2.setName("lala");
        Member member3 = new Member();
        member3.setGroup("second");         member3.setName("baba");

        List<Member> list = new ArrayList<>();
        list.add(member);        list.add(member2);        list.add(member3);

        Map<String, List<Member>> map = new HashMap<>();
        if(list !=null && !list.isEmpty()){
            for (Member mem : list) {
                if (map.containsKey(mem.group)){
                    map.get(mem.group).add(mem);
                }else {
                    List memList = new ArrayList<Member>();
                    memList.add(mem);
                    map.put(mem.group,memList);
                }
            }
        }
        System.out.println(map.toString());
    }


/*    Map<String, Map<String, StringBuilder>> map = new HashMap<>();
		for (Object info : obj) {
        String merShopId = info.getString("merShopId");
        String activityId = info.getString("activityId");
        String discountPrice = info.getString("discountPrice");
        if(map.containsKey(merShopId)){
            map.get(merShopId).get("activityIds").append(",").append(activityId);
            map.get(merShopId).get("discountPrices").append(",").append(discountPrice);
        }else {
            Map<String, StringBuilder> activityIdAndDiscountPriceMap = new HashMap<>();
            activityIdAndDiscountPriceMap.put("activityIds", new StringBuilder(activityId));
            activityIdAndDiscountPriceMap.put("discountPrices", new StringBuilder(discountPrice));
            map.put(merShopId, activityIdAndDiscountPriceMap);
        }
    }*/


}


class Member{
    String group;
    String name;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}
