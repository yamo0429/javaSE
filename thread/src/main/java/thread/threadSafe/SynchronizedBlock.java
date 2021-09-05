package thread.threadSafe;


/**
 * 1.同步代码块
 *	Synchronized(锁对象){
 *	 	需要同步的代码块
 *  }
 * 2. 锁
 * 		1. 锁对象可以是任意对象
 * 		2. 锁对象必须是唯一的
 * 3. 拿到锁的线程执行代码,其他线程等待,直到该线程执行完释放锁,其他线程才能拿锁执行!
 * 4. 在加锁的代码中,一个时间只有一个线程执行
 * 5. 什么时候使用同步锁？
 * 		1. 同步锁虽然避免并发修改问题,但是不可避免地会降低程序效率，应该在多个线程操作同一资源的代码块上加锁
 */
public class SynchronizedBlock{
	
	public static void main(String[] args) {
		
		MyTicketTask task = new MyTicketTask();
		Thread t1 = new Thread(task, "窗口111");
		Thread t2 = new Thread(task, "窗口222");
		Thread t3 = new Thread(task, "窗口333");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
class MyTicketTask implements Runnable{
	// 全局共享资源
	int tickets = 100;
	/**
	 * 1. 如果专门定义一个锁对象lock,必须在成员位置,不能在run方法的内部,保证全局唯一，因为run方法会被不同线程执行，锁必须 是全局唯一的
	 * 2. this表示本类对象,task只有唯一实例,所以也可以被作为锁对象
	 * 3. 类名.class :  类的Class对象,类加载完之后在内存中产生的对象(因为类只加载一次,保证了全局唯一)
	 * 
	 */
	Object lock = new Object();
	@Override
	public void run() {
		while(true){
			try {
				/**
				 * 线程睡眠10ms,卡住
				 */
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (MyTicketTask.class) {
				if(tickets > 0){
					//注意: --在变量右边,是执行完当前值,再-1
					System.out.println(Thread.currentThread().getName() + "正在卖出第" + tickets-- + "张票");//操作的是同一个资源，故要保证唯一修改
				}else{
					break;
				}
			}
		}
	}
}
