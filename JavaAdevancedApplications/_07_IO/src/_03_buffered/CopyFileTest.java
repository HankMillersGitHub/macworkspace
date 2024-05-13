package _03_buffered;

import java.io.*;
import java.util.Date;

/**
 * @param null: null
 *              return
 * @author HankMiller
 * @date 2024/05/08 09:29
 * {@link }
 * @description 测试FileInputStream \ FileOutputStream 复制文件
 *              测试BufferedInputStream \ BufferedOutputStream 复制文件
 *              效率相较
 */
public class CopyFileTest {
    public static void main(String[] args) {
        File src1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/01.jpg");
        File src2 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/02.jpg");
        File destsrc1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/01_copy.jpg");
        File destsrc2 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_03_buffered/02_copy.jpg");
        System.out.println("不使用缓冲区消耗的时间：" + fis(src1, destsrc1));
        System.out.println("使用缓冲区消耗的时间：" + bis(src2, destsrc2));
    }
    public static long fis(File src, File dest) {
        long beginTime = new Date().getTime();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 创建流
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            // 读写文件
            byte[] cbuffer = new byte[50];
            int len;
            while ((len = fis.read(cbuffer)) != -1){
                fos.write(cbuffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 关闭流

            try {
                if(fis != null)
                    fis.close();
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        long endTime = new Date().getTime();
        return endTime - beginTime;
    }
    public static long bis(File src, File dest) {
        long beginTime = new Date().getTime();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 创建流
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 读写文件
            byte[] buffer = new byte[50];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

            }
            System.out.println("复制成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 关闭流
            try {
                if(bis != null)
                    bis.close();
                if(bos != null)
                    bos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        long endTime = new Date().getTime();
        return endTime - beginTime;
    }
}
