---
title: Java基础14（异常）
date: 2020-08-06 19:01:49
tags: Java
category: Java基础
---

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200806210624.png)

<!--more-->

# 异常分类

Java中，所有的异常对象都是派生于`throwable`类的一个类实例，以下分为`Error`和`Exception`。其中`Error`为Java运行时的内部错误和资源耗尽错误，用户无需在程序中捕捉或者抛出`Error`。另外一种则为`Exception`，用户需要对异常妥善处理。

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200806201604.png)



## 检查异常和非检查异常

### 检查异常(checked)

一般是指程序不能直接控制的外界情况，是指在编译的时候就需要检查的一类`Exception`，<font color=orange>用户程序中必须采用try catch机制处理或者通过throws交由调用者来处理</font>。这类异常，主要指<font color=red>除了Error以及RuntimeException及其子类</font>之外的异常。

```java
@Test
public void test2(){
    FileInputStream fis = null;

    try {
        File file = new File("hello.txt");
         fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.print((char)data);
            data = fis.read();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        try {
            if(fis != null){
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
```

### 非检查异常(unchecked)

是指那些不需要在编译的时候就要处理的一类异常。在Java体系里，所有的`Error`以及`RuntimeException`及其子类都是unchecked异常。再形象直白的理解为不需要`try` `catch`等机制处理的异常，可以认为是unchecked的异常。

## 运行时异常和编译时异常

### 运行时异常

都是`RuntimeException`类及其子类异常，例如`NullPointerException`(空指针异常)、`IndexOutOfBoundsException`(下标越界异常)等，这些异常是非检查异常，程序中可以选择捕获处理，也可以不处理。这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生。

### 编译时异常

是`RuntimeException`以外的异常，类型上都属于`Exception`类及其子类。从程序语法角度讲是<font color=orange>必须进行处理的异常</font>，如果不处理，程序就不能编译通过。如`IOException`、`SQLException`等以及用户<font color=red>自定义的Exception异常</font>。

# 异常处理

## 异常捕获

**try-catch-finally**

`try`: 可能出现异常的代码段

`catch`: 对应的异常类型 变量名

> 多个异常的捕获(多个catch)，<font color=orange>如果多个异常出现继承关系，则需要将超类放在下方。</font>

`finally`: <font color = red>一定会执行的代码段(在return、throw之前)</font>

> 像数据库连接、输入输出流、网络编程中的Socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源的释放，此时的资源释放，就需要声明在finally中。

```java
class Demo  
{  
    int div(int a,int b) throws ArithmeticException,ArrayIndexOutOfBoundsException//在功能上通过throws的关键字声明该功能可能出现问题  
    {  
        int []arr = new int [a];  
  
        System.out.println(arr[4]);//制造的第一处异常  
  
        return a/b;//制造的第二处异常  
    }  
}  
  
  
class ExceptionDemo  
{  
    public static void main(String[]args) //throws Exception  
    {  
        Demo d = new Demo();  
  
        try  
            {  
                int x = d.div(4,0);//程序运行截图中的三组示例 分别对应此处的三行代码  
                //int x = d.div(5,0);  
                //int x = d.div(4,1);  
                System.out.println("x="+x);   
        }  
        catch (ArithmeticException e)  
        {  
            System.out.println(e.toString());  
        }  
        catch (ArrayIndexOutOfBoundsException e)  
        {  
            System.out.println(e.toString());  
        }  
        catch (Exception e)//父类 写在此处是为了捕捉其他没预料到的异常 只能写在子类异常的代码后面  
                            //不过一般情况下是不写的   
        {  
            System.out.println(e.toString());  
        }  
          
  
  
        System.out.println("Over");  
    }  
  
}

```



## 异常抛出

`throws` 通常在一个方法（类）的声明处通过 `throws` 声明方法（类）可能拋出的异常信息

`throw` 表示抛出一个异常类的对象，生成异常对象的过程，声明在方法体内

> throws到最后，在main方法中需要try-catch捕获异常，否则报错。

```java
public class ExceptionTest2 {

    public static void main(String[] args){
        method3();
    }

    @Test
    public static void method3(){
        try{
            method2();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    @Test
    public static void method2() throws IOException{
        method1();
    }


    @Test
    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.print((char)data);
            data = fis.read();
        }
        fis.close();
    }
}
```

> 如果父类中被重写的方法没有throws方法处理异常，则子类重写的方法也不能使用throws；
>
> 子类重写的方法抛出的异常类型<font color=orange>不大于父类被重写的方法抛出的异常类型</font>。

```java
public class OverrideTest {
    public static void main(String[] args) {
        OverrideTest test = new OverrideTest();
        test.display(new Subclass());

    }

    public void display(SuperClass s){
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class SuperClass{

    public void method() throws IOException {

    }
}

class Subclass extends SuperClass{
    @Override
    public void method() throws FileNotFoundException {

    }
}
```

# 自定义异常类

> 1. 继承于现的异常结构：`RuntimeException` 、`Exception`
> 2. 提供全局常量：`serialVersionUID`
> 3. 提供重载的构造器

```java
public class EcDef extends Exception{
    static final long serialVersionUID = -70348971455766939L;

    public EcDef(){

    }

    public EcDef(String msg){
        super(msg);
    }

}
```

```java
public class EcmDef {
    public static void main(String[] args) {
        try{
            int i = Integer.parseInt(args[0]); // 分子
            int j = Integer.parseInt(args[1]); // 分母
            int result = ecm(i, j); // 调用ecm方法
            System.out.println(result);
        }catch (NumberFormatException e){
            System.out.println("数据类型不一致！");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数！");
        }catch(ArithmeticException e){
            System.out.println("除0");
        }catch(EcDef e){
            System.out.println(e.getMessage());
        }
    }

    public static int ecm(int i, int j) throws EcDef{ // 指向自己定义的异常类
        if(i < 0 || j < 0){
            throw new EcDef("分子或分母为负数了！");
        }
        return i/j;
    }
    
}
```

