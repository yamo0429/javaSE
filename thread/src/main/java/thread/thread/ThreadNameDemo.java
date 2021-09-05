package thread.thread;

/**
 * 1. 获取线程名
 * 		1. 如果是Thread的子类,可以直接调用Thread的getName方法获取
 * 		2. 如果不是thread的子类（如线程任务类）,可以调用Thread.currentThread().getName()
 * 2. 默认线程名称
 * 		1. 主线程: main
 * 		2. 子线程: Thread-0   -1   ... -n 以此类推      static int indext
 * 3. 设置线程名
 * 		1. 构造方法 new Thread(name)
 * 		2. setName
 * 4. 作用
 * 		1. 当线程出现异常时,默认的线程名很难定位(自己设置,自己就容易找)
 * 5. 多线程之间相互独立,一个线程挂掉,不影响其他线程执行(即使是主线程挂掉)
 * 		1. 每个线程都拥有自己独立的栈
 */
public class ThreadNameDemo {
	
	public static void main(String[] args) {
		
		System.out.println("主线程:" + Thread.currentThread().getName());
		
//		MyThreadB t1 = new MyThreadB();
//		t1.setName("线程1");
//		
//		MyThreadB t2 = new MyThreadB();
//		t2.setName("线程2222222");
		
		MyThreadB t1 = new MyThreadB("线程B");
		MyThreadC t2 = new MyThreadC("线程C");
		t1.start();
		t2.start();
		
		int i = 1/0;
	}
}
class MyThreadB extends Thread{
	public MyThreadB(){ }
	public MyThreadB(String name){
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ".....");
		}
	}
}
class MyThreadC extends Thread{
	public MyThreadC(String name){
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(i == 3){
				System.out.println(getName() + "======");
				int j = 1/0;
			}
		}
	}
}
