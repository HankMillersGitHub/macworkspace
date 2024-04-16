import java.security.spec.RSAOtherPrimeInfo;

/*
 * 案例：使用两个线程打印1-100，线程一、线程二交替打印
 * */
public class Main {
    public static void main(String[] args) {
        // 自己写的
        /*
        Print p1 = new Print();
        Print p2 = new Print();
        p1.start();
        p2.start();*/

        // 老师写的
        Print p = new Print();
        Thread t1 = new Thread(p,"线程一");
        Thread t2 = new Thread(p,"线程二");
        t1.start();
        t2.start();
    }
}
// 自己写的
/*
// 公用的代码是打印
class Print extends Thread{

    static int num = 0;
    @Override
    public void run() {
        while (num < 100){
            System.out.println(Thread.currentThread().getName() + "打印的数字是：" + ++num);
        }
    }
}
*/

// 老师写的
class Print implements Runnable{
    Object obj = new Object();
    private int num = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
//            synchronized (obj) {
                // 唤醒所有等待的线程
                notify();
                if(num <= 100){
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e ){
                        System.out.println(e.getMessage());
                    }
                    System.out.println(Thread.currentThread().getName() + "打印的数字是：" + num);
                    num++;
                    // 线程一旦进入此方法，就进入等待状态，同时释放对同步监视器的调用
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }else{
                    break;
                }
            }
        }
    }
}