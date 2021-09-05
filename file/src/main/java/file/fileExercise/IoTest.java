package file.fileExercise;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 构造：pathname、StrParent+child、FileParent+child
 * <p>
 * 创建：mkdir、mkdirs、createNewFile
 * <p>
 * 删除/重命名/剪切：delete和renameTo
 * <p>
 * 判断：isAbsolute、isDirectory、isFile、exists
 * <p>
 * 列举：listRoots、list、listFiles
 * <p>
 * 获取:
 * 1. getAbsoluteFile		获取一个文件（夹）的绝对路径对象
 * 2. getAbsolutePath		获取一个文件（夹）的绝对路径字符串对象
 * <p>
 * 5. getParentFile 获取父目录文件对象
 * 4. getParent 获取父目录字符串对象
 * <p>
 * 3. getName() 获取的是File类的对象中封装的文件或目录的最后一级名称
 * <p>
 * 6. getPath 获取当前路径（似乎与上面的getAbsolutePath一样效果）
 * <p>
 * 7. length  文件中数据的长度
 */
public class IoTest {
    @Test
    public void test1() {
        File file = new File("f:\\test_io\\c.jpg");
        File file1 = new File(new File("f:/test_io"), "d.txy");
        File file2 = new File("f:/test_io", "k.txt");

    }

    @Test
    public void test2() throws IOException {
        String separator = File.separator;
        System.out.println(separator);

        File file = new File("f:/test_io/0/vdn2.txt");
//        System.out.println(file.mkdir());
//        System.out.println(file.mkdirs());
        System.out.println(file.createNewFile());

    }

    @Test
    public void test3() {
        File file = new File("f:/test_io/0/vdn");
//        System.out.println(file.delete());
        System.out.println(new File("f:/test_io/0").renameTo(new File("f:/test_io/1")));

    }

    @Test
    public void test4() {
        File file = new File("f:/test_io/b.txt");
        System.out.println(file.isAbsolute());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());

    }

    @Test
    public void test5() {
        File file = new File("f:/test_io");
       /* String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(new File(file, list[i]));
            System.out.println(file.getAbsolutePath()+File.separator+list[i]);
        }*/
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getAbsolutePath());
        }


    }

    @Test
    public void test6() {
        File file = new File("f:/test_io/cz.jpg");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());

        System.out.println(file.getParent());
        System.out.println(file.getParentFile());

        System.out.println(file.getPath());

        System.out.println(file.getName());

        System.out.println(file.length());

    }

    @Test
    public void test7() {

    }


}
