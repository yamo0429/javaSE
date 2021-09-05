package io.charStream;

import java.io.*;

import org.junit.Test;
/**
 * BufferedWriter:将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
 * BufferedReader:从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
 */
public class BufferedReader_BufferedWriter {

    /**
     * 一次读写一个字符
     * 一次读写一个字符数组
     */
    @Test
    public void test232() throws IOException {
//创建输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader("FileWriterDemo.java"));

		/*
		//一次读写一个字符
		int ch;
		while((ch=br.read())!=-1){
			System.out.print((char)ch);
		}
		*/

        //一次读写一个字符数组
        char[] chs = new char[1024];
        int len;
        while((len=br.read(chs))!=-1) {
            System.out.print(new String(chs,0,len));
        }

        //释放资源
        br.close();
    }

    @Test
    public void test22(){


    }


    /**
     * 缓冲流的特有方法复制文件：一次读写一行字符串
     */
    @Test
    public void buffered() throws IOException {
        //字符缓冲流+字符便捷流
        //BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        //BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));

        //字符缓冲流+字符转换流
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("demo1(gbk).txt"), "gbk"));
        FileInputStream fis = new FileInputStream("a.txt");

        File file = new File("demo2(gbk).txt");
        if(!file.exists()){
            // 如果输出文件父目录不存在, 就需要创建
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));//GBK编码文件的读写方式默认不写

        String line = null;
        while ((line = br.readLine()) != null) { // 对于字符流只能写字符串，不能读字符串，不过字符缓冲流的特有方法可以做到
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
//		bw.write("xxx");//无法继续写入，因为bw流已经关闭
        br.close();
    }

}
