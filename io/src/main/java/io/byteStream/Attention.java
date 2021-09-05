package io.byteStream;

import java.io.*;

import org.junit.Test;

public class Attention {

//    问题1 : 流必须关流,但是如果在流关闭之前,出了异常,那么流的关闭动作就无法被执行了,可以使用异常机制来进行处理.将必须被执行的行为,放到 finally 代码块中.
//    问题2 : 既然把关闭动作,放在finally后.流的定义也必须放在 try 块之外,否则看不到.
//    问题3 : 如果创建流的时候,已经抛出了异常,那么流就不存在,不需要关闭,因此关闭流之前,需要先判断流是否为 null.
    @Test
    public void test2() throws IOException {
        closeIo();
    }
    private static void closeIo(Closeable... ios) {  // Closeable:可以关闭资源的流顶层接口
        for (Closeable io : ios) {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test() throws IOException {
        FileOutputStream fos = null;
        try {
//			int i = 1 /0;
            fos = new FileOutputStream("b.txt");
            fos.write(97);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


//   "数据追加出现的问题 :"流一旦关闭,再次写数据,会覆盖文件中原来的数据.
//   "如何解决 ?"使用以上提供了的两个构造方法来创建`文件输出流`对象
//   "数据换行问题 :"1.如果想换行,可在数据末尾追加: \r\n。但\r\n 只是Windows系统识别的换行符.其他系统呢？
//   "解决方案 :"如果我们能根据系统来获取对应的换行符,就可以跨平台,如何从系统获取换行符呢?System类中的方法：System.lineSeparator();
    @Test
    public void fos_append() throws IOException {
        FileOutputStream fos = new FileOutputStream("aaa.txt", true);
        String s = "Hello 我的, I love you!";
        /**
         *  System.lineSeparator() 会获取系统的行分割符(因系统而异)
         */
        String separator = System.lineSeparator();
        String addSeparator = separator + s;

        fos.write(addSeparator.getBytes());//String转为字符数组后输出
        fos.close();

    }


//    文件输出流对象只会创建文件,不会创建文件夹,因此,在关联时必须要先判断父目录是否存在
    @Test
    public void fos_notice() throws IOException {
        File file = new File("C:/test2/c.txt");
        //判断父目录是否存在,如果父目录不存在则创建
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file);

        fos.write(97);

        fos.close();
    }

    @Test
    public void offset() throws IOException {
        // 写方法write有三个：int或char（int类型与char是相通的）、带偏移量的字节数组、不带偏移量的字节数组
    }


}

