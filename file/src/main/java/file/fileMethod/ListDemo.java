package io.file.fileMethod;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 6. 列举方法
	0. static File[] listRoots 列出可用的文件系统(硬盘的所有盘符)了解
	1. String[] list() 返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。 列出指定目录下面的所有子文件和子文件夹
	2. File[] listFiles()  返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
		
	3. 需求 : 扫描 E:\javawork\heima23\day10 下的所有文件和子文件夹,并且打印其绝对路径.
 *
 */
public class ListDemo {
	
	@Test
	public void test1(){
		//需求 : 扫描f:/test_io\a下的所有文件和子文件夹,并且打印其绝对路径，两种方法如下
		File file = new File("f:/test_io\\a");

		/*String[] list = file.list();
		for (String name : list) {
			System.out.println(name);
			File absFile = new File(file, name);
			System.out.println(absFile);
		}*/
		
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			System.out.println(file2);
		}

		File[] files = File.listRoots();

		for (File fil :
				files) {
			System.out.println(fil);
		}

	}



	@Test
	public void test2(){
		File[] listRoots = File.listRoots();
		for (File file : listRoots) {
			System.out.println(file);
		}
	}
}
