package view;

import domain.Designer;
import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();
    public void enterMainMenu(){
        boolean loopFlag = true;
        char key = 0;
        do {
            if(key != '1'){
                listAllEmployees();
            }
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员  4-退出    (请选择1-4)：");
            key  = Utility.readMenuSelection();
            System.out.println();
            switch (key){
                case '1':listTeam();
                    break;
                case '2':addMember();
                    break;
                case '3':deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出：Y/N:");
                    char yesOrNo = Utility.readConfirmSelection();
                    if(yesOrNo == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }while (loopFlag);
    }

    // 显示所有员工成员
    public void listAllEmployees(){
        System.out.println("\n-----------------------------------------------------");
        Employee[] emps = listService.getAllEmployees();
        if(emps.length == 0){
            System.out.println("NO STAFF");
        }else{
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备\t");
        }
        for (Employee emp : emps) {
            System.out.println(" " + emp);
        }
        System.out.println("-----------------------------------------------------");
    }

    // 显示开发团队成员列表
    private void listTeam(){
        System.out.println("\n---------------------团队成员列表----------------------");
        Programmer[] team = teamService.getTeam();
        if(team.length == 0){
            System.out.println("开发团队目前没有成员");
        }else{
            System.out.println("TID/ID\t姓名\t\t年龄\t工资\t\t奖金\t\t股票");
        }
        for (Programmer programmer : team) {
            System.out.println(" " + programmer.getDetailsForTeam());
        }
        System.out.println("-----------------------------------------------------");
    }

    // 添加成员到团队
    private void addMember(){
        System.out.println("\n---------------------添加团队成员----------------------");
        System.out.print("请输入要添加的员工的ID：");
        int id = Utility.readInt();
        try{
            Employee e = listService.getEmployee(id);
            teamService.addMember(e);
            System.out.println("添加成功");
        }catch (TeamException e){
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        Utility.readReturn();
    }

    // 删除指定成员
    private void deleteMember(){
        System.out.println("\n---------------------删除团队成员----------------------");
        System.out.print("请输入要删除的员工ID:");
        int id = Utility.readInt();
        try{
            teamService.removeMember(id);
            System.out.println("删除成功");
        }catch (TeamException e){
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        Utility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
