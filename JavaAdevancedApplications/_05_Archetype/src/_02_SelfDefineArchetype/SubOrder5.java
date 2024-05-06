package _02_SelfDefineArchetype;

import java.util.ArrayList;

public class SubOrder5<T,E> extends Order<T>{
    E e;
    public void show(E e){
        System.out.println(e);
    }
    public <E>ArrayList<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e:arr){
            list.add(e);
        }
        return list;
    }
}
