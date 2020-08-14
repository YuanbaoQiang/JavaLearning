/**
 * <h3>项目3</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-10 16:15
 **/

package com.yuanbaoqiang.team.view;

import com.yuanbaoqiang.team.service.NameListService;
import com.yuanbaoqiang.team.service.TeamService;

public class TeamView {
    private NameListService lisSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu(){
        listAllEmployees();

        System.out.println();

    }

    /*
     * @description: 显示所有员工的信息
     * @author: YuanbaoQiang
     * @date: 2020/8/10 16:48
     * @param
     * @return: void
     */
    public void listAllEmployees(){

    }

    private void getTeam(){

    }

    private void addMember(){

    }


    private void deleteMember(){

    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
    }

}
