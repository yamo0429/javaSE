package io.file.fileMethod;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 5. 获取的方法
 * 1. getAbsoluteFile		获取一个文件（夹）的绝对路径对象
 * 2. getAbsolutePath		获取一个文件（夹）的绝对路径字符串对象
 *
 * 5. getParentFile 获取父目录文件对象
 * 4. getParent 获取父目录字符串对象
 *
 * 3. getName() 获取的是File类的对象中封装的文件或目录的最后一级名称
 *
 * 6. getPath 获取当前路径（似乎与上面的getAbsolutePath一样效果）
 *
 * 7. length  文件中数据的长度
 */
public class GetDemo {

    @Test
    public void test1() throws IOException {
        File revFile = new File("hello.txt");

        File absFile = revFile.getAbsoluteFile();
        String absPath = revFile.getAbsolutePath();
        String revName = revFile.getName();
        String absName = absFile.getName();

        System.out.println(absFile);
        System.out.println(absPath);
        System.out.println(revName);
        System.out.println(absName);
        System.out.println("==========================");

        String parent = revFile.getParent();
        String parent2 = absFile.getParent();
        File parentFile = revFile.getParentFile();
        File parentFile2 = absFile.getParentFile();
        String path = revFile.getPath();
        String path2 = absFile.getPath();

        System.out.println(parent);
        System.out.println(parent2);
        System.out.println(parentFile);//null
        System.out.println(parentFile2);
        System.out.println(path);//hello.txt
        System.out.println(path2);
        System.out.println("==========================");

        long length = revFile.length(); //编码表(字符集)。。字符流  =  字节流 + 编码表；在gbk : 一个中文字符两个字节；在utf-8:一个中文字符三个字节
        System.out.println(length);
    }
}








