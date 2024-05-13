package _02_filestream;

import org.junit.Test;

import java.io.*;

public class FileStreamTest {
    @Test
    public void test(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 创建被复制的文件
            File file1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_02_filestream/01.jpg");
            // 创建复制后的文件
            File file2 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_02_filestream/01_copy.jpg");
            // 创建输入输出流
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            // 读文件
            byte[] cbuf = new byte[1024]; // 每次读入1kb
            int len; // 记录每次读入到cbuf中的字符的个数
            while ((len = fis.read(cbuf)) != -1){
                /*for (int i = 0; i < len; i++) {
                    fos.write(cbuf[i]);
                }*/
                fos.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null)
                    // 关闭流
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
