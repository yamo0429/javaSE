package io.file.fileMethod;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 由于File类既可以表示文件，也可以表示文件夹（目录），Java针对File类的创建方法给出2种方式，一是创建文件的方法，一是创建文件夹的方法
 * 2. 创建方法
 * 1. createNewFile()：创建文件
 * 1. 把封装的File类的对象创建成一个文件（无论是否有文件后缀名）
 * 1. 文件后缀名的作用 : 指定打开该文件的 `软件`.
 * 2. 返回值
 * 1. 返回true：如果指定的路径没有创建的文件，创建成功
 * 2. 返回false：如果同名的文件已经存在，则不会再创建文件，创建失败
 * 3. 抛出IOException：如果指定的路径不存在，这时就会抛异常
 * 2. mkdir() ： 创建单级目录
 * 1. 返回值：如果指定路径需要创建父级目录，则返回false，创建失败.
 * 3. mkdirs() ：多级目录
 * 1. 返回值：可单级，也可多级，自动创建父级目录。如果已经存在同名文件，返回false
 * <p>
 * 文件后缀名:指定打开方式(指定打开此文件的软件),文件可以没有后缀名
 */
public class CreateDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("f:\\test_io\\test2\\c.txt");//c.txt也可以表示一个目录名

        boolean mkdir = file.mkdir();          //返回值:true,创建单级目录成功，返回:false,父目录不存在
        System.out.println(mkdir);

        boolean mkdirs = file.mkdirs();        //如果父目录不存在,则一并创建,多级目录
        System.out.println(mkdirs);

        boolean result1 = file.createNewFile();//返回true:创建成功；返回false:该文件（或同名文件夹）已存在
        System.out.println(result1);
    }





}
