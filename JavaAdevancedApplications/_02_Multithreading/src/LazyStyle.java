public class LazyStyle {
    static Bank b1 = null;
    static Bank b2 = null;
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                b1 = Bank.getInstance();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                b2 = Bank.getInstance();
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b2 == b1);
    }
}
class Bank {
    private Bank(){}
    private static volatile Bank instance = null;
    public static Bank getInstance(){
        if(instance == null){
            synchronized (Bank.class){      // 使用同步代码块的方式处理线程安全
                if (instance == null) {
                    // 为了出现线程安全问题，添加如下代码
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}