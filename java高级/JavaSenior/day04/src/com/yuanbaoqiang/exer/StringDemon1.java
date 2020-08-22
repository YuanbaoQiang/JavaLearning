/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-16 08:04
 **/

package com.yuanbaoqiang.exer;

import org.junit.Test;

public class StringDemon1 {

    /*
    * 获取一个字符串再另一个字符串中出现的次数。
    * 比如获取"ab"在"abkkcadafadabajklabskab"中出现的次数
    * */

    /*
     * @description: 获取subStr在mainStr中出现的次数
     * @author: YuanbaoQiang
     * @date: 2020/8/16 8:09
     * @param mainStr
     * @param subStr
     * @return: int
     */
    public int getCount(String mainStr, String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(subLength > mainLength) return count;
        // 方式一
/*        while((index = mainStr.indexOf(subStr)) != -1){
            count++;
            mainStr = mainStr.substring(index + subLength);
        }*/

        while((index = mainStr.indexOf(subStr,index)) != -1){
            count++;
            index += subLength;
        }


        return count;
    }

    @Test
    public void testGetCount(){
        String mainStr = "abkkcadafadabajklabskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }


}
