package io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.TreeMap;

/**
	FileUtils 类 :
		1. static void copyFile(File srcFile, File destFile);	复制文件
		2. static void copyDirectoryToDirectory(File srcDir, File destDir).递归复制目录及其子文件/子目录
 *
 */
public class Commons_IO {
	public static void main(String[] args) throws IOException {

		// TODO 注意这里缺少：1 原文件是否存在  2 目标文件/目录的父目录是否存在
		FileUtils.copyFile(new File("f:/test_io/aaa.txt"), new File("f:/test_io/bbb.txt"));
		FileUtils.copyDirectoryToDirectory(new File("f:/test_io/aaa"), new File("f:/test_io/bbb"));

		// TODO 其他方法（很多，重要）
//        FileUtils.

        LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
        TreeMap<Integer, Object> treeMap2 = new TreeMap<>();

    }

}
