package map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapTest {


    @Test
    public void test(){
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("a","aaa");
        treeMap.put("d","ddd");
        treeMap.put("c","ccc");
        TreeMap<Integer, Object> treeMap2 = new TreeMap<>();
        treeMap2.put(4,"aaa");
        treeMap2.put(3,"ddd");
        treeMap2.put(2,"ccc");
        System.out.println(treeMap.toString()); // {a=aaa, c=ccc, d=ddd}
        System.out.println(treeMap2.toString()); // {2=ccc, 3=ddd, 4=aaa}
    }

    @Test
    public void test3(){
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put("北京","abc");
        treeMap.put("上海","abc");
        treeMap.put("广州","abc");
        System.out.println(treeMap.toString());
    }


}
