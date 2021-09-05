package io.file.factorial;

import java.io.File;

/**
 * 1. 扫描 C:\test\FileDoc 下所有的文件及其子文件中的 .java 文件.
 *
 */
public class FileDemo {
	public static void main(String[] args) {
		/**
		 * 1.关联最外层目录
		 */
		/**
		 * 如何结束递归?如果是文件,结束
		 * 如何调用递归? 如果是文件夹,就继续遍历
		 */
		File file = new File("f:/test_io\\a");
		//file表示文件也可以表示文件夹
		findJavaFile(file);
	}

	private static void findJavaFile(File file) {
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			//不是文件夹就是文件
			if(file2.isDirectory()){
				System.out.println("继续查找下去");
				findJavaFile(file2);
			}else{
				if(file2.getPath().endsWith(".java")){
					System.out.println(file2);
				}
			}
		}
	}
}
