package protocol.tcp;

import java.util.UUID;

public class UUIDDemo {
	
	public static void main(String[] args) {
		UUID randomUUID = UUID.randomUUID();
		//a2e05d81-f7f2-4678-8e88-1d19ef0a4f9d
		System.out.println(randomUUID);
	    String uuid = randomUUID.toString();
	    String real = uuid.replaceAll("-", "");
	    System.out.println(real);
	    for (int i = 0; i < 10;i++) {
	    	/**
	    	 * 链式编程：简化代码
	    	 */
			String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println(replaceAll);
		}
	}
}
