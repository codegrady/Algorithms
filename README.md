# 算法 Coding And Praticing

## LeetCode
    刷Leetcode 算法题
## NewCoder
    牛客算法
## Standerd
    标准的算法：排序、查找等


## 常用的代码 以及 一些技巧

### 转换

#### char 转 int 
```java
    int x = 0; 
    char c = x - '0'
```
        #### int 转 char
```java
    char c = '0'; 
    int x = c + '0';
```    


## 随机数

### 简单随机数
```java
    double random = Math.random();   ==> [0,1)等概率。
    int x = (int) (Math.random()*K) ; [0 , k-1] 等概率。
```
    
### 随机数的N次方

```java
    //[0,1) x 概率为 x 平方
    double r = Math.max(Math.random(),Math.random());

    //[0,1) x 概率为 x3次方
    double r = Math.max(Math.random(),Math.max(Math.random(),Math.random()));
```
### 随机函数的转化
f（）是[1,5] 等概率，如何返回[1,7]等概率？
f（）函数转化为 [0,1] 等概率
再转化为，[0,7]等概率 

```java
    // [1,5] 等概率
    public static int f(){ 
        return (int)(Math.random*5)+1;
    }   
    
    //[0,1] 等概率
    public static int f1(){
        int ans = 0;
        do{
            ans = f();
        }while(ans == 3);
        return ans < 3 ? 0 : 1;
    }
    //[0,7] 等概率
    public static int f2(){
        return (f1() << 2 ) + (f1() << 1) +f1();
    }
    
    //[1,7] 等概率
    public static int f3(){
        int ans = 0;
        do{
            ans = f2();   
        }while(ans==0);
        return ans;
    }   
```

### 不等概率 转换为 等概率
f() 函数 返回 [0，1] 为不能概率，如何返回 [0，1] 等概率

```java
    //[0,1]不等概率返回
    public static int f(){
        double x = Math.random();
        return x < 0.7?0:1;
    }
    
    //[0,1] 等概率返回
    public static int f1(){
        int ans=0;
        do{
        ans=f();
        }while(ans==f());
        return ans;
    }
```

## 位运算

    

### 位运算实现 加减乘除

#### 加法
    异或运算 <=> 无进位相加
    相加进位信息 => 与运算 左移一位
```java
    int a = 46,b=20;
    a + b == (a^b) + ((a&b)<<1)
    // 不能出现 ‘+’ 
    public static int add(int a,int b){
        int sum = a;
        while(b!=0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
```

#### 减法
利用加法 a - b == a + （-b） 
（-b） == ~b + 1

```java
    public static int negNum(int n){
        return add(~n,1);
    }   
    
    public static int minus(int a,int b){
        return add(a,negNum(b));
    }
```

#### 乘法

```java
    public static int multi(int a, int b){
        int res = 0;
        while(b!=0){
            if((b & 1) != 0){
                res = add(res,a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

```
