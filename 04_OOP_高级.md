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



# 第八章 关键字

## 8.1 final关键字的使用

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

## 8.2 抽象类和抽象方法(abstract关键字)

### 1. 由来

随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则更一般，更通用。类的设计应该保证父类和子类能够共享特征。有时将一个父类设计的非常抽象，以至于他没有具体的实例，这样的类叫做抽象类，<span style="color:orange">包含抽象方法的抽象方法必须是抽象类</span>

### 2. abstract的理解：

抽象的

### 3. abstract可以用来修饰方法、类

### 4. 具体使用

1. 抽象类

   抽象类不能被实例化。

   抽象类中包含构造器，因为子类对象实例化时会直接或间接的调用父类的构造器

   抽象类中可以没有抽象方法。

2. 抽象方法

   抽象方法所在的类必须是抽象类

   抽象方法只有方法的声明没有方法体<span style="color:red;">`abstract public void say();`</span>

   抽象方法的功能是确定的，通过方法的声明即可确定，只是不知道如何具体实现(体现为没有方法体)

   抽象方法必须被子类重写

### 5. abstract不能使用的场景

​	属性、构造器、代码块等。

不能和static方法、private方法、final方法(类)共用

1. 子类不能重写父类中声明为private的方法
2. 避免静态方法使用类来进行调用
3. final方法不能被重写，fianl不能有子类，抽象类必须有子类



## 8.3 interface关键字(接口的使用)

### 1. 接口的理解

接口的本质是契约、标准、规范，就像法律一样，制定好之后，大家都需要遵守。

### 2. 定义接口的关键字：interface

### 3. 接口内部结构的说明：

> 可以声明
>
> 	1. 属性：必须使用`public static final`修饰
> 	2. 方法：
> 	 	1. JDK8之前：只能声明抽象方法，修饰为`public abstract`
> 	 	2. JDK8：声明静态方法和默认方法
> 	 	3. JDK8之后：声明私有方法

> 不可以声明
>
> 1. 构造器：与抽象类一样，不能实例化对象
> 2. 代码块
> 3. 。。。。



### 4. 接口与类的关系：实现关系	

### 5. 格式

> `class A extends SuperA implements B,C{}`
>
> A 相较于 SuperA 来说：A 是 SuperA 的子类
>
> A 相较于 B C 来说：A 是 B 和 C 的实现类

### 6. 满足此关系后，说明：

> 类可以实现多个接口
>
> 类针对于接口的多实现，一定程度上就弥补了类的单继承的局限性。
>
> 类必须将实现的接口中的所有的抽象方法都重写，才能实例化，否则此实现类必须声明为抽象类

### 7. 接口与接口的关系：继承关系，且可以多继承

```java
interface AA{
  void method1();
}
interface BB{
  void method2();
}
interface CC extends AA,BB{	// 接口可以多继承
 
}
class DD implements CC{
  public void method1(){}
  public void method2(){}
  ......
}
```

### 8. 接口的多态性：接口名 变量名 = new 实现类对象；

```java
public class Main {
    public static void main(String[] args) {
        // 1. 创建接口实现类的对象
        Printer p = new Printer();
        Computer c = new Computer();
        c.transferDate(p);
        System.out.println("------------------------");
        // 2. 创建接口实现类的匿名对象
        c.transferDate(new Dirve());
        System.out.println("------------------------");

        // 3. 创建接口匿名实现类的对象
        USB undefineUsb = new USB(){
            @Override
            public void start() {
                System.out.println("未知设备开始工作");
            }

            @Override
            public void stop() {
                System.out.println("未知设备结束工作");
            }
        };
        c.transferDate(undefineUsb);
        System.out.println("------------------------");

        // 4. 创建接口匿名实现类的匿名对象
        c.transferDate(new USB() {
            @Override
            public void start() {
                System.out.println("匿名设备开始工作");
            }

            @Override
            public void stop() {
                System.out.println("匿名设备结束工作");
            }
        });
    }
}
interface USB{
    void start();
    void stop();
}
class Printer implements USB{
    @Override
    public void start() {
        System.out.println("this is printer , it's begain.打印机开始工作");
    }
    @Override
    public void stop() {
        System.out.println("this is printer , it's stop.打印机结束工作");
    }
}

class Dirve implements USB{
    @Override
    public void start() {
        System.out.println("usb drive , begain。u盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("usb drive , stop。u盘结束工作");
    }
}

class Computer{
    public void transferDate(USB usb){ // 相当于 USB usb = new Printer();
        System.out.println("Device successfully connected，设备连接成功");
        usb.start();
        System.out.println("Data transmission in progress。。。。数据传输开始");
        usb.stop();
        System.out.println("Disconnect，断开连接");
    }
}
```

### 9. 区分抽象类和接口

> 共性：
>
> ​	都可以声明抽象方法
>
> ​	都不能实例化
>
> 不同：
>
> 1️⃣抽象类一定有构造器，接口没有构造器
>
> 2️⃣类与类之间继承关系，类与接口之间是实现关系，接口与接口之间是多继承关系

<table>
<tr>
<th>No.</th>
<th>区别点</th>
<th>抽象类</th>
<th>接口</th>
</tr>
<tr>
        <td>1</td>
        <td>定义</td>
        <td>可以包含抽象方法的类</td>
        <td>主要是抽象方法和全局常量的集合</td>
    </tr>
    <tr>
        <td>2</td>
        <td>组成</td>
        <td>构造方法、抽象方法、普通方法、常量、变量</td>
        <td>构造方法、抽象方法、普通方法、常量、变量常量、抽象方法、(JDK8:默认方法、静态方法)</td>
    </tr>
    <tr>
        <td>3</td>
        <td>使用</td>
        <td>子类继承抽象类(extends)</td>
        <td>子类实现接口(implements)</td>
    </tr>
    <tr>
        <td>4</td>
        <td>关系</td>
        <td>抽象类可以实现多个接口</td>
        <td>接口不能继承抽象类，但允许继承多个接口</td>
    </tr>
    <tr>
        <td>5</td>
        <td>常见设计模式</td>
        <td>模版方法</td>
        <td>简单工厂、工厂模式、代理模式</td>
    </tr>
    <tr>
        <td>6</td>
        <td>对象</td>
        <td colspan="2">都通过对象的多态性产生实例化对象</td>
    </tr>
    <tr>
        <td>7</td>
        <td>局限</td>
        <td>抽象类有单继承的局限</td>
        <td>接口没有此局限</td>
    </tr>
    <tr>
        <td>8</td>
        <td>实际</td>
        <td>作为一个模版</td>
        <td>作为一个标准或是表示一种能力</td>
    </tr>
    <tr>
        <td>9</td>
        <td>选择</td>
        <td colspan="2">如果抽象类和接口都可以使用的话，优先使用接口，因为可以避免单继承的局限性</td>
    </tr>
</table>
# 第九章 类的成员之五：内部类(inner)

## 9.1 什么是内部类？

将一个类A定义在另一个类B中，里面的类A就称为<span style="color:orange">内部类(InnerClass)</span>，则B称为<span style="color:orange">外部类(OuterClass)</span>

## 9.2 为什么需要内部类

具体来说，当一个事物A的内部，还有一部分需要完整的结构B进行描述，而这个内部的完整结构B又只为A提供服务，不在其他地方单独使用，那么整个内部的完整结构B最好使用内部类

总的来说，遵循<span style="color:red;">高内聚、低耦合</span>的OOP开发原则

## 9.3 内部类使用举例

Thread类(多线程类)内部声明了State类，表示线程的生命周期

HashMap类中，声明了一个Node类，表示封装的key&value

## 9.4 内部类的分类

> 成员内部类：直接声明在外部类的里面
>
> ​	使用static修饰的：静态成员内部类
>
> ​	不使用static修饰的：非静态成员内部类



> 局部内部类：声明在方法、构造器、代码块内的内部类，称为局部内部类
>
> ​	匿名的局部内部类：
>
> ​	非匿名的局部内部类：

## 9.5 内部类包含的知识

> 1. 成员内部类的理解：
>
>    1. 从类的角度看：	
>
>       内部可以声明属性、方法、构造器、内部类、代码块等结构
>
>       内部类可以声明父类，可以实现接口
>
>       可以使用final修饰，表示此类不可以有子类
>
>       可以使用abstract修饰
>
>    2. 从外部类的成员角度看：
>
>       在内部可以调用外部类的结构。比如：属性、方法。。。。。
>
>       可以使用四种权限修饰(public 缺省 private protected)
>
>       可以使用static进行修饰
>
> 2. 如何创建成员内部类的实例：
>
>    ```java
>    public class Main {
>        public static void main(String[] args) {
>            // 1. 创建Person的静态成员内部类的实例
>            Person.Dog d = new Person.Dog();
>            // 2. 创建Person的非静态成员内部类的实例
>            Person p = new Person();
>            Person.Bird bird = p.new Bird(); // 正确的
>        }
>    }
>    class Person {
>        // 静态成员内部类
>        static class Dog{
>    
>        }
>        // 非静态成员内部类
>        class Bird{
>    
>        }
>    }
>    ```
>
>    
>
> 3. 如何在成员内部类中调用外部类的结构
>
>    ```java
>    void show(int age){
>        System.out.println("age = " + age); // 形参中的age
>        System.out.println("age = " + this.age); // Bird中的age
>        System.out.println("age = " + Person.this.age); // Person中的age
>    }
>    ```
>
>    
>
> 4. 局部内部类的基本使用
>
>    ```java
>    public class OuterClass{
>      public void method(){
>        // 局部内部类
>        class InnerClass{
>          // 可以声明属性、方法等
>        }
>      }
>    }
>    
>    // 开发中的场景
>    // 开发中使用内部类的场景
>    class OuterClass {
>        public Comparable getInstance() {
>            // 提供实现Comparable接口的类
>            // 方式1：提供了接口的实现类的对象
>            /*class MyComparable implements Comparable{
>                @Override
>                public int compareTo(Object o) {
>                    return 0;
>                }
>            }
>            MyComparable m = new MyComparable();
>            return m;*/
>            // 方式2：提供了接口的实现类的匿名对象
>            /*class MyComparable implements Comparable{
>                @Override
>                public int compareTo(Object o) {
>                    return 0;
>                }
>            }
>            return new MyComparable();*/
>            // 方式3：提供了接口的匿名实现类的对象
>            /*Comparable c = new Comparable() {
>                @Override
>                public int compareTo(Object o) {
>                    return 0;
>                }
>            };
>            return c;*/
>            // 方式4：提供了接口的匿名实现类的匿名对象
>            return new Comparable() {
>                @Override
>                public int compareTo(Object o) {
>                    return 0;
>                }
>            };
>        }
>    
>    }
>     
>    ```
>
>    

## 9.6 关于成员内部类的理解





# 第十章 枚举类和

## 10.1 概述

* 枚举类本质上也是一种类，只不过这个类的对象是有限的、固定的几个，不能让用户随意创建。
* 枚举类的例子：
  * 星期：Monday 。。。。。。。Sunday
  * 性别：man male
  * 月份：January 。。。。。。。 December
* 若枚举类只有一个对象，则可以作为一种单例模式的实现方式
* 枚举类的实现：
  * JDK5之前，需要程序员自定义枚举类型
  * JDK5之后，java支持enum关键字来快速定义枚举类型

## 10.2 枚举类的定义<span style="color:red;">(如果根据某个类的实例是固定个数的，推荐声明为枚举类)</span>

### 1. JDK5之前

```java
// Season 季节枚举类
class Season{
    // 声明当前类的实例对象的实例变量
    private final String seasonName;
    private final String seasonDesc;
    // 1. 私有化类的构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }
    // 2. 提供实例变量的get方法

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    // 3. 创建当前类的实例
    public static final Season SPRING = new Season("spring","春暖花开");
    public static final Season SUMMER = new Season("summer","夏日炎炎");
    public static final Season SUTUMN = new Season("autumn","秋高气爽");
    public static final Season WINTER = new Season("winter","冬日黑裘");
    // 4.

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
```

### 2. JDK5.0

```java
enum Season{
    // 1. 创建对象,必须在枚举类的开头声明实例对象，对象之间使用逗号隔开
    SPRING("spring","春暖花开"),
    SUMMER("summer","夏日炎炎"),
    AUTUMN("autumn","秋高气爽"),
    WINTER("winter","冬日黑裘");
		// 声明当前类的实例对象的实例变量
    private final String seasonName;
    private final String seasonDesc;
		// 私有化类的构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }
		// 声明属性的get方法
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
```

## 10.3 Enum中常用方法

```java
/*
Sting ToString():默认返回的是常量名(对象名)，可以继续手动重写该方法
(关注)static 枚举类型[] values():返回枚举类型的对象数组，该方法可以很方便的遍历所有的枚举类，是一个静态方法
(关注)static 枚举类型 valueOf(String name),可以把一个字符串转为对应的枚举类型对象，要求字符串必须是枚举对象的名字，如果不是，会有运行异常：IllegalArgumentException
  String s = "MAN";
  gender g1 = gender.valueOf(s);
  System.out.println(g1.getGenderDesc());
String name(): 得到当前枚举常量的名称，建议先使用toString()
int ordinal() : 返回当前枚举常量的次序号，默认从0开始
*/
```

## 10.4 枚举类实现接口的操作

### 情况一：

枚举类实现接口，在枚举类中重写接口中的抽象方法，当通过不同的枚举类对象调用此方法时，执行的是同一个方法

### 情况二：

让枚举类的每一个对象重写接口中的抽象方法，当通过不同的枚举类对象调用此方法时，执行的是不同的方法





<span>```</span>
