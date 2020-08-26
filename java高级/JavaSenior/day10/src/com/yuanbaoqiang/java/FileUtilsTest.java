/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-23 09:29
 **/

package com.yuanbaoqiang.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {
    public static void main(String[] args) {
        File srcFile = new File("day10\\wallhaven-oxrq99.jpg");
        File destFile = new File("day10\\wallhaven-oxrq99-02.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
