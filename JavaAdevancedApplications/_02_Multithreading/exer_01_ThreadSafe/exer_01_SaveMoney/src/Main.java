import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Main {
    public static void main(String[] args) {
        Account acct = new Account();
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.start();
        c2.start();
    }
}
class Account{
    private double balance;

    public synchronized double saveMoney(int money) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return balance += money;
    }
}
class Customer extends Thread{
    Account account;
    public Customer(Account acct){
        this.account = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "存入1000元，余额为：" + account.saveMoney(1000));
        }
    }
}