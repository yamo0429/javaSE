package io;

import org.junit.Test;

import java.io.*;
import java.util.Random;

public class CutFileTool {
    @Test
    public void cutFile() throws Exception {
        long begin = System.currentTimeMillis();
//        File file = new File("c:/end");
//        File file = new File("d:/end");
//        File file = new File("e:/end");
//        File file = new File("f:/end");
        File file = new File("g:/end");

        suffix(file);
        copy(file);
//        deleteFile(file);
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - begin) / 1000 + "秒");
    }


    private static void suffix(File file) {
        int i = 1;
        int j = 1;

        File[] listFiles = file.listFiles();

        for (File file2 : listFiles) {
            //不是文件夹就是文件
            if (file2.isDirectory()) {
                suffix(file2);
                file2.renameTo(new File(file2.getParent() + "/" + (j++)));
            } else {

                file2.renameTo(new File(file2.getParent() + "/" + (i++) + ".txt"));
            }
        }
    }


    private static void copy(File file) throws Exception {
        BufferedReader br = null;
        BufferedWriter bw = null;
        File[] listFiles = file.listFiles();
        int j = 1;

        for (File file3 : listFiles) {

            //不是文件夹就是文件
            if (file3.isDirectory()) {
                copy(file3);
            } else {
                String path = file3.getPath();
                System.out.println(path + "====================");

                br = new BufferedReader(new InputStreamReader(new FileInputStream(file3), "gbk"));

                try {
                    bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file3)));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        bw.write(line);
                        bw.newLine();
                        bw.flush();
                    }
                } catch (Exception ex) {
                    System.out.println("文件存在，但是无法查看，可能是隐藏只读================");
                }
            }
        }
        if (bw != null)
            bw.close();
        if (br != null)
            br.close();
    }


    //删除文件及其所在文件夹、但最后不删除总文件夹
    private static void deleteFile(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteFile(file2);
                    file2.getAbsoluteFile().delete();
                } else {
                    //空txt文件不会被删除，不会出现在误删恢复
                    file2.delete();
                }

            }
//        file.delete();
        }
    }


}