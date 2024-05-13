package _01_File.Exer02_jpg;

import java.io.File;
import java.io.FilenameFilter;

public class JPGTest {
    public static void main(String[] args) {
        // 自己手写的方法
      /*  File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_01_File/Exer02_jpg");
        File[] files = file.listFiles();
        for (File str:files){
            // 方式一
//            if(str.toString().substring(str.toString().indexOf(".")).equals(".jpg")){
//                System.out.println("目录中存在.jpg文件，文件名为：" + str.getName());
//            }
            // 方式二
            if(str.toString().endsWith(".jpg")){
                System.out.println(str.getName());
            }

        }*/
        // 自己手写的方法结束
        // 方式三
        // File的文件过滤器
        // public String[] list(FilenameFilter filter)
        File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/src/_01_File/Exer02_jpg");
        String[] listFiles = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {  // name为子文件或子文件目录的名称
                return name.endsWith(".jpg");
            }
        });
        for (String str : listFiles){
            System.out.println(str);
        }
    }
}
