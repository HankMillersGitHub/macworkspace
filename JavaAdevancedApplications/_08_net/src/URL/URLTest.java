package URL;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/25 08:08
 */
public class URLTest {
    public static void main(String[] args) {
        String str = "http://localhost:8080/examples/demo.jpg?name=Hank&age=19";
        try {
            URL url = new URL(str);
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test1() throws RuntimeException {
        // 1. 获取url实例
        String str = "http://localhost:8080/examples/demo.jpg?name=Hank&age=19";
        try {
            URL url = new URL(str);
            // 2. 建立与服务器的连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            // 3. 创建输入流输出流
            InputStream is = urlConnection.getInputStream();
            File file = new File("demo.jpg");
            FileOutputStream fos = new FileOutputStream(file);
            // 4. 读写资源
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            // 5. 关闭流
            fos.close();
            is.close();
            urlConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
