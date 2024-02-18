# 第四章 工程与模块化管理

## 1.1 Project和Module的概念

在idea中，提出了Project和Module这两个概念

在idea中，Project是最顶级的结构单元，然后就是Module。目前，主流的大型项目都是多Module结构，这类项目一般按功能划分，比如：user-core-module、user-facade-module和user-hessian-module等等，模块之间彼此可以相互依赖，有着不可分割的业务关系，因此对于一个project而言：

* 当为单module项目的时候，这个单独的module就是project
* 当为多module项目的时候，多个模块处于同一个project中，此时彼此之间具有相互依赖的关联关系
* 当多个模块没有建立依赖关系的话，可以作为一个小项目运行

## 1.2 Module和Package

在一个module下，可以声明多个包，一般命名规范如下：

* 不要有中文

* 不要以数字开头

* 给包取名时一般都是公司域名倒着写，而且都是小写

  比如：www.HankMiller.vip

  包名应该是`vip.HankMiller`



# 第五章 数组

## 5.1 数组的概述和一维数组的使用

### 5.1.1 数组的概述

#### 5.1.1.1 数组的概念

* 数组，是多个相同类型的数据按一定顺序排列的集合，并使用一个名字命名，并通过编号的方式对这些数据进行统一的管理

#### 5.1.1.2 几个相关的概念

1. 数组名
2. 数组的元素
3. 数组的下标、角标、下角标、索引、index(即找到指定数组元素的索引)
4. 数组的长度(数组容器中存储的元素的个数)

#### 5.1.1.3 数组的特点

1. 数组中的元素在内存中是依次紧密排列的，有序的
2. 数组是引用数据类型的变量，数组的元素，既可以是基本数据类型也可以是引用数据类型
3. 数组，一旦初始化完成，其长度就确定了，并且其长度不可更改
4. 创建数组对象会在内存中开辟一整块连续的空间，占据的空间大小，取决于数组的长度和数组元素的类型

#### 5.1.1.4 数组的分类

1. 按照元素的类型，基本数据类型元素的数组，引用数据类型元素的数组
1. 按照数组的维数来分

### 5.1.2 一维数组的使用(6个基本点)

1. 一维数组的声明和初始化

   ```java
   // 1. 数组的声明和初始化
           // 声明
           double[] arr;
           // double arr[] = new double[3];
           // 初始化 静态初始化
           arr = new double[]{1,2,3,4};
           // 以下方式是一种省略写法
           // int arr[] = {1,2,3,4};
   
           // 声明的同时初始化 静态初始化
           String[] foods = new String[]{"汉堡","薯条","可乐"};
           // String foods[] = {"汉堡","薯条","可乐"};
           // String foods[] = new String[3];
           // 声明 并且规定数组长度 动态初始化
           String[] gifts = new String[3];
           //  String gifts[] = new String[3];
   ```

   

1. 调用数组的指定元素

   ```java
   // 2. 数组的调用
           // 通过角标的方式，获取数组的元素
           // 角标的范围从0开始到-1结束
           System.out.println(foods[0]);
           // 报错ArrayIndexOutOfBoundsException
           // 原因是越界
           // System.out.println(foods[3]);
   ```

   

1. 数组的属性，length表示数组的长度

   ```java
   // 3. 数组的长度：用来描述数组容器中容量的大小
           // 使用length表示
           System.out.println(gifts.length);
   ```

   

1. 数组的遍历

   ```java
   // 4. 如何遍历数组
           for (int i = 0; i < arr.length; i++) {
               System.out.println(arr[i]);
           }
   ```

   

1. 数组的默认初始化值

   ```java
           int test[] = new int[3];            // 0
           double test1[] = new double[3];     // 0.0
           long test2[] = new long[3];         // 0
           boolean test3[] = new boolean[3];   // false
           String test4[] = new String[3];     // null
           char test5[] = new char[3];         // 0 / '\u0000'
   ```

   

1. 一维数组的内存解析

   1. java中的内存结构是如何划分的？
      * 将内存区域分为五个部分：程序计数器、虚拟机栈、本地方法栈、堆、方法区
      * 与目前数组的存储结构
        * 虚拟机栈，用于存放方法中声明的变量名和数组首地址
        * 堆，用于存放数组的实体(即数组中所有的元素)

1. 一维数组案例

   1. 

   ```java
   /*
   	破解房东电话
   	单间短期出租四个月，550/月(水电煤公摊，网费35/月)，空调卫生间厨房齐全，屋内均为IT人士，要求租客是同行或刚毕业，爱干净、安静
   */
   int[] arr = new int[]{8,2,1,0,3};
   int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
   String tel = "";
   for (int i = 0; i < index.length; i++) {
       int value = index[i];
       tel += arr[value];
   }
   System.out.println("联系方式：" + tel);
   ```
   2. 输出英文星期几
   
      ```java
      /*
      	用一个数组，保存一到七的英语单词。从键盘输入1-7.输出相应单词
      */
      String day[] = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入1-7：");
      int input = scanner.nextInt();
      System.out.println("您输入的是：" + day[input - 1]);
      
      ```
   
   3. 学生考试等级划分
   
      ```java
      /*
      	从键盘读入学生成绩，找出最高分，并输出学生成绩等级
      	成绩 >= 最高分 - 10 		等级为'A'
      	成绩 >= 最高分 - 20 		等级为'B'
      	成绩 >= 最高分 - 30  	等级为'C'
      	其他					 等级为'D'
      	先读入学生人数，根据人数创建int数组，存放学生成绩
      */
      // 接收数据
      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入学生人数：");
      int numOfPeople = scanner.nextInt();
      int achievement[] = new int[numOfPeople];
      System.out.println("请输入各自成绩：");
      for (int i = 0; i < achievement.length; i++) {
          achievement[i] = scanner.nextInt();
      }
      // 找最高成绩
      int maxAchievement = 0;
      for (int i = 0; i < achievement.length; i++) {
          if (achievement[i] > maxAchievement) {
              maxAchievement = achievement[i];
          }
      }
      
      System.out.println("成绩最高的分数是：" + maxAchievement);
      System.out.println("按您输入的顺序，等级依次为：");
      for (int i = 0; i < achievement.length; i++) {
          if (achievement[i] >= maxAchievement - 10) {
              System.out.println("student" + i + " score is " + achievement[i]+ " grade is" + 'A');
          } else if (achievement[i] >= maxAchievement - 20) {
              System.out.println("student" + i + " score is " + achievement[i]+ " grade is" + 'B');
          } else if (achievement[i] >= maxAchievement - 30) {
              System.out.println("student" + i + " score is " + achievement[i]+ " grade is" + 'C');
          } else {
              System.out.println("student" + i + " score is " + achievement[i]+ " grade is" + 'D');
          }
      
      }
      ```

## 5.2 多维数组的使用

### 5.2.1 声明与初始化

```java
// 1. 二维数组的声明与初始化
// 方式1：静态初始化：数组变量的赋值和数组元素的赋值同时进行
int arr[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
// 方式2：动态初始化：数组变量的赋值和数组元素的赋值分开进行
int arr1[][] = new int[3][3];
// 方式3：动态初始化的第二种写法
int arr2[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9,10}};
// 其他正确的写法
int arr3[][] = {{1,2,3},{4,5,6},{7,8,9}};

// 2. 数组元素的调用
System.out.println(arr[1]);

// 3. 数组的长度
System.out.println(arr.length);     //输出的是外层的长度

// 4. 遍历数组
for (int i = 0; i < arr2.length; i++) {
    for (int j = 0; j < arr2[i].length; j++) {
        System.out.println(arr2[i][j]);
    }
}
// 5. 数组元素的默认初始化值
```

### 5.2.2 数组的默认初始化值

1. 数组的默认初始化值

   ```java
   int arr1[][] = new int[2][2];           // 0
   short arr2[][] = new short[2][2];       // 0
   long arr3[][] = new long[2][2];         // 0
   double arr4[][] = new double[2][2];     // 0.0
   char arr5[][] = new char[2][2];         // 0 / '\u0000'
   boolean arr6[][] = new boolean[2][2];   // false
   String arr7[][] = new String[2][2];     // null
   
   int arr[][] = new int[2][];// 外层null 内层空指针异常
   ```

   

### 5.2.3 案例

1. 计算以下表格中的总和

   | i/j   | j = 0 | j = 1 | j = 2 | j = 3 |
   | ----- | ----- | ----- | ----- | ----- |
   | i = 0 | 3     | 5     | 8     | null  |
   | i = 1 | 12    | 9     | null  | null  |
   | i = 2 | 7     | 0     | 6     | 4     |

   ```java
   int arr[][] = {{3,5,8},{12,9},{7,0,6,4}};
   int sum = 0;
   for (int i = 0; i < arr.length ; i++) {
       for (int j = 0; j < arr[i].length; j++) {
           sum += arr[i][j];
       }
   }
   System.out.println(sum);
   ```

1. 声明：`int[] x,y[];`在给xy变量赋值以后，以下选项允许通过编译的是：

   1. `x[0] = y;`不可以
   1. `y[0] = x;` 可以
   1. `y[0][0] = x;不可以`
   1. `x[0][0] = y;不可以`
   1. `y[0][0] = x[0];可以`
   1. `x = y;不可以`

1. 二维数组存储数据，并遍历

   ```java
   String employees = {
       {"10","1","张三","22","5000"},
       {"13","2","李四","22","5000","10000","20000"},
       {"12","3","王五","22","5000"},
       {"11","4","赵六","22","5000"},
       {"12","5","李星云","22","5000","20000","30000"},
       {"13","6","姬如雪","22","5000"},
       {"11","7","陆林轩","22","5000"},
       {"10","8","张子凡","22","5000"},
       {"11","9","张楚岚","22","5000",,"20000","30000"},
       {"12","10","宝儿姐","22","5000"},
       {"10","11","袁天罡","22","5000",,"20000","30000"},
       {"11","12","李淳风","22","5000"},
       {"11","13","唐玄宗","22","5000"},
       {"11","14","李世民","22","5000"},
   }
   // 10 代表普通职员 11 代表程序员  12 代表设计师 13代表架构师
   ```

## 5.3 常见算法

### 5.3.1 数值型数组特征值统计(平均值、最大最小值、总和等)

1. 定义一个int型的一维数组，包含十个元素，分别赋予一些随机整数，然后求出所有元素的最大值，最小值，总和，平均值，并输出(要求所有随机数都是两位数)

   ```java
   int arr[] = new int[10];
   for (int i = 0; i < 10; i++) {
       arr[i] = (int)(Math.random() * 90) + 10;
       System.out.print(arr[i] + "\t");
   }
   // max
   int maxNum = arr[0];
   for (int i = 1; i < 10; i++) {
       if(arr[i] > maxNum){
           maxNum = arr[i];
       }
   }
   // min
   int minNum = arr[0];
   for (int i = 1; i < 10; i++) {
       if(arr[i] < minNum){
           minNum = arr[i];
       }
   }
   // sum
   int sum = 0;
   for (int i = 0; i < 10; i++) {
       sum += arr[i];
   }
   // average
   int average = sum / 10;
   
   System.out.println("最大值为：" + maxNum);
   System.out.println("最小值为：" + minNum);
   System.out.println("总和为：" + sum);
   System.out.println("平均值为：" + average);
   ```

2. 评委打分：再编程竞赛中，有十位评委为参赛的选手打分，分数分别为`5,4,6,8,9,0,1,2,7,3`，求选手的最后得分(去掉一个最高分，去掉一个最低分，求平均值)

   ```java
   int score[] = {5,4,6,8,9,0,1,2,7,3};
   int maxScore = score[0];
   int minScore = score[0];
   int sum = 0;
   for (int i = 0; i < score.length; i++) {
       if(maxScore < score[i]){
           maxScore = score[i];
       }
       if(minScore > score[i]){
           minScore = score[i];
       }
       sum += score[i];            
   }
   sum = sum - maxScore - minScore;
   System.out.println("最后得分为：" + (sum / 8));
   ```

      

### 5.3.2 数组元素的赋值

1. 使用二维数组打印一个10行杨辉三角，第一行一个元素，第n行n个元素，每一行开始元素和最后元素都是1，从第三行开始，对于并非第一个元素和最后一个元素的元素，即`yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j]`

   * 自己写的(有问题)

     ```java
     int[][] yangHuiTriangle = new int[10][10];
     yangHuiTriangle[0][0] = 1;
     yangHuiTriangle[1][0] = 1;
     yangHuiTriangle[1][1] = 1;
     for (int i = 2; i < 10; i++) {
         for (int j = 0; j < i; j++) {
             if(j == 0){
                 yangHuiTriangle[i][j] = 1;
             }else if((j + 1) == i){
                     yangHuiTriangle[i][j] = 1;
             }else{
                 yangHuiTriangle[i][j] = yangHuiTriangle[i-1][j-1] + yangHuiTriangle[i-1][j];
             }
         }
     }
     for (int[] ints : yangHuiTriangle) {
         System.out.println("");
         for (int anInt : ints) {
             System.out.print(anInt + " ");
         }
     }
     // 输出为
     // 1 0 0 0 0 0 0 0 0 0
     // 1 1 0 0 0 0 0 0 0 0
     // 1 1 0 0 0 0 0 0 0 0
     // 1 2 1 0 0 0 0 0 0 0
     // 1 3 3 1 0 0 0 0 0 0
     // 1 4 6 4 1 0 0 0 0 0
     // 1 5 10 10 5 1 0 0 0 0
     // 1 6 15 20 15 6 1 0 0 0
     // 1 7 21 35 35 21 7 1 0 0
     // 1 8 28 56 70 56 28 8 1 0
     ```

   * 老师写的(没问题)

     ```java
     // 创建数组
     int[][] yangHuiTriangle = new int[10][];
     // 使用循环初始化外层元素
     for (int i = 0; i < yangHuiTriangle.length; i++) {
         yangHuiTriangle[i] = new int[i + 1];
         // 给元素赋值
         // 给首末元素赋值为1；
         yangHuiTriangle[i][0] = 1;
         yangHuiTriangle[i][i] = 1;
         // 给非首末元素赋值
         for (int j = 1; j < yangHuiTriangle[i].length - 1; j++) {
             yangHuiTriangle[i][j] = yangHuiTriangle[i - 1][j - 1] + yangHuiTriangle[i - 1][j];
         }
     }
     for (int[] ints : yangHuiTriangle) {
         System.out.println("");
         for (int anInt : ints) {
             System.out.print(anInt + " ");
         }
     }
     ```

   * <span style="color:red;">`要先分析清楚，再开始动手，先用注释写好过程，再用代码实现`</span>

1. 生成三十个不重复的随机数

   ```java
   // 步骤2: 创建一个数组来存放不重复的随机数
   int[] uniqueNumbers = new int[30];
   int count = 0;
   
   // 步骤3: 生成30个不重复的随机数
   while (count < 30) {
       // 生成随机数
       int randomNumber = (int)(Math.random() * 90) + 10;
   
       // 检查随机数是否已经存在于数组中
       boolean alreadyExists = false;
       for (int i = 0; i < count; i++) {
           if (uniqueNumbers[i] == randomNumber) {
               alreadyExists = true;
               break;
           }
       }
   
       // 如果随机数不存在于数组中，则添加到数组中
       if (!alreadyExists) {
           uniqueNumbers[count] = randomNumber;
           count++;
       }
   }
   
   // 步骤4: 打印生成的数组
   System.out.println("生成的随机数数组：");
   System.out.println(Arrays.toString(uniqueNumbers));
   ```

1. 输入一个数字n，生成一个由回形数组成的n阶矩阵，如：输入3，输出

   `123`

   `894`

   `765`

   ```java
   // 输入一个数字n，输出一个回形数
   Scanner scanner = new Scanner(System.in);
   System.out.print("请输入一个数字：");
   int n = scanner.nextInt();
   int[][] arr = new int[n][n];
   // 数组中最大的数字
   int s = n * n;
   // 数字填充进行的方向
   int k = 1;
   /*
   * k : 1 向右
   * k : 2 向下
   * k : 3 向左
   * k : 4 向上
   * */
   // 边界
   int top = 0;
   int left = 0;
   int right = n -1;
   int bottom = n -1;
   // 需要填充的数字
   int num = 1;
   while (num <= s){
       // 向右 变上界
       if(k == 1){
           for (int i = left; i <= right; i++) {
               arr[top][i] = num++;
           }
           top++;
       // 向下 变右界
       }else if(k == 2){
           for (int i = top; i <= bottom; i++) {
               arr[i][right] = num++;
           }
           right--;
       // 向左 变下界
       }else if(k == 3){
           for (int i = right; i >= left; i--) {
               arr[bottom][i] = num++;
           }
           bottom--;
       // 向上 变左界
       }else{
           for (int i = bottom; i >= top; i--) {
               arr[i][left] = num++;
           }
           left++;
       }
       k = (k + 1) % 4;
   }
   // 输出
   for (int i = 0; i < n; i++) {
       System.out.println("");
       for (int j = 0; j < n; j++) {
           System.out.print("\t" + arr[i][j]);
       }
   }
   ```

   

### 5.3.3 数组的复制

1. 定义一个八个素数的数组，复制该数组

   ```java
   int[] arr = new int[]{2,3,5,7,11,13,17,19};
   int[] arr1 = new int[arr.length];
   for (int i = 0; i < arr.length; i++) {
       arr1[i] = arr[i];
   }
   ```

### 5.3.4 数组的反转

1. 定义数组，并实现反转

   ```java
   // 第一种方式
   int[] arr1 = new int[arr.length];
   // 反转后数组的索引
   int index = 0;
   for (int i = arr.length - 1; i >= 0; i--) {
       arr1[index] = arr[i];
       index++;
   }
   
   // 第二种方式
   for (int i = 0; i < (arr.length / 2) - 1; i++) {
       int temp = arr[i];
       arr[i] = arr[arr.length - 1 - i];
       arr[arr.length - 1 - i] = temp;
   }
   ```

### 5.3.5 数组的扩容和缩容

1. 数组扩容，现有长度为5的数组，要将数组长度扩容到一倍，并将10，20，30三个元素添加到数组中

   ```java
   int[] arr = new int[]{1,2,3,4,5};
   int[] newArr = new int[2 * arr.length];
   for (int i = 0; i < newArr.length; i++) {
       if(i == arr.length){
           newArr[i] = 10;
           newArr[i + 1] = 20;
           newArr[i + 2] = 30;
       }else if(i < arr.length){
           newArr[i] = arr[i];
       }
   }
   ```

1. 数组缩容，现有长度为7的数组，需要删除数组中索引为4的元素

   ```java
   // 不需要新建数组
   int[] arr = new int[]{1,2,3,4,5,6,7};
   // 要删除的元素的索引
   int index = 4;
   for (int i = index; i < arr.length - 1; i++) {
       arr[i] = arr[i + 1];
   }
   arr[arr.length - 1] = 0;
   for (int j: arr) {
       System.out.println(j);
   }
   
   // 需要新建数组
   int[] arr = new int[]{1,2,3,4,5,6,7};
   int[] newArr = new int[arr.length - 1];
   for (int i = 0; i < arr.length; i++) {
       if(i != 4){
           if(i < 4){
               newArr[i] = arr[i];
           }else{
               newArr[i-1] = arr[i];
           }
       }
   }
   ```

   

### 5.3.6 数组元素的查找

1. 定义数组，查找元素5是否在数组中出现过，如果出现过，输出索引

   ```java
   int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
   int index = -1;
   for (int i = 0; i < arr.length; i++) {
       if(arr[i] == 5){
           index = i;
       }
   }
   ```

1. 二分法做第一题

   * 二分法必须是有序数组

   ```java
   int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
   int low = 0;
   int high = arr.length - 1;
   int mid = -1;
   while (low <= high){
       mid = low + (high - low) / 2;
   
       if(arr[mid] == 5){
           break;
       }else if(arr[mid] < 5){
           low = mid + 1;
       }else if(arr[mid] > 5){
           high = mid - 1;
       }else{
           mid = -1;
       }
   }
   System.out.println(mid);
   ```

### 5.3.7 数组的排序

* 排序算法的衡量标准(时间复杂度，空间复杂度，稳定性)

* 排序的分类

  * 内部排序(内存中排序)和外部排序(外部存储设备和内存)

  ![](E:\workspace\noteImage\1.png)

* 排序内部的实现细节

1. 冒泡排序

   ```java
   int[] arr = new int[]{4,1,2,6,8,9,7,5,3,0};
   for (int i = 0; i < arr.length - 1; i++) {
       for (int j = 0; j < arr.length - 1 - i; j++) {
           int temp;
           if(arr[j] > arr[j + 1]){
               temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
           }
       }
   }
   ```

   

1. 快速排序(开发中默认使用的方法)

   ```java
   // 使用递归的方法
   
   ```



## 5.4 工具类的使用和常见异常

### 5.4.1 工具类的使用

数组的常用方法：

```java
// 1. boolean equals(int[] a,int[] b)比较两个数组的元素是否依次相等
// int[] a = new int[]{1, 2, 3};
// int[] b = new int[]{1, 2, 3};
// System.out.println(Arrays.equals(a, b));

// 2. String toString(int[] a); 输出数组元素信息
// int[] a = new int[]{1,2,3};
// System.out.println(Arrays.toString(a));

// 3. void fill(int[] a,int val) 将指定值填充到数组之中
// int[] a = new int[]{1,2,3};
// Arrays.fill(a,10);
// System.out.println(Arrays.toString(a));

// 4. void sort(int[] a) 使用快速排序算法实现的排序
// int[] a = new int[]{4,1,5,7,8,2};
// Arrays.sort(a);
// System.out.println(Arrays.toString(a));

// 5. int binarySearch(int[] a,int key) 二分查找
// int[] a = new int[]{1,2,3,4,5,6,7,8,9};
// int index = Arrays.binarySearch(a,5);
// System.out.println(index);
```



### 5.4.2 常见异常

1. 数组角标越界异常: `ArrayIndexOutOfBoundsException`
1. 空指针异常：`NullPointerException`