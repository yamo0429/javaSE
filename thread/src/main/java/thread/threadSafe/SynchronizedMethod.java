package thread.threadSafe;


/**
 * 1.同步方法：在方法返回值前加上Synchronized关键字
 * 2.同步方法的锁对象：默认是this，即当前调用这个方法的对象
 */
public class SynchronizedMethod{
	
	public static void main(String[] args) {
		
		MyTicketTask2 task = new MyTicketTask2();
		Thread t1 = new Thread(task, "窗口111");
		Thread t2 = new Thread(task, "窗口222");
		Thread t3 = new Thread(task, "窗口333");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
class MyTicketTask2 implements Runnable{

	static int tickets = 1000; // 全局共享资源
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(10); // 线程睡眠10ms,卡住
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.sellTicket();  //同步方法的锁是this，当前调用这个方法的对象
			if(tickets == 0 ){
				break;
			}
		}
	}
	private synchronized void sellTicket() {
		if(tickets > 0){
			//注意: --在变量右边,是执行完当前值,再-1
			System.out.println(Thread.currentThread().getName() + "正在卖出第" + tickets-- + "张票");
		}
	}
}
