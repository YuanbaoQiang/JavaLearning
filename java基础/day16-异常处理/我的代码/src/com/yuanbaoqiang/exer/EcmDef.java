/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-06 18:16
 **/

package com.yuanbaoqiang.exer;

/*
*
*
*
*
* */

public class EcmDef {
    public static void main(String[] args) {
        try{
            int i = Integer.parseInt(args[0]); // 分子
            int j = Integer.parseInt(args[1]); // 分母
            int result = ecm(i, j); // 调用ecm方法
            System.out.println(result);
        }catch (NumberFormatException e){
            System.out.println("数据类型不一致！");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数！");
        }catch(ArithmeticException e){
            System.out.println("除0");
        }catch(EcDef e){
            System.out.println(e.getMessage());
        }
    }

    public static int ecm(int i, int j) throws EcDef{ // 指向自己定义的异常类
        if(i < 0 || j < 0){
            throw new EcDef("分子或分母为负数了！");
        }
        return i/j;
    }

}
