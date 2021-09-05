package file.fileFilter;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 1/3：原始list、listFiles方法过滤
 */
public class FilterOriginalDemo {
    @Test
    public void test() throws IOException {
        //	1. 需求 : test_io\FileDoc是否有 `.jpg` 格式的文件,如果有,则打印其绝对路径.
        File file = new File("f:/test_io\\FileDoc");
        String[] list = file.list();
        for (String name : list) {
            if (name.endsWith(".jpg")) {
                File file2 = new File(file, name);
                System.out.println(file2);
            }
        }

    }

    @Test
    public void test1() throws IOException {
        File file = new File("f:/test_io\\FileDoc");
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".jpg")) {
                System.out.println(file2);
            }
        }
    }
}
