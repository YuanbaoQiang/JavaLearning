/**
 * <h3>项目3</h3>
 * <p>表示员工的状态</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-07 14:15
 **/

package com.yuanbaoqiang.team.service;

public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
