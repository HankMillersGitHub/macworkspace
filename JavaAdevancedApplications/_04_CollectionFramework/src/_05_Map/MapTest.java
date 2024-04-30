package _05_Map;

import _02_iterator.Person;
import org.junit.Test;

import java.util.*;

public class MapTest {
    @Test
    public void test(){
        HashMap m1 = new HashMap();
        m1.put("age",null);
        m1.put("name","Hank");
        System.out.println("put方法：  " + m1);
        HashMap m2 = new HashMap();
        m2.putAll(m1);
        System.out.println("putAll方法：  " + m2);
        System.out.println("remove的元素的value是：" + m2.remove("name"));
        System.out.println("remove方法：  " + m2);
        m2.clear();
        System.out.println("clear方法：  " + m2);
        System.out.println("get方法：  " + m1.get("name"));
        System.out.println("containsKey方法：  " + m1.containsKey("name"));
        System.out.println("containsValue方法：  " + m1.containsValue("name"));
        System.out.println("size方法：  " + m1.size());
        System.out.println("isEmpty方法：  " + m2.isEmpty());
        System.out.println("equals方法：  " + m2.equals(new Person("Hank", 19)));
        // 遍历操作
        Set set1 = new HashSet();
        set1 = m1.keySet();
        Collection collection = new ArrayList();
        collection = m1.values();
        Set set3 = new HashSet();
        set3 = m1.entrySet();
        // 遍历key集
        System.out.println("keySet方法：  " + set1);
        // 遍历value集
        System.out.println("values方法：  " + collection);
        // 遍历entry集
        System.out.println("entrySet方法：  " + set3);
        /*
        *   添加修改操作
                Object put(Object key ,Object value) 将指定key-value添加或修改到当前Map对象中
                void putAll(Map m) 将m中所有的key-value存放到当前map中

            删除操作
                Object remove(Object key)：移除指定key的key-value值，并返回value
                void clear()：清空当前map中的所有数据

            元素查询操作
                Object get(Object key)：获取指定key对应的value
                boolean containsKey(Object key)：是否包含指定的key
                boolean containsValue(Object value)：是否包含指定的value
                int size()：返回map中key-value的对数
                boolean isEmpty()：判断当前map是否为空
                boolean equals(Object obj)：判断当前map和参数对象obj是否相等

            元视图操作方法
                Set keySet()：返回所有的key构成的Set集合
                Collection values()：返回所有value构成的Collection集合
                Set entrySet()：返回所有key-value对构成的Set集合
        * */
    }
}
