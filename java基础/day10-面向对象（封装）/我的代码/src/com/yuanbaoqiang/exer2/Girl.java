/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-27 19:29
 **/

package com.yuanbaoqiang.exer2;

public class Girl {
    private String name;
    private int age;

    public Girl(){

    }


    public Girl(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void marry(Boy boy){
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }


    /**
     * @description:
     * @author: YuanbaoQiang
     * @date: 2020/7/27 19:40
     * @param girl
     * @return: int 正数 ：前面对象大； 负数：当前对象小；0：当前对象与形参对象相等
     */
    public int compare(Girl girl){
/*        if(this.age > girl.age){
            return 1;
        }else if(this.age > girl.age){
            return -1;
        }else{
            return 0;
        }*/

        return this.age - girl.age;
    }
}
