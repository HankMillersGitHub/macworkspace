# 第七章 OOP高级

## 7.1 关键字：static

本节代码：

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(Chinese.country);
        Chinese.speak();

        Chinese c1 = new Chinese("Hank",10001);
        Chinese c2 = new Chinese("Miller",10002);
        Chinese.country = "USA";
        c1.sayHello();
//        c1.country = "China";
        System.out.println(c1.country + " + " + c2.country);
    }
}
class Chinese{
    static String country;
    String name;
    int id;
    public static void speak(){
        System.out.println("i am a Chinese!");

    }
    public void sayHello(){
        System.out.println("hello ,i am a Chinese!");
        Chinese.speak();
    }
    public Chinese() {
    }

    public Chinese(String name, int id) {
        this.name = name;
        this.id = id;
    }

}
```



### 1. static关键字

* static表示静态的
* static可以用来修饰的结构：属性、方法、代码块、内部类

### 2. 静态变量：使用static修饰的成员变量称为静态变量、类变量

对比静态变量与实例变量

1. 个数

   > 静态变量：在内存中只有一份，被类的多个对象共享
   >
   > 实例变量：每个对象都有一个自己的变量，不共享

2. 内存位置

   > 静态变量：jdk6及之前，存放在方法区，jdk7及以后，存放在堆空间
   >
   > 实例变量：存放在堆空间的对象实体中

3. 加载时机

   > 静态变量：随着类的创建而创建，由于类只能被创建一次，所以静态变量也只有一份
   >
   > 实例变量：当类被实例化以后，实例变量才被创建，所以每个实例都有一份实例变量

4. 调用者

   > 静态变量：当前类的所有实例都可以调用，也可以被当前类调用
   >
   > 实例变量：只能被当前实例调用

5. 判断是否可以调用：从生命周期的角度解释

   > 静态变量：因为在类被创建时就已经生成，所以可以被类以及类的实例调用
   >
   > 实例变量：因为随着类的实例化而创建，所以只能被类的实例调用

6. 消亡时机

   > 静态变量：随着类的卸载而消亡
   >
   > 实例变量：随着实例的卸载而消亡

### 3. 静态方法：被static修饰的方法称为类方法、静态方法

> 随着类的加载而加载
>
> 可以通过`类.静态方法`的形式直接调用静态方法
>
> 静态方法内可以调用静态的属性和方法，不可以调用非静态的属性和方法
>
> static修饰的方法内不能使用this和super，如果要调用静态变量，直接写即可，如：
>
> ​	static String nation;
>
> ​	public static void whereAreYouForm(){
>
> ​		System.out.println("i am form " + nation);	
>
> ​	}

### 4. 开发中，什么时候需要将属性或方法声明为静态的

> 判断当前类的多个实例是否能共享此成员变量，并且此成员变量的值还必须是相同的
>
> 开发中常常将一些常量声明为静态的，如：`static double PI = 3.14`
>
>  
>
> 方法内操作的变量如果都是静态变量，则此方法建议声明为静态方法
>
> 开发中，常常将工具类中的方法定义为静态变量，比如Array类、Math类

### 5. 练习

```java
// 银行账户练习
public class Main {
    public static void main(String[] args) {
        Account a1 = new Account("12345",0.05);
        Account a2 = new Account("12345",0.05);
        Account a3 = new Account("12345",0.05);
        // a1 存入 10000元；
        a1.setVacancise(10000);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}
class Account{
    // account
    private int account;
    // password
    private String password;
    // vacancise 账户余额
    private double vacancise;
    // rate 利率
    private double rate;
    // smallestVacancise 最小余额
    private static double smallestVacancise = 0;
    private static int id = 10001;
    public Account() {
        this.account = id++;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getVacancise() {
        return vacancise;
    }

    public void setVacancise(double vacancise) {
        this.vacancise = vacancise;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Account(String password, double rate) {
        this();
        this.password = password;
        this.vacancise = smallestVacancise;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account=" + account +
                ", vacancise=" + vacancise +
                ", rate=" + rate +
                '}';
    }
}

// 圆形练习
public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(10.3);
        Circle c2 = new Circle(10.3);
        Circle c3 = new Circle();
        System.out.println(Circle.count);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }
}
class Circle{
    private double raidus;
    private int id;
    static int count = 0;
    private static int init = 1000;
    public Circle() {
        this.id = init++;
        count++;
    }

    public Circle(double raidus) {
        this();
        this.raidus = raidus;
    }

    public double getRaidus() {
        return raidus;
    }

    public void setRaidus(double raidus) {
        this.raidus = raidus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    @Override
    public String toString() {
        return "Circle{" +
                "raidus=" + raidus +
                ", id=" + id +
                '}';
    }
}
```



## 7.2 单例设计模式

### 1. 何为单例模式

所谓类的单例模式，就是采取一定的方法保证在整个软件系统中，对某个类<span style="color:orange;">只能存在一个对象实例</span>，并且该类只提供一个取得其对象实例的方法

### 2. 实现思路

如果我们要让类在一个虚拟机中只能产生一个对象，我们首先必须<span style="color:red;">将类的构造器的访问权限设置为私有(private)</span>，这样，就不能用new操作符在类的外部产生类的对象了，但在类的内部仍可以产生该类的对象。因为在类的外部还无法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象，静态方法只能访问类中的静态成员变量，所以指向类内部产生的该类对象的变量也必须定义成静态的 

### 3. 如何实现单例模式

> 饿汉式：不管用不用都会创建实例

```java
public class BankTest {
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);
    }
}
// 饿汉式实现单例模式
class Bank{
    // 1. 类的构造器私有化
    private Bank(){}
    // 2. 在类的内部创建当前类的实例
    // 4. 此属性也必须声明为静态
    private static Bank instance = new Bank();
    // 3. 使用getAxxx()方法获取当前类的实例，必须声明为static
    public static Bank getInstance(){
        return instance;
    }
}
```



> 懒汉式：只有用的时候才会创建实例

```java
public class GirlFirendTest {
    public static void main(String[] args) {
        GirlFriend g1 = GirlFriend.getGirlFriend();
        GirlFriend g2 = GirlFriend.getGirlFriend();
        System.out.println(g1 == g2);
    }
}
// 懒汉式实现单例模式
class GirlFriend{
    // 1. 类的构造器私有化
    private GirlFriend(){}
    // 2. 声明当前类的实例
    // 4. 当前实例也必须是static
    private static GirlFriend instance = null;
    // 3. 通过getXxx()方法获取当前实例，如果当前实例是null，则在方法内进行创建
    public static GirlFriend getGirlFriend(){
        if(instance == null){
            instance = new GirlFriend();
        }
        return instance;
    }
}

```

### 4. 对比两种模式的优缺点

特点：

> 饿汉式：“立即加载”，随着类的加载，当前的唯一实例就被加载
>
> 懒汉式： “延迟加载“，在需要使用的时候再进行实例的创建

优缺点：

| 方式   | 优点                                                         | 缺点                               |
| ------ | ------------------------------------------------------------ | ---------------------------------- |
| 饿汉式 | 写法简单，由于内存中较早加载，使用更方便，更快，是线程安全的 | 内存中占用时间更长                 |
| 懒汉式 | 线程不安全                                                   | 在需要的时候进行创建，节省内存空间 |

## 7.3 类的成员之四：代码块

### 1. 代码块(或初始化块)的作用

用来初始化类或对象的信息(即初始化类或对象的成员变量)

### 2. 代码块的修饰

只能使用static进行修饰，并且按此方式分为静态代码块和非静态代码块

### 3. 具体使用



#### 3.1 静态代码块

```java
// 随着类的加载而执行
// 由于类的加载只会执行一次，所以静态代码块也只会执行一次
// 作用：用来初始化类的信息
// 内部可以声明变量、调用属性或方法、输出语句等操作
// 静态代码块的执行要先于非静态代码块的执行
// 如果声明的有多个静态代码块，则按照声明的先后顺序进行调用
// 静态代码块内部只能调用静态的结构(静态的属性、方法等)，不能调用非静态的结构
static{
  
}
```



#### 3.2 非静态代码块

```java
// 随着对象的创建而执行
// 因为是随着对象的创建而执行的，所以非静态代码块每创建一次对象，就会执行一次
// 作用：用来创建对象的信息
// 内部可以声明变量、调用属性或方法、输出语句等操作
// 如果声明的有多个非静态代码块，则按照声明的先后顺序进行调用
// 非静态代码块内部可以调用静态的结构(静态的属性、方法等)，也可以调用非静态的结构
{
  
}
```

## 7.4 总结：属性赋值过程

1. 可以给类的非静态属性(即实例变量)赋值的位置有：

   * 1️⃣默认初始化
   * 2️⃣显式初始化
   * 3️⃣构造器中初始化
   * 5️⃣代码块中初始化
   * 4️⃣有了对象以后，通过`对象.属性`或`对象.方法`的方式进行赋值

2. 执行的先后顺序

   1️⃣默认 -> 2️⃣显式 / 5️⃣代码块 -> 3️⃣构造器 -> 4️⃣`对象.属性`

3. 关于`<init>`方法的简单说明

   此方法在字节码文件中可以看到，每个方法对应一个类的构造器。(类中声明了几个构造器就会有几个方法)

   编写的代码中的构造器，就是以此方法的方式去呈现

   方法的内部代码包含了实例变量的显式赋值、代码块中的赋值和构造器中的代码

   方法用来初始化当前创建的对象的信息

4. 给实例变量赋值的位置很多，开发中选择在哪里赋值

   > 显示赋值：比较适合于每个对象的属性值相同的场景
   >
   > 构造器中赋值：比较适合于每个对象的属性值不同的场景



# 关键字

## 一、final关键字的使用

### 1. final的理解

最终的

### 2. final可以用来修饰的结构

类、方法、变量

### 3. 具体说明

1. final修饰类

   表示此类不能被继承

   比如：String 、StringBuffer 、 StringBuilder类

2. final修饰方法

   表示此方法不能被重写

   比如：Object类中的getClass()

3. final修饰变量：既可以修饰成员变量也可以修饰局部变量，被修饰的变量其实就变成常量，一旦赋值就不可更改

   1. final修饰成员变量：有那些位置可以给成员变量赋值

      ```java
      class A{
        // 3. 显式赋值
        final int age = 10;
        // 1. 构造器中赋值
        A(){
          age = 2;
        }
        A(int age){
          this.age = age
        }
        // 2. 代码块中赋值
        {
          age = 100;
        }
      }
      ```

   2. fianl修饰局部变量：一旦赋值，值就不能修改

      ```java
      // 1. 方法内声明的局部变量：在调用局部变量前，就要赋值
      class A{
        public method(){
          final int num = 19;
        }
      }
      // 2. 方法的形参：在调用此方法是，对形参进行赋值，一旦赋值就不可更改
      class B {
        public method(final int mum){
          
        }
      }
      method(20);
      ```

### 4. final与static搭配

修饰成员变量时，成员变量兼具两者的所有特点：此成员变量称为全局常量

比如：Math中的PI

## 二、抽象类和抽象方法(abstract关键字)

### 1. 由来

随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则更一般，更通用。类的设计应该保证父类和子类能够共享特征。有时将一个父类设计的非常抽象，以至于他没有具体的实例，这样的类叫做抽象类

### 2. 
