package com.yuanbaoqiang.exer;

public class Test {
    public static void main(String[] args){
        Person p1 = new Person();

        p1.name = "Tom";
        p1.age = 18;
        p1.sex = 1;

        p1.study();
        p1.showAge();

        int newAge = p1.addAge(2);
        System.out.println(p1.name + "的新年龄为：" + newAge);

        System.out.println(p1.age); // 20

        //******************************

        Person p2 = new Person();
        p2.showAge(); // 0


    }



}

class Person {
    // 属性
    String name;
    int age;

    /*
    * sex: 1 表明是男性
    * sex: 0 表明是女性
    * */
    int sex;

    public void study() {
        System.out.println("studying");
    }
    public void showAge(){
        System.out.println("age：" + age);
    }

    public int addAge(int i){
        age +=2;
        return age;
    }

}
