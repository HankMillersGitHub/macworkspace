package _03_buffered;

import org.junit.Test;

import java.io.*;

/**
 * Description : 测试BufferedReader 和 BufferedWriter
 * */
public class BufferedReaderWriterTest {
    /*
    * test BufferedReader
    * */
    @Test
    public void test() {
        BufferedReader br = null;
        try {
            // 创建File对象及响应的流
            File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/demo.txt");
            br = new BufferedReader(new FileReader(file));
            // 不使用readLine
            /*char[] cbuffer = new char[5];
            int len;
            while ((len = br.read(cbuffer)) != -1){
//                // 方式一：
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuffer[i]);
//                }
                // 方式二：
                String str = new String(cbuffer,0,len);
                System.out.print(str);
            }*/
            // 使用readLine 每次读取一行文本中的数据，返回的数据不包含换行符
            String data;
            while ((data = br.readLine())!= null){
                System.out.println(data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // close flow
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /*
    * test BufferedWriter BufferedReader
    * */
    @Test
    public void test1(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 创建流
            br = new BufferedReader(new FileReader("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/demo.txt"));
            bw = new BufferedWriter(new FileWriter("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/demo_copy.txt"));
            // 读写操作
            // 不使用readLine
            /*char[] buffer = new char[5];
            int len;
            while ((len = br.read(buffer)) != -1){
                bw.write(buffer,0,len);
            }*/
            // 使用readLine
            String data;
            while ((data = br.readLine())!=null){
                // 因为readLine不包括换行操作，所以有两种方法自己添加换行
                // 方法一：
                bw.write(data + "\n");
                // 方法二：
                // bw.newLine(); // 表示换行操作
                // bw.flush(); // 刷新的方法，每次调用此方法时，就会主动将内存中的数据写出到磁盘文件中
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // 关闭流
                if(br != null)
                    br.close();
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
