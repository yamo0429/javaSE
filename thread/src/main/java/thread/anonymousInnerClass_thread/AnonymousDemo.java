package thread.anonymousInnerClass_thread;

import org.junit.Test;

/**
 * 匿名方式实现多线程，仍然是基于Thread和Runnable
 * 原理
 * 	JVM 调用 thread的run方法
 * 	1. 如果子类重写了run方法,直接执行子类的run方法
 *  2. 如果没有thread子类，而是实现接口,那么直接调用thread的run方法（传入target类的对象），这时会做如下操作：
 *  	1. 判断成员属性  runanable  target = null ,如果是,则do nothing
 *      2. 如果不是,执行targer的run方法
 *
 */
public class AnonymousDemo {
	
	public static void main(String[] args) {
		//面试题:如何打印? 优先级：子类-父类-任务类，且前一个执行，后面就不会执行
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("重写接口run...");
			}
		}){
			@Override
			public void run() {
				System.out.println("重写父类run...");
			}
		}.start();
	}

	@Test
	private static void myTaskTest() {
		//线程一
		MyTask task = new MyTask();
		Thread t = new Thread(task);
		t.start();

		//线程二（匿名）
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}).start();
	}

	@Test
	private static void myThread0Test() {

		MyThread0 t = new MyThread0();
		t.start();

		new Thread(){
			@Override
			public void run() {
				super.run();
			}
		}.run();

		new Thread(){
			public void run() {
				System.out.println(getName() + "正在运行");
			};
		}.start();
	}
}


class MyThread0 extends Thread{
	@Override
	public void run() {
		super.run();
	}
}

class MyTask implements Runnable{
	@Override
	public void run() {

	}
}