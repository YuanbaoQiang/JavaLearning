/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-31 13:22
 **/

package com.yuanbaoqiang.exer1;

public class GeometricTest {


    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();

        Circle c1 = new Circle(2.3,"white",1.0);
        test.displayGeometricObject(c1);

        Circle c2 = new Circle(3.3,"white",1.0);
        test.displayGeometricObject(c2);

        boolean isEquals = test.equalsArea(c1,c2);
        System.out.println("c1和c2的面积是否相等：" + isEquals);
    }




    public void displayGeometricObject(GeometricObject o){
        System.out.println("面积为：" + o.findArea());
    }

    // 测试两个对象的面积是否相等
    public boolean equalsArea(GeometricObject o1, GeometricObject o2){
        return o1.findArea() == o2.findArea();
    }
}
