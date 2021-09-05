package enumTest;

import bean.Color4;
import org.junit.Test;

import java.util.*;

public class EnumMapTest {
    /**
     * 相比于 HashMap，EnumMap 更为高效，专门为枚举类准备的，当然用HashMap也行
     */
    @Test
    public void enumMapTest() {
        EnumMap<Color4, Integer> map = new EnumMap<Color4, Integer>(Color4.class);
        map.put(Color4.Red, 111);
        map.put(Color4.Yellow, 222);

        for (Map.Entry<Color4, Integer> color4 : map.entrySet()) {
            System.out.println(color4.getKey() + "==" + color4.getValue());
        }
    }

    /**
     * 测试：EnumSet 及其静态方法 allOf()：自动将类中所有元素设置到集合中（重要）
     */
    @Test
    public void enumSetTest() {
        EnumSet<Color4> color4s = EnumSet.allOf(Color4.class);

        Iterator<Color4> iterator = color4s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getColor());
            System.out.println(iterator.next().getNo());
            System.out.println(iterator.next().getNum());
        }
    }

}


