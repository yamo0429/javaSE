package file.fileFilter;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 2/3：list(过滤器)方法的过滤（实现类或者匿名内部类）
 */
//	1. 需求 :  C:\test\filedoc 是否有 `.jpg` 格式的文件,如果有,则打印其绝对路径
public class FilenameFilter {
	
	@Test
	public void test1() throws IOException{
		File file = new File("f:/test_io\\c");
		
		MyFilenameFilter mf = new MyFilenameFilter();
		String[] list = file.list(mf);
		for (String name : list) {
			File file2 = new File(file, name);
			System.out.println(file2);
		}
	}
}
class MyFilenameFilter implements java.io.FilenameFilter{
	/**
	 * 参数:dir 在file.list中被赋值(this):C:\\test\\FileDoc
	 * 参数:name  在父目录中找出的文件(夹)名
	 * 返回值:true   name就会被放到(集合转数组)数组中,作为list方法的返回值
	 */
	@Override
	public boolean accept(File dir, String name) {
//		System.out.println("dir:" + dir);
//		System.out.println("name:" + name);
		return name.endsWith(".jpg");
	}
	
}




