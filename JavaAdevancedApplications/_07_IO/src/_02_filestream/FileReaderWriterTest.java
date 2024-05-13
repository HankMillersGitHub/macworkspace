package _02_filestream;

import org.junit.Test;

import java.io.*;

// /Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_02_filestream/demo.txt
public class FileReaderWriterTest {
    /*
     * 读取demo.txt文件中的内容并输出出来
     * */
    @Test
    public void test() {
        FileReader fr = null;
        try {
            // 1. 创建file类的对象，对应demo.txt文件
            File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_02_filestream/demo.txt");
            // 2. 创建输入型字符流，用于读取数据
            fr = new FileReader(file);
            // 3. 读取数据并显示在控制台上
            // 方式一：
        /*int data = fr.read();
        while (data != -1){
            System.out.print((char)data);
            data = fr.read();
        }*/
            // 方式二：
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 流资源的关闭操作，必须要关闭，否则会内存泄漏
            try {
                // 为了程序健壮性更好
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // 对test1进行优化，每次读取多个字符存放到字符数组中，减少了与磁盘交互的次数，提高效率
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            // 1. 创建file类的对象，对应demo.txt文件
            File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_02_filestream/demo.txt");
            // 2. 创建输入型字符流，用于读取数据
            fr = new FileReader(file);
            // 3. 读取数据并显示在控制台上
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 流资源的关闭操作，必须要关闭，否则会内存泄漏
            try {
                // 为了程序健壮性更好
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /*
    * 需求：将内存中的数据写入到demo.txt中
    * */
    @Test
    public void test2(){
        FileWriter fw = null;
        try {
            // 1. 创建fule类的对象，指明要写出的文件的对象
            File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_02_filestream/demo.txt");
            // 2. 创建输出流
            // 覆盖文件的构造器
            fw = new FileWriter(file);
            // 在现有文件的基础上追加内容
//            fw = new FileWriter(file,true);
            // 3. 写出的具体操作
            // 输出的方法 write(String str) / write(char[] cbuf)
            fw.write("马中豪");
            fw.write("❤️");
            fw.write("马中豪");
            System.out.println("写入成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // 4. 关闭流
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /*
    * 复制一份demo.txt 命名为demo_cpoy.txt
    * */
    @Test
    public void test3() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 创建被复制的文件
            File file1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_02_filestream/01.jpg");
            // 创建复制后的文件
            File file2 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_02_filestream/01_copy.jpg");
            // 创建输入输出流
            fr = new FileReader(file1);
            fw = new FileWriter(file2);
            // 读文件
            char[] cbuf = new char[5];
            int len; // 记录每次读入到cbuf中的字符的个数
            while ((len = fr.read(cbuf)) != -1){
                /*for (int i = 0; i < len; i++) {
                    fw.write(cbuf[i]);
                }*/
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        } finally {
            try {
                if(fr != null)
                    // 关闭流
                    fr.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.fillInStackTrace();
            }
        }

    }
}
