# 第一章 异常处理

## 1.1 java异常体系

### 1. Throwable

<span style="color:orange">`java.lang.Throwable`</span>类是java程序执行过程中发生的异常事件的对应的类的根父类

<span style="color:red">Throwable中的常用方法</span>

* <span style="color:orange">`public void printStatackTrace()`:</span>打印异常的详细信息
* <span style="color:orange">`public String getMessage()`</span>:获取发生异常的原因

### 2. Error和Exception

 Throwable可分为两类：Error和Exception。分别对应着<span style="color:orange">`java.lang.Error`</span>与<span style="color:orange">`java.lang.Exception`</span>两个类。

<span style="color:red">Error</span>：java虚拟机无法解决的严重问题，如：JVM系统内部错误、资源耗尽等严重情况。一般不编写针对性的代码进行处理。	

​	例如：StatackOverflowError(栈内存溢出)和OutOfMemoryError(堆内存溢出，简称OOM)。

<span style="color:red">Exception</span>：其他因变成错误或偶然的外在因素导致的一般性问题，需要使用针对性的代码进行处理，使程序继续运行。否则一旦发生异常，程序也会挂掉。例如：

* 空指针异常
* 试图读取不存在的文件
* 网络连接中断
* 数组角标越界

> 说明：
>
> ​	设置程序运行时的堆空间大小 
>
> ​		run -> edit configurations -> build and run >> modify options -> add VM options -> input -Xms10m -Xmx10m
>
> ​		注意： 堆内存被JVM分为几部分，其中一部分可以被使用，其他部分会被线程等使用，所以设定的堆内存不能被程序员完全占用

## 1.2 异常的体系结构

java.lang.Throwable: 异常体系的根父类

​	|--- java.lang.Error : 错误。Java虚拟机无法解决的严重问题，如：JVM系统内部错误，资源耗尽等严重情况，一般不编写针对性代码进行处理

​		|---- StatackOverflowError、OutOfMemoryError

​	|--- java.lang.Exception : 异常，我们可以编写针对性的代码进行处理

​		|---- 编译时异常：(受检异常)在执行javac.exe命令时，出现的异常

​			|-----ClassNotFoundException

​			|-----FileNotFoundException

​			|-----IOException

​		|---- 运行时异常：(非受检异常)在执行java.exe命令时，出现的异常

​			|----- ArrayIndexOutOfBoundsException

​			|----- NullPointerException

​			|----- ClassCastException

​			|----- NumberFormatException

​			|----- InputMismatchException

​			|----- ArithmeticException

## 1.3 异常的处理方式

<span style="color:red">java异常处理</span>：

​	java采用的异常处理机制，是将<span style="color:orange">异常处理的程序代码集中在一起</span>，与正常的代码分开，使得代码简洁、优雅，并易于维护

<span style="color:red">java异常处理的方式</span>

方式一：try-catch-finally

方式二：throws + 异常类型

### 1. 方式一：捕获异常(try-catch-finally)

1. 基本格式

   ```java
   try{
     /*可能产生异常的代码块*/
     // 在执行的过程中，一旦出现异常，就会在出现异常的代码处，生成相对应的异常类，并将此对象抛出
     // 一旦抛出，此程序就不在执行之后的代码
   }catch(异常类型1 e){
     /*针对于异常类型1的处理方式*/
     // 代码块 针对于try中抛出的异常进行捕获处理，一旦进行了处理，代码就可以继续进行
   }catch(异常类型2 e){
    /*针对于异常类型2的处理方式*/ 
   }finally{
     /* 代码块 无论是否异常都要执行的代码块*/
   }
   ```

2. 使用举例

   ```java
   try{
       Scanner scan = new Scanner(System.in);
       int num = scan.nextInt();
       System.out.println(num);
   }catch (InputMismatchException e){
       System.out.println("there is InputMismatchException");
   }catch (NullPointerException e){
       System.out.println("there is NullPointerException");
   }
   System.out.println("exception has been handle");
   /*
   如果多个异常类型满足子父类的关系，那么子类异常必须写父类异常的上面
   */
   /*
   catch中处理异常的方式
   1. 使用自己编写的处理语句
   2. printStackTrace()： 打印异常的详细信息
   3. getMessage()：获取发生异常的原因
   */
   /*
   对于运行时异常，一般不对其进行处理，运行中如果出现，就修改代码
   对于编译时异常，必须要进行处理，否则编译不通过，相当于把编译时异常延后到了运行时
   */
   ```

3. finally使用及举例

   ```java
   /*
   将一定要被执行的代码写在finally结构中
   更深刻的理解：
   	无论try或catch中是否存在仍然未处理的异常，无论try或catch中是否存在return语句，finally结构中的代码都会被执行
   	
   finally和catch语句都是可选的，但是都不能单独使用
   
   有一些资源(输入流、输出流、数据库连接、Socket链接等资源)，在使用完以后，必须显式的进行关闭操作，否则GC不会自动回收这些资源，进而导致内存泄漏
   为了保证这些资源在使用完之后，不管是否出现了未被处理的异常的情况下，这些资源能被关闭。我们必须将这些操作声明在finally中
   */
   ```

   

### 2. 方式二：声明抛出异常的类型(throws + Exception)

1. 格式

   ```java
   public void sayHello throws 异常类型1,异常类型2{}
   ```

2. 举例

   ```java
   public void sayHello throws NullPointerException,IOException{}
   ```

3. 是否真正处理了异常？

   从编译是否能通过的角度，看成是给出了异常万一出现时的解决方案，此方案就是继续向上抛出

   但是从这种方式看，仅仅是将可能出现的异常抛给了此方法的调用者，此调用者仍然需要考虑如何处理相关异常，从这个角度看，并没有真正意义上处理异常

4. 方法的重写的要求<span style="color:red">(只针对于编译时异常)</span>

   子类重写的方法抛出的异常可以与父类抛出的异常相同，也可以是父类抛出异常的子类

5. 开发中如何选择异常的处理方式(important 经验之谈)

   > 资源一定要被执行，使用try-catch-fianlly
   >
   > 如果父类被重写的方法没有throws异常类型，则子类重写的方法中如果出现异常，使用try-catch-fianlly
   >
   > 开发中，方法a中依次调用了方法b,c,d等方法，方法b,c,d之间是递进关系，此时如果方法b,c,d中有异常，我们通常选择使用throws，而方法a中通常选择使用try-catch-finally

## 1.4 手动throw异常对象

1. 为什么需要手动抛出异常对象

   在实际开发中，如果出现不满足具体场景的代码问题，我们就有必要跑出一个指定类型的异常对象

2. 如何理解手动和自动抛出异常对象

   抛：

   ​	自动抛：程序执行的过程中，一旦出现异常，就会在出现异常的代码处，自动生成对应的异常类的对象，并将此对象抛出

   ​	手动抛：程序执行的过程中，不满足指定条件的情况下，主动使用`throw + 异常类的对象`的方式抛出异常对象

   抓：

   ​	狭义上讲：try-catch的方式捕获异常，并处理

   ​	广义上讲：把“抓”理解为“处理”，则此时对应着异常处理的两种方式：try-catch-finally 和 throws

3. 如何实现手动抛出异常

   在方法内部，满足指定条件的情况下，使用throw 异常类对象 的方式抛出

4. 注意点：<span style="color:red">throw后的代码不能被执行，编译不通过</span>

5. throws和throw的区别(上游排污，下游治污)

   throw一般用于手动抛出异常，使用在方法内部，是产生异常的

   throws一般用于处理异常的时候，使用在方法声明时，是处理异常的

## 1.5 自定义异常

1. 如何自定义异常

   1. 继承于现有的异常体系，通常继承于Exception / RuntimeException
   2. 通常提供几个重载的构造器
   3. 提供一个全局常量：`static final long serialVersionUID = *******************l`

2. 如何使用自定义异常类

   在具体的代码中满足指定条件的情况下，需要手动的使用"Throw 自定义异常类的对象"的方式，将异常对象抛出

   如果自定义异常类是非运行时异常，则必须考虑如何处理此异常类的对象

3. 为什么要自定义异常类

   为了能够见名知意，更快的处理问题

   我们更关心的是，通过异常的名称就能直接判断此异常出现的原因。既然如此，我们就有必要在实际开发场景中，不满足我们指定条件时指明我们自己特有的异常类。通过此异常类的名称，就能判断出具体出现的问题

## 项目：团队调度



# 第二章 多线程

## 2.1 相关概念

* <span style="color:red">程序(program)</span>：为完成特定任务，用某种语言编写的一组指令的集合，即指一段静态的代码，静态对象
* <span style="color:red">进程(process)</span>：程序的一次执行过程
  * 每个进程都有一个独立的内存空间，系统运行一个程序既是一个进程从创建、运行到消亡的过程。称为生命周期
  * 程序是静态的，进程是动态的
  * 进程作为操作系统调度和分配资源的最小单位（也是系统运行程序的基本单位），系统在运行时会为每个进程分配不同的内存区域
  * 现代的操作系统，大多支持多进程，支持同时运行多个程序
* <span style="color:red">线程(thread)</span>：进程可进一步细化为线程，是程序内部的一条执行路径，一个进程中至少有一个线程。
  * 一个进程同一个时间内运行多个线程就是支持多线程的
  * 线程是CPU调度和执行的最小单位
  * 一个进程中的多个线程共享相同的内存单元，他们从同一个堆中分配对象，可以访问相同的变量和对象，这就使得线程间通信更简便、高效。但多个线程操作共享的系统资源可能就会带来安全隐患

1. 多线程程序的优点
   1. 提高程序的响应，对图形化界面更有意义，用户体验更好
   2. 提高计算机的CPU利用率
   3. 改善程序结构，将即长又复杂的进程分为多个线程，独立运行，利于理解和修改
2. 并行与并发
   1. 并行(parallel)：指两个或多个事件在同一时刻发生，指在同一时刻，有多条指令在多个CPU上同时执行
   2. 并发：指两个或多个事件在同一个时间段内发生，即在一段时间内，有多条指令在单个CPU上进行快速、交替执行，使得宏观上具有多个进程同时执行的效果

## 2.2 创建和启动线程

### 1. 线程的创建方式：继承Thread类

1. 创建一个Thread类的子类

2. 重写Thread的run方法 将此线程要执行的操作声明在此方法中

3. 创建当前Thread类的子类的对象

4. 通过对象调用start方法 ---> 1. 启动线程。2. 调用当前类的run方法

   ```java
   public class ThreadTest {
       public static void main(String[] args) {
           // 3. 创建Thread的子类的对象
           Thread t = new ThreadSubClass();
           // 4. 通过对象调用start方法
           t.start();
       }
   }
   // 1. 创建Thread的子类
   class ThreadSubClass extends Thread{
       // 2. 重写Thread的run方法
       public void run() {
           for (int i = 1; i <= 100; i++) {
               if(i % 2 == 0){
                   System.out.print(i + "\t");
               }
           }
       }
   }
   ```

   > 不能让已经start()的线程执行多次

### 2. 线程的创建方式：实现Runnable借口

1. 创建一个实现Runnable借口的类

2. 实现借口的run方法 ---> 将此线程要执行的操作，声明在此方法体中

3. 创建当前实现类的对象

4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的实例

5. Thread类的实例调用start()

   ```java
   public class ThreadTest {
       public static void main(String[] args) {
           // 3. 创建当前实现类的对象
           NewClass n = new NewClass();
           // 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的实例
           Thread t = new Thread(n);
           // 5. Thread类的实例调用start()
           t.start();
       }
   }
   
   // 1. 创建一个实现Runnable借口的类
   class NewClass implements Runnable{
       public void run() {
           // 2. 实现借口的run方法 ---> 将此线程要执行的操作，声明在此方法体中
           for (int i = 0; i < 100; i++) {
               if(i % 2 == 0){
                   System.out.println(Thread.currentThread().getName() + ":" + i);
               }
           }
   
       }
   }
   ```

### 3. 两种方式的异同

1. 共同点
   1. 要想启动线程，使用的都是Thread类定义的start()
   2. 创建的对象都是Thread类或其子类的实例
2. 不同点
   1. 一个是类的继承，另一个是接口的实现
   2. Runnable方式的好处：
      1. 避免了类的单继承的局限
      2. 更适合处理有共享数据的问题
      3. 实现了代码和数据的分离
3. 联系：
   1. Thread类本身就实现了Runnable接口

## 2.3 线程的常用结构

### 1. 常用构造器

> public Thread()：分配一个新的线程对象
>
> public Thread(String name)：分配一个指定名字的新的线程对象
>
> public Thread(Runnable target)：指定创建线程的目标对象，他实现了Runnable接口中的run方法
>
> public Thread(Runnable target,String name)：分配一个带有制定目标的新的线程对象并指定名字

### 2. 常用方法

> start()：启动线程 调用线程的run方法
>
> run()：将线程要执行的操作声明在run方法中
>
> currentThread()：获取当前执行代码对应的线程
>
> getName()：获取线程名
>
> setName()：设置线程名
>
> sleep(long millis)：让线程睡一会
>
> yield()：主动释放CPU执行权
>
> join()：在线程A中通过线程B调用join方法，线程A就进入阻塞状态，直到线程B执行结束，再继续执行线程A
>
> isAlive()：判断当前线程是否还存活

### 3. 线程的优先级

getPriority() 获取当前线程的优先级

setPriority() 设置当前线程的优先级 范围[1-10]

## 2.4 线程的安全问题

### 1. java如何解决线程的安全问题

#### 方式一：同步代码块

```java
synchronized(同步监视器){

	// 需要被同步的代码

}
/*
说明：
	需要被同步的代码，即多个线程共享的数据的代码
	共享数据：即多个线程都需要操作的数据
	需要被同步代码，在被synchronized包裹以后，就使得一个线程在操作这些代码的过程中，其他线程必须等待
	同步监视器，俗称锁，那个线程获取了锁，哪个线程就能执行需要同步的代码
	同步监视器：可以使用任何一个类的对象充当。但是，多个线程必须公用同一个同步监视器
*/
```

> 注意：在实现runnable借口的方式中，同步监视器可以使用this
>
> ​	   在继承Thread类的方式中，同步监视器慎用this，可以考虑当前类.class

#### 方式二：同步方法

```java
/*
如果操作共享数据的代码完整的声明在一个方法中，我们可以将此方法声明为同步方法
非静态的同步方法，默认同步监视器是this
静态的同步方法，默认同步监视器是当前类本身 	(见下列代码2)
*/
// 代码1

// 代码2
public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Test();
        t1.start();
        Thread t2 = new Test();
        t2.start();
        Thread t3 = new Test();
        t3.start();
    }
}
class Test extends Thread{
    static int ticket = 100;
    static boolean isContinue = true;
    public void run() {
        while (isContinue) {
            show();
        }
    }
    public synchronized static void show(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "售出，剩余：" + ticket);
            ticket--;
        }else{
            isContinue = false;
        }
    }
}


```

### synchronized利弊

解决了线程安全问题，但是在操作共享数据时，多线程实际上是串行执行的，意味着性能低。

### 2. 课后练习

1. 新年倒计时：模拟新年倒计时，每隔一秒输出一个数字，一次输出10，9，8...1。最后输出新年快乐

   ```java
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
   ```

2. 银行账户，两个储户分别向同一个账户存3000，每次存1000，存三次。每次存完打印账户余额

   ```java
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
   ```


## 2.5 单例模式中懒汉式的线程安全问题

### 1. 懒汉式创建单例模式

```java
// 懒汉式 只有使用时才被初始化 所以有线程安全问题
class Bank {
    // 1. 私有化构造器
    private Bank(){}
    // 2. 声明私有静态变量，存储该类唯一的实例
    private static Bank instance = null;
    // 3. 声明私有的静态方法，提供其他类获取该类唯一实例的方式
    // public static Bank getInstance(){  // 未处理线程安全问题之前
    public static synchronized Bank getInstance(){  // 处理线程安全问题，同步监视器默认为Bank.class
        // 为了出现线程安全问题，添加如下代码
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 4. 懒加载，只有需要当前类的实例的时候再创建实例
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }
}
// 饿汉式 创建时就已经初始化
class Bank1{
    // 1. 私有化构造器
    private Bank1(){}
    // 2. 声明私有静态变量并初始化
    private static final Bank1 bank1 = new Bank1();
    // 3. 声明共有静态方法
    public static Bank1 getBank1(){
        return bank1;
    }
}
```

### 2. 第二种处理方式

```java
class Bank {
    private Bank(){}
    private static Bank instance = null;
    public static Bank getInstance(){
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
            return instance;
        }
    }
}
```

### 3. 第三种处理方式

```java
class Bank {
    private Bank(){}
  	// 为了避免指令重排 添加volatile关键字
    private static volatile Bank instance = null;
    public static Bank getInstance(){
        if(instance == null){		// 这里加一道判断，如果非空，直接取结果
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
```

## 2.6 死锁问题

### 1. 如何看待死锁

不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己所需要的同步资源，就形成了死锁

### 2. 诱发死锁的原因

* 互斥条件
* 占用且等待
* 不可抢夺
* 循环等待

以上四个条件，同时出现就会触发死锁

### 3. 解决死锁

死锁一旦出现，认为很难干预，只能尽量避免，可以考虑打破以上的诱发原因

* 互斥条件基本没办法被打破，因为线程需要通过互斥解决安全问题
* 可以考虑一次性申请所有所需要的资源，这样就不存在等待问题
* 占用部分资源的线程再进一步申请其他资源的时候，如果申请不到，就主动释放已经占用的资源
* 可以讲资源改为线型顺序。申请资源时，先申请序号较小的，这样避免循环等待问题

## 2.7 lock的使用

除了使用synchronize同步机制处理线程安全问题之外，还可以使用JDK5提供的Lock处理

* 步骤
  1. 创建Lock实例，需要确保多个线程共用一个lock实例，需要考虑将此对象声明为static、final
  2. 调用lock方法，锁定对共享资源的调用
  3. 调用unlock方法，释放对共享资源的锁定
* 比较synchronized和lock？
  * synchronized不管是同步代码块还是同步方法都需要在结束一对大括号之后才能释放同步监视器的调用
  * lock是通过两个方法控制需要被同步的代码，更灵活，作为借口提供了多种实现类，适合更多的更复杂的场景

## 2.8 线程间通信

### 1. 线程间通信的理解

当我们需要多个线程来共同完成一件任务，并且我们希望他们有规律的执行，那么多线程之间一定需要一些通信机制，可以协调他们工作，以此实现多线程同步操作一份数据

### 2. 涉及到三个方法的使用

wait()：线程一旦执行此方法，就进入等待状态，同时会释放对同步监视器的调用

notify()：一旦执行此方法，就会唤醒被wait的线程中优先级最高的线程，(如果被wait的多个线程优先级相同，那么就随机唤醒一个)，被唤醒的线程从当初wait的位置继续执行

notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程

### 3. 注意点

此三个方法的使用，必须是在同步代码块或同步方法中。

Lock需要配合Condition实现线程间的通信

此三个方法的调用者，必须是同步监视器，否则会报异常

此三个方法声明在Object类中



### 4. 案例

#### 案例一：使用两个线程打印1-100，线程一、线程二交替打印

```java
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
```



#### 案例二：生产者&消费者

生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品，如果生产者试图生产更多的产品给店员，店员会叫停生产者，如果店中有空位放产品了，在通知生产者继续生产，如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者取走产品

```java
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
```

### 5. wait和sleep的区别

相同点：

* 一旦执行，当前线程都会进入阻塞状态

不同点：

* 声明的位置不同：wait声明在Object中，sleep声明在Thread中的静态方法
* 使用的场景不同：wait只能使用在同步代码块或同步方法中，sleep可以使用在任何需要使用的地方
* 使用在同步代码块或同步方法中：wait一旦执行会释放同步监视器，sleep一旦执行不会释放同步监视器
* 结束阻塞的方式：wait有到达指定之间自动结束阻塞或通过被notify唤醒线程结束阻塞，sleep到达指定时间自动结束阻塞



## 2.9 新增的创建线程的方式

### 1. 创建多线程的方式三：实现Callable(5.0新增)

```java
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        // 3. 创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        // 4. 将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        // 5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread的对象
        Thread t1 = new Thread(futureTask);
        t1.start();

        try{
            // 6. 获取Callable中call方法的返回值
            // get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
// 1. 创建一个实现Callable的类
class NumThread implements Callable {
    // 2. 实现call方法，将此线程需要执行的操作声明在call方法中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

```

与Runnable方式对比的好处

1. call()可以有返回值，更灵活
2. call()可以使用throws的方式处理异常，更灵活
3. Callable使用了范型参数，可以指明具体的call()的返回值类型，更灵活

缺点：如果在主线程中需要获取call方法的返回值，则此时的主线程是阻塞的

### 2. 创建多线程的方式4:线程池

好处：

* 提高程序执行效率，因为线程已经提前创建好了
* 提高了资源的复用率，因为执行完的线程并没有销毁，而是可以继续执行其他任务
* 可以设置相关参数，对线程池中的线程的使用进行管理





# 第三章 常用类和基础API

## 3.1 String 

### 1. String类的理解

#### 1.1 类的声明

```java
public final class String implements java.io.Serializable,Comparable<String>,CharSequence
/*
final: String是不可被继承的
Serializable：可序列化的接口，凡是实现此借口的类的对象就可以通过网络或本地流进行数据传输
Comparable：凡是实现此接口的类的对象都可以比较大小
*/
```

#### 1.2 内部声明的属性

```java
// JDK8
// 存储字符串数据的容器
private final char value[];
/*
final：指明此数组一旦初始化，其地址就不可变。

*/
// JDK9以后，为了节省空间选择使用byte类型的来存储Sting
// 存储字符串数据的容器。
private final byte[] value; 
```

### 2. 字符串常量的存储位置

* 字符串常量都存储在字符串常量池中
* 字符串常量池中不允许存放两个相同的字符串常量
* 字符串常量池中，在不同的jdk版本中，存放的位置不同。JDK7之前存放在方法区中，JDK7之后存放在堆内存中

### 3. String的不可变性

1. 当对字符串变量进行重新赋值时，需要制定一个字符串常量的位置进行赋值，不能在原有的位置修改

   ```java
   String a = "hello";
   String b = "hello";
   b = "hi";
   System.out.println(a); // hello
   ```

2. 当对现有字符串进行拼接时，需要重新开辟空间保存拼接以后的字符串，不能在原有的位置修改

   ```java
   String a = "hello";
   String b = "hello";
   b += "hi";
   System.out.println(a); // hello
   ```

3. 当调用字符串的replace方法替换字符串中的某个字符时，需要重新开辟空间存储修改以后的字符串，不能再原有位置修改

### 4. String实例化的两种方式

```java
String str1 = new String("hello");
String str2 = "hello";
```

### 5. String的连接操作

情况一：常量 + 变量，结果仍然存储在字符传常量池中，此时的常量可能是字面量，也可能是final常量

情况二：常量 + 变量 或 变量 + 变量，结果都会通过new的方式创建新的字符串，返回堆空间中此字符串对象的地址

情况三：调用字符串的intern()，返回的是字符串常量池中字面量的地址

情况四：concat()：不管是常量还是变量调用此方法，同样不管参数是常量还是变量，调用此方法都会返回new的对象

### 6. String的构造器和常用方法

#### 6.1 构造器

```java
public String() ：初始化新创建的String对象，以使其表示空字符序列
public String(String original) ：初始化一个新创建的String对象，使其表示一个与参数相同的字符序列
public String(char value[])：通过当前参数中的字符数组来构造新的String
public String(char value[], int offset, int count)：通过字符数组的一部分来创建新的String
public String(byte bytes[])：使用平台的默认字符集解码当前参数中的字节数组来构建新的String
public String(byte bytes[], String charsetName)：通过使用指定字符集解码当前参数中的字节数组构建新的String
```

#### 6.2 常用方法

```java
常用方法 
// 1. boolean isEmpty() 判断字符串是否为空
System.out.println(str1.isEmpty());
// 2. int length() 返回字符串的长度
System.out.println(str2.length());
// 3. String concat(x) 拼接两个字符串，并返回新的字符串
str1 = str1.concat(str2);
// 4. boolean equals(Object obj) 比较字符串是否相等，区分大小写
System.out.println(str1.equals(str2));
// 5. boolean equalsIgnoreCase(Object obj) 比较字符串是否相等，不区分大小写
System.out.println(str1.equalsIgnoreCase(str2));
// 6. int compareTo(String other) 比较字符串大小，区分大小写，按照unicode编码值比较大小
System.out.println(str1.compareTo(str2));
// 7. int compareToIgnoreCase(String other) 比较字符串大小，不区分大小写
System.out.println(str1.compareToIgnoreCase(str2));
// 8. String toLowerCase() 将字符串中大写字母转为小写
System.out.println(str2.toLowerCase());
// 9. String toUpperCase() 将字符串中小写字母转为大写
System.out.println(str1.toUpperCase());
// 10. String trim() 去掉字符串前后空符
System.out.println(str2.trim());
// 11. public String intern() 结果在常量池中共享
str1.intern();

搜索方法
// 1. boolean contains(x) 是否包含x
System.out.println(str2.contains("he"));
// 2. int indexOf(xx) 从前往后查找当前字符串中的xx，如果有就返回第一次出现的下标，没有就返回-1
System.out.println(str2.indexOf("a"));
// 3. int indexOf(String str,int fromIndex) 返回指定字符串在此字符串中第一次出现的下标，从指定索引开始
System.out.println(str2.indexOf("he",1));
// 4. int lastIndexOf(xx) 从后往前查找当前字符串中的xx，如果有就返回最后一次出现的下标，没有就返回-1
System.out.println(str2.lastIndexOf("Wo"));
// 5. int lastIndexOf(String str,int fromIndex) 返回指定字符串在此字符串最后一次出现处的索引，从指定的索引开始从后往前搜索
System.out.println(str2.lastIndexOf("wo",2));

截取方法
// 1. String subString(int beginIndex) 返回一个新的字符串，他是当前字符串从beginIndex开始截取到字符串最后
System.out.println(str2.substring(2));
// 2. String subString(int beginIndex,int endIndex) 返回一个新的字符串，他是当前字符串从beginIndex截取到endIndex
System.out.println(str2.substring(2,4));

开头和结尾
// 1. char charAt(index) 返回index位置的字符
System.out.println(str2.charAt(2));
// 2. char[] toCharArray()  将此字符串作为一个新的字符数组返回
char[] a = str1.toCharArray();
// 3. static String valueOf(char[] data) 返回指定数组中表示该字符序列的String
System.out.println(String.valueOf(new char[]{'a','b','c','d','e'}));
// 4. static String valueOf(char[] data,int offset,int count) 返回指定数组中表示该字符序列的String，从offset开始，留count位
System.out.println(String.valueOf(new char[]{'a','b','c','d','e'},2,2));
// 5. static String copyValueOf(char[] data) 返回指定数组中表示该字符序列的String
System.out.println(String.copyValueOf(new char[]{'a','b','c','d','e'}));
// 6. static String copyValueOf(char[] data,int offset,int count) 返回指定数组中表示该字符序列的String，从offset开始，留count位
System.out.println(String.valueOf(new char[]{'a','b','c','d','e'},2,2));
// 7. boolean startsWith(xx) 测试字符串是否以指定的前缀开始
System.out.println(str2.startsWith("he"));
// 8. boolean startsWith(String prefix,int offset) 测试此字符串从指定索引开始的子字符串是否以prefix为前缀开始
System.out.println(str2.startsWith("he", 3));
// 9. boolean endsWith(xx) 测试此字符串是否以指定后缀结束
System.out.println(str2.endsWith("he"));

替换
// 1. String repalce(char oldChar,char newChar) 返回一个新的字符串，他是通过newChar替换的
System.out.println(str2.replace('l','o'));
// 2. String repalce(CharSequence target,CharSequence repalcement) 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
System.out.println(str2.replace("hello", str1));
// 3. String repalceAll(String regex,String replacement) 使用给定的replacement替换所有匹配给定的正则表达式的子字符串
System.out.println(str2.replaceAll("[^a-zA-Z]", str1));
// 4. String replaceFirst(String regex,String replacement) 使用给定的replacement替换第一个匹配给定的正则表达式的子字符串
System.out.println(str2.replaceFirst("[^a-zA-Z]", str1));
```

##### 练习：手写reverse

```java
// 手写reverse
public static String reverse(String str,int beginIndex,int endIndex){
    char[] chars = str.toCharArray();
    char[] chars1 = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
        if(i >= beginIndex && i < endIndex){
            chars1[i] = chars[chars.length - 1 - i];
        }else{
            chars1[i] = chars[i];
        }
    }
    return String.copyValueOf(chars1);
}
// 手写trim
public static String myTrim(String str){
    if (str == null) {
        return null;
    }
    int start = 0;
    int end = str.length() - 1;
    // 移除开头的空白字符
    while (start <= end && Character.isWhitespace(str.charAt(start))) {
        start++;
    }
    // 移除结尾的空白字符
    while (end >= start && Character.isWhitespace(str.charAt(end))) {
        end--;
    }
    // 如果整个字符串都是空白字符，则返回空字符串
    if (start > end) {
        return "";
    }
    // 截取非空白字符部分
    return str.substring(start, end + 1);
}
```



## 3.2 StringMore

### 1. 三个类的对比：String、StringBuffer、StringBuilder

String:不可变字符序列，底层使用char型数组(JDK8及之前)，底层使用byte数组(JDK9及以后)

StringBuffer:可变字符序列 JDK1.0声明，线程安全的，效率低，底层使用char型数组(JDK8及之前)，底层使用byte数组(JDK9及以后)

StringBuilder:可变字符序列 JDK5.0声明，线程不安全，效率高，底层使用char型数组(JDK8及之前)，底层使用byte数组(JDK9及以后)

### 2. 源码启示

如果开发中需要频繁的针对于字符串进行增删改等操作，建议使用StringBuffer和StringBuilder替换String，使用String效率较低

如果开发中不涉及到线程安全问题，建议选择StringBuilder来替换StringBuffer

如果开发中大概确定要操作的字符的个数，建议使用`StringBuffer(int capacity)`构造器，避免多次扩容效率较低

### 3. StringBuffer和StringBuilder的常用方法

```java
修改原字符串
// 1. StringBuffer append(x) 使用追加的方式进行添加字符串
System.out.println(str.append("abc")); // abcabc
// 2. StringBuffer delete(int start,int end) 删除[start,end)之间的字符串
System.out.println(str.delete(1, 3)); // aabc
// 3. StringBuffer deleteCharAt(int index) 删除index位置的字符
System.out.println(str.deleteCharAt(2)); // aac
// 4. StringBuffer replace(int start,int end,String str) 替换[start,end)范围内的字符序列为str
System.out.println(str.replace(1, 2, "abcdefg")); // aabcdefgc
// 5. void setCharAt(int index,char c) 替换index位置的字符
str.setCharAt(0,'u'); // uabcdefgc
// 6. char charAt(int index) 查找指定index位置的字符
System.out.println(str.charAt(0)); // u
// 7. StringBuffer insert(int index,xx) 在index位置插入xx
System.out.println(str.insert(0, "HankMiller")); // HankMilleruabcdefgc
// 8. int lenght() 返回当前字符串的长度
System.out.println(str.length()); // 19
// 9. StringBuffer reverse() 反转字符串
System.out.println(str.reverse()); // cgfedcbaurelliMknaH

不修改原字符串
// 1. int indexOf(String str) 在当前字符序列中查询str第一次出现的标
System.out.println(str.indexOf("a")); // 0
// 2. int indexOf(String str,int fromIndex) 在当前字符序列[fromIndex,最后]中查寻str第一次出现的下标
System.out.println(str.indexOf("b",1)); // 0
// 3. int lastIndexOf(String str) 在当前字符串中查找str最后一次出现的下标
System.out.println(str.lastIndexOf("c")); // 2
// 4. int lastIndexOf(String str,int fromIndex) 在当前字符序列[fromIndex,最后]中查询str最后一次出现的位置
System.out.println(str.lastIndexOf("c",1)); // 2
// 5. String substring(int start) 截取当前字符序列的[start,最后]的字符序列
System.out.println(str.substring(1)); // bc
// 6. String subtring(int start,int end) 截取当前字符序列[start,end]
System.out.println(str.substring(0, 1)); // ab
// 7. String toString() 返回此字符串中数据的字符串表现形式
System.out.println(str.toString());// abc
// 8. void setLength(int newLength) 设置当前字符序列长度为newLength
str.setLength(10);
System.out.println(str.length()); // 10
```

## 3.2 Date日期

### 1. JDK8之前的日期API

```java
System.currentTimeMillis(); // 获取当前时间戳，常用来计算时间差
/*
* Date类
*   java.util.Date
*       两个构造器 -> 空参(创建一个基于当前系统时间的Date的实例) 和 时间戳为参数(创建一个基于指定时间戳的Date对象)
*       两个方法 -> getTimes() 获取当前对应时间的毫秒数 toString() 获取完整格式的时间
*   java.sql.Date extends java.util.Date  对应着数据库中的Date类型
*       java.sql.Data(时间戳)
*
*
* */
Date d = new Date(); // 创建一个基于当前系统时间的Date的实例
long milliTimes = d.getTime();
System.out.println(milliTimes); // d对应的毫秒数
Date e = new Date(milliTimes); // 创建一个基于指定时间戳的Date对象

java.sql.Date d1 = new java.sql.Date(milliTimes);
System.out.println(d1.getTime());

/*
* SimpleDateFormat类，用于日期时间的格式化和解析
*
* */
// 格式化 ： 日期 ---> 字符串
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat();
System.out.println(sdf.format(date));
// 解析： 字符串 ---> 日期
try {
    Date date1 =sdf.parse("22-04-15 下午3:21");
    System.out.println(date1);
} catch (ParseException e) {
    throw new RuntimeException(e);
}

// 格式化：日期 ---> 字符串
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MM dd HH:mm:ss Z");
Date date2 = new Date();
String stringDate = sdf1.format(date2);
System.out.println(stringDate);
// 解析：字符串 ---> 日期 当前sdf接受的格式是yyyy MM dd HH:mm:ss Z
try {
    Date date3 = sdf1.parse("12 09 29 18:12:12 +0800");
    System.out.println(date3);
} catch (ParseException e) {
    throw new RuntimeException(e);
}

// Calendar 日历
/*
* Calendar 抽象类
* 1. 实例化 由于Calendar是一个抽象类 所以需要创建其子类的实例，这里我们通过Calendar
*    的静态方法
* 2. 常用方法：
*   get(int field) / set(intfield,xx) / add(int field,xx) / getTime() / setTime()
* */
Calendar calendar = Calendar.getInstance();
Calendar calendar1 = new GregorianCalendar();
Calendar calendar2 = new BuddhistCalendar();
// get(int field)
System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));
System.out.println(calendar2.get(Calendar.DATE));
// set(int field ,xx) 将field的数据改为xx
calendar1.set(Calendar.DAY_OF_MONTH,12);
System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
// add(int field,xx) 在field的基础上加xx
calendar2.set(Calendar.DAY_OF_MONTH,20);
System.out.println(calendar2.get(Calendar.DAY_OF_MONTH));
// getTime()
Date date = calendar1.getTime();
System.out.println(date);
// setTime(Date date) 使用指定的date重置calendar
calendar2.setTime(date);
System.out.println(calendar2.get(Calendar.DAY_OF_MONTH));
```

### 2. JDK8之后的日期API

#### 2.1 LocalDate LocalTime LocalDateTime 

类似于Calendar类 有两种实例化的方法，now() of()

```java
// LocalDate
// LocalTime
// LocalDateTime

// now() 静态方法，根据当前时间创建对象或指定时区的对象
LocalDate d1 = LocalDate.now();
LocalTime d2 = LocalTime.now();
LocalDateTime d3 = LocalDateTime.now();
// of(xx,xx,xx,xx,xxx) 静态方法，根据指定日期或时间创建对象
LocalDate d4 = LocalDate.of(2024,12,12);
LocalTime d5 = LocalTime.of(12,12,12);
LocalDateTime d6 = LocalDateTime.of(2012,12,12,0,0,0);
// getXxx()
System.out.println(d1.getDayOfMonth()); // 19
System.out.println(d1.getDayOfWeek());  // Friday
System.out.println(d1.getDayOfYear());  // 110
System.out.println(d1.getMonth());  // APRIL
System.out.println(d1.getYear());   // 2024
// withXxx() 体现不可变性
System.out.println(d1.withYear(2021));
System.out.println(d1.withMonth(12));
System.out.println(d1.withDayOfMonth(14));
System.out.println(d1.withDayOfYear(120));
// plusXxx()
System.out.println(d1.plusDays(12));
System.out.println(d1.plusMonths(12));
System.out.println(d1.plusYears(12));
System.out.println(d1.plusWeeks(1));
// minXx()
System.out.println(d1.minusDays(10));
System.out.println(d1.minusYears(10));
System.out.println(d1.minusMonths(10));
System.out.println(d1.minusWeeks(10));
```

#### 2.2 Instant 

时间线上的一个瞬时点，可以被用来记录程序中事件的时间戳

| 方法                          | 描述                                                         |
| ----------------------------- | ------------------------------------------------------------ |
| now()                         | 静态方法，返回一个Instant类的对象                            |
| ofEpochMilli(long epochMilli) | 静态方法，返回在1970-01-01 0.0.0的基础上加上指定毫秒数的Instant实例 |
| atOffset(ZoneOffset offset)   | 结合即时的偏移来创建一个OffsetDateTime                       |
| toEpochMilli()                | 返回1970-01-01 0.0.0 到当前时间的毫秒数，即时间戳            |

```java
Instant i1 = Instant.now();
System.out.println(i1.toEpochMilli());
Date d = new Date();
System.out.println(Instant.ofEpochMilli(d.getTime())); // 得到结果的时间是格林威治时间
i1.atOffset(ZoneOffset.ofHours(8)); // 调整回东八区时间
```



#### 2.3 DateTimeFormatter 

用来格式化LocalDate LocalTime LocalDateTime 格式hide时间

提供三种格式化方法：

* (了解)预定义的标准格式：ISO_LOCAL_DATE_TIME、ISO_LOCAL_DATE、ISO_LOCAL_TIME

* (了解)本地化相关的格式：ofLocallizedDate(FormatStyle.LONG)

  ```java
  // 本地化相关的格式：ofLocallizedDateTime()
  // FormatStyle.MEDIUM / FormatStyle.SHORT 适用于LocalDateTime
  
  // 本地化相关的格式：ofLocalizedDate()
  // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT 适用于LocalDate
  ```

* 自定义格式：ofPattern("yyyy-MM-dd hh:mm:ss")

| 方法                       | 描述                                                    |
| -------------------------- | ------------------------------------------------------- |
| ofPattern(String pattern)  | 静态方法，用于返回一个指定字符串格式的DateTimeFormatter |
| format(TemporalAccessor t) | 格式化一个日期、时间。返回字符串                        |
| parse(CharSequence text)   | 将指定格式的字符串序列解析为一个日期、时间              |

```java
// 自定义格式
DateTimeFormatter d =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
// 格式化： 日期、时间 --> 字符串
LocalDate date = LocalDate.now();
d.format(date);
System.out.println(date);

// 格式化： 字符串 --> 日期、时间
TemporalAccessor newDate = d.parse("2023-09-20");
// 将TemporalAccessor的时间转换为LocalDate类型的时间
LocalDate from = LocalDate.from(newDate);
System.out.println(from);
```

### 3. 与传统日期处理的转换

| 类                                                         | To 遗留类                            | From 遗留类                 |
| ---------------------------------------------------------- | ------------------------------------ | --------------------------- |
| java.time.Instant & java.util.Date                         | Date.from(instant)                   | date.toInstant()            |
| java.time.Instant & java.sql.Timestamp                     | Timestamp.from(instant)              | timestamp.toInstant()       |
| java.time.ZonedDateTime & java.util.GregorianCalendar      | GregorianCalendar.from(zoneDateTime) | cal.toZonedDateTime()       |
| java.time.LocalDate & java.sql.Time                        | Date.valueOf(localDate)              | date.toLocalDate()          |
| java.time.LocalTime & java.sql.Time                        | Date.valueOf(localDate)              | date.toLocalTime()          |
| java.time.LocalDateTime & java.sql.Timestamp               | Timestamp.valueOf(localDateTime)     | timestamp.toLocalDateTime() |
| java.time.Zone & java.util.TimeZone                        | Timezone.getTimeZone(id)             | timeZone.toZoneId()         |
| java.time.format.DtaeTimeFormatter & java.text.Date.Format | formatter.toFormat()                 | null                        |

## 3.3 Compare

实现对象的排序可以考虑两种方法：自然排序和定制排序

### 1. 方式一：

实现Comparable接口的方式

实现步骤：

1. 具体的类实现Comparable接口
2. 重写Comparable中的compareTo方法，在此方法中指明比较两个对象大小的标准
3. 使用此方法可以进行排序

```java
public class ComparableTest {
    public static void main(String[] args) {
        String[] strs = new String[]{"Hank","Jack","Lili","Lucy"};
        Product p1 = new Product("炼狱狂蛇",799);
        Product p2 = new Product("北海巨妖",399);
        Product p3 = new Product("黑曼巴",299);
        Product p4 = new Product("proclick",1299);
        Product[] products = new Product[]{p1,p2,p3,p4};
        Arrays.sort(products);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
// 商品类
class Product implements Comparable{
    private String name;
    private int price;
    public Product() {
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    /*
    * 当前类需要实现Comparable中的抽象方法
    * 在此方法中指明如何判断当前累的对象的大小
    * */
    @Override
    public int compareTo(Object o) {
        if(o == this){
            return 0;
        }
        if(o instanceof Product){
            Product p = (Product)o;
            return Integer.compare(this.price,p.price);
        }
        throw new RuntimeException("数据不匹配");
    }
}
```

### 2. 方式二：

实现Comparator的方式

步骤：

* 创建一个实现了Comparator接口的实现类A
* 实现类A要求重写Comparator接口中的抽象方法compare(Object o1,Object o2),在此方法中指明要比较大小的对象的大小关系
* 创建此实现类A的对象，并将此对象传入到相关方法的参数位置即可

```java
public class ComparatorTest {
    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Product("iphone15ProMax",9999);
        products[1] = new Product("HuaWeiMate60Pro",8999);
        products[2] = new Product("XiaoMi21Pro",6999);
        products[3] = new Product("Samsung",7999);
        // 创建一个实现了Comparator接口的实现类的对象
        Comparator comparator = new Comparator() {
            // 如何判断两个对象的大小，其标准就是此方法的方法体要编辑的逻辑
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Product && o2 instanceof Product){
                    Product c1 = (Product) o1;
                    Product c2 = (Product) o2;
                    return Integer.compare(c1.getPrice(),c2.getPrice());
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        Arrays.sort(products,comparator);
        for (Product product : products){
            System.out.println(product);
        }
    }
}
```

### 3. 对比

角度一：

自然排序：单一的唯一的

定制排序：灵活的多样的

角度二：

自然排序：一劳永逸的

定制排序：临时的

角度三：

自然排序：Comparable 重写compareTo

定制排序：Comparator 对应的抽象方法是compare(Object o1 , Object o2);

## 3.4 Other

### 1. System

* 成员变量：`Scanner scanner = new Scanner(System.in);`

  * System类包括三个成员变量：in，out，err，分别代表标准输入流，标准输出流，标准错误输出流

* 成员方法：

  * <span style="color:orange">`native long currentTimeMillis()`</span>

    该方法的作用是返回当前计算机的时间，时间的表达格式是当前计算机的时间和格林威治时间所差的毫秒数

  * <span style="color:orange">`void exit(int status)`</span>

    该方法的作用是退出程序，其中status的值为0代表正常退出，非零代表异常退出，在图形化界面编程中实现程序的退出功能

  * <span style="color:orange">`void gc()`</span>

    该方法的作用是请求系统进行垃圾回收，至于系统是否立即回收，则取决于系统中垃圾回收算法的实现以及系统执行时的情况

  * <span style="color:orange">`String getProperty(String key)`</span>

    该方法的作用是获得系统中属姓名为key的属性对应的值，系统中常见的属性名和属性的作用如下表

    | 属性名       | 属性说明           |
    | ------------ | ------------------ |
    | java.version | Java运行时环境版本 |
    | java.home    | java安装目录       |
    | os.name      | 操作系统的名称     |
    | os.version   | 操作系统的版本     |
    | user.name    | 用户的账户名称     |
    | user.home    | 用户的主目录       |
    | user.dir     | 用户的当前工作目录 |

  * <span style="color:orange">`static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)`</span>

    从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束，常用于数组的插入和删除

### 2. Runtime

每个java程序都有一个Runtime类实例，使应用程序能够与其运行的环境相连接

* <span style="color:orange">`public static Runtime getRuntime()`</span>：返回与当前java程序相关的运行时对象，应用程序不能创建自己的Runtime类实例
* <span style="color:orange">`public long totalMemory()`</span>：返回java虚拟机中初始化时的内存总量，此方法返回的值可能随时间的推移而变化，这取决于主机环境，默认为物理电脑内存的1/64
* <span style="color:orange">`public long maxMemory()`</span>：返回java虚拟机中最大程度能使用的内存总量，默认为物理电脑内存的1/4
* <span style="color:orange">public long freeMemory()</span>：返回java虚拟机中的空闲内存量，调用gc方法可能导致freeMemory返回值的增加

### 3. Math类

包含基本的数学运算的方法，如初等指数、对数、平方根和三角函数，类似这样的工具类，所有的方法均为静态方法，并且不会创建对象，调用起来非常简单

* `public static double abs(double a)`：返回double值的绝对值
* `public static double ceil(double a)`：返回大于等于参数的最小整数
* `public static double floor(double a)`：返回小于等于参数的最大整数
* `public static long round(double a)`： 返回最接近参数的long(相当于四舍五入) 技巧，将参数+0.5 然后向下取整
* `public static double pow(double a,double b)`：返回a的b次方
* `public static double sqrt(double a)`： 返回a的平方根
* `public static double random()`： 返回(0,1)之间的随机数
* `public static final double PI`： 返回圆周率
* `public static double max(double x,double y)`： 返回x，y的最大值
* `public static double min(double x,double y)`： 返回x，y的最小值
* `acos,asin,atan,cos,sin,tan`：三角函数

### 4. BigInteger

构造器：`BigInteger(String value)`：根据字符串创建BigInteger对象

方法：

* `public BigInteger abs()`返回此BigInteger的绝对值的BigInteger
* `BigInteger add(BigInteger value)`返回值为(this + value)的BigInteger
* `BigInteger subStract(BigInteger value)`返回值为(this - value)的BigInteger
* `BigInteger multiply(BigInteger value)`返回值为(this * value)的BigInteger
* `BigInteger divide(BigInteger value)`返回值为(this / value)的BigInteger
* `BigInteger remainder(BigInteger value)`返回值为(this % value)的BigInteger
* `BigInteger[] divideAndRemainder(BigInteger value)`返回此(this / value) 和 (this % value)的两个BigInteger的数组
* `BigInteger pow(int exponent)`返回值为(this ^ exponent)的BigInteger

### 5. BigDecimal

构造器：

public BigDecimal(double value)

public BigDecimal(String vlaue) ---> 推荐

常用方法：

* `public BigDecimal add(BigDecimal augend)`
* `public BigDecimal subStract(BigDecimal subtrahend)`
* `public BigDecimal multiply(BigDecimal multiplicand)`
* `public BigDecimal divide(BigDecimal divisor,int scale,int roundingMode)`：divisor是除数，scale指明保留几位小数，roundingMode指明舍入模式(ROUND_UP向上加一,ROUND_DOWN直接舍去 ROUND_HALF_UP四舍五入)

### 6. Random

用于产生随机数：

* `boolean nextBoolean()`返回下一个伪随机数，他是取自此随机数生成器序列的均匀分布的boolean值
* `void nextBytes(byte[] bytes)`：生成随机字节并将其置于用户提供的byte数组中
* `double nextDouble()`返回下一个伪随机数，他是取自此随机数生成器序列的，在0.0 - 1.0 之间均匀分布的double值
* `float nextFloat()`返回下一个伪随机数，他是取自此随机数生成器序列的，在0.0 - 1.0 之间均匀分布的float值
* `double nextGaussian()`：返回下一个伪随机数，他是取自此随机数生成器序列的，呈高斯分布的double值，平均值是0.0，标准差是1.0
* `int nextInt()`：返回下一个伪随机数，他是此随机数生成器序列中平均分布的int值
* `int nextInt(int n)` ：返回下一个伪随机数，他是取自此随机数生成器序列的，在[0,n)之间均匀分布的int值
* `long nextLong()`：返回下一个伪随机数，他是取自此随机数生成序列的均匀分布的long值



# 第四章 集合框架

## 4.1 数组的优缺点

### 特点：

数组一旦初始化，长度就是确定的

数组中的多个元素是依次紧密排列的，有序的可重复的

(优点)数组一旦初始化完成，其元素的类型就是确定的，不是此类型的元素，就不能添加到此数组中

(优点)元素的类型既可以是基本数据类型，也可以是引用数据类型

### 弊端：

数组一旦初始化，长度就不可变了

数组中存储数据特点的单一性，对于无序的不可重复的场景的多个数据就无能为力了

数组中可用的方法、属性都极少，具体的需求需要自己组织代码逻辑

针对于数组元素的插入删除操作，性能较差

## 4.2 java的集合框架体系

java.util.Collection:存储一个一个的数据

​	|-----子接口：list：存储有序的、可重复的数据("动态"数组)

​		|-----ArrayList(主要实现类) 、LinkedList、Vector

​	|----- 子接口：Set：存储无序的、不可重复的数据(数学中的集合)

​		|-----HashSet(主要实现类)、LinkedHashSet、TreeSet

java.util._05_Map:存储一对一对的数据(key-value键值对，类似于数学中的映射)

​		|-----HashMap(主要实现类)、LinkedMap、TreeMap、Hashtable、Properties

## 4.3 Collection的常用方法

| 返回值类型    | 方法名                              | 描述                                                         |
| ------------- | ----------------------------------- | ------------------------------------------------------------ |
| `boolean`     | `add(E e)`                          | 确保此集合包含指定的元素（可选操作）。                       |
| `boolean`     | `addAll(Collection<? extends E> c)` | 将指定集合中的所有元素添加到此集合中（可选操作）。           |
| `void`        | `clear()`                           | 从此集合中删除所有元素（可选操作）。                         |
| `boolean`     | `contains(Object o)`                | 如果此集合包含指定的元素，则返回 true。                      |
| `boolean`     | `containsAll(Collection<?> c)`      | 如果此集合包含指定集合中的所有元素，则返回 true。            |
| `boolean`     | `equals(Object o)`                  | 将指定对象与此集合进行比较以测试相等性。                     |
| `int`         | `hashCode()`                        | 返回此集合的哈希码值。                                       |
| `boolean`     | `isEmpty()`                         | 如果此集合不包含任何元素，则返回 true。                      |
| `Iterator<E>` | `iterator()`                        | 返回此集合中的元素上的迭代器。                               |
| `boolean`     | `remove(Object o)`                  | 从此集合中删除指定元素的单个实例（如果存在）（可选操作）。   |
| `boolean`     | `removeAll(Collection<?> c)`        | 删除此集合中也包含在指定集合中的所有元素（可选操作）。       |
| `boolean`     | `retainAll(Collection<?> c)`        | 仅保留此集合中包含在指定集合中的元素（可选操作）。           |
| `int`         | `size()`                            | 返回此集合中的元素数。                                       |
| `Object[]`    | `toArray()`                         | 返回包含此集合中所有元素的数组。                             |
| `<T> T[]`     | `toArray(T[] a)`                    | 返回一个包含此集合中所有元素的数组；返回数组的运行时类型是指定数组的类型。 |

### 1. 集合和数组间的转换

集合 ---> 数组

调用Collection实例的toArray方法

数组 ---> 集合

调用Arrays的asList方法

### 2. 向Collection中添加元素的要求

要求元素所属的类一定要重写equals()

原因是因为Collection中的相关方法(contains() / remove())会调用元素所在类的equals方法

## 4.4 迭代器

### 1. 迭代器(Iterator)的作用

用来遍历集合中的元素

### 2. 如何获取迭代器(Iterator)对象

`iterator.next()`获取迭代器对象

### 3. 如何实现遍历

```java
while(iterator.hasNext()){
    System.out.println(iterator.next()); // next() 指针下移，将下移位置的元素返回
}
```

### 4. 增强for循环(foreach)的使用

#### 1. 作用

用来遍历数组、集合

#### 2. 格式

```java
for(要遍历的数组或集合的类型 变量名 ： 要遍历的集合或数组的变量){
  变量.操作。。。。。。
}
```

#### 3. 说明

针对于集合来讲，增强for循环底层依然使用的是迭代器

增强for循环是将集合或数组中的元素依次赋值给临时变量，循环体中对临时变量的修改可能不会导致原有的数据的修改



## 4.5 List

### 1. List接口中存储数据的特点：

用于存储有序的可重复的数据 --> 使用List代替数组，"动态"数组

### 2. List中的常用方法

Collection中15个方法

因为List是有序的，进而就会有索引，进而就会有针对于索引的操作的方法

> 插入元素
> 	void add(int index ,Object ele) 在index的位置插入ele
> 	boolean addAll(int index,Collection eles) 从index的位置开始将eles中的所有元素添加进来
>
> 获取元素
> 	Object get(int index) 获取index位置的元素
> 	List subList(int fromIndex,int toIndex) 返回从fromIndex到toIndex位置的子集合
>
> 获取元素索引
> 	int indexOf(Object obj) 返回obj在指定集合中首次出现的位置、
> 	int lastIndexOf(Object obj) 返回obj在当前集合中最后一次出现的位置
>
> 删除和替换元素
> 	Object remove(int index) 移除指定index位置的元素，并返回此元素
> 	Object set(int index,Object ele) 设置置顶index位置的元素为ele

小结：

> 增
> 	add(Object obj)
> 	addAll(Collection collection)
>
> 删
> 	remove(Object obj)
> 	remove(int index)
>
> 改
> 	set(int index,Object obj)
>
> 查
> 	get(int index)
>
> 插
> 	add(int index,Object ele)
> 	addAll(int index,Collection collection)
>
> 长度
> 	size()
>
> 遍历
> 	iterator()
> 	for()
> 	fori()

### 3. List及其实现类的特点

> java.util.Collection:存储一个一个的数据
> |-----子接口：list：存储有序的、可重复的数据("动态"数组)
> 	|-----ArrayList：主要实现类 线程不安全的，效率较高，底层使用的Object[]数组存储，在添加和查找数据时效率较高，插入				和删除数据时效率较低
> 	|-----LinkedList：底层使用双向链表的方式进行存储，在插入和删除数据时效率较高，添加和查找数据时效率较低。在对集				合中的数据进行频发的插入和删除时建议使用LinkedList类
> 	|-----Vector：List的古老的实现类，线程安全的，效率较低，底层使用的Object[]数组存储



## 4.6 Set

> java.util.Collection:存储一个一个的数据
> |----- 子接口：Set：存储无序的、不可重复的数据(数学中的集合)
> 	|-----HashSet(主要实现类)：底层使用的是HashMap，即使用数组+单向链表+红黑树结构进行存储(JDK8当中)。
> 		|-----LinkedHashSet：是HashSet的子类；在现有的数组+单向链表+红黑树的基础上，又添加了一组双向链表，用于						    记录添加元素的先后顺序，即我们可以按照添加元素的顺序实现遍历。便于频繁的查询操作。	|-----TreeSet：底层使用红黑树存储，可以按照添加的元素的指定的属性的大小顺序进行遍历。

set中的常用方法即为Collection中的十五个方法，没有新增方法

### 1. 开发中的使用

相较于List和Map来说，Set使用的较少

用来过滤重复数据。

### 2. Set中的无序性、不可重复性的理解

> 无序性：不等于随机性。也不是指添加和遍历的顺序不一致。<span style="color:orange">与添加元素的位置有关，不像ArrayLisy一样是依次紧密排列的。这里是根据添加的元素的哈希值计算的其在数组中的存储位置，此位置不是依次排列的，表现为无序性</span>

> 不可重复性：添加到Set中的元素不能相同，<span style="color:orange">比较的标准需要判断hashCode()得到的哈希值与equals()得到的boolean结果</span>，hash值相同且equals方法返回true，则认为元素是相同的

### 3. 添加到HashSet/LinkedHashSet中元素的要求

要求元素所在的类要重写equals和hashCode两个方法，同时要求equals和hashCode要保持一致性，我们只需要自动生成两个方法的重写即可，即能保证两个方法的重复性

### 4. TreeSet的使用

1. 底层数据结构是红黑树

2. 添加数据后的特点，可以按照添加元素的指定的属性的大小顺序进行遍历

3. 向TreeSet中添加元素的要求

   > 要求添加到TreeSet中的元素必须是同一类型的元素，否则会报错(ClassCastException)
   >
   > 添加的元素需要考虑排序：定制排序和自然排序

4. 判断数据是否相同的标准

   > 不再考虑equals和hashCode方法，也就意味添加到treeSet中的元素，所在的类不需要重写这两个方法
   >
   > 比较元素大小的或比较元素是否相等的标准就是考虑自然排序或定制排序中compareTo或compare的返回值，如果这两个方法的返回值为0，则认为两个对象是相等的，由于treeSet中不能存放相同的元素，则后续的对象不再存储在TreeSet中

## 4.7 Map

java.util._05_Map:存储一对一对的数据(key-value键值对，类似于数学中的映射)
	|-----HashMap：主要实现类，线程不安全的，执行效率高，可以添加null的key或value值，底层使用数组+单向链表+红黑树结构存				   储(JDK8)
		|-----LinkedMap：是HashMap的子类，在HashMap使用的基础上，增加了一对双向链表，用于记录添加元素的相关顺序，进而					     在遍历元素时，就可以按照添加顺序显示。<span style="color:orange">开发中对于频繁的遍历操作建议使用此类</span>
	|-----TreeMap：使用红黑树存储，可以按照添加的key-value中的key元素的指定的属性的大小顺序进行遍历，需要考虑自然排序和定				 制排序
		|-----Propertie：其key和value都是String类型，常用来处理属性文件。
	|-----Hashtable：古老实现类，线程安全的，执行效率低，不可以添加null的key或value值，底层使用数组+单向链表结构存储(JDK8)

### 1. HashMap中的元素的特点

> HashMap中的所有的key之间是不可重复的，无序的，所以所有的key就构成一个Set集合 -- > key所在的类要重写hashCode和equals方法
>
> HashMap中所有的value彼此之间是可重复的无序的，所有的value之间就构成一个Collection集合 ---> value所在的类要重写equals方法
>
> HashMap中所有的key-value就构成了一个entry。所有的entry之间是不可重复的、无序的，所有的entry就构成了一个Set集合

### 2. Map中的常用方法

> 添加修改操作
> 	Object put(Object key ,Object value) 将指定key-value添加或修改到当前Map对象中
> 	void putAll(_05_Map m) 将m中所有的key-value存放到当前map中
>
> 删除操作
> 	Object remove(Object key)：移除指定key的key-value值，并返回value
> 	void clear()：清空当前map中的所有数据
>
> 元素查询操作
> 	Object get(Object key)：获取指定key对应的value
> 	boolean containsKey(Object key)：是否包含指定的key
> 	boolean containsValue(Object value)：是否包含指定的value
> 	int size()：返回map中key-value的对数
> 	boolean isEmpty()：判断当前map是否为空
> 	boolean equals(Object obj)：判断当前map和参数对象obj是否相等
>
> 元视图操作方法
> 	Set keySet()：返回所有的key构成的Set集合
> 	Collection values()：返回所有value构成的Collection集合
> 	Set entrySet()：返回所有key-value对构成的Set集合

> <span style="color:orange">小结</span>：
>
> <span style="color:orange">增</span>：
>
> ​	put(Object key ,Object value)
>
> <span style="color:orange">删</span>：
>
> ​	remove(Object key)
>
> <span style="color:orange">改</span>：
>
> ​	put(Object key ,Object value) 
>
> <span style="color:orange">查</span>：
>
> ​	get(Object key)
>
> <span style="color:orange">长度</span>：
>
> ​	size()
>
> <span style="color:orange">遍历</span>：
>
> ​	keySet()
>
> ​	values()
>
> ​	entrySet()

### 3. TreeMap的使用

> 使用红黑树存储
> 可以按照添加的key-value中的key元素的指定的属性的大小顺序进行遍历
> 需要考虑自然排序和定制排序
> 要求：向TreeMap中添加的key必须是同一个类型的对象

### 4. Hashtable和Properties的使用

Properties:是Hashtable的子类，其key和value都是String类型的，常用来处理属性文件

```html
<span style="color:orange"></span>
<span style="color:red">小结</span>
<span style="color:green"></span>
```

## 4.8 Collections

### 1. 常用方法

> 排序操作
> reverse(List)反转List中的元素
> shuffle(List)对List集合元素进行随机排序
> sort(List)根据元素的自然顺序对指定List集合元素按生序排列
> sort(List,Comparator)根据指定的Comparator产生的顺序对List集合元素进行排序
> swap(List,int,int)将指定List集合中的i处元素和j处元素进行互换
>
> 查找：
> Object max(Collection)根据元素的自然排序，返回给定集合中的最大元素
> Object max(Collection,Comparator)根据Comparator指定的顺序，返回给定集合中的最大元素
> Object min(Collection)根据元素的自然排序，返回给定集合中最小的元素
> Object min(Collection,Comparator)根据comparator指定的顺序，返回给定集合中的最小元素
> int binarySearch(List list,T key)在List集合中查找某个元素的下标，但是List的元素必须是T或T的子类对象，而且必须是可以比较大小的，即支持自然排序的，而且集合中也事先必须有序，否则结果不确定
> int binarySearch(List list,T key,Comparator c)在List集合中查找某元素的下表，但是List的元素必须是T或T的子类对象，而且集合实现也必须按照c比较器规则进行排序过，否则结果不确定
> int frequency(Collection c,Object o)返回指定集合中指定元素的出现次数
>
> 复制、替换
> void copy(List dest,List src)将src中的内容复制到dest中
> boolean replaceAll(List list,Object oldVal,Object newVal)使用新的值替换旧的值
> 多个unmodifiableXxx()方法，该方法返回指定的Xxx的不可修改的视图
>
> 添加
> boolean addAll(Collection c,T...elements)将所有的指定元素添加到c中
>
> 同步
> Collections类中提供多个synchronizedXxxx()方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
>
> | 返回值            | 方法名                                        | 描述                                               |
> | ----------------- | --------------------------------------------- | -------------------------------------------------- |
> | Collection<T>     | synchronizedCollection(Collection<T> c)       | 返回由指定集合支持的同步（线程安全）集合。         |
> | List<T>           | synchronizedList(List<T> list)                | 返回由指定列表支持的同步（线程安全）列表。         |
> | Map<K,V>          | synchronizedMap(Map<K,V> m)                   | 返回由指定映射支持的同步（线程安全）映射。         |
> | NavigableMap<K,V> | synchronizedNavigableMap(NavigableMap<K,V> m) | 返回由指定导航映射支持的同步（线程安全）导航映射。 |
> | NavigableSet<T>   | synchronizedNavigableSet(NavigableSet<T> s)   | 返回由指定导航集支持的同步（线程安全）导航集。     |
> | Set<T>            | synchronizedSet(Set<T> s)                     | 返回由指定集合支持的同步（线程安全）集合。         |
> | SortedMap<K,V>    | synchronizedSortedMap(SortedMap<K,V> m)       | 返回由指定排序映射支持的同步（线程安全）排序映射。 |
> | SortedSet<T>      | synchronizedSortedSet(SortedSet<T> s)         | 返回由指定排序集支持的同步（线程安全）排序集。     |
>
> 

