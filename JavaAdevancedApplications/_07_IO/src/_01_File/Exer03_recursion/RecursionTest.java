package _01_File.Exer03_recursion;

import org.junit.Test;

import java.io.File;

public class RecursionTest {
    public static void main(String[] args) {
        File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_01_File/Exer03_recursion/a");
        printFilename(file);
    }

    /**
     * @param file: File
     * @author HankMiller
     * @date 2024/05/07 15:49
     * @description : 递归实现遍历所有文件和文件目录
     */
    /*
    private static void printFilename(File file) {
        int lastIndex = file.getAbsolutePath().lastIndexOf('/');
        System.out.println(file.getAbsolutePath().substring(lastIndex + 1));
        File[] files = file.listFiles();
        if(files != null){
            for (File file1 : files){
                if(file1.listFiles() != null){
                    printFilename(file1);
                }else if(file1.isDirectory() && file1.listFiles() == null){
                    System.out.println(file1.getName());
                }else{
                    System.out.println(file1.getName());
                }
            }
        }
    }*/
    public static void printFilename(File file){
        if(file.isFile()){
            System.out.println(file.getName());
        }else if(file.isDirectory()){
            int lastIndex = file.getAbsolutePath().lastIndexOf('/');
            System.out.println(file.getAbsolutePath().substring(lastIndex + 1));
            File[] files = file.listFiles();
            for (File file1 : files){
                printFilename(file1);
            }
        }
    }
}
