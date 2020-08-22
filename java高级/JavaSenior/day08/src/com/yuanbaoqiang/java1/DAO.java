/**
 * <h3>JavaSenior</h3>
 * <p></p>
 *
 * DAO：data(base) access object
 * @author : YuanbaoQiang
 * @date : 2020-08-20 13:35
 **/

package com.yuanbaoqiang.java1;

import java.util.List;

public class DAO<T> { // 表的共性操作的DAO
    // 添加一条记录
    public void add(T t){

    }

    // 删除一条记录
    public boolean remove(int index){
        return false;
    }

    // 修改一条记录

    public void updata(int index, T t){

    }

    // 查询一条记录
    public T getIndex(int index){
        return null;
    }

    // 查询多条记录
    public List<T> getForList(int index){
        return null;
    }


    // 泛型方法
    // 举例：获取表中一共有多少条记录？获取最大的员工入职时间？
    public <E> E getValue(){
        return null;
    }


}
