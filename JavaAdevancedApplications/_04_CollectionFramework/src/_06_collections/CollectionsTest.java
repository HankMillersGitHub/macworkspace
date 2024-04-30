package _06_collections;

import _02_iterator.Person;
import _04_Set.User;
import org.junit.Test;

import java.util.*;

public class CollectionsTest {
    @Test
    public void test1(){
        /*
        *   排序操作
            reverse(List)反转List中的元素
            shuffle(List)对List集合元素进行随机排序
            sort(List)根据元素的自然顺序对指定List集合元素按生序排列
            sort(List,Comparator)根据指定的Comparator产生的顺序对List集合元素进行排序
            swap(List,int,int)将指定List集合中的i处元素和j处元素进行互换
        * */
        List list = new ArrayList();
        list.add(new User("Hank1",17));
        list.add(new User("Hank2",11));
        list.add(new User("Hank3",29));
        list.add(new User("Hank4",39));
        System.out.println("原列表"+list);
        Collections.reverse(list);
        System.out.println("reverse"+list);
        Collections.shuffle(list);
        System.out.println("shuffle"+list);
        Collections.sort(list);
        System.out.println("sort"+list);
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    if(u1.getAge() == u2.getAge()){
                        return u1.getName().compareTo(u2.getName());
                    }
                    return u1.getAge() - u2.getAge();
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        Collections.sort(list,comparator);
        System.out.println("sort-comparator"+list);
        Collections.swap(list,1,2);
        System.out.println("swap:"+list);
    }
    @Test
    public void test2(){
        /*
        *   查找：
            Object max(Collection)根据元素的自然排序，返回给定集合中的最大元素
            Object max(Collection,Comparator)根据Comparator指定的顺序，返回给定集合中的最大元素
            Object min(Collection)根据元素的自然排序，返回给定集合中最小的元素
            Object min(Collection,Comparator)根据comparator指定的顺序，返回给定集合中的最小元素
            int binarySearch(List list,T key)在List集合中查找某个元素的下标，但是List的元素必须是T或T的子类对象，而且必须是可以比较大小的，即支持自然排序的，而且集合中也事先必须有序，否则结果不确定
            int binarySearch(List list,T key,Comparator c)在List集合中查找某元素的下表，但是List的元素必须是T或T的子类对象，而且集合实现也必须按照c比较器规则进行排序过，否则结果不确定
            int frequency(Collection c,Object o)返回指定集合中指定元素的出现次数
        * */
       /* Set set = new HashSet();
        set.add(new User("Hank1",14));
        set.add(new User("Hank2",15));
        set.add(new User("Hank3",16));
        set.add(new User("Hank4",17));
        set.add(new User("Hank5",18));
        System.out.println(Collections.max(set));
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    if(u1.getAge() == u2.getAge()){
                        return u1.getName().compareTo(u2.getName());
                    }else{
                        return u1.getAge() - u2.getAge();
                    }
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        System.out.println(Collections.max(set, comparator));
        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set,comparator));*/
        /*ArrayList arrayList = new ArrayList();
        arrayList.add(new User("Hank1",11));
        arrayList.add(new User("Hank2",12));
        arrayList.add(new User("Hank3",13));
        arrayList.add(new User("Hank4",14));
        User user = new User("Hank",20);
        System.out.println(Collections.binarySearch(arrayList,user));
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    if(u1.getAge() == u2.getAge()){
                        return u1.getName().compareTo(u2.getName());
                    }
                    return u1.getAge() - u2.getAge();
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        System.out.println(Collections.binarySearch(arrayList,user,comparator));
        System.out.println(Collections.frequency(arrayList,new User("Hank1",11)));*/
    }
    @Test
    public void test3(){
        /*
        *   复制、替换
            void copy(List dest,List src)将src中的内容复制到dest中 完全按照src的数量覆盖，如果src的数量少，则保留一部分dest中的数据，如果数量多，则报错(下标越界)
            boolean replaceAll(List list,Object oldVal,Object newVal)使用新的值替换旧的值
            多个unmodifiableXxx()方法，该方法返回指定的Xxx的不可修改的视图
            添加
            boolean addAll(Collection c,T...elements)将所有的指定元素添加到c中
        * */
        /*ArrayList arrayList1 = new ArrayList();
        arrayList1.add(new User("Hank1",22));
        arrayList1.add(new User("Hank2",33));
        arrayList1.add(new User("Hank3",44));
        arrayList1.add(new User("Hank4",55));
        arrayList1.add(new User("Hank4",55));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new User("Miller1",11));
        arrayList2.add(new User("Miller2",12));
        arrayList2.add(new User("Miller3",13));
        arrayList2.add(new User("Miller4",14));
        arrayList2.add(new User("Miller5",15));
        Collections.copy(arrayList2,arrayList1);
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()){
            System.out.println("copy之后的list" + iterator.next());
        }*/
        /*        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new User("Jerry",19));
        arrayList3.add(new User("Jerry",19));
        arrayList3.add(new User("Jerry",19));
        arrayList3.add(new User("Jerry",19));
        Collections.replaceAll(arrayList3,new User("Jerry",19),new User("Hank",99));
        Iterator iterator3 = arrayList3.iterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next());
        }*/
    }
}
