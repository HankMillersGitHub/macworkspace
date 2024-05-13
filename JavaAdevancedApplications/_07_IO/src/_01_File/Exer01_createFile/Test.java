package _01_File.Exer01_createFile;

import java.io.File;
import java.io.IOException;

public class Test {
    // 创建一个和hello.txt相同路径的abc.txt文件
    public static void main(String[] args) {
        File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_01_File/Exer01_createFile/hello.txt");
        System.out.println(file.getParent());
//        File file1 = new File(file.getParent() + "/abc.txt");
        File file1 = new File(file.getParent(),"abc.txt");
        try {
            System.out.println(file1.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
