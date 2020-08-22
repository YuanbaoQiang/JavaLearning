/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-21 09:22
 **/

package com.yuanbaoqiang.exer2;

import java.io.File;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<File> arr = new ArrayList<>();

        File file = new File("D:\\JavaLearning");
        ArrayList<File> files = listAllFiles(arr,file);
        print(files);


    }


    /*
     * @description: 获取目标文件目录的所有文件
     * @author: YuanbaoQiang
     * @date: 2020/8/21 9:43
     * @param arr 传入一个空的动态数组
     * @param file 目标文件目录
     * @return: java.util.ArrayList<java.io.File>
     */
    public static ArrayList<File> listAllFiles(ArrayList<File> arr, File file){
        // 记录file目录下的文件和文件夹，并输出
        File[] files = file.listFiles();
        // 处理文件
        for(File data : files){
            if(data.isDirectory()){ // 文件夹，递归
                listAllFiles(arr,data);
            }else{ // 文件
                arr.add(data);
            }
        }
        return arr;
    }

    /*
     * @description: 打印目标文件内的所有文件
     * @author: YuanbaoQiang
     * @date: 2020/8/21 9:44
     * @param arr
     * @return: void
     */
    public static void print(ArrayList<File> arr){
        for (File data : arr){
            System.out.println(data);
        }
    }
}
