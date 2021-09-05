package io.file.fileDemo;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 删除指定文件夹下的子文件夹及其内容
 * @author fangchang
 *
 */
public class AnswerDemoFinal {
	static File srcfile = new File("f:/test_io\\a\\FileDoc");
	@Test
	public void test1() throws IOException{
		
		deleteFile(srcfile);
	}

	private static void deleteFile(File f) {
		File[] listFiles = f.listFiles();
		for (File file : listFiles) {
			if(file.isDirectory()){
				deleteFile(file);
			}else{
				String parent = file.getParent();
				System.out.println(parent);
				if(!parent.equals(srcfile.getAbsolutePath())){//此句说明FileDoc子文件夹下的文件，才能删除，最后再删除该子文件夹
					file.delete();
				}
			}
		}
		f.delete();
	}
}
