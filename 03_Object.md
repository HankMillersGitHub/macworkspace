# 第六章 面向对象基础

## 6.1 Java的基本元素：类和对象

### 6.1.1 类的声明和使用

#### 6.1.1.1 面向对象完成功能的三个步骤

1. 类的定义(创建类、并设计类的内部成员和方法)

   ```java
   public class Phone {
       // 属性
       String brand;
       int price;
       // 方法
       public void call(){
           System.out.println("手机可以打电话");
       }
       public void sendMessage(){
           System.out.println("手机可以发短信");
       }
   }
   ```

   

1. 对象的创建

   ```java
   Phone newPhone = new Phone();
   ```

   

1. 对象调用属性或方法

   ```java
   newPhone.brand = "iphone";
   newPhone.price = 8999;
   newPhone.call();
   ```




### 6.1.2 类的内存解析

#### 6.1.2.1 JVM内存结构划分

1. 栈：方法内定义的变量，都存储在栈中
1. 堆：new出来的结构，比如数组的实体，对象的实体(包括对象中的属性)
1. 方法区：存放类的模板

### 6.1.3 类的成员

#### 6.1.3.1 属性

1. 变量的分类
   1. 按照数据类型来分，八种基本数据类型和引用数据类型
   1. 按照变量在类中的位置不同，分为成员变量和局部变量
1. 属性的几个称谓：
   1. 成员变量
   1. 属性
   1. field(字段、域)
1. 区分成员变量和局部变量
   1. 相同点：
      1. 都有自己的作用域
      1. 声明的格式相同
      1. 都必须先声明后使用
   1. 不同点：
      1. 类中声明的未知不通
         1. 属性：声明在类中，方法外的变量
         1. 局部变量：声明方法，构造器内部的变量
      1. 在内存中分配的位置不同
         1. 属性：随着对象的创建，存储在堆空间中
         1. 局部变量：存储在栈空间中
      1. 生命周期
         1. 属性：随着对象的创建而创建，随着对象的消亡而消亡
         1. 局部变量：随着方法对应的栈帧入栈，局部变量会在栈中分配，随着方法对应的栈帧出栈，局部变量消亡
      1. 作用域
         1. 属性：在整个类的内部都是有效的
         1. 局部变量：仅限于声明此局部变量的方法内
      1. 是否有权限修饰符进行修饰
         1. 都有哪些权限修饰符：public private protected
         1. 属性是可以使用权限修饰符进行修饰的，局部变量不可以使用
      1. 是否有默认值
         1. 属性都有默认初始化值，意味着如果没有给属性进行显示初始化赋值，则会有初始化值
         1. 局部变量都没有默认初始化值，意味着如果不给变量进行初始化赋值，局部变量不可用
         1. 注意：对于方法的形参，在调用该方法时，对形参进行赋值即可

#### 6.1.3.2 方法

* 方法是类或对象行为的抽象，用来完成某个功能操作，在某些语言中也成为函数或过程
* 将功能封装为方法的目的是，可以实现代码重用，减少冗余，简化代码
* java中方法不能独立存在，所有方法必须定义在类中
* 方法内可以调用本类中所有的方法
* 方法内不能定义方法

1. 方法声明的格式

   ```java
   权限修饰符 [其他修饰符] 返回值类型 方法名(形参列表){
       // 方法体
   }
   ```

   1. 权限修饰符：

      1. public 
      1. private
      1. protected
      1. 缺省

   1. 返回值类型：当调用完此方法时，是否需要返回一个结果

      1. 无返回值(void)
      1. 有返回值(根据返回值类型定义，可以是基本数据类型，也可以是引用数据类型)

   1. 方法名 和变量命名标准一致

   1. 形参列表：形参属于局部变量，且可以声明多个

      格式：(形参类型1 形参1，形参类型2 形参2，。。。)

      分类：

      	1. 无形参 但是不能省略小括号
      	1. 有形参，根据需要，声明形参个数

   1. return的作用

      1. 结束一个方法
      1. 结束一个方法并返回一个值给方法的使用者

### 6.1.4 对象数组

数组的元素可以是基本数据类型，也可以是引用数据类型

1. 案例一

   1. 定义类Student，包含三个属性，学号姓名班级
   1. 创建二十个学生对象，学号从0到19，年纪和成绩都随机决定

   问题一：打印出三年级的学生信息

   问题二：使用冒泡排序学生成绩，并遍历所有信息
   
   ```java
   // 详见(JavaSECode\chapter05\practice05_03_ObjectArray) 
   ```
   
   

### 6.1.5 练习

1. 声明员工类Employee,包含属性：编号id 姓名name 年龄age 薪资salary，声明EmployeeTest类，并在main方法中创建两个员工对象，并未属性赋值，并打印两个员工的信息

   ```java
   // Employee
   public class Employee {
       String id;
       String name;
       int age;
       double salary;
       public void sayHello(){
           System.out.println("i am " + name + ",i'm " + age + " years old ,i can make " + salary +" a year.");
       }
   }
   // EmployeeTest
   public class EmployeeTest {
       public static void main(String[] args) {
   
           Employee Hank = new Employee();
           Hank.name = "HankMiller";
           Hank.age = 39;
           Hank.salary = 50000;
           Employee Write = new Employee();
           Write.name = "Write";
           Write.age = 35;
           Write.salary = 500000;
   
           Hank.sayHello();
           Write.sayHello();
       }
   }
   ```

1. 声明一个MyDate类型，有属性，年月日，声明一个Employee类型有属性：编号姓名年龄生日薪资，在EmployeeTest测试类的main方法中，对生日和个人信息进行赋值并输出

   ```java
   // Employee
   public class Employee {
       String id;
       String name;
       int age;
       double salary;
   
       MyDate birthday;
       public void sayHello(String date){
   //        System.out.println(date);
           System.out.println("i am " + name + ",i'm " + age + " years old ,i can make " + salary +" a year.and my birthday is " + date);
       }
   }
   // MyDate
   public class MyDate {
       int year;
       int month;
       int day;
       public String output(){
           return year + "年" + month + "月" + day + "日";
       }
   }
   // EmployeeTest
   public class EmployeeTest {
       public static void main(String[] args) {
   
           Employee Hank = new Employee();
           Hank.name = "HankMiller";
           Hank.age = 39;
           Hank.salary = 50000;
           Hank.birthday = new MyDate();
           Hank.birthday.year = 1998;
           Hank.birthday.month = 5;
           Hank.birthday.day = 15;
           
           Employee Write = new Employee();
           Write.name = "Write";
           Write.age = 35;
           Write.salary = 500000;
           Write.birthday = new MyDate();
           Write.birthday.year = 1998;
           Write.birthday.month = 6;
           Write.birthday.day = 21;
   
           Hank.sayHello(HankDate.output());
           Write.sayHello(WriteDate.output());
       }
   }
   
   
   ```
   



### 6.1.6 方法的重载(overload)

1. 定义：
   * 在方法的类中，允许存在一个以上的同名方法，只要他们的参数列表不同即可，参数列表不同，意味着参数个数或参数类型的不同
   * 重载的特点：与修饰符、返回值类型无关，只看参数列表，且参数列表必须不同
   * 重载方法调用：JVM通过方法的参数列表，调用匹配的方法
     * 先找参数个数、类型最匹配的
     * 再找个数和类型可以兼容的，如果同时多个方法可以兼容将会报错

### 6.1.7 可变个数形参的方法

1. 使用场景：再调用方法时，可能会出现方法形参的类型是确定的，但是参数的个数不确定，此时就可以使用这种方法
1. 格式 ： (参数类型 ... 参数名)
1. 说明：
   1. 可变个数形参的方法在调用时，针对于可变的形参的实参个数可以为0个1个或多个
   1. 可变个数形参的方法与同一个类中，同名的多个方法可以构成重载
   1. 可变个数形参的方法与同一个类中方法名相同，且与可变个数形参的类型相同的数组参数不构成重载
   1. 如果可变个数形参的方法有确定的参数，可变类型的参数必须写在形参列表的最后
   1. 可变个数形参最多在一个方法的形参列表中出现一次

```java
// 案例：n个字符串进行拼接，每一个字符串之间使用某种字符进行分割，如果没有传入字符串，那么返回空字符串
public class StringConcatenation {
    public String stringConcatenation(String ... str){
        StringBuilder sum = new StringBuilder();
        for (String s : str) {
            // append方法可以将参数链接到调用者后面
            sum.append(s);
        }
        return sum.toString();
    }
    public static void main(String[] args) {
        StringConcatenation sc = new StringConcatenation();
        String result = sc.stringConcatenation("abcd","efg","hijk");
        System.out.println(result);
    }
}
```



### 6.1.8 方法的值传递机制

1. 对于方法内声明的局部变量，值传递的机制：
   1. 如果是基本数据类型的变量，则将此变量保存的数据值传递出去
   1. 如果是引用数据类型的变量，则将此变量保存的地址值传递出去
1. 方法的参数的传递机制，值传递机制
   1. 概念：
      1. 形参，在定义方法时，方法名后面括号中声明的变量称为形式参数，简称形参
      1. 实参，再调用方法时，方法名后面括号中的使用的值、变量、表达式称为实际参数，简称实参
   1. 规则
      1. 如果是基本数据类型的变量，则将此变量保存的数据值传递出去
      1. 如果是引用数据类型的变量，则将此变量保存的地址值传递出去

```java
// 面试题
public class InterviewQuestion {
    public static void main(String[] args) {
        InterviewQuestion iq = new InterviewQuestion();
        int a = 10;
        int b = 20;
        iq.method(a,b); // 需要在method方法被调用后仅输出a = 100;b = 200;
        method2(a,b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    // 方法一：不改变原本题目的情况下，直接停止运行
    public void method(int a,int b){
        System.out.println("a = " + a * 10);
        System.out.println("b = " + b * 10);
        System.exit(0);
    }

    // 方法二：重写println方法
    public static void method2(int a,int b){
        PrintStream ps = new PrintStream(System.out){
            public void println(String x){
                if("a = 10".equals(x)){
                    x = "a = 100";
                }else if("b = 20".equals(x)){
                    x = "b = 200";
                }
                super.println(x);
            }
        };
        System.setOut(ps);
    }
}

```



### 6.1.9 递归

1. 自己调用自己的方法就是递归
1. 分类
   1. 直接递归
   1. 简介递归
1. 使用说明：
   1. 递归方法包含一种隐式循环
   1. 递归方法会重复执行某段代码，但这种重复执行无需循环控制
   1. 递归一定要向已知方向递归，否则会出现无穷递归，类似死循环，最终出现堆栈溢出

```java
// 青蛙跳楼梯
public class Factorial {
    public int factorial(int n){
        if(n==2){
            return 2;
        }else if(n == 1){
            return 1;
        }else if(n == 3){
            return factorial(2) + factorial(1);
        }else{
            return factorial(n - 1) + factorial(n-2);
        }
    }
}
```



### 6.1.10 Package&import

#### 6.1.10.1 package

1. package

   1. 包
   1. 用于指明该文件中定义的类、接口等结构所在的包

1. 语法格式

   `package 顶层包名.子包名;`

   举例：

   ```java
   package pack1.pack2
   public class StudentTest {
       public static void main(String[] args) {
           System.out.println("Hello World!");
       }
   }
   ```

1. 说明：

   * 一个源文件只能有一个声明包的package语句
   * package语句作为java源文件的第一条语句出现，若缺省该语句，则指定为无名包
   * 包名，属于标识符，满足标识符命名的规则和规范(全部小写)，见名知意
     * 常用公司域名倒置： `vip.Hank.xxx`
     * 取包名时不要使用`java.xxx`包
   * 包对应于文件系统中的目录，package语句中用"."来指明包目录的层次。每一个.表示一层文件目录
   * 同一个包下可以声明多个结构，但实际不能定义同名结构，不同的包下可以定义同名结构

1. 包的作用

   1. 包可以包含类和子包，划分项目<span style="color:orange">层次</span>，便于管理
   1. 帮助<span style="color:orange">管理大型软件系统</span>>，将功能相近的类划分到同一个包中，比如：MVC的设计模式
   1. 解决<span style="color:orange">类命名冲突</span>>
   1. 控制访问权限

1. 基础阶段常用包

   * `java.lang`:包含一些java语言的核心类，如String、math、Integer、System和Thread
   * `java.net：包含执行于网络相关的操作的类和接口`
   * `java.io：包含能提供多种输入输出的类`
   * `java.util：包含一些实用工具类，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数`
   * `java.text：包含一些java格式化相关的类`
   * `java.sql：包含java进行JDBC数据库编程的相关类/接口`
   * `java.awt：包含了构成抽象窗口工具集的多个类，用来创建应用程序`



#### 6.1.11.1 import

1. import：导入

1. 告诉编译器到哪里去找这个类

1. 语法格式：`import 包名.类名`

1. 应用举例

   ```java
   import java.util.Scanner;
   public class StudentTest {
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
       }
   }
   ```

1. 注意事项

   * import语句，声明在包的声明和类的声明之间
   * 如果需要导入多个类和接口，那么就并列显示多个import语句
   * 如果使用`a.*`导入结构，表示导入a包下的所有结构，可以使用`java.util.*`导入util包下的所有结构
   * 如果导入的类或接口是`java.lang`包下的，或者是当前包下的，可以省略import语句
   * 如果已经导入java.a包下的类，那么如果需要使用a包下的子包，仍然需要导入
   * 如果在代码中使用不同包下的同名的类，那么就需要使用类的全类名的方式指明调用的是哪个类
   * `import static`组合的使用，调用指定类或接口下的静态的属性或方法

## 6.2 类的特性

### 6.2.1 封装性

1. 为什么需要封装性？

   高内聚低耦合是软工中的概念，内聚是指一个模块内各个元素彼此结合的紧密程度，耦合指的是一个软件结构内部不同模块之间相互连接程度的度量，内聚意味着重用和独立，耦合意味着多米诺效应，牵一发而动全身

   高内聚低耦合的体现之一是：

   * 高内聚：类的内部数据操作细节由自己完成，不允许外部干涉；
   * 低耦合：尽暴露少量的方法给外部使用，尽量方便外部调用

1. 什么是封装性？

   所谓封装，就是把客观事物封装成抽象概念的类，并且类可以把自己的数据和方法只向可信的类或者对象开放，向没必要开放的类或者对象隐藏信息，<span style="color:red;font-weight:bold">通俗的讲，把该隐藏的隐藏起来，该暴露的暴露出来，这就是封装性的设计思想。</span>

1. java如何实现数据封装

   * 实现封装就是控制类或成员的可见性范围

   java规定了四种权限修饰符，分别是：private、protected、public、缺省

   使用四种权限修饰符修饰类及类的内部成员，当这些成员被调用时，体现可见性的范围

   | 修饰符    | 本类内部 | 本包内 | 其他包的子类 | 其他包非子类 |
   | --------- | -------- | ------ | ------------ | ------------ |
   | private   | √        | ×      | ×            | ×            |
   | 缺省      | √        | √      | ×            | ×            |
   | protected | √        | √      | √            | ×            |
   | public    | √        | √      | √            | √            |

   类：只能使用public、缺省修饰

   类的内部成员：可以被四种权限修饰符修饰

1. 开发中四种权限的使用情况

   1. 比较高：public private
   1. 比较低：缺省 protected

1. 封装性的体现

   * 场景一：私有化类的属性，提供公共的getset方法，对此属性进行获取和修改
   * 场景二：将类中不需要向外部暴露的方法，进行私有化
   * 场景三：单例模式中构造器声明称private，避免在类的外部创建实例

1. 案例

   ```java
   /*
    *  创建程序，在其中定义两个类：Person类和PersonTest类，定义如下
    * 用setAge()设置合法的年龄(0-130岁)，用getAge()返回人的年龄
    * 在PersonTest类中实例化Person类的对象B，调用setAge和getAge，体会java的封装性
    *
    * */
   class Person1{
       private int age;
   
       public int getAge() {
           return age;
       }
   
       public void setAge(int age) {
           if(age > 0 && age < 130){
               this.age = age;
           }
       }
   }
   class Person1Test{
       public static void main(String[] args) {
           Person1 person = new Person1();
           person.setAge(10);
           System.out.println(person.getAge());
       }
   }
   ```


### 6.2.2 继承性

#### 1. java如何实现继承性：

通过extends关键字实现类的继承，从而引出方法的重写(override)

```java
// 父类
public class Person{
  public void sayHello(){
    System.out.println("say my name!");
  }
}
// 子类
public class Student entends Person{
  public void sayHello(){
    System.out.println("my name is Hank");
  }
}
```

#### 2. super关键字

1. 为什么需要super？

   子类继承父类以后，对父类的方法进行了重写，是否还可以对父类中被重写的方法进行调用？

   ​	可以进行调用

   如何调用？

   ​	使用super关键字进行调用

2. super的理解。`父类的。。。`

3. super可以调用的结构：属性、方法、构造器

##### 2.1 super调用属性、方法

子类继承父类以后，就可以在子类的方法或构造器中，调用父类中声明的属性或方法。(满足封装性的前提下)，

如何调用呢？需要使用`super.`的结构，表示调用父类的属性或方法

一般情况下，可以考虑省略`super.`的结构，但是如果出现子类重写了父类的方法或父类子类中出现了同名的属性时，则必须使用super关键字声明，显示的调用父类被重写的方法或父类中声明的同名的属性

##### 2.2 super调用构造器

1. 子类继承父类时，不会继承父类的构造器，只能通过`super(参数列表)`的方式调用父类指定的构造器。
2. 规定：`super(参数列表)`，必须声明在构造器的首行
3. 在构造器的首行可以使用`this(形参列表)`，调用本类中重载的构造器，结合2：在构造器的首行，`this(形参列表)`和`super(参数列表)`只能二选一
4. 如果在子类构造器的首行既没有显示调用"this(形参列表)"，也没有显式调用"super(形参列表"，则子类此构造器默认调用"super()”，即调用父类中空参的构造器。
5. 由3和4得到结论：子类的任何一个构造器中，要么会调用本类中重载的构造器，要么会调用父类的空参构造器。
   1. 由5得到：一个类中声明有n个构造器，最多有n-1个构造器中使用了"this(形参列表)"，则剩下的那个一定使用"super(形参列表)”。


> 我们在通过子类的构造器创建对象时，一定在调用子类构造器的过程中，直接或间接的调用到父类的构造器，也正因为调用过父类的构造器，我们才会将父类中声明的属性或方法加载到内存中，供子类对象使用

#### 3. 子类对象实例化的全过程

```java
class Creature{	// 生物类
  // 声明属性、方法、构造器
}
class Animal{	// 动物类
  // ...
}
class Dog{	// 🐶类
  // ...
}
class DogTest{
  public static void main(String[] args){
    Dog d = new Dog();
  }
}

```

1. 从结果的角度来看，体现为类的继承性

   当我们创建子类对象后，子类对象就获取了其父类中声明的所有的属性和方法，在权限允许的情况下，可以直接调用父类的构造器

2. 从过程的角度来看

   当我们通过子类构造器创建对象的时候，子类的构造器一定会直接或间接的调用到其父类的构造器，而其父类的构造器同样会直接或间接的调用爷类的构造器，直到调用了Object类中的构造器为止

   正因为我们调用过子类所有的父类的构造器，所以我们就会将父类中声明的属性、方法加载到内存中，供子类对象使用

### 6.2.3 多态性

#### 1. 多态性的体现

子类对象的多态性：父类的引用指向子类的对象。(或子类的对象赋给父类的引用)

#### 2. 多态性的应用

多态性的应用：虚拟方法调用
 	在多态的场景下，调用方法时：
		编译时，认为方法是左边声明的父类的类型的方法(被重写的方法)
		执行时，实际执行的是子类重写父类的方法
		简称为：编译看左边，运行看右边

#### 3. 多态性的使用前提：

1. 要有类的继承关系
2. 要有方法的重写

#### 4. 多态的适用性

<span style="color:red;">仅适用于方法，不适用于属性。</span>

#### 5. 多态的优缺点

##### 5.1 优点

极大地减少代码冗余，不需要定义多个重载的方法

举例：

```java
/**
 * @program: macWorkSpace
 * @ClassName Animal
 * @description: 多态的使用场景
 * @author: HankMiller
 * @create: 2024-03-03 15:34
 * @Version 1.0
 **/
public class Animal {
    public static void func(Ani ani){
        ani.eat();
        ani.jump();
    }
    public static void main(String[] args){
        Dog dog = new Dog();
        Animal.func(dog);
        Animal.func(new Cat());
    }
}
class Ani{
    public void eat(){
        System.out.println("animal eat food!");
    }
    public void jump(){
        System.out.println("animal jump!");
    }
}
class Dog extends Ani{
    public void eat(){
        System.out.println("dog eat shit!");
    }
    public void jump(){
        System.out.println("dog jump!");
    }
}
class Cat extends Ani{
    public void eat(){
        System.out.println("Cat eat fish!");
    }
    public void jump(){
        System.out.println("Cat jump!");
    }
}
```

##### 5.2 缺点

针对于创建的对象，在内存中已经加载了子类对象特有的属性和方法，但是不能直接对其进行调用。

所以多态的应用场景一般多见于：父类需要进行扩展，符合开闭原则(对扩展开放，对修改关闭)

#### 6. 向下转型

向下转型可能会出现：类型转换异常(ClassCastException)

1. 建议在向下转型之前使用`instanceof`进行判断，避免出现ClassCastException

2. 格式：`a instanceof A`:判断对象a是否是类A的实例

3. 如果 a instanceof A 返回true，则：

   a instance superA 返回也是true，其中A是superA的子类

```java
public static void main(String[] args) {
        Ani ani = new Cat();
        Dog dog;
        if(ani instanceof Dog){
            dog = (Dog) ani;
        }else{
            System.out.println("猫不是狗");
        }
    }
```



## 6.3 构造器

### 6.3.1 构造器的理解



### 6.3.2 构造器的作用

1. 搭配new关键字，创建类的对象
1. 在创建对象的同时，可以给对象的相关属性赋值

### 6.3.3 构造器的使用说明

1. 构造器的声明格式：权限修饰符 类名(形参列表){}
1. 如果当前类中没有显式提供构造器的情况下，系统会提供一个空参数的构造器，且构造器权限与类声明的权限相同
1. 一旦类中显式声明了构造器，则系统不再提供默认的空参的构造器
1. 一个类中可以声明多个构造器，彼此之间构成重载

## 散点

1. 匿名对象
   1. 匿名对象往往只能被调用一次
   1. 匿名对象常常作为实参传递给方法的形参
1. 类中属性(仅考虑实例变量)赋值过程
   1. 在类的属性中，可以有那些位置给属性赋值
      * ①默认赋值
      * ②显式赋值
      * ③构造器中赋值
      * ④对象.方法赋值
      * ⑤对象.属性赋值
   1. 这些位置执行的先后顺序如何

## 6.4 Obejct类的使用

1. Object 类的说明

   > * 任何一个java类都直接或间接的继承于Object类
   > * Object类成为java类的根父类
   > * Object类中声明的结构(属性、方法等)就具有通用性
   >   * Object中没有生命属性
   >   * Object类提供了一个空参的构造器
   >   * <span style="color:red;">重点关注Object类中声明的方法</span>

2. 常用方法：

   1. 重点方法：
      1. equals() 
      
         ```java
         /*
         1. 适用性
           任何引用数据类型都可以使用。
         2. 定义
         3. 子类使用说明
         	> 自定义的类在没有重写Object中equals()方法的情况下，调用的就是Obejct中声明的equals()，比较两个对象的引用地址是否相同。(或比较两个对象是否指向了堆空间中的同一个对象实体)
         	> 对于像String、File、Date和包装类等，调用的就是各自重写之后的equals()，用于比较两个对象的实体内容是否相等
         4. 开发中使用说明
         	> 实际开发中，针对于自定义的类，常常要重写equals，主要是判断两个对象的属性值是否相等
         5. 面试题：区分 == 和 equals() 
         	== 是一个运算符
         		1. 适用范围：基本数据类型，引用数据类型
         		2. 基本数据类型：判断数据值是否相等
         		3. 引用数据类型：比较两个引用变量的地址值是否相等(或比较两个引用是否指向同一个对象实体)
         	equals() 
         		1. 适用范围：只能使用在引用数据类型上
         		2. 具体使用：对于类来说，重写equals方法和不重写equals方法
         */
         
         ```
      
      2. toString
      
         ```java
         /*
         1. Obejct类中toString的定义
         	public String toString(){
         		return getClass().getName() + "@" + Integer.toHexString(hashCode())
         	}
         2. 开发中的使用场景
         	> 平时我们在调用System.out.prointln()打印变量的时候，其实就调用了toString()
         	
         3. 子类使用说明
         	> 自定义的类。在没有重写Object的toString方法的情况下，默认返回对象的地址值
         	> String、File、Date或包装类等Object的子类，返回各自当前对象的实体内容
         	
         4. 开发中使用说明：
         	> 习惯上，开发中对于自定义的类在调用toString
         */
         ```
      
         
      
   2. 了解方法：
      1. clone()
      
         ```java
         // 是一种创建对象的方式
         Person p1 = new Person();
         Person p2 = p1.clone();
         ```
      
      2. finalize()
      
         ```java
         // 简单理解为垃圾回收机制
         //类似vue中的beforeDestory
         // 这个方法可能导致内部出现循环引用，导致此对象不能被回收
         引出面试题：final、finaly、finalize的区别
         ```
      
   3. 其他方法
      1. getClass()
      2. hashcode()
      3. notify()
      4. notifyAll()
      5. wait()

## 方法重载和重写的区别

重载：两同一不同

重写：继承以后，子类对父类同名同参数的方法的覆盖

# 复习

## 1. this关键字的使用

* this调用的结构：属性、方法；构造器

* this调用属性或方法时理解为：当前对象或当前正在创建的对象；

  ```java
  public void setName(String name){
    this.name = name;	// this表示当前对象
  }
  class Person {
    public Person(String name){
      this.name = name;	// this表示正在创建的对象
    }
  }
  ```

* this(形参列表)的方式，表示调用当前类中其他的重载的构造器。

  ```java
  class Person{
    String name;
    int age;
    public Person(){
      this("hank",18);	// 调用当前类中其他的重载的构造器
    }
    public Person(String name,int age){
      this.name = name;
      this.age = age;
    }
  }
  ```

  

## 2. 面向对象的特征二：继承性

* 继承性的好处：
  * 减少了代码冗余，提高了复用性；
  * 提高了扩展性
  * 为多态的使用提供了前提
* 继承性的特点：
  * 局限性：类的单继承性。后续通过类实现接口的方式，实现单继承的局限性
  * 支持多层继承，一个父类可以声明多个子类。
* 基础：`class A extends B{}`
* 理解：子类获取到父类的全部的属性、方法。可能受封装性的影响，不能直接调用

## 3. 方法的重写(override / overwrite)

* 面试题：方法重载与重写的区别
  * 方法的重载：“两同一不同”-相同类，相同方法名，不同参数列表；
  * 方法的重写：
    * 前提：类的继承
    * 子类对父类同名同参数方法的覆盖、覆写。



## 4. super关键字的使用

* super可以调用的结构：属性、方法、构造器
* super：父类的
* super调用父类属性、方法：
  * 如果子父类中出现了同名的属性，此时super.属性名的方式，表明调用的是父类中声明的属性
  * 子类重写父类方法，如果子类方法中需要调用父类被重写的方法，需要使用super关键字
* super调用构造器：
  * 在子类的构造器中，首行要么使用this(形参列表)，要么使用super(形参列表)

## 5. 子类对象实例化的全过程

* 结果上来说：体现为继承性
* 过程上来说：子类调用构造器创建对象时，一定会直接或间接的调用父类的构造器，直到调用到Object的构造器

## 6. 面向对象的特征三：多态性

* 广义上的理解：子类对象的多态性、方法的重写

  狭义上的理解：子类对象的多态性

* 格式：Object o = new String(); 父类的引用指向子类的对象

* 多态的好处：减少了大量的重载的方法的定义，体现了开闭原则；

* 多态的使用：虚拟方法调用，“编译看左边，运行看右边”

* 多态的逆过程：向下转型，使用强转

  * 为了避免出现强转时的ClassCastException，建议强转之前使用instanceOf进行判断

## 7. Object类的使用

* 根父类
* equals()的使用
  * 重写和不重写的区别
  * 面试题：==和equals的区别
* toString()的使用
  * Object中toString调用后，返回当前对象所属的类和地址值
  * 开发中常常重写toString，用于返回当前对象的属性信息

