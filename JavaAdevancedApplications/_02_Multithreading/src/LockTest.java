import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.start();
        w2.start();
        w3.start();
    }
}
class Window extends Thread{
    static int ticket = 100;
    // 1. 创建Lock实例，需要保证多个线程共用同一个staric，需要考虑将此对象声明为static
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try{
                // 2. 执行lock方法，锁定对共享资源的调用
                lock.lock();
                if(ticket > 0){
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println(Thread.currentThread().getName() + "购买，剩余：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                // 3. 执行unlock方法，解锁对共享资源的调用
                lock.unlock();
            }
        }
    }
}
