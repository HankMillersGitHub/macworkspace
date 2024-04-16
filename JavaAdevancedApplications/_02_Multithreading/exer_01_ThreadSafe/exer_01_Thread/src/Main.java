public class Main {
    public static void main(String[] args) {
        Thread t = new NewYear();
        t.start();
    }
}
class NewYear extends Thread{
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Happy New Year!!!");
    }

}