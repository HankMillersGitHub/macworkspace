import java.lang.reflect.Executable;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        // 设置线程池中线程数的上限
        threadPoolExecutor.setMaximumPoolSize(50);

        // 2. 执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        executorService.execute(new Number1()); // 此方式适合实现Runnable接口的方式
        executorService.execute(new Number2());
        // 3. 关闭连接池

        executorService.shutdown();
    }
}
class Number1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
class Number2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}
