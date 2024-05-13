package _03_buffered;

import org.junit.Test;

import java.io.*;

public class BufferedTest {
    /*
    * 使用bufferedInputStream / bufferedOutputStream复制图片
    *  */
    @Test
    public void test() throws FileNotFoundException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 创建File对象
            File src = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/01.jpg");
            File dest = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/01_copy.jpg");
            // 2. 创建流对象
            // 文件流
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            // 处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 3. 数据的读入和写出
            byte[] buffer = new byte[4096];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // 4. 关闭流 先关外层流，由于外层流的关闭，也会自动的对内层的流进行关闭操作，所以可以省略内层流的关闭
                if(bis != null)
                    bis.close();
                if(bos != null)
                    bos.close();
                /* if(fis != null)
                    fis.close();
                if(fos != null)
                    fos.close();*/
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
