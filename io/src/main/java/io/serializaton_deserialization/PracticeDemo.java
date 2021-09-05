package io.serializaton_deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 5. 练习和应用
			1. 练习：集合（四大名著：作者） 进行序列化和反序列化
			2. 应用：
				1. 序列化这个概念太笼统，说白了就是方便计算机表述，使用010101的方式方便传输和存储。
				2. java 序列化 也是为了 传输和存储，只是 Serializable 是使用java内部序列化格式。
				开发中，由于java自身的序列化信息不够简洁，一般很少有使用java 序列化对象进行通信的。
 *
 */
public class PracticeDemo {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		HashMap<String,Student> map = new HashMap<String, Student>();
		map.put("西游记",new Student("吴承恩", 18));
		map.put("红楼梦",new Student("曹雪芹", 20));
		map.put("三国演义",new Student("罗贯中", 21));
		map.put("水浒传",new Student("施耐庵", 22));
		//施夷光     西施
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f:/test_io/book.txt"));
		oos.writeObject(map);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:/test_io/book.txt"));
		HashMap<String,Student> readMap = (HashMap<String, Student>) ois.readObject();
		Set<String> keySet = readMap.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			Student value = readMap.get(key);
			System.out.println(key + ":" + value);
		}
	}
}
