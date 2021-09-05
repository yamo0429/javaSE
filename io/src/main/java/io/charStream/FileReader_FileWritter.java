package io.charStream;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_FileWritter {

    /**
     * 1 字符流如何解决字节流读取中文乱码的问题？字符流中 read()方法并非一次读取一个字节，而是底层根据编码表规则，一次读取表示一个字符的字节数，故而不会乱码
     * 2 字符流如何解决字节流输出字符串时必须转换成字节数组这个问题的？也是根据底层默认的编码表
     */
    @Test
    public void readChinese() throws IOException {
        FileReader fr = new FileReader("b.txt");
        FileWriter fw = new FileWriter("c.txt");

        int c = -1;
        while ((c = fr.read()) != -1) { // read()方法并非一次读取一个字节，而是底层根据编码表规则，一次读取表示一个字符的字节数
            fw.write(c);
            fw.flush();//如果不加flush刷新缓冲区，则close也可以先刷新后关闭
        }
        fw.close();//TODO 如果上面不加flush刷新缓冲区，则close也可以刷新
        fr.close();
    }

    @Test
    public void outString() throws IOException {
        FileWriter fileWriter = new FileWriter("c.txt");
        fileWriter.write("abc中国人"); //可直接输出字符/字符数组/字符串：解决字节流写出数据时, 字符串必须转换成字节数组的问题
        fileWriter.close();//TODO 如果上面不加flush刷新缓冲区，则close也可以刷新
    }

    /**
     * 便捷流复制文件：一次读写一个字符数组 （字符流无法一次读写一个字符串，只能写字符串，不能读字符串，不过字符缓冲流的特有方法可以读字符串）
     * FileReader & FileWriter (使用电脑系统默认编码中文是GBK，不可指定编码表)
     * InputStreamReader & OutputStreamWriter (手动指定编码表，默认GBK，可以自行指定编码表)
     *
     * 问题：既然字节流和字符流都能复制文件，那它们有何区别？
     * 字符流在复制过程中需要先编码后解码，效率低。而且在复制图片和音视频文件时也因为编解码的原因，容易造成复制之后的文件产生问题
     * 字节流复制过程没有编解码，效率高，而且不出错
     * 总结：文件复制应该用字节流、字符流应该用来读写字符数据
     */
    @Test
    public void fr_fw_charArray() throws IOException {

        FileReader fr = new FileReader("b.txt");
        FileWriter fw = new FileWriter("c.txt");

        int len = -1;
        char[] buffer = new char[1024];
        while ((len = fr.read(buffer)) != -1) {
            fw.write(buffer, 0, len);
        }
        fw.close();
        fr.close();

        System.out.println("复制完成!");
    }



}
