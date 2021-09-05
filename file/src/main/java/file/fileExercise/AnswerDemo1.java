package file.fileExercise;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class AnswerDemo1 {
	
	@Test
	public void test1() throws IOException{
		//File.length()仅仅用于获得某个文件的大小，单位为bytes
		File file = new File("f:/test_io");
		System.out.println(file.length());
		
		long dirSize = getDirSize(file);
		System.out.println(dirSize);
	}
	
	 public static long getDirSize(File file) {     
	        //判断文件是否存在     
	        if (file.exists()) {     
	            //如果是目录则递归计算其内容的总大小    
	            if (file.isDirectory()) {     
	                File[] children = file.listFiles();     
	                long size = 0;     
	                for (File f : children)     
	                    size += getDirSize(f);     
	                return size;     
	            } else {//如果是文件则直接返回其大小,以“兆”为单位   
	            	long size =  file.length();        
	                return size;     
	            }     
	        } else {     
	            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");     
	            return 0;     
	        }     
	    }  
}
