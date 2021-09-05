package io.charStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 	使用字节流读和写字符数据产生的问题
 *  问题1 : 读取中文数据, 发生了 `乱码`：因为在GBK中,一个中文字符由两个字节表示,如果一个字节一个字节的读,会破坏愿意!!!乱码
 *  问题2 : 如果写出的是字符数据, 需要将字符数据转换成字节数组
 */
public class ByteStream_problems {

	
	@Test
	public void test() throws IOException{
		FileOutputStream fos = new FileOutputStream("c.txt");
		fos.write(97); // 'a'
		fos.write(98); // 'b'
		fos.write(99); // 'c'
		fos.write("abc中国人".getBytes()); //即字节数组，里面可以加编码表，byte[] a = str.getBytes("utf-8");
		fos.close();
		
}

	@Test
	public void test1() throws IOException{

		FileInputStream fis = new FileInputStream("b.txt");//TODO 读取项目下文件，而非resources下。。。另外为何打印流的相对路径是项目下，而非io，见 PrintDemo
		//一个字节一个字节的读
		int c = -1;
		//因为本地系统默认字符集是GBK，而在GBK中,一个中文字符由两个字节表示,如果一个字节一个字节的读,会破坏愿意!!!乱码
		while((c = fis.read()) != -1){
			System.out.print(c+" = ");
			System.out.print((char)c+"\r\n");
		}
		fis.close();
	}



}
