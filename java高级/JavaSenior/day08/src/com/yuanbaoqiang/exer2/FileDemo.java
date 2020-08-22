/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-21 09:04
 **/

package com.yuanbaoqiang.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\JavaLearning\\java高级\\io\\io1\\hello.txt");
        // 创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        System.out.println(destFile);
        if(!destFile.exists()){
            boolean newFile = destFile.createNewFile();
            System.out.println("创建成功");
        }



    }

}
