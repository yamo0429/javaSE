package collectionInterface.generic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
	泛型是JDK1.5特性，是一种安全机制，在集合中的泛型指定的数据存储类型
	泛型特点：强制集合存储的数据类型，避免了类型的强制转换
	泛型将问题由运行时期(比如类转换异常)，提前到了编译时期发现
	Java的泛型是伪泛型：只存在编译时期，编译成功之后生存的运行文件class中没有泛型(泛型擦除)
 */
public class GenericTest {

    class Human { }
    @Test
    public void test244() throws IOException{

        Human human1 = new Human();
        Human human2 = new Human();
        System.out.println(human1.equals(human2));

    }

	@Test
	public void test2() throws IOException{

		ArrayList<String> list = new ArrayList<String>();
		// 编译报错
		// list.add(119);
	}


    @Test
    public void test32() throws IOException {
        // 1 可在创建对象时确定泛型，本例
        // 2 也可以在类中实现接口时确定泛型：class GenericClass<String, int> implements GenericInterface<String, int> {}
        GenericClass<String, Integer> gc = new GenericClass<String, Integer>("zs", 20);

        //测试普通方法上泛型：分别是无返回值类型和有返回值类型
        gc.love("lisi", 123);
        String ddd = gc.like("ddd");

    }

	@Test
	public void test11(){
		ArrayList<Object> list = new ArrayList<>();
		HashMap map = new HashMap<String,Object>();
		TwoTuple<List, Map> tuple = new TwoTuple<>(list, map);
		List a = tuple.getA();
		Map b = tuple.getB();
	}



}
