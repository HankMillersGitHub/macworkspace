package service;

import domain.Employee;
import domain.Programmer;

public class TeamService {
    private static int counter = 1; // memberId 自动赋值基数
    private final int MAX_MEMBER = 5;   // 最大成员数
    private Programmer[] team = new Programmer[MAX_MEMBER]; // 保存成员对象的数组
    private int total = 0;  // 记录开发团队中的人数变量


    public void setTeam(Programmer[] team) {
        this.team = team;
    }

    public TeamService() {
    }

    public TeamService(int counter, Programmer[] team, int total) {
        this.counter = counter;
        this.team = team;
        this.total = total;
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    // 添加成员
    public void addMember(Employee e) throws TeamException{
        /*
        * 以下情况添加失败
        * 1. 成员已满，无法添加
        * 2. 该成员不是开发人员，无法添加
        * 3. 该员工已经是某团队成员
        * 4. 该员工正在休假，无法添加
        * 5. 该员工已经在开发团队中
        * 6. 团队中至多只能有一名架构师
        * 7. 团队中至多只能有两名设计师
        * 8. 团队中之多只能有三名程序员
        * */
    }

    // 删除成员
    public void removeMember(int memberId) throws TeamException{

    }
}
