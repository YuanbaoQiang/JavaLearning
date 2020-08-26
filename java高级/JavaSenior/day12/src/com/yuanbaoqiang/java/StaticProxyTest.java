/**
 * <h3>JavaSenior</h3>
 * <p>
 *
 *     静态代理的举例
 *     代理类和被代理类在编译期间，就确定下来了
 *
 *
 * </p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-25 09:12
 **/

package com.yuanbaoqiang.java;


interface ClothFactory{
    void produceCloth();
}


// 代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; // 就拿被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");

    }
}


class NikeClothFactory implements ClothFactory{


    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}




public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();

        // 创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();

    }
}
