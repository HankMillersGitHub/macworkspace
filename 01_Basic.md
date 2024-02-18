# 第一章节 Java基础概念

### 常用cmd命令

| 命令            | 说明                 | 举例               |
| --------------- | -------------------- | ------------------ |
| 盘符名称 + 冒号 | 盘符切换             | E：回车，切换到E盘 |
| dir             | 查看当前路径下的内容 |                    |
| cd 目录         | 进入单级目录         | cd mzh             |
| cd ..           | 回退到上一级         |                    |
| cd 目录1/目录2  | 进入多级目录         | cd Steam\PUBG      |
| cd \            | 回退到盘符目录       |                    |
| cls             | 清屏                 |                    |
| exit            | 推出命令提示符窗口   |                    |

## 二、基础

### 1、注释

```java
// 	单行注释
/*
	多行注释
*/

	文档注释
/**
* @author Hank
* @version 1.0
* @param null
* */
```

### 2、核心机制 JVM

## 第一章小结

### 一、企业真题

1. 一个`.java`源文件中是否可以包含多个类？有什么限制？

   一个源文件中可以声明多个类，但是最多只能有一个类使用public进行声明，且要求声明为public的类的类名只能和源文件相同

2. Java的优势

   * 跨平台性
   * 安全性高
   * 简单性
   * 高性能
   * 面向对象
   * 健壮

   社区繁荣

3. Java是否存在内存溢出、内存泄漏？如何解决？

   存在内存溢出、内存泄漏

4. 如何看待 java 是半编译半解释型语言？

   查

# 第二章 变量与标识符

## 1、关键字(keyword)

* 定义：被Java语言赋予特殊含义，用作专门用途的字符串(或单词)
  * hellworld案例中，出现的关键字有`class`、`public`、`static`、`void`等，这些单词已经被Java定义好了
* 特点：所有的关键字都是小写
* 关键字比较多，不需要专门记住，学到哪用到哪

## 2、标识符(identifier)

1. 什么是标识符？

   java中变量方法类等要素命名时使用的字符串序列，成为标识符

2. 标识符的命名规则

   由字母数字下划线组成，且数字不可以开头

   不可以使用关键字或保留字，但是可以包含关键字和保留字

   Java中严格区分大小写，长度无限制，标识符不能包含空格

3. 标识符的命名规范

   * 包含：多单词组成的所有字母小写：xxyyzz
   * 例如：java.lang、com.hankmiller.bean
   * 类名、接口名：多单词组成，所有单词首字母大写：XxYyZz
   * 例如：HelloWorld、HankMiller
   * 变量名、方法名：多单词组成，除第一个单词首字母小写外其余单词首字母大写:xxxYyZz
   * 例如：age,name,gender,address
   * 常量名：所有字母都大写，多单词时每个单词之间使用下划线链接：XX_YY_ZZ
   * 例如：THE_MAX_NUMBER

   ## 3、变量

   ### 3.1 初识变量

   * 变量的概念：
     * 内存中的一个存储区域，该区域的数据可以在同一类型范围内不断变化
     * 变量的构成包含三个要素：数据类型、变量名、存储的值
     * Java中变量声明的格式：`数据类型 变量名 = 变量值`
   * 变量的作用：用于在内存中保存数据
   * 使用变量时注意:
     * Java中每个变量必须先声明后使用
     * 使用变量名来访问这块区域的数据
     * 变量的作用域：其定义所在的一对大括号内
     * 同一个作用域内不能定义重名变量
   * Java中数据类型
     * 基本数据类型(8种)：
       * 整型 byte \ short \ int \ long
       * 浮点型 float \ double
       * 字符型 char
       * 布尔型 boolean
     * 引用数据类型：
       * 类(class)
       * 数组(array)
       * 接口(interface)
       * 枚举(enum)
       * 注解(annotation)
       * 记录(record)

## 4、基本数据类型介绍

### 4.1 整数类型：byte / short / int / long

* Java中各整数类型有固定的表示范围和字段长度，不受具体操作系统的影响，以保证Java程序的可移植性

  | 类型  | 占用存储空间 | 表示范围                |
  | ----- | ------------ | ----------------------- |
  | byte  | 1字节 = 8bit | -128 - 127              |
  | short | 2字节        | -2^15 - 2^15-1          |
  | int   | 4字节        | -2^31 - 2^31-1 (约21亿) |
  | long  | 8字节        | -2^63 - 2^63-1          |

* 定义long类型的变量，赋值时需要以`l`或`L`作为后缀

* Java程序中变量通常声明为int型，除非不足以表示较大的数，才使用long

* Java的整型默认为int型

#### 4.1.1 补充：计算机存储单位

* 字节(byte):是计算机用于计算存储容量的基本单位，一个字节表示8bit
* 位(bit)：是数据存储的最小单元，在二进制系统中，每一个0或1就是一个位，其中八个bit称为一字节
* 转换关系：
  * 8bit = 1Byte
  * 1024Byte = 1KB
  * 1024KB = 1MB
  * 1024MB = 1GB
  * 1024GB = 1TB

### 4.2 浮点类型

* 与整数类型类似，Java浮点类型也有固定的表示范围和字段长度，不受操作系统影响

  | 类型         | 占用存储空间 | 表示范围               |
  | ------------ | ------------ | ---------------------- |
  | 单精度float  | 4字节        | -3.403E38 - 3.403E38   |
  | 双精度double | 8字节        | -1.798E308 - 1.798E308 |
  
* 浮点型常量有两种表示形式：

  * 十进制形式：如：5.12  512.4f (必须有小数点)
  * 科学计数法形式。如：5.12e2  522e2
  
* float：单精度浮点型，尾数可以精确到7位有效数字，很多情况下，精度很难满足要求

* double：双精度，精度是float的两倍，通常采用此类型

* 定义float类型的常量，赋值时需要以`f`或`F`作为后缀

* Java的浮点型默认为double类型

#### 4.2.1 关于浮点型精度的说明

* 并不是所有的小数都能用二进制浮点数表示，二进制浮点数不能精确表示0.1、0.01、0.001这样的10的负次幂

* 浮点类型float、double的数据不适合在不容许舍入误差的金融计算领域，如果需要精确数字计算或保留指定位数的精度，需要使用`BigDecimal`类

* 测试用例：

  ```java
  float ff1 = 123123123f;
  float ff2 = ff1 + 1;
  System.out.println(ff1);		// 输出为1.2312312E8
  System.out.println(ff2);		// 输出为1.2312312E8
  System.out.println(ff1 == ff2);	// 输出为true
  // 结论 说明精度不高
  ```


### 4.3 字符类型：char

* char型数据用来表示通常意义上的`字符`(占两个字节)

* Java中所有的字符都用Unicode编码，故一个字符可以存储一个字母，一个汉字，或者其他书面语的一个字符

* 字符变量的三种表现形式：

  * 形式一：使用单引号括起来的单个字符
    * `char c1 = 'a';char c2 = 'b'`
  * 形式二：直接使用Unicode值来表示字符型常量：`\uxxx`,其中，xxx代表一个十六进制整数
    * `char c1 = \u0023; // 表示#`
  * 形式三：Java中还允许使用转义字符，来将其后的字符转为特殊字符型常量
    * `char c1 = '\n'; // \n 表示换行符`
  * 形式四：直接使用ASCII码赋值
    * `char c1 = 97; // 表示小写a`

* 常用的转义字符

  | 转义字符 | 说明   | Unicode表示方式 |
  | -------- | ------ | --------------- |
  | \n       | 换行符 | \u000a          |
  | \t       | 制表符 | \u0009          |
  | `\"`     | 双引号 | \u0022          |
  | `\'`     | 单引号 | \u0027          |
  | `\\`     | 反斜线 | \u005c          |
  | `\b`     | 退格符 | \u0008          |
  | `\r`     | 回车符 | \u000d          |

* char类型是可以进行运算的，因为他都有对应的Unicode码，可以看作一个数值

### 4.4 布尔类型

* 布尔类型用来判断逻辑条件，一般用于流程控制语句中：
  * if
  * for
  * while
  * do-while
* 布尔类型的数据只有两个值：true和false
  * 不可以使用0或非0整数代替false和true
  * 拓展：Java虚拟机中没有任何供布尔值使用的字节码指令，java中所操作的布尔值，编译之后都使用Java虚拟机中的int整数来代替，true用1代替，false用0代替
  * 了解：我们不谈布尔类型的占用空间大小，但是真正在内存中分配的话，使用的是4个字节

## 5、基本数据类型变量间运算规则

* 这里提到的基本数据类型有七种，不包括boolean类型
* 运算规则包括：
  * 自动类型提升
  * 强制类型转换

### 5.1 自动类型提升

* 当容量小的变量与容量大的变量做运算时，结果自动转换为容量大的数据类型

  `byte/short/char ---> int ---> long ---> float ---> double`

* 说明：此处提到的容量大小，不是占用内存空间的大小，而是指表示数据的范围的大小

### 5.2 强制类型转换

* 如果要将容量大的数据转换为容量小的数据，需要使用强制类型转换

* 强制类型转换需要使用强转符：`()`，在（）内要指明需要转换为的数据类型

  ```java
  double a = 10;
  int b = (int)a
  ```

* 强制类型转换过程中可能出现精度损失的情况

  ```java
  float a = 12.3;
  int b = (int)a; 	// b结果为12
  int c = 128;
  type d = (type)c;	// 结果为-128 涉及到原码反码和补码
  ```


### 5.3 基本数据类型和String的运算

#### 5.3.1 字符类型：String

* String 不是基本数据类型，属于引用数据类型
* 使用一对“”来表示一个字符串，内部可以包含0个、1个或多个字符
* 声明方式与基本数据类型类似，例如：String a = "mzh"

#### 5.3.2 运算规则

1. 任意八种基本数据类型的数据与String只能进行“+”运算，且结果一定是String类型

2. String类型不能通过强转转为其他数据类型

   ```java
   String a = "123";
   int num = (int)a; 	// 错误写法
   int num = Integer.parseInt(a);	//正确写法，借助包装类的方法才能转
   ```

#### 5.3.3 案例

* 个人信息输出

  ```java
  String name = "马中豪";
  int age = 27;
  String gender = "男";
  int weight = 70;
  // marital status表示婚姻状况
  boolean maritalStatus = false;
  // contact information 表示联系方式
  String contactInformation = "18335784129";
  System.out.println("name = " + name);
  System.out.println("age = " + age);
  System.out.println("gender = " + gender);
  System.out.println("weight = " + weight);
  System.out.println("maritalStatus = " + maritalStatus);
  System.out.println("contactInformation = " + contactInformation);
  ```

## 6、计算机底层如何存储数据

### 6.1 进制的分类

* 十进制(decimal)
  * 数字组成 0 - 9
* 二进制(binary)
  * 数字组成 0 、1
* 八进制(octal)
  * 数字组成 0 - 7
  * 满8进1，以数字0开头
* 十六进制(hexadecimal)
  * 数字组成 0 - 9、`a - f`
  * 满16进1，以`0x`或`0X`开头，此处的`a - f`不区分大小写

### 6.2 进制的换算举例

| 十进制 | 二进制 | 八进制 | 十六进制 |
| ------ | ------ | ------ | -------- |
| 0      | 0      | 0      | 0        |
| 1      | 1      | 1      | 1        |
| 2      | 10     | 2      | 2        |
| 3      | 11     | 3      | 3        |
| 4      | 100    | 4      | 4        |
| 5      | 101    | 5      | 5        |
| 6      | 110    | 6      | 6        |
| 7      | 111    | 7      | 7        |
| 8      | 1000   | 10     | 8        |
| 9      | 1001   | 11     | 9        |
| 10     | 1010   | 12     | a        |
| 11     | 1011   | 13     | b        |
| 12     | 1100   | 14     | c        |
| 13     | 1101   | 15     | d        |
| 14     | 1110   | 16     | e        |
| 15     | 1111   | 17     | f        |
| 16     | 10000  | 20     | 10       |

### 6.3 二进制的由来

二进制，是计算技术中广泛采用的一种数制，由莱布尼兹在1679年发明

二进制用0和1表示数字，基数为2 ，进位规则是逢二进一

### 6.4 二进制如何表示整数

* 计算机数据的存储使用二进制补码形式存储，并且最高位是符号位
  * 正数：最高位是0
  * 负数：最高位是1
* 规定：
  * 正数的补码反码和原码一致，成为三码合一
  * 负数的补码与反码、原码不一致
    * 负数的原码：把十进制转为二进制，然后最高位设为1；
    * 负数的反码：原码的基础上，符号位不变，其余位取反
    * 负数的补码：反码 + 1；

## 7、运算符

运算符是一种特殊的符号，用以表示数据的运算、赋值和比较等

运算符的分类：

* 按照功能分为：算术运算符、赋值运算符、比较运算符、逻辑运算符、位运算符、条件运算符、Lambda运算符

  | 分类         | 运算符                                                       |
  | ------------ | ------------------------------------------------------------ |
  | 算数运算符   | `+  -  *   /  %  ++  --`                                     |
  | 赋值运算符   | `=  +=  -=  *=  /=  %=  >>=  <<=  >>>=  &=  |=  ^= 等`       |
  | 比较运算符   | `>   <   >=   <=   ==   !=`                                  |
  | 逻辑运算符   | `&  |  ^  !  &&  ||`                                         |
  | 位运算符     | `&与   |或   ^亦或   ~按位取反   <<左移   >>右移   >>>无符号右移` |
  | 条件运算符   | `(条件表达式) ? 结果1 : 结果2`                               |
  | Lambda运算符 | `-> Java新特性`                                              |

* 按照操作数的个数分为：一元运算符、二元运算符、三元运算符

  | 分类       | 运算符                         |
  | ---------- | ------------------------------ |
  | 一元运算符 | `+ - ! ++ -- ~`                |
  | 二元运算符 | 出上下之外全是二元             |
  | 三元运算符 | `(条件表达式) ? 结果1 : 结果2` |

* 位运算(& | ^ ~ << >> >>>)

  * `<<` 向左移动一位，结果在原有基础上 * 2；（正负数都适用）

    ```java
    int num = 7;
    System.out.println(num << 1); 	// 结果为14
    System.out.println(num << 2); 	// 结果为28
    System.out.println(num << 3); 	// 结果为56
    ```

  * `>>` 向右移动以为，结果在原有基础上 / 2,如果不能整除，则向下取整

  * `>>>` 无符号右移 ，左边空位直接补零

  * & 

    ```java
    0000 0000 1000 0000			// 256
    0000 0000 0000 0001 		// 1
    256 & 1 = 
    0000 0000 0000 0000			// 0
    ```

  * |

    ```java
    0000 0000 0001 0001			// 17
    0000 0000 0010 0010			// 34
    9 | 18 = 
    0000 0000 0011 0011			// 51
    ```

  * 案例

    1. 高效的方式计算 2 * 8

       ```java
       2 >> 3 或
       8 >> 1
       ```

    2. 如何交换两个int型的变量？String呢？

       ```java
       // 位运算的方式
       int a = 10;
       int b = 100;
       a = a ^ b;
       b = a ^ b;
       a = a ^ b;
       // 传统方式
       int a = 10;
       int b = 100;
       int temp;
       temp = a;
       a = b;
       b = temp;
       ```


## 第二章复习

### 一、随堂复习

#### 1.1 关键字、保留字

#### 1.2 标识符

#### 1.3 变量的基本使用

#### 1.4 基本数据类型变量的使用

#### 1.5 基本数据类型变量间的运算规则

##### 1.5.1 自动类型提升

##### 1.5.2 强制类型转换

#### 1.6 String类的使用、基本数据类型变量之间的计算

#### 1.7 运算符

# 第三章 流程控制语句

## 1. 顺序结构

顺序结构就是从上到下依次执行的代码结构就是顺序结构

## 2. 分支结构

### 2.1 if-else条件判断语句

```java
// 格式1
if(条件表达式){
    代码块
}
// 格式2
if(条件表达式){
    代码块1
}else{
    代码块2
}
// 格式3
if(条件表达式1){
    代码块1
}else if(条件表达式2){
    代码块2
}else if(条件表达式3){
    代码块3
}else{
    代码块4
}
// if else 的嵌套
if(条件语句1){
    if(条件语句2){
        代码块1
    }else{
        代码块2
    }
}else{
    代码块3
}
```

* 案例1：成年人心率的正常范围是每分钟60-100次，体检时，如果心率不在此范围内，则提示需要进一步检查

  ```java
  // heartRate 表示心率
  int heartRate = 80;
  
  if(heartRate >= 60 && heartRate <= 100){
  	System.out.println("心率正常");
  	
  }else{
  	System.out.println("需要进一步检查");
  }
  System.out.println();
  ```

* 案例2：定义一个整数，判定是偶数还是奇数

  ```java
  // numericalJudgment 表示数值判断
  int numericalJudgment = 2;
  if(numericalJudgment % 2 == 0 && numericalJudgment != 2){
  	System.out.println(numericalJudgment + "是偶数");
  }else{
  	System.out.println(numericalJudgment + "是奇数");
  }
  ```

* 案例3：岳云鹏参加java考试，她和父亲岳不群达成承诺：如果

  * 成绩为100分，奖励一辆帕拉梅拉

  * 成绩为80-99，奖励一台捷安特

  * 成绩为60-79，奖励欢乐谷游玩一天

  * 其余，胖揍一顿

    ```java
    // examScoress 表示考试成绩
    int examScoress = 90;
    if(examScoress == 100){
    	System.out.println("帕拉梅拉一台");
    }else if(examScoress >= 80 && examScoress <100){
    	System.out.println("捷安特一台");
    }else if(examScoress >= 60 && examScoress < 80){
    	System.out.println("欢乐谷一日游");
    }else{
    	System.out.println("男女混合双打一次");
    }
    ```

* 案例4：由键盘输入三个整数分别存储为num1 num2 num3,对他们进行排序，并且从小到大输出

  ```java
  import java.util.Scanner;
  class ProcessControl{
  	public static void main(String[] args){
  		Scanner scan = new Scanner(System.in);
  		int num1 = scan.nextInt();
  		int num2 = scan.nextInt();
  		int num3 = scan.nextInt();
  		if(num1 > num2){
  			if(num3 > num1){
  				System.out.println(" " + num2 + " " + num1 + " " + num3);
  			}else if(num3 < num2){
  				System.out.println(" " + num3 + " " + num2 + " " + num1);
  			}else{
  				System.out.println(" " + num2 + " " + num3 + " " + num1);
  			}
  		}else{
  			if(num3 < num1){
  				System.out.println(" " + num3 + " " + num1 + " " + num2);
  			}else if(num3 > num2){
  				System.out.println(" " + num1 + " " + num2 + " " + num3);
  			}else{
  				System.out.println(" " + num1 + " " + num3 + " " + num2);
  			}
  		}
  		System.out.println();
  	}
  	
  }
  ```
  
  ### 2.2 switch-case条件判断语句
  
  ```java
  switch(表达式){
      case 常量1:执行语句1；break;
      case 常量2:执行语句2；break;
      case 常量3:执行语句3；break;
  }
  ```
  
  ```java
  int num = 10;
  switch(num){
  	case 1:System.out.println("1");break;
  	case 10:System.out.println("10");break;
  	case 100:System.out.println("100");break;
  }
  ```
  
  

## 3. Scanner:键盘输入功能的实现

* 如何从键盘获取不同的数据类型

* 键盘输入代码的四个步骤：

  1. 导包`import java.util.Scanner`;
  2. 创建Scanner类型的对象：`Scanner scan = new Scanner(System.in)`
  3. 调用Scanner类的相关方法`(next() / nextXxx())`,来获取指定数据类型的变量
  4. 释放资源：`scan.close();`

* 案例：注册交友网站需要输入信息

  ```java
  // process control 意思是流程控制
  import java.util.Scanner;
  class ProcessControl{
  	public static void main(String[] args){
  		Scanner scan = new Scanner(System.in);
  		System.out.println("please input your age ~");
  		int age = scan.nextInt();
  		System.out.println("please input your name ~");
  		String name = scan.next();
  		System.out.println("please input your gender ~");
  		String gender = scan.next();
  		System.out.println("please input your address ~");
  		String address = scan.next();
  		System.out.println("please input your maritalStatus ~");
  		Boolean maritalStatus = scan.nextBoolean();
  		// System.out.println(maritalStatus.equals("true"));
  		System.out.println("my name is " + name + ",i'm " + age + " years old,i'm a " + gender + ",i'm " + maritalStatus + ".i live in " + address);
  		
  		scan.close();
  	}
  	
  }
  ```

## 4. 如何获取一个随机数

如何产生一个指定范围的随机整数？

1. Math类的random()方法的调用，会返回一个（0，1）范围内的double型值

2. `Math.random() * 100 --->>[0,100);`

   `(int)Math.random() * 100 ; --->> [0,99]`

   `(int)Math.random() * 100 + 5; --->> [5,104]`

3. 如何获取[a,b]范围内的随机整数？`(int)Math.random() * (b - a + 1) + a`

4. 举例

   ```java
   double a = (int)Math.random() * 5 + 5;
   System.out.println(a);
   ```

## 5. 关键字break和continue的使用

break：结束循环

continue：结束本次循环，继续下一次循环

内层结束外层循环：

```java
breakOuterLoop:for(){
    for(){
        ....
        break breakOuterLoop;
        continue:breakOuterLoop;
    }
}
```



## 案例

1. 使用for循环实现输出菱形

   ```java
   /*
   								第i行	空格个数j	*个数k		j = 5 - i
   			-----*				0		5			1			k = 2 * i + 1
   			----***				1		4			3
   			---*****			2		3			5
   			--*******			3		2			7
   			-*********			4		1			9	
   			***********			5		0			11
   			
   			-*********			0		1			9			j = i + 1
   			--*******			1		2			7			k = 2 * (5 - i) + 1
   			---*****			2		3			5
   			----***				3		4			3
   			-----*				4		5			1
   			
   		*/
   		// 上半部分
   		for(int i = 0;i <= 5;i++){
   			for(int j = 0;j < 5 - i;j++){
   				System.out.print(" ");
   			}
   			for(int k = 0;k < 2 * i + 1;k++){
   				System.out.print("*");
   			}
   			System.out.println("");
   		}
   		// 下半部分
   		for(int i = 0;i < 5;i++){
   			for(int j = 0;j < i + 1;j++){
   				System.out.print(" ");
   			}
   			for(int k = 1;k < 2 * (5 - i);k++){
   				System.out.print("*");
   			}
   			System.out.println("");
   		}
   ```

2. 99乘法表

   ```java
   for(int i = 1;i <= 9;i++){
   			for(int j = 1;j <= i;j++){
   				System.out.print(j + "*" + i + "=" + i * j +" ");
   			}
   			System.out.println("");
   		}
   ```

3. 找出100以内的所有素数？10000以内的？

   ```java
   // 第一种方法
   for(int i = 2;i<100;i++){
   	int number = 0;
   	for(int j = 2;j<i;j++){
   		if(i%j==0){
   			number++;
   		}
   	}
   	if(number==0){
   		System.out.println(i);
   	}
   }
   // 第二种方法
   for(int i = 2;i<100;i++){
   	boolean flag = false;
   	for(int j = 2;j<i;j++){
   		if(i%j==0){
   			flag = true;
   		}
   	}
   	if(!flag){
   		System.out.println(i);
   	}
   }
   // 优化之后的第二种方法
   for(int i = 2;i<100;i++){
   	boolean flag = false;
   	for(int j = 2;j<=Math.sqrt(i);j++){
   		if(i%j==0){
   			flag = true;
              	 break;
               /*原因是两个约数最终都会慢慢靠近i的开方*/
   		}
   	}
   	if(!flag){
   		System.out.println(i);
   	}
   }
   ```

   # 总项目：谷粒记账

```java
// 主文件
import java.util.Scanner;
class PracticeProject{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		/*
			假设家庭起始的生活基本金为10000元
			每次登记收入后，收入的金额应该累加到基本金上，并记录本次收入明细，以便日后查询
			每次登记支出后，指出的金额应该从基本金中扣除，并记录本次指出明细，以便日后查询
			查询收支明细时，显示所有的收入，支出明细列表
			
		*/ 
		boolean falg = true;
		// 初始金额
		int balance = 10000;
		// 记录收支信息
		String info = "";
		while(falg){
			System.out.println("--------Hank记账软件--------\n");
			System.out.println("        1. 收支明细        ");
			System.out.println("        2. 登记收入        ");
			System.out.println("        3. 登记支出        ");
			System.out.println("        4. 退    出        \n");
			System.out.println("--------Hank记账软件--------");
			System.out.print("        请选择1-4：");
			// 用户输入 格式为char
			char key = Utility.readMenuSelection();
			switch(key){
				case '1':
					System.out.println("--------当前收支明细记录--------");
					System.out.println("收支\t账户金额\t收支金额\t说明");
					System.out.println(info);
					System.out.println("-------------------------------");
					break;
				case '2':
					System.out.print("本次收入金额：");
					// income 表示收入金额
					int income = Utility.readNumber();
					System.out.print("本次收入说明：");
					// illustrate 表示支出的说明
					String illustrate = Utility.readString();
					balance += income;
					info += "收入" + "\t" + balance + "\t\t" + income + "\t\t" + illustrate + "\n"; 
					System.out.println("-------------登记完成-------------");
					break;
				case '3':
					System.out.print("本次支出金额：");
					// expenditure 表示支出金额
					int expenditure = Utility.readNumber();
					System.out.print("本次支出说明：");
					// infomation 表示支出的说明
					String infomation = Utility.readString();
					balance -= expenditure;
					info += "支出" + "\t" + balance + "\t\t" + expenditure + "\t\t" + infomation + "\n"; 
					System.out.println("-------------登记完成-------------");
					break;
				// 退出的逻辑
				case '4':
					System.out.print("确认是否退出( Y / N ):");
					char exit = Utility.readConfirmSelection();
					if(exit == 'Y'){
						falg = false;
					}else{
						break;
					}
					break;
				
			}

		}
	}
}
```

```java
// 工具类
import java.util.Scanner;
/**
	Utility工具类，将不同的功能封装为方法，就是可以直接通过调用方法使用它的功能，无需考虑实现细节
*/
class Utility{
	private static Scanner scanner = new Scanner(System.in);
	/**
		用于界面菜单的选择，如果输入正确字符，则方法返回，返回值为用户输入值，如果输入错误，重新输入
	*/
	public static char readMenuSelection(){
		char c ;
		for(;;){
			String str = readKeyBoard(1);
			c = str.charAt(0);
			if(c != '1' && c != '2' && c != '3' && c != '4'){
				System.out.println("选择错误，请重新输入：");
			}else{
				break;
			}
		}
		return c;
	}
	/**
		用于收入和指出金额的输入，该方法从键盘读取一个不超过四位数长度的整数，并将其作为方法的返回值
	*/
	public static int readNumber(){
		int n;
		for(;;){
			String str = readKeyBoard(4);
			try{
				n = Integer.parseInt(str);
				break;
			}catch(NumberFormatException e){
				System.out.println("数字输入错误，请重新输入：");
			}
		}
		return n;
	}
	/**
		用于收支说明的输入，该方法从键盘读取一个长度不超过8的字符串，并将其作为方法的返回值
	*/
	public static String readString(){
		String str = readKeyBoard(8);
		return str;
	}
	/**
		用于确认选择的输入，该方法从键盘读取y或n，并将其作为方法的返回值
	*/
	public static char readConfirmSelection(){
		char c;
		for(;;){
			String str = readKeyBoard(1).toUpperCase();
			c = str.charAt(0);
			if(c == 'Y' || c == 'N'){
				break;
			}else{
				System.out.println("输入错误，请重新输入:");
			}
			
		}
		return c;
	}
	/**
		该方法用于检测输入的数据是否符合调用该方法的要求，
		一个参数，表示要接受的字符串的最大长度
	*/
	private static String readKeyBoard(int limit){
		String line = "";
		while(scanner.hasNext()){
			line = scanner.nextLine();
			if(line.length() < 1 || line.length() > limit){
				System.out.println("输入错误，请重新输入：");
				continue;
			}
			break;
		}
		return line;
	}
}
```































