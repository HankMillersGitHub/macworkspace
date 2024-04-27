package _04_Set.Exer01;

import java.util.*;
// 我写的
/*public class ListTest {
    public static List duplicateList(List list){
        // 参数list中只存放Integer对象
        // 在list内去除重复数字值，尽量简单

        // 创建结果集合用于存放处理之后的list
        List result = new ArrayList();
        // 创建新的Set用于处理原list
        Set set = new HashSet();
        set.addAll(list);
        result.addAll(set);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        List a = new ArrayList();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(4);
        a = duplicateList(a);
        System.out.println("---------");
        Iterator iterator = a.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}*/
// 老师写的
public class ListTest {
    public static List duplicateList(List list){
        /*
         * 参数list中只存放Integer对象
         * 在list内去除重复数字值，尽量简单
         * */
        HashSet hashSet = new HashSet(list);
        List list1 = new ArrayList(hashSet);
        return list1;
    }

    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        arrayList = duplicateList(arrayList);
        System.out.println(arrayList);
    }
}