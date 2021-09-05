package map;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 2. Map中的方法
 * 1. Map<K,V> <泛型>： K 表示作为键的类型,V表示值的类型
 * 2. put: 存储键值对
 * 1. 键值对存储到集合中 V put (K,V)
 * 2. 如果存储了相同的键,覆盖原有的值
 * 3. 返回值：一般返回null,如果存储了重复的键,返回被覆盖之前的值
 * 3. get：通过键，取出键对应的值
 * 1. V get(K),传递键,返回对应的值
 * 2. 如果集合中没有这个键,返回null(因为没有索引，所以不存在越界)
 * 4. remove：移除键值对
 * 1. V remove(K),传递键,移除这个键值对
 * 2. 返回值:移除之前的值（无此键，则返回null）
 * 5. keySet: 将集合中所有的键,存储到Set集合中
 * 6. values: 将集合中的所有的值,存储到Collection集合中
 * 7. size:获取map集合的大小
 */
public class MapTest {

    @Test
    public void size() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "海卫1号");
        map.put(2, "海卫2号");
        map.put(3, "海卫3号");
        map.put(4, "海卫1号");

        int size = map.size();
        System.out.println(size);

    }

    @Test
    public void values() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "海卫1号");
        map.put(2, "海卫2号");
        map.put(3, "海卫3号");
        map.put(4, "海卫1号");
        Collection<String> values = map.values();
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

    }

    @Test
    public void keySet() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "海卫1号");
        map.put(2, "海卫2号");
        map.put(3, "海卫3号");
        map.put(4, "海卫4号");

        //获取key的单列集合，key本来就不重复
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            System.out.println(i);
        }

    }

    @Test
    public void remove() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "海卫1号");
        map.put(2, "海卫2号");
        map.put(3, "海卫3号");
        map.put(4, "海卫4号");
        /**
         * remove返回的是被移除的值
         * 如果没有此key，就返回null（没有索引，不存在越界异常）
         */
        String remove = map.remove(8);
        System.out.println(remove);
        System.out.println(map);

    }

    @Test
    public void put() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "海卫1号");
        map.put(2, "海卫2号");
        map.put(3, "海卫3号");
        map.put(4, "海卫4号");
        map.put(10, "海卫5号");

        System.out.println(map);
    }

    @Test
    public void test() {


    }


}
