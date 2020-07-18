# JavaLearning

> 这是元宝:sun_with_face:的Java学习笔记

## 简单介绍

本科机械设计专业，偏机构设计及动力学分析。虽然本科学过C,C#，用过Matlab，但是编程基础不太可，毕竟非科班。硕士:mortar_board:期间偏学术，在用Linux，用Python科学计算，科研作图等，研究方向与代码不是特相关。

现在正在转Java中，每天会抽出时间进行学习总结,并上传至个人博客中：

[国外Github站点](https://yuanbaoqiang.github.io/)（可能比较慢:crying_cat_face:，有时翻墙会好些）

[国内coding站点](http://48lxh0.coding-pages.com/)（自动分配的域名，不稳定，速度相比于上一个会快些，由于域名不能跨省备案，所以暂时还没有稳定的个人域名）

所以一起加油吧！如果觉着有用可以点个star:star2:哦~

## 仓库文件

1. 黑马的课件，内含pdf总结文档及源代码；
2. Markdown（`.md`）文件；
3. IDEA的项目文件，`.java`文件在src文件夹中。
4. 一些文档资料在<font color=red>书籍资料</font>文件夹:file_folder:中

## 注意事项

> git, wget, curl速度太慢的解决办法：socks5代理。

### Windows

ip为127.0.0.1, 端口为<font color=red>1080</font>

走http

```bash
git config --global http.proxy 'socks5://127.0.0.1:1080'
```

走https

```bash
git config --global https.proxy 'socks5://127.0.0.1:1080'
```

取消代理

```java
git config --global --unset http.proxy
git config --global --unset https.proxy
```

### Linux

如果你是SSR,并且走的http的代理端口是<font color=red>12333</font>，想执行wget或者curl来下载国外的东西，可以使用如下命令：

```bash
export http_proxy=http://127.0.0.1:12333
```

如果是https那么就经过如下命令：

```bash
export https_proxy=http://127.0.0.1:12333
```