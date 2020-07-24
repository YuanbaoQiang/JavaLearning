/**
 * <h3>我的代码</h3>
 * <p>将StudentTest中的代码进行封装</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-23 16:34
 **/


/*
 * 定义类Student,包含三个属性：学号number（int），年级state（int），成绩score（int）
 * 创建20个学生对象，学号1到20，年级和成绩都由随机数确定。
 * 问题一：打印出3年纪（state值为3）的学生信息
 * 问题二：使用冒泡顺序按照学生成绩排序，并遍历所有学生信息
 *
 * 提示
 * 1. 生成随机数，Math.random()。返回值类型为double;
 * 2. 四舍五入取整：Math.round(double d)，返回类型为long
 *
 * */
package com.yuanbaoqiang.exer;

public class StudentTestImprovement {
    public static  void main(String[] args){
        // 创建20个学生对象
        StudentOne[] s = new StudentOne[20];

        for (int i = 0; i < s.length; i++) {

            // 创建对象
            s[i] = new StudentOne();

            // 定义学号
            s[i].number = (i + 1);

            // 定义年级
            // [1,6]
            s[i].state = (int)(Math.random() * (6 - 1 + 1) + 1);

            // 定义分数
            // [0,100]
            s[i].score = (int)(Math.random() * (100 - 0 + 0) + 0);

        }


        StudentTestImprovement test = new StudentTestImprovement();

        // 遍历
        test.print(s);

        // 问题一：打印出3年纪（state值为3）的学生信息
        System.out.println("************************************");
        test.searchState(s,3);
        test.print(s);

        // 问题二：使用冒泡顺序按照学生成绩排序，并遍历所有学生信息
        System.out.println("************************************");
        test.sort(s);
        test.print(s);


    }
    



    /**
     * @description: 遍历学生
     * @author: YuanbaoQiang
     * @date: 2020/7/23 18:11
     * @param s 需要遍历的数组
     * @return: void
     */
    public void print(StudentOne[] s){
        for(int i = 0; i < s.length; i++){ 
            System.out.println(s[i].info());
        }
    }





    /**
     * @description:
     * @author: YuanbaoQiang
     * @date: 2020/7/23 18:10
     * @param s 要查找的数组
     * @param state 要查找的年级
     * @return: void
     */

    public void searchState(StudentOne[] s, int state){
        for(int i = 0; i < s.length; i++){
            if(s[i].state == state){
                System.out.println(s[i].info());
            }
        }
    }




    /**
     * @description: 给StudentOne数组排序（冒泡排序）
     * @author: YuanbaoQiang
     * @date: 2020/7/23 18:10
     * @param s 需要从小到大排序的StudentOne
     * @return: void
     */
    public void sort(StudentOne[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 0; j < s.length - 1 - i; j++) {
                if (s[j + 1].score < s[j].score) {
                    StudentOne temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
    }
}

class StudentOne{
    int number; // 学号
    int state; // 年级
    int score; // 分数



    /**
     * @description: 学生信息
     * @author: YuanbaoQiang
     * @date: 2020/7/23 18:11
     * @param
     * @return: java.lang.String
     */
    public String info() {
        return "学号为：" + number + ", 年级为：" + state + ", 分数为：" + score;
    }

}
