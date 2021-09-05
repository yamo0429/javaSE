package io.byteStream.exercise;

import java.io.File;

/**
 * 2. 删除文件夹（包括子文件）
	1. 说明 : 如果一个文件夹是非空文件夹, 不能直接删除. 首先需要将内部的所有文件和文件夹全部删除, 最后才能够删除该空文件夹.
 *
 */
public class DeleteDemo {
	public static void main(String[] args) {
		//从内往外删
		File file = new File("f:/end/a");
		
		deleteFile(file);
		
	}

	private static void deleteFile(File file) {
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			if(file2.isDirectory()){
				deleteFile(file2);
			}else{

				file2.delete();
			}
		}
		file.delete();
	}
}
