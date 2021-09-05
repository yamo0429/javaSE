package io.file.fileMethod;

import java.io.File;

/**
 * String ddString =File.separator;  获取系统分隔符
 * 
 * File: 在java中表示文件夹和文件(必然要和路径进行绑定)
 *  	1. File(String pathname) 
	 		1. 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
		2. File(File parent, String child) 
			1. 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
		3. File(String parent, String child) 
			1. 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
 * 路径概念
 * 		1. 相对路径:没有根盘符的目录,在JavaSe工程中的默认根路径,是当前项目的路径
 * 		2. 绝对路径:带跟盘符的目录
 * 正斜杠和反斜杠
 * 		1. 正斜杠 / ,在java中表示路径分隔符(unix的文件分隔符)
 * 		2. 反斜杠 \,在windows中表示路径分隔符.在java中表示特定含义，如\t(制表符),java中要想表示windos路径
 * 		       就需要进行转义：\\
 */
public class ConstructorDemo {
	
	public static void main(String[] args) {
		
		File file1 = new File("f:/test_io/hello.txt");//这是绝对路径，也可以写相对路径

		File file3 = new File("f:/test_io\\test", "a.txt");

		File file2 = new File("f:/test_io\\test");
		File file4 = new File(file2,"b.txt");
		
		System.out.println(file1);
		System.out.println(file2);
		System.out.println(file3);
		System.out.println(file4);

	}
}
