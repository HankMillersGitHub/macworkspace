/*
* 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品，
* 如果生产者试图生产更多的产品给店员，店员会叫停生产者，
* 如果店中有空位放产品了，在通知生产者继续生产，
* 如果店中没有产品了，店员会告诉消费者等一下，
* 如果店中有产品了再通知消费者取走产品
* */
public class MyCode {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Customer customer1 = new Customer(clerk);
        Customer customer2 = new Customer(clerk);
        Productor productor = new Productor(clerk);
        customer1.setName("消费者1");
        customer1.start();
        customer2.setName("消费者2");
        customer2.start();
        productor.setName("生产者");
        productor.start();
    }
}
// 店员类
class Clerk{
    private int productNum = 0;
    public int getProductNum() {
        return productNum;
    }

    // 增加产品数量的方法
    public synchronized void addProduct(){
        if(productNum >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        productNum++;
        System.out.println(Thread.currentThread().getName() + "生产了第" + productNum + "个产品。");
        // 唤醒消费者
        notify();
    }
    // 减少产品数量的方法
    public synchronized void subProduct(){
        if(productNum <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + "拿取了第" + productNum + "个产品。");
        productNum--;
        // 唤醒生产者
        notify();
    }
}

// 生产者类
class Productor extends Thread{
    private Clerk clerk = new Clerk();
    public Productor(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "正在生产商品，当前商品数量：" + clerk.getProductNum());
            clerk.addProduct();
        }
    }
}

// 消费者类
class Customer extends Thread{
    private Clerk clerk = new Clerk();
    public Customer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "正在购买商品，当前商品数量：" + clerk.getProductNum());
            clerk.subProduct();
        }
    }
}