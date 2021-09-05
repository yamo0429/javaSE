package io.byteStream.exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 	1. 复制目录及子目录 (多层复制)
		1. 注意点 : 复制只能复制文件, 不可以复制文件夹，文件夹只能创建。
 */
public class CopyDemo2 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 将  C:\test\filedoc 目录中的所有文件  复制到  C:\test\a下
		//1.关联源文件,以及目标文件
		File srcFile = new File("C:\\test\\filedoc");
		
		File destFile = new File("C:\\test\\a");
		copyFile(srcFile, destFile);
		
	}

	private static void copyFile(File srcFile, File destFile)
			throws FileNotFoundException, IOException {
		//2. 在a目录下创建filedoc目录
		//C:\test\a\filedoc
		String name = srcFile.getName();
		//C:\test\a + filedoc
		File folder = new File(destFile,name);
		folder.mkdirs();
		//3.遍历源文件的所有子文件夹
		File[] listFiles = srcFile.listFiles();
		for (File file : listFiles) {
			if(file.isDirectory()){
				System.out.println("需要创建文件夹!继续遍历此文件夹");
				//TODO: 多级文件
				/**
				 * src: file   C:\test\filedoc\folder
				 * dest:   C:\test\a\filedoc\folder    folder + filename
				 */
				copyFile(file,folder);
			}else{
				/*****************copy start********************/
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				
				/**
				 * 目标 file: C:\test\a\filedoc  + filename;
				 */
				File copyFile = new File(folder,file.getName());
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyFile));
				
				int len = -1;
				byte[] buffer = new byte[1024];
				while((len = bis.read(buffer)) != -1){
					bos.write(buffer, 0, len);
				}
				bis.close();
				bos.close();
				
				/*****************copy end********************/
			}
		}
	}
}
