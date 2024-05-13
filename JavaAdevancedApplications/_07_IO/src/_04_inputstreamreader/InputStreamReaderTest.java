package _04_inputstreamreader;

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {
        // utf8格式的文件
        File file1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_04_inputstreamreader/demo2.txt");
//        File file1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_04_inputstreamreader/demo1.txt");
        // 创建流
        FileInputStream fis = new FileInputStream(file1);
        InputStreamReader isr = new InputStreamReader(fis,"gbk");
        // 读文件
        char[] cbuffer = new char[5];
        int len;
        while ((len = isr.read(cbuffer)) != -1){
            /*for (int i = 0; i < len; i++) {
                System.out.print(cbuffer[i]);
            }*/
            String str = new String(cbuffer,0,len);
            System.out.print(str);
        }
        // 关闭流
        isr.close();
    }
}
