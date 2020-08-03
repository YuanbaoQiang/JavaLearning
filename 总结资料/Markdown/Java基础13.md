---
title: Java基础13（抽象类、接口、内部类）
date: 2020-08-03 07:37:49
tags: Java
category: Java基础
---

![](https://cdn.jsdelivr.net/gh/YuanbaoQiang/PicGoBed/img/20200803102846.png)

<!--more-->

# 关键词: `abstract`

如果自下而上在类的继承结构中上移，那么位于上层的类就更具有一般性，可能更抽象。超类或者祖先类一般更具有普遍性，不会定义更为详细的方法或功能。例如学生-->人类-->生物，此时生物作为祖先类，不能直接一定到下属成员的具体功能，比如学生学习、唱歌等，一般通过定义一个关键字关键词: `abstract`，然后子类进行改写其方法。

`abstract`通常可以用来修饰类和方法。`abstract`修饰类为抽象类，`abstract`修饰方法为抽象方法。

## 抽象类

> 1. 此类不可以被实例化；
> 2. 抽象类必须要有构造器，便于子类对象实例化调用。

## 抽象方法

> 1. <font color=orange>包含一个或者多个抽象方法的类本身就必须被声明为抽象的；</font>
> 2. 抽象方法必须<font color=orange>不含方法体;</font>
> 3. 子类（可实例化，非`abstract`修饰）必须对父类中的抽象方法进行重写；否则该子类也无法被实例化，需要用`abstract`修饰成为抽象类。

```java
abstract class School{
    // 静态方法不含方法体
    // 正确的写法
    public abstract void show();
    
    // 错误的写法
/*    public abstract void display(){
        // 方法体
    }*/
}
```

# 接口（interface）

> 在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。

接口不是类，和类属于并列关系。

类包含对象的属性和方法，接口则包含类可以实现的方法或功能。

接口无法被实例化，但是可以被实现。因此<font color=red>在接口定义中绝对不能有构造器</font>。

## JDK7之前

> 只能定义全局常量和抽象方法

### 全局常量

修饰符：`public static final`，但是在`interface`范围内书写可省略。

```java
interface Flyable{
    // 全局常量
    // 完整书写
    public static final int MAX_SPEED = 7900; // 第一宇宙速度
    // 省略书写
    // 省略public static final
    int MIN_SPEED = 1; // 省略了 public static final
}
```

### 抽象方法

修饰符：`public abstract`，但是在`interface`范围内书写可省略。

```java
interface Flyable{
    // 抽象方法
    // 完整书写
    public abstract void fly();

    // 省略书写
    // 省略了public abstract
    void stop();
}
```

## JDK8及以后

除了全局常量和抽象方法外，<font color=orange>还可以定义静态方法和默认方法</font>。

**接口CompareA**

```java
public interface CompareA {
    // 静态方法
    public static void method1(){
        System.out.println("CompareA：北京");
    }


    // 默认方法
    public default void method2(){
        System.out.println("CompareA：上海");
    }


    public default void method3(){
        System.out.println("CompareA：method3");
    }

}
```

**接口CompareB**

```java
public interface CompareB {
    public default void method3(){
        System.out.println("CompareB：method3");
    }
}
```

### 静态方法

```java
// 静态方法
public static void method1(){
    System.out.println("CompareA：北京");
}
```
#### 静态方法只能通过接口来调用

```java
SubClass s = new SubClass();
// 知识点1：接口中定义的静态方法，只能通过接口来调用
CompareA.method1()；
```

### 默认方法

```java
// 默认方法
public default void method2(){
    System.out.println("CompareA：上海");
}
```
#### 默认方法只能通过实现类的对象来调用

```java
// 知识点2：通过实现类的对象，可以调用接口中的默认方法
s.method2();
```

## 接口冲突

如果实现类实现了多个接口，而这多个接口定义了同名同参数的默认方法，比如`CompareA`和`CompareB`中的`method3`默认方法，那么在实现类没有重写此方法的情况下，将会产生接口冲突，报错。

## 类优先原则

如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法，那么子类在没有重写此方法的情况下，默认是父类中的同名同参数的方法。

## 接口的属性

在`C++`中，一个类允许有多个超类（多重继承-multiple inheritance），但是在Java中，类只能有一个父类，通过扩展多个接口，弥补了Java的单继承性。

```java
class Bullet extends Object implements Flyable, Attackable, CC{
    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }


    @Override
    public void attack() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}
```

### 接口扩展

从通用性较高的接口扩展到专用性较高的接口。

```java
interface AA{
    void method1();
}

interface BB{
    void method2();
}

interface CC extends AA,BB{

}
```

# 内部类（inner class）（用到后继续补充）

> 1. 内部类方法可以访问该类定义所在的作用域中的数据，包括私有的数据；
> 2. 内部类可以对同一个包中的其他类隐藏起来；
> 3. 用匿名内部类来定义回调函数会方便很多；
> 4. 内部类能独立地继承一个（接口的）实现，无论外围类是否已经继承了某个（接口的）实现，对于内部类没有影响。

**一方面，作为外部类的成员：**

1. 调用外部类的结构；
2. 可以被static修饰；
3. 可以被四种不同的权限修饰。

**另一方面，作为一个类：**

1. 类内可以定义属性、方法、构造器等；
2. 可以被final修饰，表示此类不能被继承，言外之意，不适用final就可以被继承；
3. 可以被abstract修饰。

**内部类传送门**：[Java内部类](https://www.cnblogs.com/chengjinsheng/p/13396542.html)、[java内部类（代码演示）](https://blog.csdn.net/weixin_44038165/article/details/107586931)



