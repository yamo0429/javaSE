package thread.ticketDemo;

/**
 * 实现runnable接口方式的好处
 *    1. 弥补java类的单继承局限,扩展性更强
 *    2. 更好的实现任务(核心执行程序)的资源共享
 *    3. 但依然无法解决线程安全问题
 *    对于Runnable接口来说，这100张票不加static也能保证多个窗口操作的是同一资源，因为多个窗口执行的是同一个卖票程序。但同样不能避免并发修改问题（亲测：窗口2和3都卖了第71张）
 *
 */
public class TicketRunnableDemo {
	
	public static void main(String[] args) {
		
		MyTicketTask0 task = new MyTicketTask0();
		Thread t1 = new Thread(task, "窗口1");
		Thread t2 = new Thread(task, "窗口2");
		Thread t3 = new Thread(task, "窗口3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
class MyTicketTask0 implements Runnable{
	int tickets = 100;
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(tickets > 0){
				//注意: --在变量右边,是执行完当前值,再-1
				System.out.println(Thread.currentThread().getName() + "正在卖出第" + tickets-- + "张票");
			}else{
				break;
			}
		}
	}
}
