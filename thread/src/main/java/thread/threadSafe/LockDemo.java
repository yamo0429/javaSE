package thread.threadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 1. 创建lock的实现类  ReentrantLock
 * 2. 方法
 * 1. lock
 * 2. unlock
 */
public class LockDemo {


    public static void main(String[] args) {

        MyTicketTask3 task = new MyTicketTask3();
        Thread t1 = new Thread(task, "窗口111");
        Thread t2 = new Thread(task, "窗口222");
        Thread t3 = new Thread(task, "窗口333");

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyTicketTask3 implements Runnable {
    int tickets = 1000;  // 全局共享资源，可以用static修饰

    @Override
    public void run() {
        while (true) {
            Lock lock = new ReentrantLock(); //1. 创建lock实例，也可放在外面。。TODO 每次都新建一个锁对象？？？？
            lock.lock(); //2. 上锁
            this.sellTicket();
            if (tickets == 0) {
                lock.unlock();//注意:不能让线程带着锁跑路!!!执行完跑路之前需要释放锁,让其他线程一起跑。。否则，当ticket<0后，就不再执行后续代码，导致无法释放锁
                break;
            }
            lock.unlock();  //3.释放锁 realease lock
        }
    }

    private void sellTicket() {
        if (tickets > 0) {
            //注意: --在变量右边,是执行完当前值,再-1
            System.out.println(Thread.currentThread().getName() + "正在卖出第" + tickets-- + "张票");
        }
    }
}
