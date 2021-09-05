package file.fileFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.junit.Test;

/**
 * 3/3：listFiles(过滤器)方法过滤（实现类或者匿名内部类）
 *
 * 1. 多态
 * 1. 接口回调
 * 2. 匿名内部类
 * 1. 在API方法中的形参为接口,如果我们只重写接口方法,就可以直接用匿名内容类(简化书写)
 * 3. 自定义接口实现类
 * 1. 扩展接口功能(将后缀名变成变量,由调用者指定)
 */
public class FilenameFilter2 {
    @Test
    public void test1() throws IOException {

        File file = new File("f:/test_io");

        //方法1：实现类
		File[] listFiles1 = file.listFiles(new MyFilenameFilter2(".txt"));
		for (File file1 : listFiles1) {
			System.out.println(file1);
		}

        //方法2：匿名内部类
        File[] listFiles2 = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });
        for (File file2 : listFiles2) {
			System.out.println(file2);
        }
    }
}

class MyFilenameFilter2 implements FilenameFilter {
    String suffix;

    public MyFilenameFilter2(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }

}
