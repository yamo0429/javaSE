package thread.runnable;

/**
 * 创建线程的第二种方法
 * 1.声明实现 Runnable 接口的类
 * 2.该类然后实现 run 方法
 * 3.然后可以分配该类的实例，在创建 Thread 时作为一个参数来传递并启动,保证了线程之间共享资源
 * 原理
 * 1. jvm回调thread的run方法
 * 2. 如果我们采用继承thread的方式,重写run方法,那么jvm执行的就是thread子类的run方法
 * 3. 如果我们采用实现runnable的方法,那么JVM 执行的是thread的run方法(判定是否有runnable接口的实现类对象,如果有,执行实现类的run方法)
 */
public class RunnableDemo {

    public static void main(String[] args) {
        /**
         * 3.创建接口实现类对象
         * 4. 将线程任务类传递给thread对象
         */

        /*
         * 有时会先执行线程4这可以理解。因为虽然程序是从上往下执行，但有时却先切到线程4的start方法上？
         * 但是如果CPU先切换到线程4，为什么不是线程4一个人把任务都执行完了呢？还要留给其他线程执行呢？
         * 也就是说，开启了一个线程后，它不需要等自己执行完毕全部资源后再往下执行下一行代码吗？比如第一个strat执行完毕
         * 之后，才执行第二个start？为何一个线程执行一些资源后，会给其他线程执行呢？第二个线程何时开启？难道不是等第一个线程
         * 全部执行完毕再开启？
         *
         * 解答：见线程的状态（生命周期），每个线程都有自己的时间片，这决定着线程处在不同的状态
         * */
        MyRunnableTask task = new MyRunnableTask();//TODO 保证了线程之间共享资源，但与Thread方式一样，仍可能造成并发修改异常
        Thread t1 = new Thread(task, "线程1");
        Thread t2 = new Thread(task, "线程2");

        t1.start();
        t2.start();
    }
}

/**
 * 1.
 * 1.是声明实现 Runnable 接口的类
 * 2.该类然后实现 run 方法
 */
class MyRunnableTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在下载——"+i);
        }
    }

}
