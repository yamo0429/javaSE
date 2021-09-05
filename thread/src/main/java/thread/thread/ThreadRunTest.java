package thread.thread;

/**
 * Run 和 Start方法的区别
 * 		1. new Thread的时候,只表明创建了线程对象,但是系统还没分配给这个对象资源
 *		2. 我们自己调用run方法,执行的是我们重写的方法,线程还没被开启!!!(只有单线程)  直接调用
 *		3. start方法:  开启线程, JVM会执行run方法
 *			1. 原理: 底层start0 本地方法,会申请系统资源,开启线程  
 *			2. JVM 调用 thread的run方法，执行的是子类重写的run方法(接口回调,多态)
 */
public class ThreadRunTest {
	
	public static void main(String[] args) {
		
		MyThreadD t1 = new MyThreadD("线程=========");
		MyThreadD t2 = new MyThreadD("线程*********");
		
//		t1.run();//只是调用自己的run方法，要启动线程，必须调用start方法
//		t2.run();
		t1.start();
		t2.start();
	}
}
class MyThreadD extends Thread{
	
	public MyThreadD(String name){
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(getName() + "正在执行......");
		}
	}
}
