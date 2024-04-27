package _04_Set;

import _02_iterator.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    @Test
    public void test(){
        Set set = new HashSet();
        set.add("aa");
        set.add("aa");
        set.add(123);
        set.add("bb");
        set.add(new Person("tim",18));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
