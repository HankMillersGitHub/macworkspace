public class WindowTest {
    public static void main(String[] args) {
        SaleTicket s = new SaleTicket();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();

    }
}
class SaleTicket implements Runnable{

    int ticket = 100;

    boolean isContinue = true;
    @Override
    public void run() {
        while (isContinue) {
            show();
        }
    }
    public synchronized void show(){    // 此时的同步监视器就是this this是唯一的所以是安全的
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + "售出，票号为：" + ticket);
            ticket--;
        } else {
            isContinue = false;
        }
    }
}