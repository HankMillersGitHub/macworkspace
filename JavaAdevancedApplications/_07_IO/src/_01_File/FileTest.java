package _01_File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    /*
     * public File(String pathname)：以pathname为路径创建File对象，可以是绝对路径或者是相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储
     * public File(String parent,String child)：以parent为父路径，以child为子路径创建File对象
     * public File(File parent,String child)：根据一个父File对象和自文件路径创建File对象
    * */
    @Test
    public void test(){
        // public File(String pathname)
        File file1 = new File("/test");
        // public File(String parent,String child):参数一一定是一个文件目录，参数二可能是文件目录也可能是文件
        File file2 = new File("/test","son");
        // public File(File parent,String child)
        File file3 = new File(file1,"file1Child");
    }
    @Test
    public void test1(){
        /*
         * public String getName()获取名称
         * public String getPath()获取路径
         * public String getAbsolutePath()获取绝对路径
         * public File getAbsoluteFile()获取绝对路径表示的文件
         * public String getParent()获取上层文件目录路径，若无返回null
         * public long length()获取文件长度(字节数)，不能获取目录的长度
         * public long lastModified()获取最后一次修改时间，毫秒值
         * */
        File file1 = new File("hello.txt");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
    }
    @Test
    public void test2(){
        File file1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/IO/test/");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
    }
    @Test
    public void test3(){
        /*
        * public String[] list()返回一个String数组，表示该File目录中所有的子文件或目录
        * public File[] listFiles()返回一个File数组，表示该File目录中所有的子文件或目录
        * */
        File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/");
        String[] strs = file.list();
        for (String str : strs){
            System.out.println(str);
        }
        for (File filei : file.listFiles()){
            System.out.println(filei);
        }
    }
    @Test
    public void test4(){
        /*
        * public boolean renameTo(File dest)：把文件重命名为指定的文件路径
        * File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/hello.txt");
          File file1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/IO/test/world.txt");
        * 要想此方法返回true，要求
        *   file必须存在，且file1必须不存在，且file1所在的文件目录需要存在
        * */
        File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/hello.txt");
        File file1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/IO/test/world.txt");
        System.out.println(file.renameTo(file1));
        System.out.println(file.getAbsolutePath());
    }
    @Test
    public void test5(){
        /*
         * public boolean exists()此file表示的文件或目录是否实际存在
         * public boolean isDirectory()此file表示的是否是目录
         * public boolean isFile()此file表示的是否为文件
         * public boolean canRead()判断是否可读
         * public boolean canWrite()判断是否可写
         * public boolean isHidden()判断是否隐藏
         * */
        File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/IO/test/hello.txt");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println("*******************");
        File file1 = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/IO");
        System.out.println(file1.exists());
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }
    @Test
    public void test6(){
        /*
        * public boolean createNewFile()创建文件，如果文件存在，则不创建并返回false
        * public boolean mkdir()创建文件目录，如果此文件目录存在，就不创建了，如果此文件目录的上层不存在，也不创建
        * public boolean mkdirs()创建文件目录，如果上层不存在，一并创建
        * public boolean delete()删除文件或者文件夹
          删除注意事项：java中删除不会进入回收站，要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
        * */
        /*File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/IO/nihao.txt");
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        File file = new File("/Volumes/TOSHIBA EXT/JavaWorkSpace/JavaAdevancedApplications/_07_IO/IO/IOS/IOS1/test1");
        System.out.println(file.mkdir());
        System.out.println(file.mkdirs());
        System.out.println(file.delete());
    }
}
