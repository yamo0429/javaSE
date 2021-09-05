package io.byteStream;

import java.io.*;

import org.junit.Test;

public class CopyWay {

    /**
     * 	字节输入流
     * 	read() 一个字节一个字节的读。因此读取中文会乱码（gbk中，中文是两个字节）
     */
    @Test
    public void fis_test() throws IOException {
//		FileInputStream fis = new FileInputStream("f:ioTest/b.txt");
        FileInputStream fis = new FileInputStream("a.txt");
//        注意: int = 4 byte。java中可用int类型接收byte,因为文本中字节对应编码表中是数字!!!
		/*
		int a = fis.read();
		System.out.println((char)a);
		int b = fis.read();
		System.out.println((char)b);
		int c = fis.read();
		System.out.println(c);
		int end = fis.read();
		System.out.println(end);*/

        int content = -1;
        while ((content = fis.read()) != -1) {  //每次读取一个字节长度，对应编码表中的一个数字，所以用int接收
            System.out.print((char)content);//read() 一个字节一个字节的读。因此读取中文会乱码（gbk中，中文是两个字节）
        }

    }

    /**
     * 字节输出流
     * void write(int b)
     * void write(byte[] b)   如果输入的是字符串，则可以使用str.getBytes()转化成字符数组
     * void write(byte[] b, int off, int len)
     */
    @Test
    public void fos_start() throws IOException {
        FileOutputStream fos = new FileOutputStream("c.txt");  // TODO 如果输出路径不是项目路径，则需要对父目录进行判空

//		1.void write(int b) 一个字节一个字节的些
        fos.write(301);
//		2.void write(byte[] b) 。。。。。如果操作同一个流,默认往后添加   ( , boolean append) append = true;
        byte[] ca = {100, 101, 102, 103, 104};
        fos.write(ca);
//		3.void write(byte[] b, int off, int len)
        fos.write(ca, 2, 2);

        fos.close();
    }


    // TODO 以下演示复制文件，即边读边写
    /**
     * 一次读写一个字节
     * 缓存的原理: 1. java进行IO读写(内存连接硬盘),如果连接次数过多,影响效率 2. 缓存区 - > 在内存中开辟缓存区(数组) ->
     * 一次性将硬盘中的数据读到缓存区 ->减少资源开销,提升程序效率 3. 用空间换时间 (折中)
     */
    @Test
    public void byte_() throws IOException {
        long startTime = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("C:\\test\\张三.jpg");

        File file = new File("f:/aaa/bbb/ccc.txt");
        if(!file.exists()){
            // 如果输出文件父目录不存在, 就需要创建
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file);

        int c = -1;
        while ((c = fis.read()) != -1) {
            fos.write(c);// 如果直接输出中文，则需要用getByte方法将其转换成字节数组
            fos.flush();  // 如果不加flush，则下面的close方法也可以先刷新后 关闭（下同）
        }
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        long exeTime = endTime - startTime;
        System.out.println(exeTime);
    }

    /**
     * 一次读写一个字节数组（无偏移量，这就意味着数组之后的无用数据都会被输出）
     */
    @Test
    public void byteArray_no_offset() throws IOException {
        long startTime = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("a.txt");


        File file = new File("f:/aaa/bbb/ccc.txt");
        if(!file.exists()){
            // 如果输出文件父目录不存在, 就需要创建
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file);

        int c = -1;
        byte[] buffer = new byte[8];
        while ((c = fis.read(buffer)) != -1) { // read方法会将数据放入byte数组，并返回长度
            fos.write(buffer);// 如果直接输出中文，则需要用getByte方法将其转换成字节数组；不带偏移量，则最后一次读取的数组中的空白部分也会被读取
        }
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        long exeTime = endTime - startTime;
        System.out.println(exeTime);
    }

    /**
     * 一次读写一个字节数组8（有偏移量，数组里靠后的空白无用数据不会被输出）
     */
    @Test
    public void byteArray_offset() throws IOException {
        long startTime = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("a.txt");

        File file = new File("f:/aaa/bbb/ccc.txt");
        if(!file.exists()){
            // 如果输出文件父目录不存在, 就需要创建
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file);

        int len = -1;
        byte[] buffer = new byte[8];
        while ((len = fis.read(buffer)) != -1) {  // read方法会将数据放入byte数组，并返回长度
            /**
             * 从offerset位置开始,写len个长度 当26个字母最后8个的时候 yz(6个残留) len = 2
             */
            fos.write(buffer, 0, len);// 如果直接输出中文，则需要用getByte方法将其转换成字节数组；带偏移量，则最后一次读取的数组中的空白部分不会被读取
        }
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        long exeTime = endTime - startTime;
        System.out.println(exeTime);
    }

    /**
     * 一次读写一个字节数组1024（有偏移量，数组里靠后的空白无用数据不会被输出）
     */
    @Test
    public void byteArray1024_offset() throws IOException {
        long startTime = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("ly.jpg");

        File file = new File("f:/aaa/bbb/ccc.jpg");
        if(!file.exists()){
            // 如果输出文件父目录不存在, 就需要创建
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file);

        int len = -1;
        // buffer就是水缸,没有勺子,一次倒空
        byte[] buffer = new byte[1024]; // byte数组容量大小视情而定
        while ((len = fis.read(buffer)) != -1) { // read方法会将数据放入byte数组，并返回长度
            fos.write(buffer, 0, len);// 如果直接输出中文，则需要用getByte方法将其转换成字节数组
        }
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        long exeTime = endTime - startTime;
        System.out.println(exeTime);

    }


}
