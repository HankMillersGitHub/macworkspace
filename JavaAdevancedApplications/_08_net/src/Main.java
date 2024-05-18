import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Main {
    public static void main(String[] args) throws UnknownHostException {
        // 1. 实例化
        // 1.1 InetAddress.getByName获取制定ip对应的ia实例
/*        InetAddress ia1 = InetAddress.getByName("192.168.0.1");
        System.out.println(ia1);
        InetAddress ia3 = InetAddress.getByName("www.baidu.com");
        System.out.println(ia3);*/
        // 1.2 InetAddress.getLocalHost获取本地IP对应的InetAddress的实例
/*        InetAddress ia2 = InetAddress.getLocalHost();
        System.out.println(ia2);*/
        // 2. 两个常用的方法
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        // 获取当前IP地址的域名
        System.out.println(inetAddress.getHostName());
        // 获取当前实例的IP地址
        System.out.println(inetAddress.getHostAddress());
    }
}