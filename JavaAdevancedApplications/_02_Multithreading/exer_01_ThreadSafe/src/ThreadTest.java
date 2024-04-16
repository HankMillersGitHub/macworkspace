public class ThreadTest {
    public static void main(String[] args) {
        MainTest t1 = new MainTest();
        Thread h1 = new Thread(t1);
        Thread h2 = new Thread(t1);
        Thread h3 = new Thread(t1);
        h1.start();
        h2.start();
        h3.start();
    }
}
class MainTest implements Runnable{
    static int ticket = 100;
    static boolean isContinue = true;
    @Override
    public void run() {
        while (isContinue) {
            show();
        }
    }
    public synchronized void show(){
        if(ticket > 0){
            System.out.println(Thread.currentThread() + "售出,剩余：" + ticket);
            ticket--;
        }else{
            isContinue = false;
        }
    }
}
