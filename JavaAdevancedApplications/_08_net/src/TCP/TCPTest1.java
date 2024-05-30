package TCP;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 问题一：客户端讲内容发送给客户端，服务端将内容打印到控制台
 * @auther mazhonghao
 * @date 2024/5/20 18:54
 */
public class TCPTest1 {
    // 客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 1. 创建一个Socket
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1"); // IP地址
            int port = 8080; // 端口号
            socket = new Socket(inetAddress, port);
            // 2. 发送数据
            os = socket.getOutputStream();
            os.write("你好，我有一个帽衫".getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 3. 关闭Socket
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null; // 阻塞式的方法
        InputStream is = null;
        try {
            // 1. 创建一个ServerSocket
            int port = 8080;
            serverSocket = new ServerSocket(port);
            // 2. 调用accept(),接受客户端Socket
            socket = serverSocket.accept();
            System.out.println("服务端开启");
            System.out.println("收到了来自：" + socket.getInetAddress().getHostAddress() + "的连接");
            // 3. 接受数据
            is = socket.getInputStream();
            byte[] buffer = new byte[5];
            int len;
            //
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 内部维护了一个byte[]
            while((len = is.read(buffer)) != -1){
                // 以下代码可能引起乱码 是错误的
            /*  String str = new String(buffer,0,len);
                System.out.print(str);*/
                // 引入ByteArrayOutputStream之后的代码
                baos.write(buffer,0,len);
            }
            System.out.println(baos);
            System.out.println("\n数据接受完毕");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 4. 关闭Socket & ServerSocket
            try {
                if(socket != null)
                    socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                if(serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
