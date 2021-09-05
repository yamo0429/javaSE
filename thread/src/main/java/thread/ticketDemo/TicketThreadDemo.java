package thread.ticketDemo;

/**
 * 需求：假设某航空公司有三个窗口发售某日某次航班的100张票
 * 这时,100张票可以作为共享资源,三个售票窗口需要创建三个线程. 使用代码模拟实现(一共100张!)
 * 这100张票需要用static修饰，以保证三个窗口操作同一个资源（如果不加static，则每个窗口各自都卖了100张），但仍然可能会遇到并发修改问题，即多个窗口操作同一张票（亲测：窗口2和3都卖了第100张）
 * 使用Runnable接口后，虽然100张票不加static修饰就可以保证操作统一资源，但同样无法避免并发修改问题
 */
public class TicketThreadDemo {

    public static void main(String[] args) {

        MyWindow mw1 = new MyWindow("窗口1");
        MyWindow mw2 = new MyWindow("窗口2");
        MyWindow mw3 = new MyWindow("窗口3");
        MyWindow mw4 = new MyWindow("窗口4");
        MyWindow mw5 = new MyWindow("窗口5");
        MyWindow mw6 = new MyWindow("窗口6");

        mw1.start();
        mw2.start();
        mw3.start();
        mw4.start();
        mw5.start();
        mw6.start();
    }
}

class MyWindow extends Thread {
    /**
     * 1. 票数是总票数,而不是每个窗口的票数!
     * 要变成静态,为所有实例所共享
     */
    static int tickets = 100;
//    int tickets = 100;

    public MyWindow(String name) {
        super(name);
    }

    //执行任务
    @Override
    public void run() {
        //卖票
        while (true) {
            if (tickets > 0) {
                System.out.println(getName() + "正在售出第" + tickets + "张票");
                tickets--;
            } else {
                break;
            }
        }

    }
}