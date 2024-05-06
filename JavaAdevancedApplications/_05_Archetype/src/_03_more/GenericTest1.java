package _03_more;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest1 {
    /*
    * ? 的使用
    * */
    @Test
    public void test(){
        List<?> list = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("123");
        arrayList.add("234");
        arrayList.add("345");
        list = arrayList;
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());


        }
    }
}
