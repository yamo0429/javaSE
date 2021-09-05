package io.file.fileMethod;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 2. 删除方法
 * 1. boolean delete()：  删除File类对象中的文件或文件夹。
 * 1. 删除不走回收站，谨慎使用。
 * 2. 文件：直接删除
 * 3. 文件夹：要求文件夹一定是空的，非空文件夹不能直接删除。（可以从内向外）
 * 3. 重命名
 * 1. renameTo(File dest) // destination 目的地
 * 1. 如果重命名在同一个父目录下, 相当于重命名
 * 2. 如果重命名不在同一个父目录下, 相当于剪切
 */
public class DeleteDemo {

    @Test
    public void deleteTest() throws IOException {
        File file = new File("f:/test_io/c/c.txt");
        boolean delete = file.delete();
        System.out.println(delete);
    }

    @Test
    public void renameToTest() throws IOException {
        File file = new File("f:/test_io/c/cz2.jpg");
        boolean renameTo = file.renameTo(new File("f:/test_io/cz.jpg"));
        System.out.println(renameTo);
    }

}
