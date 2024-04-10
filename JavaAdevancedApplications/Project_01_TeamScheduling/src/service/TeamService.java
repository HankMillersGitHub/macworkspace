package service;

import domain.Architect;
import domain.Designer;
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
        // 以下情况添加失败
        // 1. 成员已满，无法添加
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        // 2. 该成员不是开发人员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        // 3. 该员工已经是某团队成员
        // 4. 该员工正在休假，无法添加
        Programmer p = (Programmer) e;
        switch (p.getStatus()){
            case BUSY : throw new TeamException("该员工已经是某团队成员");
            case VOCATION: throw new TeamException("该员工正在休假，无法添加");
        }
        // 5. 该员工已经在开发团队中
        boolean isExist = isExist(p);
        if(isExist){
            throw new TeamException("该员工已经在开发团队中");
        }
        // 6. 团队中至多只能有一名架构师
        // 7. 团队中至多只能有两名设计师
        // 8. 团队中之多只能有三名程序员
        // 分别代表架构师、设计师、程序员
        int aNum = 0,pNum = 0,dNum = 0;
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Architect){
                aNum++;
            } else if (team[i] instanceof Designer) {
                dNum++;
            } else{
                pNum++;
            }
        }
        if(p instanceof Architect){
            if(aNum >= 1){
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if(p instanceof Designer){
            if(dNum >= 2){
                throw new TeamException("团队中至多只能有两名设计师");
            }
        }else{
            if(pNum >= 3){
                throw new TeamException("团队中之多只能有三名程序员");
            }
        }

        // 代码执行到这里 表示能正常添加到当前数组中
        p.setMemverId(counter++);
        p.setStatus(Status.BUSY);
        team[total++] = p;
    }
    // 判断成员是不是已经在团队中
    public boolean isExist(Programmer p ){
        for (int i = 0; i < total; i++) {
            if(team[i].getId() == p.getId()){
                return true;
            }
        }
        return false;
    }
    // 删除成员
    public void removeMember(int memberId) throws TeamException{
        int i = 0;
        for (; i < total; i++) {
            if(team[i].getMemverId() == memberId){
                // 找到了这个员工,需要调整他的相关属性
                team[i].setStatus(Status.FREE);
                // 员工的merberid可以不修改

                break;
            }
        }
        if(i == total){
            throw new TeamException("No Trace Of This Person");
        }

        // 调整数组
        for (int j = i; j < total; j++) {
            team[j] = team[j + 1];
        }
        team[--total] = null;

    }
}
