package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 字节打印流 & 字符打印流"：
 * 1. 只有输出流. 没有输入流
 * 2. 既可以输出到文件,又可以输出到其它流中
 * 3. 无需关流
 * 4. PrintStream 自带自动刷新. PrintWriter 需要启动自动刷新
 */
public class printWriter {
    public static void main(String[] args) throws IOException {

        PrintStream ps = new PrintStream("log.txt");//TODO 这里的根目录是vdn，而不是io，需要写成"javaSE/io/log.txt"。ByteStream_problems 里就是io
        ps.println("有bug了,快来人啊!");
//		ps.close();//无需手动关流和刷新

        PrintWriter pw = new PrintWriter(new FileWriter("javaSE/io/log.txt"), true);//autoFlush = true : 自动刷新
        pw.println("快跑啊,bug制造机来啦!");
        pw.println("大家好,dddd?");
//		pw.close();//上面开启懂得刷新后，这里无需手动关流和刷新。但自动刷新的功能只对 PrintWriter的print 系列的方法有效,write方法需要手动刷新
        pw.write("I love you all. 我爱你们!");
        pw.flush();
    }

}
