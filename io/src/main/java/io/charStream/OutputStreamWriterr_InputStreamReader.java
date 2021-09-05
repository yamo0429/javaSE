package io.charStream;

import org.junit.Test;
import sun.nio.cs.ext.GBK;

import java.io.*;
/**
 * 转换流的构造方法中都会接收一个字符串类型的 `编码表名称`, 可以指定该编码表名称。如果不指定, 则使用平台默认的表码表名称. 即 `GBK`。
 * 便捷流只能使用默认的GBK编码，无法指定其他编码表。故读写GBK编码（GBK是默认编码）文件时，便捷流和转换流都行，且默认不用加编码表。
 * 但读写utf-8等文件时必须指定编码表，也即必须使用转换流，不能使用便捷流
 *
 * 1. InputStreamReader(InputStream in) 创建一个使用默认字符集的转换输入流
 * 2. InputStreamReader(InputStream in, String charsetName) 使用指定字符集的转换输入流
 */
public class OutputStreamWriterr_InputStreamReader {

    /**
     * 一次读取表示一个字符的字节数(同便捷流)。TODO 字符集可以省略，默认GBK，需要指定编码时才必须加上自己指定的那个字符集如utf-8
     * 因此，便捷流只能处理GBK编码表的字符数据，若要处理其他编码表的字符数据，则要用转换流手动指定编码表
     */
    @Test
    public void isr_osw_char() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("demo2(utf8).txt"), "utf-8");//需要指定编码时才必须加上字符集
        File file = new File("demo2(utf8).txt");
        if(!file.exists()){
            // 如果输出文件父目录不存在, 就需要创建
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
        }
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

        int c = -1;
        while ((c = isr.read()) != -1) {
            // System.out.println((char) c);//直接输出c的话，是数字，数字与字符是等价和对应的
            osw.write("Hello 我的女神"); //可直接输出字符/字符数组/字符串：解决字节流写出数据时字符串必须转换成字节数组的问题
            // 字符流无法一次读写一个字符串，只能写字符串，不能读字符串，不过字符缓冲流的特有方法可以做到
            osw.write(c);
        }
        osw.close();
        isr.close();
    }

    /**
     * 一次读取一个字符数组(同便捷流)
     */
    @Test
    public void isr_osw_charArray() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("demo2(utf8).txt"), "utf-8");//字符集默认GBK，可以省略
        File file = new File("demo2(utf8).txt");
        if(!file.exists()){
            // 如果输出文件父目录不存在, 就需要创建
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
        }
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

        int len = -1;
        char[] buffer = new char[1024];
        while ((len = isr.read(buffer)) != -1) {
            osw.write(buffer, 0, len);
        }
        osw.close();
        isr.close();
    }



}
