package TCP;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 从客户端发送文件给服务器，服务器保存到本地，并返回发送成功给客户端，并关闭相应连接
 * @auther mazhonghao
 * @date 2024/5/21 21:52
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {
        // 1. 创建Socket
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 8083;
        Socket socket = new Socket(inetAddress,port);
        // 2. 创建文件流
        File file = new File("img1.jpg");
        FileInputStream fis = new FileInputStream(file);
        // 3. 通过Socket获取输出流
        OutputStream os = socket.getOutputStream();
        // 4. 读写文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        // 表明客户端数据发送完毕的方法
        socket.shutdownOutput();
        // 5. 接收来自服务端的数据
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[5];
        int len1;
        while((len1 = is.read(buffer1)) != -1){
            baos.write(buffer1,0,len1);
        }
        System.out.println(baos);
        // 6. 关闭流
        baos.close();
        is.close();
        os.close();
        fis.close();
        socket.close();
    }
    @Test
    public void server() throws IOException {
        // 1. 创建ServerSocket
        int port = 8083;
        ServerSocket serverSocket = new ServerSocket(port);
        // 2. 等待连接
        Socket socket = serverSocket.accept();
        if(socket.isConnected())
            System.out.println("连接成功");
        // 3. 通过socket获取输入流
        InputStream is = socket.getInputStream();
        // 4. 创建文件实例 fis实例
        File file = new File("img1_copy1.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        // 4. 读写文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        // 5. 返回客户端数据
        OutputStream os = socket.getOutputStream();
        os.write("阿姐很好看，我看到了".getBytes());
        // 6. 关闭流
        os.close();
        fos.close();
        is.close();
        socket.close();
    }
}
