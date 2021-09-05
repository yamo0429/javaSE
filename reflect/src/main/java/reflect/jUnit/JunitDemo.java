package reflect.jUnit;



import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;

import java.io.BufferedReader;



/**
 * Junit单元测试
 * 		1. eclipse自带Junit 框架库
 * 		2. 语法
 *			@Test
			public void demo1(){
				System.out.println("这是需要测试的代码");
			}
		3. 用途
			1. 测试代码： 一般是在工作中完成某一功能之后，单独对这个模块的代码进行测试
			2. 数据库的增删改查比较常用
 *##1. JUnit单元测试
	1. 框架，eclipse自动集成
	
	2. 注意点
		1. 一定要有注解@Test ：初始化错误
		2. 权限必须public
		3. 返回值必须void
		4. 测试方法不能有参数
	3. 三个测试
		1. @Before（test之前 ）：  用于初始化
		2. @Test（测试方法）
		3. @After（之后）：一般用于释放资源
 */
public class JunitDemo {
	
	private BufferedReader br;
	@SuppressWarnings("resource")
	@Before("bb") // ===================？？？？？？？？？？？？？ 为何要bb值
	public void beforeTest(){
		System.out.println("开始测试了");
		br = new BufferedReader(null);
		
	}
	
	@After("bb")
	public void afterTest(){
		System.out.println("结束测试了");
//		br.close();
	}
	@Test
    public void demo1(){
//		br.readLine();
//		int i = 1/0;
		System.out.println("这是需要测试的代码1111");
		try {
			
		} catch (Exception e) {
			//错误在栈中的追溯
			e.printStackTrace();
		}
	}
	@Test
	public void demo2(){
		System.out.println("这是需要测试的代码2222");
	}
	@Test
	public void demo3(){
		System.out.println("这是需要测试的代码3333");
	}
}
