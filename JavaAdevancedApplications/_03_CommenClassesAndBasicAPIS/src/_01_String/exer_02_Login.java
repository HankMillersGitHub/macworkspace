package _01_String;

import java.util.Scanner;

public class exer_02_Login {
    public static void main(String[] args) {
        // 1. 创建数组并初始化三个对象
        User[] users = new User[3];
        users[0] = new User("Tom","123123");
        users[1] = new User("Hank","123123");
        users[2] = new User("Jerry","123123");
        for (User user:users) {
            System.out.println(user);
        }
        // 2. 实例化scanner获取用户输入的用户名密码
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();

        // 是否找到用户
        boolean isFlag = false;

        // 3. 遍历数组元素，匹配用户名和密码
        for (User user : users) {
            if(user.getUserName().equals(username)){
                isFlag = true;
                if(user.getPassword().equals(password)){
                    System.out.println("登录成功");
                    break;
                }else {
                    System.out.println("密码不正确");
                }
            }
        }
        if(!isFlag){
            System.out.println("用户名不存在");
        }
    }
}
class User{
    private String userName;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return userName + "-" + password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
