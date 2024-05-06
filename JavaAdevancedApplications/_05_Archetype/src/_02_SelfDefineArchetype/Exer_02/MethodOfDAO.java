package _02_SelfDefineArchetype.Exer_02;

import _02_SelfDefineArchetype.Exer_01_Dao.User;
import org.junit.Test;

import java.util.*;

public class MethodOfDAO {
    /*
    * 编写一个范型方法，实现任意引用数据类型数组指定位置元素交换
    * */
    public static <E> void method1(E[] e,int a,int b){
        E temp ;
        temp = e[a];
        e[a] = e[b];
        e[b] = temp;
    }
    /*
    * 编写一个范型方法，接受一个任意引用类型的数组，并反转数组中的所有元素
    * */
    public static <E> void method2(E[] e) {
        Collections.reverse(Arrays.asList(e));
    }
    @Test
    public void test(){
        List<User> list = new ArrayList<>();
        list.add(new User(1001,19,"马中豪"));
        list.add(new User(1002,20,"张诗琪"));
        list.add(new User(1003,21,"里加息"));
        list.add(new User(1004,22,"王俊龙"));
        list.add(new User(1005,23,"张露露"));
        User[] array = list.toArray(new User[list.size()]);
        method1(array,1,4);
        list.clear();
        list = Arrays.asList(array);
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
