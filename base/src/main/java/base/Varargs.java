package base;

import org.junit.Test;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  可变参数
		1. JDK1.5版本特性,方法的可变参数
		2. 问题: 数据类型已知,但是参数的个数不确定
		3. 格式: 方法的参数列表中    数据类型... 变量名
		4. 调用可变参数的方法:参数可以传递,也可以不传,传递的个数不受限,包括0
		
		5. 注意事项: 一个方法只能有1个可变参数,而且只能写在参数列表的最后面
		6. 底层原理:在可变参数被赋值的同时,创建数组(不能定义成变量,语法)
 */
public class Varargs {

	@Test
	public void test() throws IOException{
		int sum = getSum("saa",2,3);
		System.out.println(sum);
	}

    /**
     *  关流工具方法
     */
	@Test
	public void test2() throws Exception{
		FileReader fr = new FileReader("");
		FileReader fr2 = new FileReader("");
		FileWriter fw = new FileWriter("");
		FileWriter fw2 = new FileWriter("");

		closeIo(fr,fr2,fw,fw2);

	}
	/**
	 * 关流工具方法
	 * 1. 可变参数
	 * 2. Closeable 是io流父级接口（向上转型）
	 * 3. 增强for循环
	 */
	private static void closeIo(Closeable... ios) {
		for (Closeable io : ios) {
			if(io != null){
				try {
					io.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 1. 可变参数的本质是数组
	 * 2. 参数传入的同时，在底层创建一个和参数个数相同的数组
	 * 3. 参数个数可以从0开始；一个参数列表中只能有一个可变参数；参数列表如果有可变参数，必须放在列表末尾
	 */
	private static int getSum(String a ,int... args) {
//		int[] array = new int[0];
//		System.out.println(array);
//		System.out.println("args:" + args.length);
		int sum = 0;
		for (int i : args) {
			sum += i;
		}
		return sum;
	}

}
