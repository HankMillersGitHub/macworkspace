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
   对于开发中异常，一般不对其进行处理，运行中如果出现，就修改代码
   对于编译时异常，必须要进行处理，
   
   */
   ```

3. finally使用及举例

   ```java
   ```

   

### 2. 方式二：声明抛出异常的类型(throws + Exception)









<span>```````````````````````````````````</span>

```html
<span style="color:orange"></span>
<span style="color:red"></span>
<span style="color:green"></span>
```

### 
