package io.byteStream.exercise;

import java.io.File;

/**
 * 3. 文件夹A中有若干文件和三个文件夹，三个文件夹中分别有一个文件夹和若干文件。
 * 		能不能在保留文件夹A中的文件的情况下删除A文件夹中的所有子文件夹？想了半天，不知道该怎么写。
 *
 * 翻译: 保留一级文件的子文件,删除子文件夹及其文件
 */
public class Delete2demo {
	//在路径中不区分大小写
	static File srcfile = new File("C:/test/a/filedoc");
	public static void main(String[] args) {
		
		deleteFile(srcfile);
	}

	private static void deleteFile(File file) {
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			if(file2.isDirectory()){
				//删除,递归
				deleteFile(file2);
			}else{
				//保留一级文件,多级文件删除
				String parentPath = file2.getParent();
				if(!parentPath.equals(srcfile.getAbsolutePath())){
					file2.delete();
				}
			}
		}
		file.delete();
	}

}
