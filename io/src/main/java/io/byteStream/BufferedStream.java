package io.byteStream;

import org.junit.Test;

import java.io.*;

public class BufferedStream {

    /**
     问题:BufferedInputStream 为什么传入流? 缓存流本身不实现IO读写功能,需要传入的流进行操作
     原理:空间换时间
     buffer 是勺子, 底层的缓冲流缓存是水缸：每次先用水缸从硬盘搞水到内存缓冲流的底层数组中，然后字节数组这个勺子再从缓冲流底层数组这个水缸中舀水
     BufferedInputStream——内存访问——bis内部包含一个默认8K的缓存区，bis先从硬盘读取8K数据到内存,然后read(buffer)从内存的这8k缓存中取1个buffer字节数组长度的数据,即通过减少连接硬盘的次数提高效率
     FileInputStream——硬盘访问——fs是每次直接从硬盘中read一1个buffer字节数组长度的数据，效率低
     */
    @Test
    public void buffered() throws IOException {
        long startTime = System.currentTimeMillis();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("f:/test_io/cz.jpg"));

        File file = new File("f:/test_io/bbb/cz.jpg");
        if(!file.exists()){
            // 如果输出文件父目录不存在, 就需要创建
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
        }

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

        int len = -1;
        //buffer 是勺子, 底层的缓冲流缓存是水缸：每次先用水缸从硬盘搞水到内存缓冲流的底层数组中，然后字节数组这个勺子再从缓冲流底层数组这个水缸中舀水
        byte[] buffer = new byte[1024];
        while((len = bis.read(buffer)) != -1){
            bos.write(buffer, 0, len);// 如果直接输出中文，则需要用getByte方法将其转换成字节数组
        }
        bis.close();
        bos.close();
        long endTime = System.currentTimeMillis();
        long exeTime = endTime - startTime;
        System.out.println(exeTime);
    }

}
