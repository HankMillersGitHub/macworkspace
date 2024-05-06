package _02_SelfDefineArchetype.Exer_01_Dao;

import java.util.*;

/**
 * @author HankMiller
 * @date 2024/05/01 15:08
 * {@link }
 * @description DAO：database access object 内部封装了操作数据库相关表的增删改查操作
 */
public class DAO<T>  {
    Map<String,T> map = new HashMap<>();
    /*
    * 保存T类型的对象到Map成员变量中
    * */
    public void save(String id,T entity){
        map.put(id,entity);
    }
    /*
    * 从map中获取id对应的对象
    * */
    public T get(String id){
        return map.get(id);
    }
    /*
    * 替换map中key为id的内容改为entity对象
    * */
    public void update(String id,T entity){
        map.replace(id,entity);
    }
    /*
    * 返回map中所有的T对象
    * */
    public List<T> list(){
        // 方式一：
/*        Collection<T> values = map.values();
        ArrayList<Object> list1 = new ArrayList<>();
        list1.addAll(values);*/
        List list = new ArrayList();
        list.addAll(map.values());
        return list;

    }
    /*
    * 删除指定id对象
    * */
    public void delete(String id){
        map.remove(id);
    }
}

