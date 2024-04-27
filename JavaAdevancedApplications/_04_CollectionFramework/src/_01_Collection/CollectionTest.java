package _01_Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {


    }
    @Test
    public void test1(){
        /*
         * add(E obj)  添加元素到当前集合中
         * addAll(Collection other) 添加other集合中的所有元素到当前集合汇总
         *
         * */
        Collection c1 =  new ArrayList();
        Collection c2 =  new ArrayList();
        Object a = new Object();
        c1.add(a);
        c1.addAll(c2);
        System.out.println(c1.size());
    }
    @Test
    public void test2(){
        /*
        * 1. `size()`返回此集合中的元素数。
        * 2. `isEmpty()`如果此集合不包含任何元素，则返回 true。
        * 3. `contains(Object o)`如果此集合包含指定的元素，则返回 true。
        * 4. `containsAll(Collection<?> c)`如果此集合包含指定集合中的所有元素，则返回 true。
        * 5. `equals(Object o)`将指定对象与此集合进行比较以测试相等性。
        * */
        Collection a = new ArrayList();
        Collection b = new ArrayList();
        b.add(new Object());
        b.add(new Object());
        b.add(new Object());
        Object o = new Object();
        a.add(new Object());
        a.add(new Object());
        a.add(new Object());
        a.add(o);
        System.out.println(a.size());// 4
        System.out.println(a.isEmpty());// false
        System.out.println(a.contains(o));// true
        System.out.println(a.containsAll(b));// false
        System.out.println(o.equals(a));//false


    }
    @Test
    public void test3(){
        /*
        * 1. `remove(Object o)`从此集合中删除指定元素的单个实例（如果存在）（可选操作）。
        * 2. `removeAll(Collection<?> c)`删除此集合中也包含在指定集合中的所有元素（可选操作）。
        * 3. `retainAll(Collection<?> c)`仅保留此集合中包含在指定集合中的元素（可选操作）。
        * */
        Collection a = new ArrayList();
        a.add("AA");
        a.add(128);
        a.add(new Object());
        System.out.println(a);
        Collection b = new ArrayList();
        b.add("BB");
        b.add(128);
        b.add(new Object());
        System.out.println(b);
        a.remove("AA");
        System.out.println(a);
        a.removeAll(b);
        System.out.println(a);
        System.out.println(b);
        a.add("AA");
        a.add(128);
        a.retainAll(b);
        System.out.println(a);

    }
    @Test
    public void test4(){
        /*
        * 1. `toArray()`返回包含此集合中所有元素的数组。
        * 2. `hashCode()`返回此集合的哈希码值。
        * 3. `iterator()`返回此集合中的元素上的迭代器。
        * */
        Collection a = new ArrayList();
        a.add("AA");
        a.add(128);
        a.add(new Object());
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(a.hashCode());
        System.out.println(a.iterator());
    }
    @Test
    public void test5() {
        Object[] b = new Object[]{1,2,3};
        Collection a = new ArrayList();
        a.add(Arrays.asList(b));
        System.out.println(a);
    }

}

