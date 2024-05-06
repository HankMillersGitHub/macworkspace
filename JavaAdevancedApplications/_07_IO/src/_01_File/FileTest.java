package _01_File;

import org.junit.Test;

import java.io.File;

public class FileTest {
    /*
     * public File(String pathname)：以pathname为路径创建File对象，可以是绝对路径或者是相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储
     * public File(String parent,String child)：以parent为父路径，以child为子路径创建File对象
     * public File(File parent,String child)：根据一个父File对象和自文件路径创建File对象
    * */
    @Test
    public void test(){
        // public File(String pathname)
        File file = new File("/test");
    }
}
