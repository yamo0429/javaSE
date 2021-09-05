package thread.thread;

/**
 * Java创建新执行线程方法一：
 * 1. 将类声明为 Thread 的子类。
 * 2. 该子类应重写 Thread 类的 run 方法
 * 3. 接下来可以分配并启动该子类的实例。
 *
 * 缺点：线程间资源不能共享
 */
public class ThreadDemo {
    public static void main(String[] args) {
        /**
         * 3.创建继承类实例
         * 4.启动线程
         */
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");

        t1.start();
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主" + i);
        }
    }
}

/**
 * 1. 继承 thread类
 * 2. 重写run方法
 */
class MyThread extends Thread {
    String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name +"--"+ i);
        }
    }
}