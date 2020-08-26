/**
 * <h3>JavaSenior</h3>
 * <p>了解类的加载器</p>
 *
 *
 *
 *
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-24 09:32
 **/

package com.yuanbaoqiang.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClassLoaderTest {

    @Test
    public void test1(){
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // 调用系统类加载的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        // 调用扩展类加载器的getParent()：无法获取引导类加载器
        // 引导类加载器主要加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }




    /*
    * Properties：读取配置文件。
    *
    *
    * */
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        // 默认在当前的module下
        // 读取配置文件的方式一：
        //FileInputStream fis = new FileInputStream("jdbc.properties");
        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");
        pros.load(fis);


        //
/*        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);*/

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.printf("user = %s, password = %s", user, password);

    }
}
