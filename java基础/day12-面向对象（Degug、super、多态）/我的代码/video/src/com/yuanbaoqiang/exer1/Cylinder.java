/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-29 13:07
 **/

package com.yuanbaoqiang.exer1;

public class Cylinder extends Circle {
    private double length;

    public Cylinder(){
        length = 1;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getLength(){
        return length;
    }

    public double findVolume(){
        return getLength() * findArea();
    }

}
