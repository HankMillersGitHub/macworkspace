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



<span>```````````````````````````````````</span>

```html
<span style="color:orange"></span>
<span style="color:red"></span>
<span style="color:green"></span>
```

### 
