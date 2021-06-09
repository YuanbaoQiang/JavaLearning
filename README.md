# java-learning-for-who-is-non-professional

# 简单介绍

本科机械设计专业，偏机构设计及动力学分析。虽然本科学过`C`,  `C#`，用过`Matlab`，但是编程基础不太可。硕士:mortar_board:期间偏学术理论，计算要求使用`Linux`平台，用`Python`科学计算，科研作图等，研究方向与编程:computer:不是特相关。**学术科研**相关的可见仓库：[lammps-data-processing](https://github.com/YuanbaoQiang/lammps-data-processing)，主要为`Python`的数据处理脚本。

~~现在正在转Java中，每天会抽出时间进行学习总结,并上传至个人博客中：~~

~~[国外Github站点](https://yuanbaoqiang.github.io/)（可能比较慢:crying_cat_face:，有时翻墙会好些）~~

~~[国内Coding站点](http://48lxh0.coding-pages.com/)（自动分配的域名，不稳定，速度相比于上一个会快些，由于域名不能跨省备案，所以暂时还没有稳定的个人域名）~~

👆上面删除线的内容，应该是一年前的起草了。笔者自学计算机知识将近一年，有很多的感受和收获，现在要整理回顾一下学习历程，当然，哪怕是工作以后也是会继续学习，也会定期的更新整理。个人自学的内容均在我的[CSDN](https://blog.csdn.net/qyb19970829)博客上。如果觉着有用可以点个star:star2:哦~

# 学习内容

## 面试总结

[学习资料分享](https://docs.qq.com/doc/DUkNicnNSa2RORFV5)

## 计算机组成原理

[计算机组成原理-计算机硬件的基本组成](https://yuanbaoqiang.blog.csdn.net/article/details/110351821)

[计算机组成原理-计算机的功能部件及层次结构](https://yuanbaoqiang.blog.csdn.net/article/details/110499195)

[计算机组成原理-计算机性能指标](https://yuanbaoqiang.blog.csdn.net/article/details/110684216)

[计算机组成原理-数制与编码（进制转换）](https://yuanbaoqiang.blog.csdn.net/article/details/110693683)

[计算机组成原理-定点数的表示和运算](https://blog.csdn.net/qyb19970829/category_10620238.html)

[计算机组成原理-浮点数的表示与运算](https://yuanbaoqiang.blog.csdn.net/article/details/111403293)

[计算机组成原理-算术逻辑单元ALU](https://yuanbaoqiang.blog.csdn.net/article/details/111411183)

[计算机组成原理-存储系统](https://yuanbaoqiang.blog.csdn.net/article/details/111566360)

[计算机组成原理-高速缓冲存储器](https://yuanbaoqiang.blog.csdn.net/article/details/111641400)

[计算机组成原理-指令系统 (指令、操作码、地址码、指令寻址、数据寻址)](https://yuanbaoqiang.blog.csdn.net/article/details/111874663)

[计算机组成原理-中央处理器（CPU基本结构及功能、指令执行、数据通路、硬布线控制器、微程序控制器、指令流水线）](https://yuanbaoqiang.blog.csdn.net/article/details/112133284)

[计算机组成原理-总线（系统总线、总线仲裁、总线操作和定时）](https://yuanbaoqiang.blog.csdn.net/article/details/112186191)

## 操作系统

[操作系统-Operating-System第一章：概述](https://yuanbaoqiang.blog.csdn.net/article/details/109017799)

[操作系统-Operating-System第二章：启动、中断、异常和系统调用](https://yuanbaoqiang.blog.csdn.net/article/details/109059898)

[操作系统-Operating-System第三章01：计算机体系结构及内存分层体系](https://yuanbaoqiang.blog.csdn.net/article/details/109150624)

[操作系统-Operating-System第三章02：地址空间和地址生成](https://yuanbaoqiang.blog.csdn.net/article/details/109207749)

[操作系统-Operating-System第三章03：内存管理方式（连续内存分配）](https://yuanbaoqiang.blog.csdn.net/article/details/109271038)

[操作系统-处理机调度（调度层次、基本准则、先来先服务、最短作业优先、高响应比、时间片轮转、优先级调度、多级反馈队列）](https://yuanbaoqiang.blog.csdn.net/article/details/112441513)

[操作系统-进程同步与互斥及算法实现（单标志、双标志先检查、双标志后检查、中断屏蔽、TSL指令、Swap指令、信号量机制）](https://yuanbaoqiang.blog.csdn.net/article/details/112535290)

[操作系统-进程同步与互斥经典问题（生产者消费者、多生产者多消费者、吸烟者、读写（读优先、写优先、读写公平）、哲学家进餐）](https://yuanbaoqiang.blog.csdn.net/article/details/112665552)

[操作系统-死锁（预防、安全序列、银行家算法图解、检测及解除）](https://yuanbaoqiang.blog.csdn.net/article/details/112756029)

[操作系统-内存分配管理（连续、非连续）](https://yuanbaoqiang.blog.csdn.net/article/details/113104397)

[操作系统-多线程模型（用户级线程和内核级线程）](https://yuanbaoqiang.blog.csdn.net/article/details/113621043)

## 计算机网络

这方面的学习没有及时的总结归纳，但是原博客有一些**内网穿透**的内容。由于课题组的服务器在导师办公室，而导师办公室和学生办公室不在一个局域网，远程连接比较麻烦，所以就想到了采用内网穿透，暴露内网端口进行远程多用户`ssh`连接，进行作业计算。不过前期也是踩了很多坑，导致服务器被黑客端口扫描攻击，文档全被加密，所以对于网络安全的问题切记要注意！

[【反向代理】-Ubuntu服务器实现多用户SSH登陆及Sakura Frp内网穿透](https://yuanbaoqiang.blog.csdn.net/article/details/109598305)（此方式不建议使用）

[【反向代理】远程连接安全配置](https://www.jianguoyun.com/p/DT9AUJMQv86nCBjpodUD)（建议自己申请一台云服务器，比较方便）

## 数据结构与算法

这方面的学习是直接通过刷题来的，解题过程都在**力扣刷题📂**（持续更新）中。

另外附上个人的一些总结性博客：

[回溯算法-层次化理解回溯过程](https://yuanbaoqiang.blog.csdn.net/article/details/113727380)

[十大排序算法—这一篇远远不够](https://yuanbaoqiang.blog.csdn.net/article/details/112971465)

[三张图简单理解回溯算法](https://yuanbaoqiang.blog.csdn.net/article/details/113665450)

待更新...

## Linux基础

`Linux`的学习始于装系统，然后一些开源软件、GPU加速的配置、以及自启动服务、内网穿透服务等环境的搭建，所以并无系统性的学习相关的基础理论知识，也只是会用一些常用的命令。附上我的一些博客记录：

[Ubuntu-RTL8812BU无线网卡安装]()

[Ubuntu-离线安装基本依赖（gcc、make、dkms等）](https://yuanbaoqiang.blog.csdn.net/article/details/109596767)

待更新...

# 额外补充

### git, wget, curl速度太慢的解决办法

> 挂VPN，然后bash界面socks5代理

#### Windows

如果ip为127.0.0.1, 端口为<font color=red>1080</font>

##### 走http

```bash
git config --global http.proxy 'socks5://127.0.0.1:1080'
```

##### 走https

```bash
git config --global https.proxy 'socks5://127.0.0.1:1080'
```

##### 取消代理

```java
git config --global --unset http.proxy
git config --global --unset https.proxy
```

#### Linux

##### 走https

```bash
export http_proxy=http://127.0.0.1:1080
```

##### 走https

```bash
export https_proxy=http://127.0.0.1:1080
```

##### 取消代理

关闭该bash窗口即可