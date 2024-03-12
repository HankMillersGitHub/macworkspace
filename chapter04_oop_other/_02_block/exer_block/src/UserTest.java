import java.util.Date;
import java.util.Timer;

public class UserTest
{
    public static void main(String[] args) {
        User u1 = new User();
        System.out.println(u1.getInfo());     User u2 = new User();
        System.out.println(u2.getInfo());
    }
}
class User{
    private String userName;
    private String password;
    private static long registrationTime;

    // 提取两个构造器中的相同代码形成代码块
    {
        System.out.println("新用户注册");
        registrationTime = System.currentTimeMillis(); // 获取系统当前时间(是距离1970年1月1日零时零点零分的毫秒数)
    }
    public User() {
        this.userName = registrationTime + "";
        this.password = "123456";
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public String getInfo(){
        return "userName: " + userName + ",password: " + password + ",registrationTime: " + registrationTime;
    }
}