package io.file.fileMethod;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 4. 判断方法：boolean
 * 1. isAbsolute 是否为绝对路径
 * 2. isDirectory	是否为 `目录`
 * 3. isFile	是否为 `文件`
 * 4. exists 是否存在
 */
public class BooleanDemo {

    public static void main(String[] args) {
        File relativeFile = new File("hello.txt");//无论是否存在，只要是绝对路径，就返回true
        boolean absolute = relativeFile.isAbsolute();
        File absFile = new File("f:/test_io/test");
        boolean absolute2 = absFile.isAbsolute();
        System.out.println(absolute);
        System.out.println(absolute2);

        boolean directory = relativeFile.isDirectory();  //如果是存在的目录,返回true
        System.out.println(directory);
        boolean directory2 = absFile.isDirectory();
        System.out.println(directory2);

        boolean file = relativeFile.isFile();            //如果是存在的文件,返回true
        System.out.println(file);
        boolean file2 = absFile.isFile();
        System.out.println(file2);

        boolean exists = relativeFile.exists();          //只要存在，返回true
        System.out.println(exists);
        boolean exists2 = absFile.exists();
        System.out.println(exists2);
    }

    @Test
    public void test2() throws IOException {

        File absFile = new File("f:/test_io/test");

        boolean absolute2 = absFile.isAbsolute();
        System.out.println(absolute2);

        boolean directory2 = absFile.isDirectory();        //如果是目录,并且存在,返回true
        System.out.println(directory2);
    }


}
