package exception;

import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 	5. finally代码块
		1. 语法：try...catch...finally{'此代码必须执行'}
		2. 一般用于IO关流（释放资源）
 *
 */
public class FinallyDemo {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		method();
//		method2();
		FileReader fr = null;
		FileWriter fw = null;
		closeIo(fr,fw);
	}
	// 可变参数：本质上是数组
	
	private static void closeIo(Closeable... ios) {
		for (int i = 0; i < ios.length; i++) {
			Closeable closeable = ios[i];
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void method2() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("a.txt");
			fw = new FileWriter("b.txt");
			
			char[] array = new char[1024];
			int len = -1;
			while((len = fr.read(array)) != -1){
				fw.write(array, 0, len);
				fw.flush();
			}
			//问题：在这里资源一定释放吗？
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void method() {
		try {
//			int i = 1/0;
			System.out.println("没有异常");
		} catch (Exception e) {
			System.out.println("捕获异常");
		}finally{
			System.out.println("一定执行");
		}
		
		System.out.println("程序继续执行");
	}
}
