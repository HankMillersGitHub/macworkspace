package TCP;

import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/22 08:40
 */
public class UDPTest {
     // 发送端
     @Test
     public void sender() throws IOException {
         // 1. 创建DategramScoket的实例
         DatagramSocket ds = new DatagramSocket();
         // 2. 创建数据报(数据，目的地址ip，端口号)
         InetAddress ia = InetAddress.getByName("127.0.0.1");
         int port = 8080;
         byte[] bytes = "i am sender".getBytes("utf-8");
         DatagramPacket packet = new DatagramPacket(bytes,0, bytes.length,ia,port);
         // 3. 发送数据报
         ds.send(packet);
         ds.close();
     }
     // 接收端
     @Test
     public void receiver() throws IOException {
         // 1. 创建DatagramSocket实例
         int port = 8080;
         DatagramSocket ds = new DatagramSocket(port);
         // 2. 创建数据报的对象，用于接收发送端发过来的数据
         byte[] buffer = new byte[1024 * 64];
         DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
         // 3. 接收数据
         ds.receive(packet);
         // 4. 获取数据并打印到控制台
         String str = new String(packet.getData(),0,packet.getLength());
         System.out.println(str);
         ds.close();
     }
}
