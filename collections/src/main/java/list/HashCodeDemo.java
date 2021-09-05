package list;

import java.io.IOException;

import org.junit.Test;

/**
 * 	4. 对象的哈希值
		1. hashcode：Object的方法，本地方法，返回值int类型
			1. 不可逆        明文  - 》  密文    不能够由密文推导明文     
			2. 唯一              一 对 一                      现实没有    无限可能（明文）   -》  有限可能（密文）
				3 + 4 = 7
		2. 哈希值：JVM根据底层的哈希算法，为对象(Object中的hashcode：是为对象地址)计算的一个十进制的整数

		3. String的重写了hashcode方法
 *
 */
public class HashCodeDemo {
	
	@Test
	public void test() throws IOException{

		String s1 = new String("abc");
		String s2 = new String("abc");
		
		// 96354
		//String重写了hashcode方法
		System.out.println(s1.hashCode()); 
		System.out.println(s2.hashCode());
	}

	@Test
	public void tes1t() throws IOException{

		Person p1 = new Person();
		
		System.out.println(p1.toString()); // 16进制的内存地址的哈希值
		System.out.println(p1.hashCode()); //10进制
	}
}
class Person{
	
}