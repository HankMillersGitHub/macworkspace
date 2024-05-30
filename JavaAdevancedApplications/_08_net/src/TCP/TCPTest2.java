package TCP;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Description: 客户端发送文件给服务端，服务端将文件保存在本地
 * @auther mazhonghao
 * @date 2024/5/20 19:33
 */
public class TCPTest2 {
    // 客户端
    @Test
    public void client() throws IOException {
        // 1. 创建Socket
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");// 指明对方的IP地址和端口号
        int port = 8082;
        Socket socket = new Socket(inetAddress,port);
        // 2. 创建File实例。FIS实例
        File file = new File("img.jpg");
        FileInputStream fis = new FileInputStream(file);
        // 3. 通过Socket获取输出流
        OutputStream os = socket.getOutputStream();
        // 4. 读写数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        // 5. 关闭Socket和相关的流
        os.close();
        fis.close();
        socket.close();
    }
    // 服务端
    @Test
    public void server() throws IOException {
        // 1. 创建ServerSocket
        int port = 8082;
        ServerSocket serverSocket = new ServerSocket(port);
        // 2. 接受来自客户端的Socket
        Socket socket = serverSocket.accept();
        // 3. 通过Socket获取一个输入流
        InputStream is = socket.getInputStream();
        // 4. 创建FIle实例，fos实例
        File file = new File("img_copy.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        // 5. 读写过程
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("数据接收完毕");
        // 6. 关闭Socket和流
        fos.close();
        is.close();
        socket.close();
    }
}
