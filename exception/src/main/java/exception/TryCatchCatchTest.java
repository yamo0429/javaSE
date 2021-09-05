package exception;

import org.junit.Test;

/**
 * 	4. 多个catch并行处理(分类讨论)
	    0. 需求：设置一个方法,传递参数：如果传递是0,方法出现空指针异常,传递的非0,出现数组越界异常。并用try.catch.catch方式处理
		1. 语法:
			 try{
			}catch(异常类  变量){
			
			}catch(异常类  变量){
			
			}
 *				1. 多个catch之间相当于方法重载
 *				2. 多个catch的检测执行是有顺序的，就按代码编写顺序
 *		2. 应用前提: 多个catch中的异常类之间,如果没有继承关系,平级异常。
		  1. 判断如下继承体系中NullPointerException和ArrayIndexOutOfBoundsException是什么关系？
		    Exception
			 |-- RuntimeException    
		        |-- NullPointerException     空指针异常    
		        |-- IndexOutOfBoundsException 
		          |-- ArrayIndexOutOfBoundsException  数组越界  
			
		3. 多个catch之间异常类,有继承关系(向上转型)
			1. 如果父类写前面，后面的子类异常永远执行不到，报错
			2. 如果子类写前面，则有可能执行到后面的父类异常，不报错
 *		
 */
public class TryCatchCatchTest {
	@Test
	public void TryCatchCatchTest() {
		try {
			//jvm检测到异常，就会创建异常对象，并调用catch（异常对象）
			method(0);
		} catch (NullPointerException e) {
			System.out.println("捕获空指针异常了！");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("捕获数组越界异常了！");
		}
		System.out.println("程序继续执行！");
	}
	//需求：设置一个方法,传递参数：如果传递是0,方法出现空指针异常,传递的非0,出现数组越界异常。并用try.catch.catch方式处理
	private static void method(int i) {
		if (i == 0) {
			String s = null;
			s.toString();
		}else{
			int[] array = new int[0];
			int j = array[1];
		}
	}
}
