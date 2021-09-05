package enumTest;

import bean.Color3;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 测试：枚举类设置多个属性、枚举类自带方法
 */
public class EnumMethodTest {
    //values()、name()、ordinal()... 还有其他方法

    @Test
    public void color3Test() {
        Color3[] values = Color3.values(); //获取所有枚举实例
        for (Color3 color3 : values) {
            String name = color3.name();//获取枚举实例的名称
            int ordinal = color3.ordinal();//获取枚举实例的默认编号，0基
            System.out.println(name + "--" + ordinal + "--");
        }
    }

    @Test
    public void color3T33est() {
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(112);
        list2.add(114);
        list2.add(113);
        Arrays.sort(new ArrayList[]{list2});
//        ArrayList[] arrayLists = {list2};
    }



}

