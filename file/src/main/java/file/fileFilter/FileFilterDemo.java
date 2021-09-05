package file.fileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.junit.Test;

/**
 * io流——文件过滤中的接口回调！！
 * 与FilenameFilter不同，对于FileFilter，只有listFiles的过滤方法，没有list的过滤方法
 *
 */
public class FileFilterDemo {
	@Test
	public void test1() throws IOException{
		File file = new File("f:/test_io\\c");
		
		//示例1
		File[] listFiles = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".jpg");
			}
		});

		for (File file2 : listFiles) {
			System.out.println(file2);
		}

		//示例2
		File[] listFiles2 = file.listFiles(new MyFileFilter(".txt"));
		for (File file2 : listFiles2) {
			System.out.println(file2);
		}
	}
}
class MyFileFilter implements FileFilter{
	String suffix;
	public MyFileFilter(String suffix){
		this.suffix = suffix;
	}
	@Override
	public boolean accept(File pathname) {
		return pathname.getAbsolutePath().endsWith(suffix);
	}
}





