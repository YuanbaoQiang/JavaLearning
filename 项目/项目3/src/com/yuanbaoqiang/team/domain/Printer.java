/**
 * <h3>项目3</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-07 14:03
 **/

package com.yuanbaoqiang.team.domain;

public class Printer implements Equipment{
    private String name; // 机器型号
    private String type; // 机器类型

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
